package com.ipl.service;

import com.ipl.dto.PlayerDTO;
import com.ipl.dto.PlayerResponseDTO;
import com.ipl.model.Player;
import com.ipl.model.Team;
import com.ipl.repository.PlayerRepository;
import com.ipl.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    public PlayerResponseDTO addPlayer(PlayerDTO dto) {
        Team team = teamRepository.findByTeamName(dto.getTeamName())
                .orElseThrow(() -> new RuntimeException("Team not found: " + dto.getTeamName()));
        Player player = new Player(dto.getName(), dto.getRole(), dto.getRuns(), dto.getWickets(), dto.getMatches(), team);
        return new PlayerResponseDTO(playerRepository.save(player));
    }

    public List<PlayerResponseDTO> getAllPlayers() {
        return playerRepository.findAll().stream()
                .map(PlayerResponseDTO::new)
                .collect(Collectors.toList());
    }

    public List<PlayerResponseDTO> getPlayersByTeam(String teamName) {
        return playerRepository.findByTeamTeamName(teamName).stream()
                .map(PlayerResponseDTO::new)
                .collect(Collectors.toList());
    }

    public List<PlayerResponseDTO> getPlayersByRole(String role) {
        return playerRepository.findByRole(role).stream()
                .map(PlayerResponseDTO::new)
                .collect(Collectors.toList());
    }

    public PlayerResponseDTO getTopScorer() {
        List<Player> result = playerRepository.findTopScorers();
        if (result.isEmpty()) throw new RuntimeException("No players found");
        return new PlayerResponseDTO(result.get(0));
    }

    public PlayerResponseDTO getTopScorerByTeam(String teamName) {
        List<Player> result = playerRepository.findTopScorerByTeam(teamName);
        if (result.isEmpty()) throw new RuntimeException("No players found for: " + teamName);
        return new PlayerResponseDTO(result.get(0));
    }

    public PlayerResponseDTO getTopWicketTaker() {
        List<Player> result = playerRepository.findTopWicketTakers();
        if (result.isEmpty()) throw new RuntimeException("No players found");
        return new PlayerResponseDTO(result.get(0));
    }

    public List<PlayerResponseDTO> getPlayersByTeamAndRole(String teamName, String role) {
        return playerRepository.findByTeamAndRole(teamName, role).stream()
                .map(PlayerResponseDTO::new)
                .collect(Collectors.toList());
    }

    public Map<String, Long> getTeamPlayerCount() {
        return playerRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        p -> p.getTeam().getTeamName(),
                        Collectors.counting()
                ));
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}

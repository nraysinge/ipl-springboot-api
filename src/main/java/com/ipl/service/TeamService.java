package com.ipl.service;

import com.ipl.dto.TeamDTO;
import com.ipl.dto.TeamResponseDTO;
import com.ipl.model.Team;
import com.ipl.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public TeamResponseDTO addTeam(TeamDTO dto) {
        if (teamRepository.existsByTeamName(dto.getTeamName()))
            throw new RuntimeException("Team already exists: " + dto.getTeamName());
        Team team = new Team(dto.getTeamName(), dto.getHomeCity(), dto.getCaptain());
        return new TeamResponseDTO(teamRepository.save(team));
    }

    public List<TeamResponseDTO> getAllTeams() {
        return teamRepository.findAll().stream()
                .map(TeamResponseDTO::new)
                .collect(Collectors.toList());
    }

    public TeamResponseDTO getTeamByName(String teamName) {
        Team team = teamRepository.findByTeamName(teamName)
                .orElseThrow(() -> new RuntimeException("Team not found: " + teamName));
        return new TeamResponseDTO(team);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}

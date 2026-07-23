package com.ipl.controller;

import com.ipl.dto.PlayerDTO;
import com.ipl.dto.PlayerResponseDTO;
import com.ipl.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "*")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<PlayerResponseDTO> addPlayer(@RequestBody PlayerDTO dto) {
        return ResponseEntity.ok(playerService.addPlayer(dto));
    }

    @GetMapping
    public ResponseEntity<List<PlayerResponseDTO>> getAllPlayers() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @GetMapping("/team/{teamName}")
    public ResponseEntity<List<PlayerResponseDTO>> getByTeam(@PathVariable String teamName) {
        return ResponseEntity.ok(playerService.getPlayersByTeam(teamName));
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<PlayerResponseDTO>> getByRole(@PathVariable String role) {
        return ResponseEntity.ok(playerService.getPlayersByRole(role));
    }

    @GetMapping("/stats/top-scorer")
    public ResponseEntity<PlayerResponseDTO> getTopScorer() {
        return ResponseEntity.ok(playerService.getTopScorer());
    }

    @GetMapping("/stats/top-scorer/{teamName}")
    public ResponseEntity<PlayerResponseDTO> getTopScorerByTeam(@PathVariable String teamName) {
        return ResponseEntity.ok(playerService.getTopScorerByTeam(teamName));
    }

    @GetMapping("/stats/top-wicket-taker")
    public ResponseEntity<PlayerResponseDTO> getTopWicketTaker() {
        return ResponseEntity.ok(playerService.getTopWicketTaker());
    }

    @GetMapping("/team/{teamName}/role/{role}")
    public ResponseEntity<List<PlayerResponseDTO>> getByTeamAndRole(
            @PathVariable String teamName, @PathVariable String role) {
        return ResponseEntity.ok(playerService.getPlayersByTeamAndRole(teamName, role));
    }

    @GetMapping("/stats/team-summary")
    public ResponseEntity<Map<String, Long>> getTeamSummary() {
        return ResponseEntity.ok(playerService.getTeamPlayerCount());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok("Player deleted successfully");
    }
}

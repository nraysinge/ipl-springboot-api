package com.ipl.controller;

import com.ipl.dto.TeamDTO;
import com.ipl.dto.TeamResponseDTO;
import com.ipl.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@CrossOrigin(origins = "*")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    public ResponseEntity<TeamResponseDTO> addTeam(@RequestBody TeamDTO dto) {
        return ResponseEntity.ok(teamService.addTeam(dto));
    }

    @GetMapping
    public ResponseEntity<List<TeamResponseDTO>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @GetMapping("/{teamName}")
    public ResponseEntity<TeamResponseDTO> getTeamByName(@PathVariable String teamName) {
        return ResponseEntity.ok(teamService.getTeamByName(teamName));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.ok("Team deleted");
    }
}

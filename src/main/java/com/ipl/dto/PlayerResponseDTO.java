package com.ipl.dto;

import com.ipl.model.Player;

public class PlayerResponseDTO {

    private Long id;
    private String name;
    private String role;
    private int runs;
    private int wickets;
    private int matches;
    private String teamName;

    // Constructor from Player entity
    public PlayerResponseDTO(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.role = player.getRole();
        this.runs = player.getRuns();
        this.wickets = player.getWickets();
        this.matches = player.getMatches();
        this.teamName = player.getTeam() != null ? player.getTeam().getTeamName() : "N/A";
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public int getRuns() { return runs; }
    public int getWickets() { return wickets; }
    public int getMatches() { return matches; }
    public String getTeamName() { return teamName; }
}

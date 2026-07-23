package com.ipl.dto;

import com.ipl.model.Team;

public class TeamResponseDTO {

    private Long id;
    private String teamName;
    private String homeCity;
    private String captain;

    public TeamResponseDTO(Team team) {
        this.id = team.getId();
        this.teamName = team.getTeamName();
        this.homeCity = team.getHomeCity();
        this.captain = team.getCaptain();
    }

    // Getters
    public Long getId() { return id; }
    public String getTeamName() { return teamName; }
    public String getHomeCity() { return homeCity; }
    public String getCaptain() { return captain; }
}

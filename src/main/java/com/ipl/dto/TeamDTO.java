package com.ipl.dto;

public class TeamDTO {
    private String teamName;
    private String homeCity;
    private String captain;

    public TeamDTO() {}

    public TeamDTO(String teamName, String homeCity, String captain) {
        this.teamName = teamName;
        this.homeCity = homeCity;
        this.captain = captain;
    }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public String getHomeCity() { return homeCity; }
    public void setHomeCity(String homeCity) { this.homeCity = homeCity; }

    public String getCaptain() { return captain; }
    public void setCaptain(String captain) { this.captain = captain; }
}

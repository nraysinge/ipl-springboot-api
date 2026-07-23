package com.ipl.dto;

public class PlayerDTO {
    private String name;
    private String role;
    private int runs;
    private int wickets;
    private int matches;
    private String teamName;

    public PlayerDTO() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public int getRuns() { return runs; }
    public void setRuns(int runs) { this.runs = runs; }

    public int getWickets() { return wickets; }
    public void setWickets(int wickets) { this.wickets = wickets; }

    public int getMatches() { return matches; }
    public void setMatches(int matches) { this.matches = matches; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
}

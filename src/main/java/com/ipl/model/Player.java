package com.ipl.model;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "role")
    private String role;

    @Column(name = "runs")
    private int runs;

    @Column(name = "wickets")
    private int wickets;

    @Column(name = "matches")
    private int matches;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    public Player() {}

    public Player(String name, String role, int runs, int wickets, int matches, Team team) {
        this.name = name;
        this.role = role;
        this.runs = runs;
        this.wickets = wickets;
        this.matches = matches;
        this.team = team;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }
}

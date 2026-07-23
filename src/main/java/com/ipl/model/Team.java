package com.ipl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_name", nullable = false, unique = true)
    private String teamName;

    @Column(name = "home_city")
    private String homeCity;

    @Column(name = "captain")
    private String captain;

    @JsonIgnore  // prevents infinite recursion
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Player> players;

    public Team() {}

    public Team(String teamName, String homeCity, String captain) {
        this.teamName = teamName;
        this.homeCity = homeCity;
        this.captain = captain;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public String getHomeCity() { return homeCity; }
    public void setHomeCity(String homeCity) { this.homeCity = homeCity; }

    public String getCaptain() { return captain; }
    public void setCaptain(String captain) { this.captain = captain; }

    public List<Player> getPlayers() { return players; }
    public void setPlayers(List<Player> players) { this.players = players; }
}

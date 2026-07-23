package com.ipl;

import com.ipl.dto.PlayerDTO;
import com.ipl.dto.TeamDTO;
import com.ipl.service.PlayerService;
import com.ipl.service.TeamService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IplApplication {

    public static void main(String[] args) {
        SpringApplication.run(IplApplication.class, args);
    }
/*
    @Bean
    CommandLineRunner seedData(TeamService teamService, PlayerService playerService) {
        return args -> {
            try {
                teamService.addTeam(new TeamDTO("Mumbai Indians", "Mumbai", "Rohit Sharma"));
                teamService.addTeam(new TeamDTO("Chennai Super Kings", "Chennai", "MS Dhoni"));
                teamService.addTeam(new TeamDTO("Royal Challengers Bangalore", "Bangalore", "Virat Kohli"));

                playerService.addPlayer(new PlayerDTO() {{ setName("Rohit Sharma"); setRole("Batsman"); setRuns(6200); setWickets(15); setMatches(243); setTeamName("Mumbai Indians"); }});
                playerService.addPlayer(new PlayerDTO() {{ setName("Jasprit Bumrah"); setRole("Bowler"); setRuns(50); setWickets(170); setMatches(130); setTeamName("Mumbai Indians"); }});
                playerService.addPlayer(new PlayerDTO() {{ setName("Kieron Pollard"); setRole("All-Rounder"); setRuns(3400); setWickets(69); setMatches(189); setTeamName("Mumbai Indians"); }});

                playerService.addPlayer(new PlayerDTO() {{ setName("MS Dhoni"); setRole("Wicket-Keeper"); setRuns(5082); setWickets(0); setMatches(250); setTeamName("Chennai Super Kings"); }});
                playerService.addPlayer(new PlayerDTO() {{ setName("Ravindra Jadeja"); setRole("All-Rounder"); setRuns(2700); setWickets(132); setMatches(210); setTeamName("Chennai Super Kings"); }});
                playerService.addPlayer(new PlayerDTO() {{ setName("Deepak Chahar"); setRole("Bowler"); setRuns(80); setWickets(85); setMatches(100); setTeamName("Chennai Super Kings"); }});

                playerService.addPlayer(new PlayerDTO() {{ setName("Virat Kohli"); setRole("Batsman"); setRuns(7263); setWickets(4); setMatches(237); setTeamName("Royal Challengers Bangalore"); }});
                playerService.addPlayer(new PlayerDTO() {{ setName("AB de Villiers"); setRole("Batsman"); setRuns(5162); setWickets(0); setMatches(184); setTeamName("Royal Challengers Bangalore"); }});
                playerService.addPlayer(new PlayerDTO() {{ setName("Yuzvendra Chahal"); setRole("Bowler"); setRuns(45); setWickets(187); setMatches(165); setTeamName("Royal Challengers Bangalore"); }});

                System.out.println("✅ Sample data seeded!");
                System.out.println("🌐 Frontend: http://localhost:8080");
                System.out.println("📡 API:      http://localhost:8080/api");
            } catch (Exception e) {
                System.out.println("ℹ️ Data already exists: " + e.getMessage());
            }
        };
    }
    */
}

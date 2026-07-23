package com.ipl.repository;

import com.ipl.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByTeamTeamName(String teamName);
    List<Player> findByRole(String role);

    @Query("SELECT p FROM Player p ORDER BY p.runs DESC")
    List<Player> findTopScorers();

    @Query("SELECT p FROM Player p WHERE p.team.teamName = :teamName ORDER BY p.runs DESC")
    List<Player> findTopScorerByTeam(@Param("teamName") String teamName);

    @Query("SELECT p FROM Player p ORDER BY p.wickets DESC")
    List<Player> findTopWicketTakers();

    @Query("SELECT p FROM Player p WHERE p.team.teamName = :teamName AND p.role = :role")
    List<Player> findByTeamAndRole(@Param("teamName") String teamName, @Param("role") String role);
}

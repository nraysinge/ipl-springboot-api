# IPL Team Manager REST API — Spring Boot

A RESTful API to manage IPL team and player data using Spring Boot, Spring Data JPA, and MySQL.

## Technologies
- Java 17
- Spring Boot 3.2
- Spring Data JPA (Hibernate auto-configured)
- MySQL 8
- Maven

## Setup

1. Install MySQL
2. Open `src/main/resources/application.properties`
3. Update `spring.datasource.username` and `spring.datasource.password`
4. Run:

```bash
mvn clean spring-boot:run
```

API will start at: `http://localhost:8080`

## API Endpoints

### Teams
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/teams | Add a team |
| GET | /api/teams | Get all teams |
| GET | /api/teams/{teamName} | Get team by name |
| DELETE | /api/teams/{id} | Delete a team |

### Players
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/players | Add a player |
| GET | /api/players | Get all players |
| GET | /api/players/team/{teamName} | Players by team |
| GET | /api/players/role/{role} | Players by role |
| GET | /api/players/stats/top-scorer | Top scorer overall |
| GET | /api/players/stats/top-scorer/{teamName} | Top scorer by team |
| GET | /api/players/stats/top-wicket-taker | Top wicket taker |
| GET | /api/players/team/{teamName}/role/{role} | Filter by team + role |
| GET | /api/players/stats/team-summary | Player count per team |
| DELETE | /api/players/{id} | Delete a player |

## Sample Request (Add Player)
```json
POST /api/players
{
  "name": "Rohit Sharma",
  "role": "Batsman",
  "runs": 6200,
  "wickets": 15,
  "matches": 243,
  "teamName": "Mumbai Indians"
}
```

## Project Structure
```
src/main/java/com/ipl/
├── IplApplication.java         ← @SpringBootApplication + data seeder
├── model/
│   ├── Team.java               ← @Entity
│   └── Player.java             ← @Entity with @ManyToOne
├── repository/
│   ├── TeamRepository.java     ← extends JpaRepository
│   └── PlayerRepository.java   ← custom @Query methods
├── service/
│   ├── TeamService.java        ← @Service
│   └── PlayerService.java      ← @Service with Collections/Streams
├── controller/
│   ├── TeamController.java     ← @RestController
│   └── PlayerController.java   ← @RestController
└── dto/
    ├── TeamDTO.java
    └── PlayerDTO.java
```

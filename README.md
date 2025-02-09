### 🎲 GameOn Backend - README.md

# GameOn Backend

GameOn Backend est l'API REST développée avec **Spring Boot**, servant de backend pour l'application GameOn.

## 🚀 Installation et Lancement

### Prérequis
- [Java 17](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/) (optionnel, pour la base de données)
- [PostgreSQL](https://www.postgresql.org/) (ou utiliser l'image Docker)

### 📦 Installation
```sh
git clone https://github.com/ton-org/gameon-backend.git
cd gameon-backend
mvn clean install
```

### 🏗️ Lancer en développement
```sh
mvn spring-boot:run
```
L'API sera accessible sur `http://localhost:8100`.

### 📊 Base de données
Si tu veux lancer PostgreSQL avec Docker :
```sh
docker run --name gameon-db -e POSTGRES_USER=gameon -e POSTGRES_PASSWORD=gameon -p 5432:5432 -d postgres
```

### 🔧 Configuration
Le fichier `application.properties` doit contenir :
```
server.port=8100
spring.datasource.url=jdbc:postgresql://localhost:5432/gameon
spring.datasource.username=gameon
spring.datasource.password=gameon
cors.allowed.origins=http://localhost:3000
```

### 📌 API Endpoints
| Méthode | Endpoint                         | Description                          |
|---------|--------------------------------|----------------------------------|
| GET     | `/api/v1/games`                | Liste des jeux                   |
| GET     | `/api/v1/games/{value}`        | Détails d’un jeu par ID ou slug |
| GET     | `/api/v1/games/filter`         | Filtrer les jeux par critères    |
| GET     | `/api/v1/games/byMechanism/{gameId}` | Jeux par mécanisme          |
| GET     | `/api/v1/games/withMechanisms/{gameId}` | Jeux avec des mécanismes similaires |
| POST    | `/api/v1/games`                | Ajouter un jeu                    |
| PUT     | `/api/v1/games/{id}`           | Modifier un jeu                    |
| DELETE  | `/api/v1/games/{id}`           | Supprimer un jeu                   |
| GET     | `/api/v1/mechanisms`           | Liste des mécanismes de jeu        |

---

💡 **Besoin d’aide ?** Contacte-moi sur [mon email](brouilliercharles@gmail.com).

---
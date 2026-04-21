# Label Modification Dashboard MVP

## Phases Delivered
1. Project structure (`backend/`, `frontend/`, `docker/`, `docs/`)
2. Backend initialized with Spring Boot and health endpoints
3. Frontend initialized with React + Vite and dashboard cards
4. PostgreSQL schema created with Flyway migration
5. Docker setup for backend, frontend, and database

## Local Run
1. Copy environment file:
   ```bash
   cp .env.example .env
   ```
2. Start with Docker Compose:
   ```bash
   docker compose -f docker/docker-compose.yml --env-file .env up --build
   ```

## Health Checks
- Backend health: `http://localhost:8080/actuator/health`
- API health: `http://localhost:8080/api/health`
- Frontend: `http://localhost:5173`

A small example using devcontainer with spring boot and postgresql

# Run
````sh
./gradlew bootRun
````
or
````sh
npx --yes @devcontainers/cli up --workspace-folder .
npx --yes @devcontainers/cli exec --workspace-folder . ./gradlew bootRun
````

````sh
curl -X GET http://localhost:8080/blockedpositions
````
# Info
PostgreSQL initializes new database volumes with the table and sample rows from
`.devcontainer/init.sql`. Existing volumes are not initialized again. To apply
the script to an existing database without deleting its data, run:

```sh
docker compose -p blacklist_devcontainer -f .devcontainer/docker-compose.yml exec -T blocked-positions-db \
  psql -v ON_ERROR_STOP=1 -U postgres -d blocked_positions < .devcontainer/init.sql
```
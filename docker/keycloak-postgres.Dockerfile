FROM postgres:15

COPY "docker/keycloak-postgres-initdb.sh" "/docker-entrypoint-initdb.d/"
COPY "docker/keycloak-postgres.conf" "/etc/postgresql.conf"
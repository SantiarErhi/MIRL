#!/bin/bash

set -e
cat /etc/postgresql.conf > /var/lib/postgresql/data/postgresql.conf
psql -v ON_ERROR_STOP=1 --username="$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER keycloak WITH PASSWORD 'ultimatelysecure';
    CREATE DATABASE keycloak;
    GRANT ALL PRIVILEGES ON DATABASE keycloak TO keycloak;
EOSQL
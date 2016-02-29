#!/bin/bash
# trap ctrl-c and call ctrl_c()
trap ctrl_c SIGINT
trap ctrl_c SIGTERM
function ctrl_c() {
    exec mysqld -u root shutdown;
}
mysqld schema.sql
mvn sql:execute tomcat7:run-war;


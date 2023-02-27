include variables.local.env
include variables.secret.env

export $(shell sed 's/=.*//' variables.local.env)
export $(shell sed 's/=.*//' variables.secret.env)

.DEFAULT_GOAL := help

docker-down:
	@echo "Stopping docker and removing containers..."
	docker stop multiset-database
	docker rm -f multiset-database

docker-up:
	@echo "Creating docker containers..."
	docker-compose -f docker/docker-compose.yml up -d --build

run-local:
	@echo "Starting spring application..."
	mvn clean compile package
	java -jar target/multiset-1.0-SNAPSHOT-spring-boot.jar

run-local-debug:
	@echo "Starting spring application..."
	mvn clean compile package
	java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 target/multiset-1.0-SNAPSHOT-spring-boot.jar
.PHONY: start
start: erase build up ## clean current environment, recreate dependencies and spin up again

.PHONY: erase
erase: ## stop and delete containers, clean volumes.
		docker-compose stop
		docker-compose rm -v -f

.PHONY: build
build: ## build environment and initialize composer and project dependencies
		docker-compose build

.PHONY: up
up: ## spin up environment
		docker-compose up -d

.PHONY: env
env: ## spin up environment
		cp ./src/main/resources/application.yml.example ./src/main/resources/application.yml

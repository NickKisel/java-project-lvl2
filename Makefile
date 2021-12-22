.DEFAULT_GOAL := build-run

install:
	./gradlew clean install

run-dist:
	./build/install/app/bin/app

check-updates:
	./gradlew dependencyUpdates


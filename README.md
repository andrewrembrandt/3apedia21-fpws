# 3apedia '21 - FP Workshop - Exercise

### Requirements
* JDK 16
  * You can install this with sdkman, for example: `sdk install java 16.0.0.j9-adpt`
* docker and docker-compose
* bash

### Introduction
This is a largely complete, but basic CRUD HTTP api for orders and products. Several lines of code have been deleted, 
to allow you to get familiar with flatMap, map, Mono, and Flux. The idea is to add the missing lines and make the code 
compile (and the tests pass).

Note that it is using the latest version of Spring R2DBC (v1.2 - including the new R2DBCEntityTemplate).

### Instructions
* There are 3 TODOs in the code in the ./ex-spring-reactive/ folder, complete them in order and run the tests to confirm 
  they work as required.
* A completed solution is provided in the ./sln-spring-reactive/ folder.

### Running (once implemented)
To launch the site with postgres simply run:
```shell script
> gradle[w] bootRun
```
To run tests:
```shell script
> gradle[w] test
```

To stop the running docker postgres instance:
```shell script
> docker-compose -f resources/postgresql.yml down
```

Note that postgres persisted data is stored in `./resources/postgres-data` with owner set to the current uid

### Troubleshooting
Should there be an issue with docker, you can completely reset your docker environment with:
```shell script
docker stop `docker ps -a -q`; docker rm `docker ps -a -q`; docker system prune -f
```

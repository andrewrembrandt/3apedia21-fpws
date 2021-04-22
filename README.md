# 3apedia '21 - FP Workshop - Exercise

### Requirements
* JDK 16
* docker and docker-compose
* bash

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

# 3apedia '21 - FP Workshop - Exercise

### Requirements
* JDK 16
* docker and docker-compose
* bash

### Running
To launch the site with postgres simply run:
```shell script
> gradle bootRun
```
To run tests:
```shell script
> gradle test
```

To stop the running docker postgres instance:
```shell script
> docker-compose -f resources/postgresql.yml down
```

Note that postgres persisted data is stored in `./resources/postgres-data` with owner set to the current uid

### Instructions
* There are 3 TODOs in the code, complete them in order

### Troubleshooting
Should there be an issue with docker, you can completely reset your docker environment with:
```shell script
docker stop `docker ps -a -q`; docker rm `docker ps -a -q`; docker system prune -f
```

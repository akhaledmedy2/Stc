# Getting Started


### Guides
Run build.bat file to build maven modules

### Docker Compose
Follow manual steps if docker compose file fails to run with this command (docker-compose up):

1-docker pull mysql
2-docker run -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=employee mysql

3-docker network create employee-network
4-docker network connect employee-network mysqldb

5-docker build -t employee .
6-docker run -p 8090:8080 --name employee-service --network employee-network employee

7-docker build -t employee-leaves .
8-docker run -p 9090:8080 --name employee-leaves --network employee-network employee-leaves

9-docker build -t discovery-server .
10-docker run -p 8762:8761 --name eureka --network employee-network discovery-server

11-docker build -t proxy-service .
12-docker run -p 9006:9005 --name proxy --network employee-network proxy-service
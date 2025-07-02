# Redis Integration in Springboot
This repository is for simple redis integration with springboot. This is how I test my Redis cache.

## 1.Redis Server Installation
We need to install **WSL** first!
#### WSL installation
<!-- Install window for linus(WSL). -->
    wsl --install

### WSL Terminal Command
    sudo apt update
    sudo apt upgrade -y

### Install Redis    
    sudo apt install redis-server -y
### Start Redis Server
    sudo service redis-server start

## 2.Springboot Setup
    -Add dependencies in Spring Initializr
    -Open IDE(IntelliJ or Elipse etc...)
    -open downloaded folder

### Spring Initializr link.
<https://start.spring.io/>

## 3.Dependencies for simple Redis cache
     <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-redis</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-cache</artifactId>
		</dependency>

### 4.Redis Configuration file
use RedisCacheManager to access Spring Cache's Abstraction.RedisCacheManager is a specific implementation of Spring's CacheManager interface that leverages Redis.
#### RedisCongfig file
![Reference Image](/Redis-server/images/Screenshot%202025-07-02%20231246.png)

#### Expiration(TTL/TTI)
It supports both Time-To-Live (TTL), where an entry expires after a fixed duration from its creation/last update, and Time-To-Idle (TTI), where an entry expires if it hasn't been accessed for a certain duration (though TTL is more commonly used with Redis directly).
#### GenericJackson2JsonRedisSerializer
Serializes objects to JSON, which is often more readable, compact, and interoperable with other languages/systems.

## 5.Docker Image for Redis
![Reference Image](/Redis-server/images/yml%20file.png)
### Run Docker Image
    -Maven Clean
    -Maven Install
    -run Docker command

## 6.Run and Testing
     -Run Spring Application
     -Request URL for Get method
     -localhost:8080/api/Book/getBook

#### Redis Testing
      -redis-cli
      -Keys *
      -Get Keys

### Here is Result
![Reference Image](/Redis-server/images/redis%20test.png)      
         

<a name="readme-top"></a>
<!-- TABLE OF CONTENTS -->
<details>
    <summary>Table of Contents</summary>
    <ol>
        <li>
            <a href="#about-the-project">About The Project</a>
        </li>
        <li>
            <a href="#built-with">Built With</a>
        </li>
        <li>
            <a href="#installation">Installation</a>
        </li>
        <li>
            <a href="#usage">Usage</a>
        </li>
    </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

This is a coding exercise that serves one of the steps of the recruiting process 
of the company <a href="http://www.ioconic.io">Ioconic</a> for a backend developer role.

The idea was to build a small web server solution that serves as a leaderboard, where
the users could:
* Post a score.
* Get Monthly leaderboard.
* Get All Time leaderboard.

The solution should take into consideration high workloads (around 1M concurrent users) 
without sacrificing quality, readability, maintainability, scalability and availability.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Built With

[![Kotlin][Kotlin]][Kotlin-url]
[![Spring][Spring]][Spring-url]
[![Mongo][Mongo]][Mongo-url]
[![Redis][Redis]][Redis-url]
[![Docker][Docker]][Docker-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



## Installation

The solution is contained within multiple docker containers. That are managed via 
a docker-compose configuration. That makes <strong>docker</strong> and <strong>docker-compose</strong> 
the only prerequisites.

After cloning this repo and CD into the root of the project:

1. Build the solution with docker-compose

    ```sh
    docker-compose build 
     ```

2. Run the solution with docker-compose

    ```sh
    docker-compose run 
     ```
This will deploy one instance of the web applicaiton @ localhost port 8080 , one instance of redis and one instance of mongodb.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Usage 

Once the application is deployed the <strong>Swagger</strong> documentation will be 
available [here](localhost:8080/http://localhost:8080/swagger-ui/index.html).

Also, 3 endpoints will be available. 
    
1. Post a score:

    ```sh 
    curl 
    --location 'localhost:8080/score' 
    --request POST
    --header 'Content-Type: application/json' 
    --data '{
    "userId":"123123",
    "score":540000,
    "createdAt": "2023-05-20T22:49:32.913751195"
    }'
    ```

    Note: This endpoint asumes that the score was created at the same time of the request.
    But, you also can set the `createdAt` attribute to post scores on a different
    date like:

    ```sh 
    curl 
    --location 'localhost:8080/score' 
    --request POST
    --header 'Content-Type: application/json' 
    --data '{
    "userId":"123123",
    "score":540000,
    "createdAt": "2023-05-20T22:49:32.913751195"
    }'
    ```

2. Get Monthly leaderboard:

    ```sh 
    curl --location 'localhost:8080/score/leaderboard/monthly'
    ```

3. Get All time leaderboard:

    ```sh 
    curl --location 'localhost:8080/score/leaderboard/all-time'
    ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>


[Kotlin]: https://img.shields.io/badge/Kotlin-0095D5?&style=for-the-badge&logo=kotlin&logoColor=white
[Kotlin-url]:https://kotlinlang.org/

[Spring]: https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white
[Spring-url]:https://spring.io/

[Mongo]:https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white 
[Mongo-url]:https://www.mongodb.com/

[Redis]:https://img.shields.io/badge/redis-%23DD0031.svg?&style=for-the-badge&logo=redis&logoColor=white
[Redis-url]:https://redis.io/

[Docker]:https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white
[Docker-url]:https://www.docker.com/

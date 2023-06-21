package io.ioconic.challenge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RestController
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories

@SpringBootApplication
@EnableMongoRepositories(basePackages = ["io.ioconic.challenge.data_layer.repository.mongo"])
@EnableRedisRepositories(basePackages = ["io.ioconic.challenge.data_layer.repository.redis"])
class ChallengeApplication

fun main(args: Array<String>) {
	runApplication<ChallengeApplication>(*args)
}

package io.ioconic.challenge.data_layer.repository.redis

import io.ioconic.challenge.data_layer.model.Score
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.CrudRepository

interface ScoreRedisRepository : CrudRepository<Score, String> {

}

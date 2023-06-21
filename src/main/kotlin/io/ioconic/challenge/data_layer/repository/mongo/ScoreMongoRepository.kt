package io.ioconic.challenge.data_layer.repository.mongo

import io.ioconic.challenge.data_layer.model.Score
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface ScoreMongoRepository : MongoRepository<Score, String> {

}

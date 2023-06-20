package io.ioconic.challenge.data_layer.score.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.where
import org.springframework.data.repository.Repository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import io.ioconic.challenge.data_layer.score.model.Score
import java.time.LocalDateTime

interface ScoreRepository : MongoRepository<Score, String> {


    @Query("{ \$expr: { \$eq: [ { \$month: \"\$createdAt\" }, { \$month: new Date() } ] } }")
    fun findMonthlyLeaderboard(page:Pageable): List<Score>
}



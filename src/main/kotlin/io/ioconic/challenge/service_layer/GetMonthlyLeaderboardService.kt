package io.ioconic.challenge.service_layer

import io.ioconic.challenge.data_layer.model.Score
import io.ioconic.challenge.data_layer.model.isScoreFromThisMonth
import io.ioconic.challenge.data_layer.repository.redis.ScoreRedisRepository
import java.time.LocalDateTime
import org.springframework.stereotype.Service

@Service
class GetMonthlyLeaderboardService(private val scoreRedisRepository: ScoreRedisRepository) {
    fun execute(): List<Score> {
        val limit = 2
        return scoreRedisRepository
                .findAll()
                .toList()
                .filter { isScoreFromThisMonth(it) } 
                .sortedByDescending { it.score }
                .take(limit)
    }
}

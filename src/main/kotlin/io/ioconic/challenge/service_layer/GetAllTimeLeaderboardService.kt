package io.ioconic.challenge.service_layer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import java.time.LocalDateTime
import io.ioconic.challenge.data_layer.model.Score
import io.ioconic.challenge.data_layer.repository.redis.ScoreRedisRepository


@Service
class GetAllTimeLeaderboardService(private val scoreRedisRepository: ScoreRedisRepository) {
    fun execute(): List<Score>{
        val limit = 2
        return scoreRedisRepository.findAll().toList()
        .sortedByDescending { it.score }
        .take(limit)
    }
}

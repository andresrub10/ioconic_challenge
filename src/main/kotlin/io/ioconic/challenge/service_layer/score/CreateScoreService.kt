package io.ioconic.challenge.service_layer.score

import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDateTime
import io.ioconic.challenge.data_layer.score.repository.ScoreRepository
import io.ioconic.challenge.data_layer.score.model.Score
import org.springframework.stereotype.Service

@Service
class CreateScoreService(private val scoreRepository: ScoreRepository) {
    fun execute(score: Score): Score {
        score.createdAt = LocalDateTime.now()
        return scoreRepository.save(score)
    }
}

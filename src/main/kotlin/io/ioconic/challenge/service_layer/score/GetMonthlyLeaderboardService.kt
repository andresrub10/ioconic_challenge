
package io.ioconic.challenge.service_layer.score

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import java.time.LocalDateTime
import io.ioconic.challenge.data_layer.score.repository.ScoreRepository
import io.ioconic.challenge.data_layer.score.model.Score


@Service
class GetMonthlyLeaderboardService(private val scoreRepository: ScoreRepository) {
    fun execute(): List<Score> {
        return scoreRepository.findMonthlyLeaderboard(PageRequest.of(0, 10).withSort(Sort.by(Sort.Direction.DESC, "score"))).toList()
    }
}

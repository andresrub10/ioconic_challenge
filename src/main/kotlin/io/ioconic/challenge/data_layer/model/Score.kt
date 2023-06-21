package io.ioconic.challenge.data_layer.model

import java.time.LocalDateTime
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.redis.core.RedisHash

@Document(collection = "score")
@RedisHash("score")
data class Score(
        @Id val id: String?,
        val score: Int,
        val userId: String,
        var createdAt: LocalDateTime?
)

fun isScoreFromThisMonth(score: Score): Boolean {
    return score.createdAt?.month == LocalDateTime.now().month
}

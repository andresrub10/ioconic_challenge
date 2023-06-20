package io.ioconic.challenge.data_layer.score.model

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id
import java.time.LocalDateTime


@Document(collection = "score")
data class Score(
        @Id val id: String?,
        val score: Int,
        val userId: String,
        var createdAt: LocalDateTime?

)

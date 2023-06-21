package io.ioconic.challenge.service_layer

import io.ioconic.challenge.data_layer.model.Score
import io.ioconic.challenge.data_layer.model.isScoreFromThisMonth
import io.ioconic.challenge.data_layer.repository.redis.ScoreRedisRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class SyncLeaderboardsService(
        private val scoreRedisRepository: ScoreRedisRepository 
) {
    @Autowired private lateinit var GetMonthlyLeaderboardService: GetMonthlyLeaderboardService

    @Autowired private lateinit var GetAllTimeLeaderboardService: GetAllTimeLeaderboardService

    fun execute(score: Score) {

        var monthlyLeaderboard = GetMonthlyLeaderboardService.execute().toMutableList()
        var allTimeLeaderboard = GetAllTimeLeaderboardService.execute().toMutableList()

        if (isScoreFromThisMonth(score) && monthlyLeaderboard.size < 2) {
            scoreRedisRepository.save(score)
            monthlyLeaderboard.add(score)
        }

        if (allTimeLeaderboard.size < 2) {
            scoreRedisRepository.save(score)
            allTimeLeaderboard.add(score)
        }

        if (isScoreFromThisMonth(score) && score.score > monthlyLeaderboard.last().score) {
            scoreRedisRepository.save(score)
            monthlyLeaderboard.removeLast()
            monthlyLeaderboard.add(score)
        }

        if (score.score > allTimeLeaderboard.last().score) {
            scoreRedisRepository.save(score)
            allTimeLeaderboard.removeLast()
            allTimeLeaderboard.add(score)
        }

        var allScores = scoreRedisRepository.findAll().toList()
        for (actualScore: Score in allScores) {
            if (!monthlyLeaderboard.contains(actualScore) &&
                            !allTimeLeaderboard.contains(actualScore)
            ) {
                scoreRedisRepository.delete(actualScore)
            }
        }
    }
    }

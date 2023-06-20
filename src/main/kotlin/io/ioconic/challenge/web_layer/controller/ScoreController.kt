package io.ioconic.challenge.web_layer.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import io.ioconic.challenge.service_layer.score.CreateScoreService
import io.ioconic.challenge.service_layer.score.GetAllTimeLeaderboardService
import io.ioconic.challenge.service_layer.score.GetMonthlyLeaderboardService
import io.ioconic.challenge.data_layer.score.model.Score

@RestController
@RequestMapping("/score")
class ScoreController {

    @Autowired
    private lateinit var createScoreService: CreateScoreService

    @Autowired
    private lateinit var getAllTimeLeaderboardService: GetAllTimeLeaderboardService

    @Autowired
    private lateinit var getMonthlyLeaderboard: GetMonthlyLeaderboardService

    @PostMapping()
    fun createScore(@RequestBody score: Score): Score {
        return createScoreService.execute(score)
    }

    @GetMapping("/leaderboard/all-time")
    fun getAllTimeLeaderboard(): List<Score> {
        return getAllTimeLeaderboardService.execute()
    }

    @GetMapping("/leaderboard/monthly")
    fun getMonthlyLeaderboard(): List<Score> {
        return getMonthlyLeaderboard.execute()
    }
}

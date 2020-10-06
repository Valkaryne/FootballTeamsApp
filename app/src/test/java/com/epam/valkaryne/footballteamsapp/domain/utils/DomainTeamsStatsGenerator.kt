package com.epam.valkaryne.footballteamsapp.domain.utils

import com.epam.valkaryne.footballteamsapp.domain.model.TeamStatsDomainModel
import com.epam.valkaryne.footballteamsapp.domain.model.TeamsStatsDomainModel
import io.mockk.mockk

object DomainTeamsStatsGenerator {

    fun getUnsortedTeamsStats() = TeamsStatsDomainModel(
        listOf(
            TeamStatsDomainModel(
                position = 3,
                team = mockk(relaxed = true),
                playedGames = 5,
                won = 3,
                draw = 0,
                lost = 2,
                points = 4,
                goalsFor = 11,
                goalsAgainst = 6,
                goalDifference = 5
            ),
            TeamStatsDomainModel(
                position = 4,
                team = mockk(relaxed = true),
                playedGames = 4,
                won = 3,
                draw = 1,
                lost = 0,
                points = 6,
                goalsFor = 10,
                goalsAgainst = 3,
                goalDifference = 7
            ),
            TeamStatsDomainModel(
                position = 2,
                team = mockk(relaxed = true),
                playedGames =6,
                won = 5,
                draw = 0,
                lost = 1,
                points = 9,
                goalsFor = 15,
                goalsAgainst = 7,
                goalDifference = 8
            ),
            TeamStatsDomainModel(
                position = 1,
                team = mockk(relaxed = true),
                playedGames = 6,
                won = 6,
                draw = 0,
                lost = 0,
                points = 12,
                goalsFor = 18,
                goalsAgainst = 1,
                goalDifference = 17
            ),
            TeamStatsDomainModel(
                position = 5,
                team = mockk(relaxed = true),
                playedGames = 3,
                won = 2,
                draw = 1,
                lost = 0,
                points = 4,
                goalsFor = 6,
                goalsAgainst = 3,
                goalDifference = 3
            )
        )
    )

    fun getSortedTeamsStats() = TeamsStatsDomainModel(
        listOf(
            TeamStatsDomainModel(
                position = 1,
                team = mockk(relaxed = true),
                playedGames = 6,
                won = 6,
                draw = 0,
                lost = 0,
                points = 12,
                goalsFor = 18,
                goalsAgainst = 1,
                goalDifference = 17
            ),
            TeamStatsDomainModel(
                position = 2,
                team = mockk(relaxed = true),
                playedGames =6,
                won = 5,
                draw = 0,
                lost = 1,
                points = 9,
                goalsFor = 15,
                goalsAgainst = 7,
                goalDifference = 8
            ),
            TeamStatsDomainModel(
                position = 4,
                team = mockk(relaxed = true),
                playedGames = 4,
                won = 3,
                draw = 1,
                lost = 0,
                points = 6,
                goalsFor = 10,
                goalsAgainst = 3,
                goalDifference = 7
            ),
            TeamStatsDomainModel(
                position = 3,
                team = mockk(relaxed = true),
                playedGames = 5,
                won = 3,
                draw = 0,
                lost = 2,
                points = 4,
                goalsFor = 11,
                goalsAgainst = 6,
                goalDifference = 5
            ),
            TeamStatsDomainModel(
                position = 5,
                team = mockk(relaxed = true),
                playedGames = 3,
                won = 2,
                draw = 1,
                lost = 0,
                points = 4,
                goalsFor = 6,
                goalsAgainst = 3,
                goalDifference = 3
            )
        )
    )
}
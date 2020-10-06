# FootballTeamsApp

FootballTeamsApp is the simple Android application that allows you to see the information about popular football teams. 

# Build

Before building, please, obtain an api-token from https://www.football-data.org/ and put it to build configs.

    buildTypes {
        release {
            ...

            buildConfigField 'String', 'X_AUTH_TOKEN', '"<your_token>"'
        }

        debug {
            buildConfigField 'String', 'X_AUTH_TOKEN', '"<your_token>"'
        }
    }

<!--
# Design Flow of PAT

```mermaid
flowchart TD


    subgraph init[Files]
        direction TB
        uDb[database handler]
        users[users file]
        games[games file]

    end

    subgraph GUI[Main GUI/s]
        direction TB
        gamesPage(Games Page)
        addGame(Game Dev Page)
    end

    subgraph userInit[Login/Signup GUI]
        direction RL
        login(Login)
        signup(Sign up)

    end

    login -> |search for in| uDb
    signup -> |add to| uDb
    uDb -> |reads file| users
    uDb -> |reads file| games
    users -> |returns array| uDb
    games -> |returns array| uDb

    userInit -> GUI
    gamesPage ->|get games| uDb
```
-->

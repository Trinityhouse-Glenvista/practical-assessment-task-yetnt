# Lehlogonolo's PAT

[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/8DST7qRz)

# Class Diagram

**<center>`TextFiles` contains multiple instances of `User` and `Game`'s classes while a User has 0 or more references to a Game's `gameId` property</center>**

```mermaid
classDiagram

class User {
    +String name
    +int age
    +int id
    +UserPermission userPermission
    +String userPassword
    +ArrayList<Integer> ownedGames
    User(name, age, id, perm, games)
    User(name, age, id, perm)
    User(name, age, perm, pass)
    +toTextFileString() String
}

class UserPermission{
    <<enumeration>>
    ADMIN
    DEV
    USER
    UNDEFINED
}

class Game {
    +int gameId
    +int developer
    +String gameName
    +String description
    +int version
    Game(id, name, dev, description, vers)
    +approveGame(gameName)
    +deleteSelf()
    +toTextFileString() String
}

class TextFiles {
    -ArrayList~User~ userArray
    -ArrayList~Game~ gamesArray
    TextFiles()
    -read() void
    +getGames() ArrayList~Game~
    +findGames(condition) ArrayList~Game~
    +findGame(condition) Game
    +getUsers() ArrayList~User~
    +findUsers(condition) ArrayList~User~
    +findUser(condition) User
    +add(game) Game
    +add(user) User
}

TextFiles --> "n" Game : fetches
TextFiles --> "n" User :  fecthes
User --> UserPermission : Can be a
User --> "0..*" Game : owns

```

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
        devPage(Dev Page)
        adminPage(Admin Panel)
    end

    subgraph userInit[Login/Signup GUI]
        direction RL
        login(Login)
        signup(Sign up)

    end

    login <--> |search for in| uDb
    signup --> |add to| uDb
    uDb --> |reads file| users
    uDb --> |reads file| games
    users --> |returns array| uDb
    games --> |returns array| uDb

    userInit -->|after user authentication suceeds| GUI
    gamesPage <-->|get games owned by user| uDb
    devPage <--> |get games made by user| uDb
    adminPage <--> |get all games| uDb

```

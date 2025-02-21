# Lehlogonolo's PAT

[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/8DST7qRz)

# Class Diagram

**<center>`TextFiles` contains multiple instances of `User` and `Game`'s classes while a User has 0 or more references to a Game's `gameId` property</center>**

```mermaid
classDiagram

class User {
    -String name
    -int age
    -int id
    -UserPermission userPermission
    -String userPassword
    -ArrayList<Integer> ownedGames
    User(name, age, id, perm, games)
    User(name, age, id, perm)
}

class UserPermission{
    <<enumeration>>
    ADMIN
    DEV
    USER
    UNDEFINED
}

class Game {
    -int gameId
    -int developer
    -String gameName
    -String description
    -int version
    Game(id, name, dev, description, vers)
    +approveGame(gameName)
    +deleteSelf()
}

class TextFiles {
    -ArrayList~User~ userArray
    -ArrayList~Game~ gamesArray
    TextFiles()
    -read() void
    +getGames() ArrayList~Game~
    +findGames(version) ArrayList~Game~
    +findOneGame(id) Game
    +getUsers() ArrayList~User~
    +findUsers(userPermission) ArrayList~User~
    +findOneUser(id) User
}

TextFiles --> "n" Game : fetches
TextFiles --> "n" User :  fecthes
User --> UserPermission : Can be a
User --> "0..*" Game : owns

```

package main;


import java.util.*;
import java.util.stream.*;

/**
 * The User class represents a user in the system with various attributes such
 * as
 * name, age, id, permission level, password, and owned games. It provides
 * constructors
 * for initializing user objects either from existing data or for newly created
 * users.
 * The class also includes a method to convert the user object to a string
 * representation
 * suitable for saving to a text file.
 */
public class User {

    public String name;
    public int age;
    public int id;
    public UserPermission userPermission;
    public String userPassword;
    public ArrayList<Integer> ownedGames;

    /**
     * Constructs a User object with the specified details.
     *
     * @param name  the name of the user
     * @param age   the age of the user
     * @param id    the unique identifier of the user
     * @param perm  the permission level of the user, represented as an integer
     * @param pass  the password of the user
     * @param games a string representing the games owned by the user, separated by
     *              '|'
     */
    User(String name, int age, int id, int perm, String pass, String games) {
        // This is the constructor used by TextFiles to init existing users.
        this.name = name;
        this.age = age;
        this.id = id;
        this.userPermission = UserPermission.toEnum(perm);
        this.ownedGames = new ArrayList<>();
        this.userPassword = pass;
        Arrays.stream(games.split("\\|"))
                .mapToInt(Integer::parseInt)
                .forEach(this.ownedGames::add);

    }

    /**
     * Constructs a new User instance with the specified name, age, id, permission
     * level, and password.
     * This constructor is used to create a user who has just been created for the
     * first time.
     *
     * @param name the name of the user
     * @param age  the age of the user
     * @param id   the unique identifier for the user
     * @param perm the permission level of the user, which will be converted to a
     *             UserPermission enum
     * @param pass the password for the user
     */
    User(String name, int age, int id, int perm, String pass) {
        // Constructor to create a new user instance with no games from the existing users.
        this.name = name;
        this.age = age;
        this.id = id;
        this.userPassword = pass;
        this.userPermission = UserPermission.toEnum(perm);
        this.ownedGames = new ArrayList<>();
    }
    
    User(String name, int age, int perm, String pass) {
        // Constructor to create a new user instance, this is a user who has just been
        // created for the first time.
        this.name = name;
        this.age = age;
        this.userPassword = pass;
        this.userPermission = UserPermission.toEnum(perm);
        this.ownedGames = new ArrayList<>();
    }

    /**
     * Converts the User object to a string representation suitable for saving to a
     * text file.
     * The format of the string is as follows:
     * 
     * name,age,id,userPermission,userPassword,ownedGames
     * 
     * where:
     * - name: the name of the user
     * - age: the age of the user
     * - id: the unique identifier of the user
     * - userPermission: the user's permission level as an integer
     * - userPassword: the user's password
     * - ownedGames: a pipe-separated list of game IDs owned by the user (empty if
     * no games are owned)
     * 
     * @return a string representation of the User object for text file storage
     */
    public String toTextFileString() {
        return Integer.toString(this.id)
                + "," + this.name
                + "," + Integer.toString(this.age)
                + "," + Integer.toString(this.userPermission.toInt())
                + "," + this.userPassword
                + "," + (!this.ownedGames.isEmpty() ? this.ownedGames.stream()
                        .map(game -> Integer.toString(game.intValue()))
                        .collect(Collectors.joining("|")) : "");
    }
}

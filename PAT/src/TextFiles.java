/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;
import java.io.*;
import java.util.function.Predicate;
import java.util.logging.*;

/**
 * Class that reads file input
 * 
 * @author ACER
 */
public class TextFiles {
    private static ArrayList<User> userArray = new ArrayList<>();
    private static ArrayList<Game> gamesArray = new ArrayList<>();

    TextFiles() {
        this.read();
    }

    /**
     * Reads user and game data from "User.txt" and "Games.txt" files respectively.
     * The method parses each line of the files, skipping the first line (assumed to
     * be headers),
     * and populates the userArray and gamesArray with User and Game objects.
     * 
     * User.txt format:
     * - Each line represents a user with comma-separated values.
     * - The first line is skipped.
     * - If a line has more than 5 values, the User object is created with 6
     * parameters.
     * - Otherwise, the User object is created with 5 parameters.
     * 
     * Games.txt format:
     * - Each line represents a game with comma-separated values.
     * - The first line is skipped.
     * - Each Game object is created with 5 parameters.
     * 
     * If the files are not found, a FileNotFoundException is caught and logged.
     */
    public final void read() {
        try {
            Scanner users = new Scanner(new File("User.txt"));
            Scanner games = new Scanner(new File("Games.txt"));
            int lineNum = -1;
            while (users.hasNextLine()) {
                lineNum++;
                String user = users.nextLine();
                if (lineNum == 0)
                    continue;
                String[] args = user.split(",");
                userArray.add(
                        args.length > 5 ? new User(
                                args[0],
                                Integer.parseInt(args[1]),
                                Integer.parseInt(args[2]),
                                Integer.parseInt(args[3]),
                                args[4],
                                args[5])
                                : new User(
                                        args[0],
                                        Integer.parseInt(args[1]),
                                        Integer.parseInt(args[2]),
                                        Integer.parseInt(args[3]),
                                        args[4]));
            }
            users.close();
            lineNum = -1;
            while (games.hasNextLine()) {
                lineNum++;
                String game = games.nextLine();
                if (lineNum == 0)
                    continue;
                String[] args = game.split(",");
                gamesArray.add(
                        new Game(
                                Integer.parseInt(args[0]),
                                args[1],
                                Integer.parseInt(args[2]),
                                args[3],
                                Integer.parseInt(args[4])));
            }
            games.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Game> getGames() {
        return gamesArray; // Implement file reading logic for Games
    }

    public ArrayList<User> getUsers() {
        return userArray; // Implement file reading logic for Users
    }

    // public static ArrayList<Game> findGames(int version) {
    // ArrayList<Game> games
    // return new ArrayList<>(); // Implement filtering logic
    // }
    //
    // public ArrayList<User> findUsers(UserPermission userPermission) {
    // return new ArrayList<>(); // Implement filtering logic
    // }

    /**
     * Finds and returns a list of games that match the given condition.
     *
     * @param condition the predicate condition to test each game against
     * @return an ArrayList of games that satisfy the given condition
     */
    public ArrayList<Game> findGames(Predicate<Game> condition) {
        ArrayList<Game> games = new ArrayList<>();
        for (Game game : gamesArray) {
            if (condition.test(game)) {
                games.add(game);
            }
        }

        return games;
    }
    
    public Game findGame(Predicate<Game> condition) {
        for (Game game : gamesArray) {
            if (condition.test(game)) {
                return game;
            }
        }
        
        return null;
    }

    /**
     * Finds and returns a list of users that match the given condition.
     *
     * @param condition a Predicate that defines the condition to test each user
     *                  against
     * @return an ArrayList of users that match the given condition
     */
    public ArrayList<User> findUsers(Predicate<User> condition) {
        ArrayList<User> users = new ArrayList<>();
        for (User user : userArray) {
            if (condition.test(user)) {
                users.add(user);
            }
        }

        return users;
    }
    
    public User findUser(Predicate<User> condition) {
        for (User user : userArray) {
            if (condition.test(user)) {
                return user;
            }
        }

        return null;
    }
}

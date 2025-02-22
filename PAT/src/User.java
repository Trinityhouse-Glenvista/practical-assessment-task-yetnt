
import java.util.*;
import java.util.stream.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ACER
 */
public class User {

    public String name;
    public int age;
    public int id;
    public UserPermission userPermission;
    public String userPassword;
    public ArrayList<Integer> ownedGames;

    User(String name, int age, int id, int perm, String pass, String games) {
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

    User(String name, int age, int id, int perm, String pass) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.userPassword = pass;
        this.userPermission = UserPermission.toEnum(perm);
        this.ownedGames = new ArrayList<>();
    }

    public String toTextFileString() {
        return this.name
                + "," + Integer.toString(this.age)
                + "," + Integer.toString(this.id)
                + "," + Integer.toString(this.userPermission.toInt())
                + "," + this.userPassword
                + "," + (!this.ownedGames.isEmpty() ? this.ownedGames.stream()
                .map(game -> Integer.toString(game.intValue()))
                .collect(Collectors.joining("|")) : "");
    }
}

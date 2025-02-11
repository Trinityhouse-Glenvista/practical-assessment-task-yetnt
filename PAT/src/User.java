/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class User {
    private String name;
    private int age;
    private int id;
    private UserPermission userPermission;
    private String userPassword;
    
    private static UserPermission intToEnum(int perm) {
        switch (perm) {
            case 0: return UserPermission.ADMIN;
            case 1: return UserPermission.DEVELOPER;
            case 2: return UserPermission.USER;
            default: return UserPermission.UNDEFINED;
        }
    }
    
    User(String name, int age, int id,int perm) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.userPermission = intToEnum(perm);
    }
}

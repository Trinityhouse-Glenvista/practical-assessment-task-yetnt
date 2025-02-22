/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

/**
 *
 * @author ACER
 */
public enum UserPermission {
    ADMIN(0),
    DEVELOPER(1),
    USER(2),
    UNDEFINED(-1);

    private final int value;

    UserPermission(int value) {
        this.value = value;
    }

    public int toInt() {
        return this.value;
    }

    public static UserPermission toEnum(int perm) {
        for (UserPermission permission : UserPermission.values()) {
            if (permission.value == perm) {
                return permission;
            }
        }
        return UNDEFINED;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

/**
 * 
 * The {@code UserPermission} enum represents different levels of user
 * permissions.
 * Each permission level is associated with an integer value.
 * <ul>
 * <li>{@link #ADMIN} - Represents an admin user with the highest level of
 * permissions (value: 0).</li>
 * <li>{@link #DEVELOPER} - Represents a developer user with elevated
 * permissions (value: 1).</li>
 * <li>{@link #USER} - Represents a regular user with standard permissions
 * (value: 2).</li>
 * <li>{@link #UNDEFINED} - Represents an undefined or unknown permission level
 * (value: -1).</li>
 * </ul>
 * 
 * <p>
 * This enum provides methods to convert between integer values and
 * {@code UserPermission} enums:
 * <ul>
 * <li>{@link #toInt()} - Converts the user permission to its integer
 * value.</li>
 * <li>{@link #toEnum(int)} - Converts an integer value to its corresponding
 * {@code UserPermission} enum.</li>
 * </ul>
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

    /**
     * Converts the user permission value to an integer.
     *
     * @return the integer representation of the user permission value.
     */
    public int toInt() {
        return this.value;
    }

    /**
     * Converts an integer permission value to its corresponding UserPermission
     * enum.
     *
     * @param perm the integer value representing the permission.
     * @return the UserPermission enum corresponding to the given integer value,
     *         or UNDEFINED if no matching permission is found.
     */
    public static UserPermission toEnum(int perm) {
        for (UserPermission permission : UserPermission.values()) {
            if (permission.value == perm) {
                return permission;
            }
        }
        return UNDEFINED;
    }
}

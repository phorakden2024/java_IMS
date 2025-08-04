/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Da Phadenphorakden
 */
public class PermissionCreate {
     private boolean tick;
    private int permissionId;
    private String permissionName;
    private String description; // Added based on the image

    public PermissionCreate(boolean tick, int permissionId, String permissionName, String description) {
        this.tick = tick;
        this.permissionId = permissionId;
        this.permissionName = permissionName;
        this.description = description;
    }

    // Getters
    public boolean isTick() {
        return tick;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public String getDescription() {
        return description;
    }

    // Setters (if you need to modify data in the table later)
    public void setTick(boolean tick) {
        this.tick = tick;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

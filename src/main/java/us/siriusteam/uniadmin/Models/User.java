package us.siriusteam.uniadmin.Models;

import us.siriusteam.uniadmin.utils.Utils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class User {
    private String userName;
    private String password;
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    private String profileImageLocation;
    private UUID uniqueId;
    private List<String> permissions;
    private LocalDate[] payments;


    public User(String userName, String password, String name, String lastName, LocalDate dateOfBirth, String address, String profileImageLocation, List<String> permissions,UUID uniqueId, LocalDate[] payments) {
        this.uniqueId = uniqueId;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.profileImageLocation = profileImageLocation;
        this.permissions = permissions;
        this.payments = payments;
    }

    public User(UUID uniqueId) {
        User userObject = Utils.getUser(uniqueId);
        this.uniqueId = uniqueId;
        assert userObject != null;
        this.userName = userObject.getUserName();
        this.password = userObject.getPassword();
        this.name = userObject.getName();
        this.lastName = userObject.getLastName();
        this.dateOfBirth = userObject.getDateOfBirth();
        this.address = userObject.getAddress();
        this.profileImageLocation = userObject.getProfileImageLocation();
        this.permissions = userObject.getPermissions();
        this.payments = userObject.getPayments();
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfileImageLocation() {
        return profileImageLocation;
    }

    public void setProfileImageLocation(String profileImageLocation) {
        this.profileImageLocation = profileImageLocation;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public LocalDate[] getPayments() {
        return payments;
    }

    public void setPayments(LocalDate[] payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "User{" + "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", profileImageLocation='" + profileImageLocation + '\'' +
                ", uniqueId=" + uniqueId +
                ", permissions=" + permissions +
                ", payments=" + Arrays.toString(payments) +
                '}';
    }
}

package us.siriusteam.uniadmin.Models;

import us.siriusteam.uniadmin.database.sql.users.UsersManager;
import us.siriusteam.uniadmin.utils.Utils;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class UserModel {
    private String userName;
    private String password;
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    private String profileImageLocation;
    private UUID uniqueId;
    private List<String> permissions;


    public UserModel(String userName, String password, String name, String lastName, LocalDate dateOfBirth, String address, String profileImageLocation, List<String> permissions, UUID uniqueId) {
        this.uniqueId = uniqueId;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.profileImageLocation = profileImageLocation;
        this.permissions = permissions;
    }

    public UserModel(UUID uniqueId) throws SQLException {
        UserModel userModelObject = new UsersManager().get(uniqueId);
        this.uniqueId = uniqueId;
        assert userModelObject != null;
        this.userName = userModelObject.getUserName();
        this.password = userModelObject.getPassword();
        this.name = userModelObject.getName();
        this.lastName = userModelObject.getLastName();
        this.dateOfBirth = userModelObject.getDateOfBirth();
        this.address = userModelObject.getAddress();
        this.profileImageLocation = userModelObject.getProfileImageLocation();
    }

    public UserModel() {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserModel{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", address='").append(address).append('\'');
        sb.append(", profileImageLocation='").append(profileImageLocation).append('\'');
        sb.append(", uniqueId=").append(uniqueId);
        sb.append(", permissions=").append(permissions);
        sb.append('}');
        return sb.toString();
    }
}

package api.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {

    private String firstName;
    private String lastName;
    private String userName;
    private String id;
    private List<UserLink> userLinks = new ArrayList<>();

    public UserDTO(String firstName, String lastName, String userName, String id, List<UserLink> userLinks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.id = id;
        this.userLinks = userLinks;
    }

    public UserDTO() {
    }

    //Intellij idea issue with Lombok, should work without getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<UserLink> getUserLinks() {
        return userLinks;
    }

    public void setUserLinks(List<UserLink> userLinks) {
        this.userLinks = userLinks;
    }

}

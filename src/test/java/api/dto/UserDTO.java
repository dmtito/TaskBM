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

}

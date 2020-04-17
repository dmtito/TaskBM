package api.dto;

import lombok.Data;

@Data
public class RegisterDTO {

    private String username;
    private String password;
    private String email;

    public RegisterDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}

package api.dto;

import lombok.Data;

@Data
public class LoginDTO {

    private String login;
    private String pass;

    public LoginDTO(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public LoginDTO(){}

}

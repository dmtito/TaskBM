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

    //Intellij idea issue with Lombok, should work without getters and setters

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

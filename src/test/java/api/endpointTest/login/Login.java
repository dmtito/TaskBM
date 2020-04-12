package api.endpointTest.login;

import api.dto.LoginDTO;
import api.endpointTest.BaseApi;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Login extends BaseApi {

    private final String loginPath = "/login";
    LoginDTO validCred = new LoginDTO("user", "password");

    @Test
    public void validLogin() {
        given()
                .auth().preemptive().basic(validCred.getLogin(), validCred.getPass())
                .when().get(loginPath)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void loginWithWrongPass() {
        given()
                .auth().preemptive().basic(validCred.getLogin(), "wrongPassword")
                .when().get(loginPath)
                .then()
                .assertThat().statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    public void loginWithWrongUserName() {
        given()
                .auth().preemptive().basic("WrongUserName", validCred.getPass())
                .when().get(loginPath)
                .then()
                .assertThat().statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

}

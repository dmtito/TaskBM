package api.endpointTest.login;

import api.dto.LoginDTO;
import api.dto.UserDTO;
import api.endpointTest.BaseApi;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
//import org.junit.Before;
//import org.junit.Test;

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

//    @Test
//    public void getUserById(){
//        String id = "5e92d0f8ee11cb000135ca36";
////        UserDTO user =
//        String s = given()
//                .when()//.pathParam("id", id)
//                .get("customers/5e92d0f8ee11cb000135ca36")
//                .body().prettyPrint();
////                .as(UserDTO.class);
//
//        System.out.println(s);
//    }
}

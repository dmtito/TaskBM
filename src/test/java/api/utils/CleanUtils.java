package api.utils;

import org.apache.http.HttpStatus;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CleanUtils {

    private static final String BASE_USER_LOGIN = "user";
    private static final String BASE_USER_PASS = "password";

    public static void deleteCustomerById(List<String> idList) {
        for (String id : idList) {
            given().auth().preemptive().basic(BASE_USER_LOGIN, BASE_USER_PASS)
                    .pathParam("id", id)
                    .when().delete("/customers/{id}")
                    .then().statusCode(HttpStatus.SC_OK);
        }
    }
}

package api.endpointTest.register;

import api.utils.CleanUtils;
import api.dto.RegisterDTO;
import api.endpointTest.BaseApi;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class Register extends BaseApi {

    private final String registerPath = "/register";
    List<String> idList = new ArrayList<>();
    RegisterDTO registerDTO = new RegisterDTO("u5", "p5", "u5@gmail.con");


    @AfterMethod
    public void clean() {
        if (!idList.isEmpty()) {
            CleanUtils.deleteCustomerById(idList);
        }
    }

    @Test
    public void registerNewUserWithValidCred() {
        Response resp = given()
                .contentType("application/json")
                .body(registerDTO)
                .when().post(registerPath);

        assertEquals(HttpStatus.SC_OK, resp.statusCode());

        getIdFromResp(resp, idList);
    }

    @Test
    public void registerNewUserWithExistedCred() {
        Response resp = given()
                .body(registerDTO)
                .when().post(registerPath);

        getIdFromResp(resp, idList);

        given()
                .body(registerDTO)
                .when().post(registerPath)
                .then()
                .assertThat().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    @Test //should fail
    public void registerNewUserWithNullParams() {
        RegisterDTO brokenDto = new RegisterDTO(null, null, null);

        Response resp = given()
                .body(brokenDto)
                .when().post(registerPath);

        getIdFromResp(resp, idList);

        assertEquals(HttpStatus.SC_INTERNAL_SERVER_ERROR, resp.getStatusCode());


    }

    private List<String> getIdFromResp(Response resp, List<String> idList){
        idList.add(resp.as(RegisterResponse.class).getId());
        return idList;
    }

}

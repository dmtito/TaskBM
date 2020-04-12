package api.endpointTest;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeTest;

public class BaseApi {

    protected static final String BASE_URL = "http://localhost";

    @BeforeTest
    public void init(){
        RestAssured.baseURI = BASE_URL;
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.port = 80;
    }

}

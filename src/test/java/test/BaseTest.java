package test;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest  {
    @BeforeEach
    public void pegarRota() {
        RestAssured.baseURI = "https://teste-deploy-d69a89680fb9.herokuapp.com/api";
    }
}

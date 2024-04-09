package testes;

import io.restassured.RestAssured;

public class BaseTest {

    public static void pegarRota() {
        RestAssured.baseURI = "https://teste-deploy-d69a89680fb9.herokuapp.com/api";
    }
}

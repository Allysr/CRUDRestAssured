package testes;

import io.restassured.RestAssured;

public class BaseTeste {

    public static void pegarRota() {
        RestAssured.baseURI = "https://teste-deploy-d69a89680fb9.herokuapp.com/api";
    }
}

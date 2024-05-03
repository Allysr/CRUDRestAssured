package utils.requests.getUserByID;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ObterDadosUsuario;

public class GetUserByIDRequest {

    public Response obterUsuarioPorID(){
        ObterDadosUsuario obterDadosUsuario = new ObterDadosUsuario();
        Integer id = obterDadosUsuario.criarUsuarioObterResponseRequest().path("id");

        return RestAssured
                .given()
                .pathParam("id", id)
                .when()
                .get("/users/{id}");
    }

    public Response obterUsuarioPorIDInvalido(){
        Integer id = 100000;
        return  RestAssured
                .given()
                .pathParam("id", id)
                .when()
                .get("/users/{id}");
    }
}

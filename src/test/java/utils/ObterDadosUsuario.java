package utils;

import factory.usuario.UsuarioData;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ObterDadosUsuario {

    public Response criarUsuarioObterResponseRequest(){
        UsuarioData usuario = new UsuarioData();

        return  RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.novoUsuario())
                .when().post("/users")
                .then()
                .statusCode(201)
                .extract()
                .response();
    }
}

package utils.requests.putUser;

import factory.usuario.UsuarioData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ObterDadosUsuario;

public class PutUserRequest {

    public Response atualizarUsuarioPorID(){
        UsuarioData usuario = new UsuarioData();
        ObterDadosUsuario obterDadosUsuario = new ObterDadosUsuario();
        Integer id = obterDadosUsuario.criarUsuarioObterResponseRequest().path("id");

        return RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.novoUsuario())
                .when().put("/users/" + id);
    }

    public Response atualizarUsuarioPorCPFInvalido(){
        UsuarioData usuario = new UsuarioData();
        ObterDadosUsuario obterDadosUsuario = new ObterDadosUsuario();
        Integer id = obterDadosUsuario.criarUsuarioObterResponseRequest().path("id");

        return RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.usuarioCPFInvalido())
                .when().put("/users/" + id);
    }

    public Response atualizarUsuarioPorCPFExistente(){
        UsuarioData usuario = new UsuarioData();
        ObterDadosUsuario obterDadosUsuario = new ObterDadosUsuario();
        Integer id = obterDadosUsuario.criarUsuarioObterResponseRequest().path("id");
        String cpf = obterDadosUsuario.criarUsuarioObterResponseRequest().path("cpf");


        return RestAssured
                .given()
                .contentType("application/json")
                .pathParam("id", id)
                .body(usuario.usuarioCPFExistente(cpf))
                .when().put("/users/{id}");
    }

    public Response atualizarUsuarioInexistente(){
        UsuarioData usuario = new UsuarioData();

        return  RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.novoUsuario())
                .when().put("/users/7000");
    }


}

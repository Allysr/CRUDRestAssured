package utils.requests.postUser;

import factory.usuario.UsuarioData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ObterDadosUsuario;

import static utils.Endpoints.USERS;

public class PostUserRequest {

    public Response criarUsuarioRequest(){
        UsuarioData usuario = new UsuarioData();

        return RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.novoUsuario())
                .when().post(USERS);
    }

    public Response criarUsuarioDadosVaziosRequest(){
        UsuarioData usuario = new UsuarioData();

        return RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.usuarioVazio())
                .when().post(USERS);
    }

    public Response criarUsuarioCPFInvalidoRequest(){
        UsuarioData usuario = new UsuarioData();

        return  RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.usuarioCPFInvalido())
                .when().post(USERS);
    }

    public Response criarUsuarioCPFExistenteRequest(){
        UsuarioData usuario = new UsuarioData();
        ObterDadosUsuario obterDadosUsuario = new ObterDadosUsuario();
        String cpf = obterDadosUsuario.criarUsuarioObterResponseRequest().path("cpf");

        return  RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.usuarioCPFExistente(cpf))
                .when().post(USERS);
    }

}

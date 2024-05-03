package utils.requests.PostUser;

import factory.Usuario.UsuarioData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ObterDadosUsuario;

public class PostUserRequest {

    public Response criarUsuarioRequest(){
        UsuarioData usuario = new UsuarioData();

        return RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.novoUsuario())
                .when().post("/users");
    }

    public Response criarUsuarioDadosVaziosRequest(){
        UsuarioData usuario = new UsuarioData();

        return RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.usuarioVazio())
                .when().post("/users");
    }

    public Response criarUsuarioCPFInvalidoRequest(){
        UsuarioData usuario = new UsuarioData();

        return  RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.usuarioCPFInvalido())
                .when().post("/users");
    }

    public Response criarUsuarioCPFExistenteRequest(){
        UsuarioData usuario = new UsuarioData();
        ObterDadosUsuario obterDadosUsuario = new ObterDadosUsuario();
        String cpf = obterDadosUsuario.criarUsuarioObterResponseRequest().path("cpf");

        return  RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.usuarioCPFExistente(cpf))
                .when().post("/users");
    }

}

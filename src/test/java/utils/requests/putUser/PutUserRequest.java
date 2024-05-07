package utils.requests.putUser;

import factory.usuario.UsuarioData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ObterDadosUsuario;

import static utils.Endpoints.USERBYID;

public class PutUserRequest {

    public Response atualizarUsuarioPorID(){
        UsuarioData usuario = new UsuarioData();
        ObterDadosUsuario obterDadosUsuario = new ObterDadosUsuario();
        Integer id = obterDadosUsuario.criarUsuarioObterResponseRequest().path("id");

        return RestAssured
                .given()
                .contentType("application/json")
                .pathParam("id", id)
                .body(usuario.novoUsuario())
                .when().put(USERBYID + "{id}");
    }

    public Response atualizarUsuarioPorCPFInvalido(){
        UsuarioData usuario = new UsuarioData();
        ObterDadosUsuario obterDadosUsuario = new ObterDadosUsuario();
        Integer id = obterDadosUsuario.criarUsuarioObterResponseRequest().path("id");

        return RestAssured
                .given()
                .contentType("application/json")
                .pathParam("id", id)
                .body(usuario.usuarioCPFInvalido())
                .when().put(USERBYID + "{id}");
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
                .when().put(USERBYID + "{id}");
    }

    public Response atualizarUsuarioInexistente(){
        UsuarioData usuario = new UsuarioData();
        Integer id = 7000;

        return  RestAssured
                .given()
                .contentType("application/json")
                .pathParam("id", id)
                .body(usuario.novoUsuario())
                .when().put(USERBYID + "{id}");
    }


}

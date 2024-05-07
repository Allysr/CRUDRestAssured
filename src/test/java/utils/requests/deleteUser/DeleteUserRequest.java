package utils.requests.deleteUser;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ObterDadosUsuario;

import static utils.Endpoints.USERBYID;

public class DeleteUserRequest {

    public Response deletarUsuarioPorID () {
        ObterDadosUsuario obterDadosUsuario = new ObterDadosUsuario();
        Integer id = obterDadosUsuario.criarUsuarioObterResponseRequest().path("id");

        return RestAssured
                .given()
                .pathParam("id", id)
                .when()
                .delete(USERBYID + "{id}");
    }

    public Response deletarUsuarioPorIDInvalido () {
        Integer id = 100000;

        return RestAssured
                .given()
                .pathParam("id", id)
                .when()
                .delete(USERBYID + "{id}");
    }
}

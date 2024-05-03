package test;

import factory.usuario.UsuarioData;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;

public class DeleteUserTest extends BaseTest{

    @Test
    @DisplayName("Deve validar status code 404 ao tentar excluir usuário inexistente")
    public void deveValidarStatusCode404AoTentarExcluirUsuarioInexistente(){
        RestAssured
                .given()
                .when()
                .delete("/users/92382")
                .then()
                .statusCode(404)
                .body("mensagem", containsString("ID do usuário não encontrado"));
    }

    @Test
    @DisplayName("Deve validar status code 204 ao excluir usuário com sucesso")
    public void deveValidarStatusCode200AoExcluirUsuarioComSucesso(){
        UsuarioData usuario = new UsuarioData();

        Integer id = RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.novoUsuario())
                .when().post("/users")
                .then()
                .statusCode(201)
                .extract()
                .path("id");

        RestAssured
                .given()
                .when()
                .delete("/users/" + id)
                .then()
                .statusCode(204);

    }
}

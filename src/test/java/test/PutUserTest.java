package test;

import factory.usuario.UsuarioData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class PutUserTest extends BaseTest {

    @Test
    @DisplayName("Deve validar status code 200 ao atualizar usuário com sucesso")
    public void deveValidarUsuarioEStatusCode200() {
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
                .contentType("application/json")
                .body(usuario.novoUsuario())
                .when().put("/users/" + id)
                .then()
                .statusCode(200);
    }


    @Test
    @DisplayName("Deve validar status code 400 ao enviar CPF inválido")
    public void deveValidarStatus400AoEnviarCPFInvalido() {
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
                .contentType("application/json")
                .body(usuario.usuarioCPFInvalido())
                .when().put("/users/" + id)
                .then()
                .statusCode(400)
                .body("mensagem", equalTo("CPF invalido"));
    }

    @Test
    @DisplayName("Deve validar status code 400 ao tentar atualizar CPF existente")
    public void deveValidarStatus400AoAtualizarCPFExistente() {
        UsuarioData usuario = new UsuarioData();

        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.novoUsuario())
                .when().post("/users")
                .then()
                .statusCode(201)
                .extract()
                .response();

        Integer id = response.path("id");
        String cpf = response.path("cpf");


        RestAssured
                .given()
                .contentType("application/json")
                .pathParam("id", id)
                .body(usuario.usuarioCPFExistente(cpf))
                .when().put("/users/{id}")
                .then()
                .statusCode(400)
                .body("mensagem", equalTo("CPF já cadastrado"));
   }


    @Test
    @DisplayName("Deve validar status code 404 ao tentar atualizar usuário inexistente")
    public void deveValidarStatusCode404AoTentarAtualizarUsuarioInexistente() {
        UsuarioData usuario = new UsuarioData();

        RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.novoUsuario())
                .when().put("/users/7000")
                .then()
                .statusCode(404)
                .body("mensagem", containsString("ID do usuário não encontrado"));
    }

    }

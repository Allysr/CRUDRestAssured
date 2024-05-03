package test;

import factory.Usuario.UsuarioData;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;


public class PostUserTest extends BaseTest {

    @Test
    @DisplayName("Deve validar usuário com status code 201")
    public void deveValidarUsuarioEStatusCode200() {
        UsuarioData usuario = new UsuarioData();

        RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.novoUsuario())
                .when().post("/users")
                .then()
                .statusCode(201);
    }

    @Test
    @DisplayName("Deve validar status code 400 não enviando campos obrigatórios")
    public void deveValidarStatus400NaoEnviandoCamposObrigatorios() {
        UsuarioData usuario = new UsuarioData();

        RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.usuarioVazio())
                .when().post("/users")
                .then()
                .statusCode(400)
                .body("mensagem", equalTo("CPF não pode ser nulo ou vazio"));
    }

    @Test
    @DisplayName("Deve validar status code 400 ao enviar CPF inválido")
    public void deveValidarStatus400AoEnviarCPFInvalido() {
        UsuarioData usuario = new UsuarioData();

        RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.usuarioCPFInvalido())
                .when().post("/users")
                .then()
                .statusCode(400)
                .body("mensagem", equalTo("CPF invalido"));
    }

    @Test
    @DisplayName("Deve validar status code 400 ao tentar cadastrar CPF existente")
    public void deveValidarStatus400AoEnviarCPFExistente() {
        UsuarioData usuario = new UsuarioData();

        String cpf = RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.novoUsuario())
                .when().post("/users")
                .then()
                .statusCode(201)
                .extract()
                .path("cpf");

        RestAssured
                .given()
                .contentType("application/json")
                .body(usuario.usuarioCPFExistente(cpf))
                .when().post("/users")
                .then()
                .statusCode(400)
                .body("mensagem", equalTo("CPF já cadastrado"));
    }

    }

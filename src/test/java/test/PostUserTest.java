package test;

import factory.Usuario.UsuarioData;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.requests.PostUser.PostUserRequest;

import static org.hamcrest.Matchers.equalTo;


public class PostUserTest extends BaseTest {
    public PostUserRequest postUserRequest;

    @BeforeEach
    public void criarPostUserRequest(){
        postUserRequest = new PostUserRequest();
    }

    @Test
    @DisplayName("Deve validar usuário com status code 201")
    public void deveValidarUsuarioEStatusCode200() {
       postUserRequest.criarUsuarioRequest()
                .then()
                .statusCode(201);
    }

    @Test
    @DisplayName("Deve validar status code 400 não enviando campos obrigatórios")
    public void deveValidarStatus400NaoEnviandoCamposObrigatorios() {
        postUserRequest.criarUsuarioDadosVaziosRequest()
                .then()
                .statusCode(400)
                .body("mensagem", equalTo("CPF não pode ser nulo ou vazio"));
    }

    @Test
    @DisplayName("Deve validar status code 400 ao enviar CPF inválido")
    public void deveValidarStatus400AoEnviarCPFInvalido() {
       postUserRequest.criarUsuarioCPFInvalidoRequest()
                .then()
                .statusCode(400)
                .body("mensagem", equalTo("CPF invalido"));
    }

    @Test
    @DisplayName("Deve validar status code 400 ao tentar cadastrar CPF existente")
    public void deveValidarStatus400AoEnviarCPFExistente() {
        postUserRequest.criarUsuarioCPFExistenteRequest()
                .then()
                .statusCode(400)
                .body("mensagem", equalTo("CPF já cadastrado"));
    }

    }

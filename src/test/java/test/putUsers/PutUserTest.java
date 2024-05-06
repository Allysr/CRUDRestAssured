package test.putUsers;

import factory.usuario.UsuarioData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.BaseTest;
import utils.requests.putUser.PutUserRequest;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class PutUserTest extends BaseTest {
    public PutUserRequest putUserRequest;

    @BeforeEach
    public void criarPutUserRequest(){
        putUserRequest = new PutUserRequest();
    }

    @Test
    @DisplayName("Deve validar status code 200 ao atualizar usuário com sucesso")
    public void deveValidarUsuarioEStatusCode200() {
        putUserRequest.atualizarUsuarioPorID()
                .then()
                .statusCode(200);
    }


    @Test
    @DisplayName("Deve validar status code 400 ao enviar CPF inválido")
    public void deveValidarStatus400AoEnviarCPFInvalido() {
        putUserRequest.atualizarUsuarioPorCPFInvalido()
                .then()
                .statusCode(400)
                .body("mensagem", equalTo("CPF invalido"));
    }

    @Test
    @DisplayName("Deve validar status code 400 ao tentar atualizar CPF existente")
    public void deveValidarStatus400AoAtualizarCPFExistente() {
        putUserRequest.atualizarUsuarioPorCPFExistente()
                .then()
                .statusCode(400)
                .body("mensagem", equalTo("CPF já cadastrado"));
   }


    @Test
    @DisplayName("Deve validar status code 404 ao tentar atualizar usuário inexistente")
    public void deveValidarStatusCode404AoTentarAtualizarUsuarioInexistente() {
        putUserRequest.atualizarUsuarioInexistente()
                .then()
                .statusCode(404)
                .body("mensagem", containsString("ID do usuário não encontrado"));
    }

    }

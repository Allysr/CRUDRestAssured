package test.deleteUser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.BaseTest;
import utils.requests.deleteUser.DeleteUserRequest;

import static org.hamcrest.Matchers.containsString;

public class DeleteUserTest extends BaseTest {
    public DeleteUserRequest deleteUserRequest;

    @BeforeEach
    public void deletarUsuarioRequest(){
        deleteUserRequest = new DeleteUserRequest();
    }

    @Test
    @DisplayName("Deve validar status code 404 ao tentar excluir usuário inexistente")
    public void deveValidarStatusCode404AoTentarExcluirUsuarioInexistente(){
        deleteUserRequest.deletarUsuarioPorIDInvalido()
                .then()
                .statusCode(404)
                .body("mensagem", containsString("ID do usuário não encontrado"));
    }

    @Test
    @DisplayName("Deve validar status code 204 ao excluir usuário com sucesso")
    public void deveValidarStatusCode200AoExcluirUsuarioComSucesso(){
        deleteUserRequest.deletarUsuarioPorID()
                .then()
                .statusCode(204);

    }
}

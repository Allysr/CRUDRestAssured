package test.GetUsers;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.BaseTest;
import utils.requests.GetUsers.GetUsersRequest;

import static org.hamcrest.Matchers.*;

public class GetUsersTest extends BaseTest {
    public GetUsersRequest getUsersRequest;

   @BeforeEach
   public void criarGetUserRequest(){
       getUsersRequest = new GetUsersRequest();
   }

    @Test
    @DisplayName("Deve validar lista de usuários com status code 200")
    public void deveValidarListaUsuariosStatusCode200(){
       getUsersRequest.obterUsuarios()
                .then()
                    .statusCode(200)
                    .body("size()", greaterThan(1));
    }

    @Test
    @DisplayName("Deve validar se o formato da resposta é JSON")
    public void deveValidarFormatoRespostaJson(){
        getUsersRequest.obterUsuarios()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    }

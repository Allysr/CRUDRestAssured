package test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class GetUserByIDTest extends BaseTest {

    @BeforeEach
    public void rotaAPI () {
        pegarRota();
    }

    @Test
    @DisplayName("Deve validar usuário com status code 200")
    public void deveValidarUsuarioEStatusCode200(){
        RestAssured
                .given()
                .when()
                    .get("/users/1")
                .then()
                    .statusCode(200)
                    .body("id", isA(Integer.class))
                    .body("nome", isA(String.class))
                    .body("dataNascimento", isA(String.class))
                    .body("cpf", isA(String.class))
                    .body("idade", isA(Integer.class));
        }

    @Test
    @DisplayName("Deve validar se o formato da resposta é JSON")
    public void deveValidarFormatoRespostaJson(){
        RestAssured
                .given()
                .when()
                    .get("/users/1")
                .then()
                    .statusCode(200)
                    .contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("Deve validar status code 404 ao buscar usuario inexistente")
    public void deveValidarStatusCode404AoBuscarUsuarioInexistente(){
        RestAssured
                .given()
                .when()
                    .get("/users/92382")
                .then()
                .statusCode(404)
                .body("mensagem", containsString("ID do usuário não encontrado"));
    }

}

package testes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class GetUsersTest extends BaseTest {

    @BeforeEach
    public void rotaAPI () {
        pegarRota();
    }

    @Test
    @DisplayName("Deve validar lista de usuários com status code 200")
    public void deveValidarListaUsuariosStatusCode200(){
        RestAssured
                .given()
                .when()
                    .get("/users")
                .then()
                    .statusCode(200)
                    .body("size()", greaterThan(1));
    }

    @Test
    @DisplayName("Deve validar se o formato da resposta é JSON")
    public void deveValidarFormatoRespostaJson(){
        RestAssured
                .given()
                .when()
                    .get("/users")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

}

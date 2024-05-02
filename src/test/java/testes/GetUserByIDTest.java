package testes;

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
                    .body("id", is(1))
                    .body("nome", containsString("Victor Test"))
                    .body("dataNascimento", equalTo("04/04/2002"))
                    .body("cpf", equalTo("149.408.830-43"))
                    .body("idade", equalTo(22));
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

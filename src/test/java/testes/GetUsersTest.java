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
    @DisplayName("Deve validar a lista de usuários")
    public void testObterListaDeUsuarios(){
        RestAssured
                .given()
                .when()
                    .get("/users")
                .then()
                    .statusCode(200)
                    .body("size()", greaterThan(1));
    }


    @Test
    @DisplayName("Deve validar os parâmetros de resposta ao obter usuário")
    public void testObterUsuarioValidandoParametrosResposta(){
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
    @DisplayName("Deve validar o formato da resposta ao obter usuário")
    public void testObterUsuarioValidandoFormatoDaResposta(){
        RestAssured
                .given()
                .when()
                    .get("/users/1")
                .then()
                    .statusCode(200)
                    .assertThat()
                    .contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("Deve aparecer uma mensagem de erro ao tentar obter um usuário inexistente")
    public void testObterUsuarioInexistenteValidandoMensagemDeErro(){
        RestAssured
                .given()
                .when()
                    .get("/users/92382")
                .then()
                .statusCode(404)
                .body("mensagem", containsString("ID do usuário não encontrado"));
    }

}

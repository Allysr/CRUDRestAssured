package testes;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class GetUsers extends BaseTeste {

    @BeforeEach
    public void rotaAPI () {
        pegarRota();
    }

    @Test
    @DisplayName("Deve validar os parametros da resposta")
    public void deveValidarOsParametrosdeResposta(){
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
                .body("idade", equalTo(22))
                .log().all();
    }


}

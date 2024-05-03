package utils.requests.GetUsers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUsersRequest {

    public Response obterUsuarios(){
        return RestAssured
                .given()
                .when()
                .get("/users");
    }
}

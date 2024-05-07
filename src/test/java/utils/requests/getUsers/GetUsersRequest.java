package utils.requests.getUsers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static utils.Endpoints.USERS;

public class GetUsersRequest {

    public Response obterUsuarios(){
        return RestAssured
                .given()
                .when()
                .get(USERS);
    }
}

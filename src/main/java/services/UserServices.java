package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.requests.CreateUserRequest;

import static io.restassured.RestAssured.given;

public class UserServices {


    private static RequestSpecification requestSpec = given()
            .header("Content-Type", "application/json")
            .header("accept", "application/json");

    private static ResponseSpecification responseSpec = RestAssured.expect().log().all();

    public Response createUser(CreateUserRequest user) {
        return given()
                .spec(requestSpec)
                .body(user)
                .when()
                .post("/api/v3/user")
                .then()
                .spec(responseSpec)
                .extract()
                .response();

    }

    public Response updateUser(String username, CreateUserRequest userRequest) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .accept("*/*")
                .body(userRequest)
                .when()
                .put( "/api/v3/user/" + username)
                .then().spec(responseSpec)
                .extract()
                .response();
    }

    public Response getUserByUsername(String username) {
        return RestAssured
                .given()
                .accept("application/json")
                .when()
                .get("/api/v3/user/" + username)
                .then().spec(responseSpec)
                .extract()
                .response();
    }

    public Response deleteUserByUsername(String username) {
        return RestAssured
                .given()
                .accept("*/*")
                .when()
                .delete("/api/v3/user/" + username)
                .then().spec(responseSpec)
                .extract()
                .response();
    }

}

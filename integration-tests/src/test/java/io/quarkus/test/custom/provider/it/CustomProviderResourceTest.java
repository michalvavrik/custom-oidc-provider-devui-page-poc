package io.quarkus.test.custom.provider.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class CustomProviderResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/custom-provider")
                .then()
                .statusCode(200)
                .body(is("Hello custom-provider"));
    }
}

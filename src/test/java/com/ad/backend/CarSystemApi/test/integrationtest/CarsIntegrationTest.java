//package com.ad.backend.CarSystemApi.test.integrationtest;
//
//import org.junit.jupiter.api.Test;
//
//public class CarsIntegrationTest {
//    @Test
//    public void testPostExample() {
//        RequestSpe = "https://jsonplaceholder.typicode.com";
//
//        String requestBody = "{“create”:true, id:123}";
//
//        given()
//                .contentType(ContentType.JSON)
//                .header(“X-Securtiy-Toker”, token)
//                .body(requestBody)
//                .when()
//                .post("/person")
//                .then()
//                .statusCode(409)  // conflict
//                .body("error", equalTo("Ya Existe"))
//                .body("body", equalTo("bar"))
//                .body("userId", equalTo(1));
//    }
//
//}

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import model.UserActivity;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RestTest {

    public static Response doGetRequest(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;

        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }

    public static void main(String[] args) {
        Response response = doGetRequest("https://jsonplaceholder.typicode.com/users");

        List<String> jsonResponse = response.jsonPath().getList("$");




        System.out.println(jsonResponse.size());

        UserActivity ua = new UserActivity();

        ua.rfm.put("hola",1);

        System.out.println(ua.rfm.get("hola") + " es el valor para hola");


        String jsonObject = "{\"brand\":\"ford\", \"doors\":5}";

       // ObjectMapper objectMapper = new ObjectMapper();
       // Map<String, Object> jsonMap = objectMapper.readValue(jsonObject,
       //         new TypeReference<Map<String,Object>>(){});

    }
}

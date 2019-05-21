

import com.google.gson.JsonArray;
import com.google.gson.annotations.JsonAdapter;
import com.jcabi.aspects.Loggable;
import despegar.Utils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.*;
import sun.plugin.javascript.JSObject;

import javax.net.ssl.SSLContext;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;


public class RAssured {

    String atpToken;

    @Before
    public void setUp() {
        atpToken = "";
        try {
            atpToken = Utils.getATPToken();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void RestAssuredTest() {

        RequestSpecification request = given().header("Authorization", atpToken).request();
        request.header("x-client", "test");
        request.log().all();
        request.contentType(ContentType.JSON);
        Response res = request.when().get("http://backoffice-aws.despegar.com/erdos-service/v3/users/email:marcelo.urreli@despegar.com/relationships");
        Assert.assertEquals(200, res.getStatusCode());
        Response body = res.then().contentType(ContentType.JSON).extract().response();
    }

    @Test
    public void RestAssuredTest3() {

        RequestSpecification request = given().header("Authorization", atpToken).request();
        request.header("x-client", "test");
        request.log().all();
        request.contentType(ContentType.JSON);
        Response res = request.when().get("http://backoffice-aws.despegar.com/erdos-service/v3/users/email:marcelo.urreli@despegar.com/relationships")
                .then().contentType(ContentType.JSON).extract().response();

        System.out.println(res.getStatusCode() + "    SERVER STATUS");

       Map<String, String> company = res.jsonPath().getMap("relationships");



       System.out.println(company.containsKey("type"));

   }




    @Test
    public void RestAssuredTest2() {


        //"http://backoffice-aws.despegar.com/euler-service/user%252Fupa%253A7bfb3168-0377-4782-bb31-6803773782bd%252Fsegments%252Fdebug%253FwithTripScore%253Dtrue"


        /**
         *     val applicationsScope = PrometeoConfig.getListOf[String]("p13n.prometeo.atp3.applications")
         *
         *     val apacheClient = new HttpClientBuilder(ClientType.APACHE, SSLContext.getDefault).build
         *     val clientId = PrometeoConfig.getStringOrDefault("p13n.prometeo.atp3.clientId", "")
         *     val clientSecret = PrometeoConfig.getString("p13n.prometeo.axtp3.clientSecret")
         *     val privateKey = PrometeoConfig.getString("p13n.prometeo.atp3.privateKey")
         *     val atpEndpoint = PrometeoConfig.getStringOrDefault("p13n.prometeo.atp3.atpEndpoint", "https://auth")
         *     val atp3Client = new ATP3Client.Builder(clientId, clientSecret, privateKey, atpEndpoint)
         *       .httpClient(apacheClient)
         *       .withJsonMapper(JacksonMapper.instance)
         *       .setDefaultParseOption(ParseOption.ALLOW_ANONYMOUS_SOURCE)
         *       .build
         *     new ATP3Helper(atp3Client, applicationsScope, newrelicScheduler)
         */


    }
}

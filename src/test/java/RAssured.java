import com.despegar.atp.ATP3Client;
import com.despegar.atp.http.HttpClientBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import javax.net.ssl.SSLContext;

import java.security.NoSuchAlgorithmException;

import static io.restassured.RestAssured.given;

public class RAssured {


    @Test
    public void RestAssuredTest() {

        RequestSpecification request = given().header("Authorization", "Bearer eyJraWQiOiJhdHAkMTIzIiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJwMTNuLWUyZS10ZXN0cyIsImF1ZCI6WyJlcmRvcyIsInAxM24tZTJlLXRlc3RzIl0sInJjIjpbeyJhcHAiOiJlcmRvcyIsImN0eCI6W3t9XSwicGVyIjpbIlJFQUQiXX1dLCJpc3MiOiJodHRwczpcL1wvYXV0aC5kZXNwZWdhci5jb20iLCJleHAiOjE1MzMwNDcxMzIsImp0aSI6ImE0YmI1Mzg4LWY1NTEtNGE4MS05M2Q4LWEwN2I2YjQzMDZlNyJ9.aMdlfwDRBEq4ufa2Bgv4-Fc-kp34VBDCYN61BTqXgLZ-wXPmaufvjrt1dSGDlewA9Flsu3Dqyq9qkAzEYINeKI9LmQi8ps_OhxDBy54z1rrRCh6CxD8KodiyiiKCUqTEDtTUSSYydYlE9y5GOsvuovGwBKB1ob7NDSyDOtPhUlG1B7pCzxUYpSGChEFGmLDaSpDtnNkPTnqCV4-bhxpJ4ZndGOMI9L1MvbCoFUkrvCYJ0q3aAIvgaIZY-ZY5-jjrag9-2F4o8Zp-ihOKIEI4BgF3H8QciO03Ez6kg5bQQq3OXD5zsTgExKMucoEp_XQOvVquAMB2lIPddGYKp8cTAQ").request();
        request.header("x-client","test");
        request.log().all();
        request.contentType(ContentType.JSON);
        Response res = request.when().get("http://backoffice-aws.despegar.com/erdos-service/v3/users/email:marcelo.urreli@despegar.com/relationships");
        Assert.assertEquals(200,res.getStatusCode());

    }

    @Test
    public void RestAssuredTest2() {


        //"http://backoffice-aws.despegar.com/euler-service/user%252Fupa%253A7bfb3168-0377-4782-bb31-6803773782bd%252Fsegments%252Fdebug%253FwithTripScore%253Dtrue"


        /**
         *     val applicationsScope = PrometeoConfig.getListOf[String]("p13n.prometeo.atp3.applications")
         *
         *     val apacheClient = new HttpClientBuilder(ClientType.APACHE, SSLContext.getDefault).build
         *     val clientId = PrometeoConfig.getStringOrDefault("p13n.prometeo.atp3.clientId", "")
         *     val clientSecret = PrometeoConfig.getString("p13n.prometeo.atp3.clientSecret")
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


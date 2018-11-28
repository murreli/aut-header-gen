import com.despegar.atp.ATP3Client;
import com.despegar.atp.http.HttpClient;
import com.despegar.atp.http.HttpClientBuilder;
import com.despegar.atp.http.mapper.jackson.JacksonMapper;
import com.despegar.atp.jwt.JWT;
import com.despegar.atp.jwt.validators.ParseOption;

import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

public class ATPClient {

    public static void main(String... args) throws NoSuchAlgorithmException {

        Properties prop = new Properties();
        InputStream input = null;

        String home = System.getProperty("user.home") + "/";


        try {

            input = new FileInputStream(home + "sensitive.conf");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("clientId") + " --- > clientId");
            System.out.println(prop.getProperty("clientSecret") + " ---- > applicationSecret ");



        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




        HttpClient apacheClient =
                new HttpClientBuilder(HttpClientBuilder.ClientType.APACHE, SSLContext.getDefault()).build();

        ATP3Client client =
                new ATP3Client.Builder(
                        prop.getProperty("clientId"),
                        prop.getProperty("clientSecret"),
                        prop.getProperty("appKey"),
                        "https://auth")
                        .httpClient(apacheClient)
                        .withJsonMapper(JacksonMapper.instance())
                        .setDefaultParseOption(ParseOption.ALLOW_ANONYMOUS_SOURCE)
                        .build();



       String x = client
                .obtainJwt(client.grantFactory().clientCredentials(), "erdos","euler", "euler-service").asAuthorizationHeader();
       System.out.println(x);
       prop.setProperty("token",x);

               // rest.interceptor(new interceptor)
       //rest.resource().get()

    }



    class Interceptor {
        // parecido a lo de euler
    }

    public static void createNewToken(ATP3Client client) {
        String x =
                client
                        .obtainJwt(client.grantFactory().clientCredentials(), "erdos","euler","euler-service")

                        .asAuthorizationHeader();
        System.out.println(x);
    }


}

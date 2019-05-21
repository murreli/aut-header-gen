package despegar;

import java.security.NoSuchAlgorithmException;

public class Utils {

    public static void main (String args[]) {

    }

    public static String getATPToken() throws NoSuchAlgorithmException {
        String token = ATPClient.getToken();
        return token;
    }
}



package login;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class Authentication {
    Algorithm algorithmHS = Algorithm.HMAC256("secret");


    public void authentication (String login, String pass) {
        String token = JWT.create().withIssuer(login+pass).sign(algorithmHS);
        DecodedJWT jwt = JWT.decode(token);
        System.out.println(jwt.getIssuer());
        System.out.println(jwt.getToken());
        System.out.println(jwt.toString());


    }
}

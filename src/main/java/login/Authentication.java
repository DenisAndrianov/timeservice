package login;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import components.User;
import dbmanagement.Start;

public class Authentication {
    private static Algorithm algorithmHS = Algorithm.HMAC256("secret");
    private static JWTVerifier verifier = JWT.require(algorithmHS).withIssuer().build();

    public static String authentication (String login, String pass) {
        try {
            login = login.toLowerCase();
            User u = Start.UserRepo.findByLoginAndPass(login,pass);
            String token = JWT.create().withIssuer(u.getId().toString()).sign(algorithmHS);
            return token;
        }   catch (Exception e)  {
            return "error";
        }
    }

    public static String decodeTokenToUserId (String token) {
        try {
            DecodedJWT t = verifier.verify(token);
            return t.getIssuer();
        } catch (Exception e)   {
            return "error";
        }
    }
}

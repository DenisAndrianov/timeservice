package login;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import components.User;
import dbmanagement.Start;
import org.json.JSONObject;
import spark.Request;

public class Authentication {
    private static Algorithm algorithmHS = Algorithm.HMAC256("secret");
    private static JWTVerifier verifier = JWT.require(algorithmHS).withIssuer().build();

    /* {
        "login": login,
        "pass": pass,
    }*/
    public static String authentication(Request request) {
        try {
            JSONObject json = new JSONObject(request.body());
            String login = json.getString("login");
            String pass = json.getString("pass");
            login = login.toLowerCase();
            User u = Start.UserRepo.findByLoginAndPass(login, pass);
            String token = JWT.create().withIssuer(u.getId().toString()).sign(algorithmHS);
            return token;
        } catch (Exception e) {
            return "error";
        }
    }

    public static Integer decodeTokenToUserId(String token) {
        try {
            DecodedJWT t = verifier.verify(token);
            return Integer.valueOf(t.getIssuer());
        } catch (Exception e) {
            return -1;
        }
    }
}

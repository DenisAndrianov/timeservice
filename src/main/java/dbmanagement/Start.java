package dbmanagement;

import components.repositories.*;
import login.Authentication;
import login.Registration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import spark.Spark;
import user.UserManage;

import java.util.ArrayList;

import static spark.Spark.*;

@SpringBootApplication
@ImportResource("classpath:Config.xml")
public class Start {
    public static ConfigurableApplicationContext context = SpringApplication.run(Start.class);
    public static OfferRepo OfferRepo = context.getBean(OfferRepo.class);
    public static UserRepo UserRepo = context.getBean(UserRepo.class);

    public static void main(String[] args) {


        post("/reg", (request, response) -> {
            return Registration.registrationByUser(UserManage.getUserRegister(request.body()));
        });

        get("/auth", (request, response) -> {
            String r = request.body();
            String l;
            String p;
            l = r.substring(0, r.indexOf("\n"));
            p = r.substring(r.indexOf("\n" + 1));
            response.body(Authentication.authentication(l, p));
            return null;
        });
    }
}

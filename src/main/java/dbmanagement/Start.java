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

import static spark.Spark.*;

@SpringBootApplication
@ImportResource("classpath:Config.xml")
public class Start {
    public static ConfigurableApplicationContext context = SpringApplication.run(Start.class);
    public static OfferRepo OfferRepo = context.getBean(OfferRepo.class);
    public static UserRepo UserRepo = context.getBean(UserRepo.class);

    public static void main(String[] args) {

        System.out.println("PORT::::::" + Spark.port());

        post("/reg", (request, response) -> {
            return Registration.registrationByUser(UserManage.getUser(response.body()));
        });

        get("/auth", (request, response) -> {
            String r = request.body();
            String l;
            String p;
            l = r.substring(0, r.indexOf("\n"));
            p = r.substring(r.indexOf("\n" + 1), r.length());
            response.body(Authentication.authentication(l, p));
            return null;
        });
    }
}

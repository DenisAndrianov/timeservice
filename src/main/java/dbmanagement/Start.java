package dbmanagement;

import components.repositories.OfferRepo;
import components.repositories.UserRepo;
import login.Authentication;
import login.Registration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import static spark.Spark.get;
import static spark.Spark.post;

@SpringBootApplication
@ImportResource("classpath:Config.xml")
public class Start {
    public static ConfigurableApplicationContext context = SpringApplication.run(Start.class);
    public static OfferRepo OfferRepo = context.getBean(OfferRepo.class);
    public static UserRepo UserRepo = context.getBean(UserRepo.class);

    public static void main(String[] args) {


        post("/reg", (request, response) -> {
            response.body(Registration.registration(request));
            return null;
        });

        get("/auth", (request, response) -> {
            response.body(Authentication.authentication(request));
            return null;
        });
    }
}

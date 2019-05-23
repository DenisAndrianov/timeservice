package dbmanagement;

import components.repositories.UserRepo;
import components.User;
import login.Authentication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:Config.xml")
public class Start {
    public static ConfigurableApplicationContext context = SpringApplication.run(Start.class);

    public static void main(String[] args) {


        UserRepo repo = context.getBean(UserRepo.class);
        new Authentication().authentication("MyLogin", "MyPasss");

    }

}

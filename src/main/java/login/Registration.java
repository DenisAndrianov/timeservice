package login;

import components.User;
import components.repositories.UserRepo;
import dbmanagement.Start;

import static spark.route.HttpMethod.get;

public class Registration {
    public void registration (String login, String pass, String firstName, String lastName, Boolean vendorFlag) {
        UserRepo userRepo = Start.context.getBean(UserRepo.class);
        login.toLowerCase();
        userRepo.save(new User(login, pass, firstName ,lastName ,vendorFlag));
    }

}

package login;

import components.User;
import components.repositories.UserRepo;
import dbmanagement.Start;

import static spark.route.HttpMethod.get;

public class Registration {

    public static String registration (String login, String pass, String firstName, String lastName, Boolean vendorFlag) {
        UserRepo userRepo = Start.context.getBean(UserRepo.class);
        login = login.toLowerCase();
        try {
            userRepo.save(new User(login, pass, firstName ,lastName ,vendorFlag));
            return "Successfully";
        }   catch (Exception e) {
            return "Error";
        }
    }
    public static String registrationByUser (User u)    {
        try {
            u.setLogin(u.getLogin().toLowerCase());
            Start.UserRepo.save(u);
        }   catch (Exception e) {
            return "Error";
        }
        return "Successfully";
    }
}

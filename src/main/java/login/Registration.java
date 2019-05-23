package login;

import components.User;
import dbmanagement.Start;
import org.json.JSONObject;
import spark.Request;

public class Registration {

    public static String registration(Request request) {
        try {
            JSONObject json = new JSONObject(request.body());
            String login = json.getString("login");
            String pass = json.getString("pass");
            String firstName = json.getString("firstName");
            String lastName = json.getString("lastName");
            boolean vendorFlag = json.getBoolean("vendorFlag");
            User u = new User(login, pass, firstName, lastName, vendorFlag);
            Start.UserRepo.save(u);
            return "Successfully";
        } catch (Exception e) {
            return "Error";
        }
    }

    public static String registrationByUser(User u) {
        try {
            u.setLogin(u.getLogin().toLowerCase());
            Start.UserRepo.save(u);
        } catch (Exception e) {
            return "Error";
        }
        return "Successfully";
    }
}

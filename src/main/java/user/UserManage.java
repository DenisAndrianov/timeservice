package user;

import components.User;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;


public class UserManage {
    //User(String login, String pass, String firstName, String lastName, Boolean vendorFlag)
   /* {
        "login": login,
        "pass": pass,
        "firstName": firstname,
        "lastName": lastName,
        "vendorFlag": vendorFlag,
    }*/
   public static User getUser (String response)    {
       JSONObject json = new JSONObject(response);
       String login = json.getString("login");
       String pass = json.getString("pass");
       String firstName = json.getString("firstName");
       String lastName = json.getString("lastName");
       boolean vendorFlag = json.getBoolean("vendorFlag");
       return new User (login, pass, firstName, lastName, vendorFlag);
   }

}

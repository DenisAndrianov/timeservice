package user;

import components.Offer;
import components.User;
import dbmanagement.Start;
import login.Authentication;
import org.json.JSONObject;
import spark.Request;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public class UserManage {
    //User(String login, String pass, String firstName, String lastName, Boolean vendorFlag)
   /* {
        "login": login,
        "pass": pass,
        "firstName": firstname,
        "lastName": lastName,
        "vendorFlag": vendorFlag,
    }*/
    public static User getUserRegister(String request) {
        JSONObject json = new JSONObject(request);
        String login = json.getString("login");
        String pass = json.getString("pass");
        String firstName = json.getString("firstName");
        String lastName = json.getString("lastName");
        boolean vendorFlag = json.getBoolean("vendorFlag");
        return new User(login, pass, firstName, lastName, vendorFlag);
    }

    /* {
         "token": token,
         "vendorsId": vendorsId,
     }*/
    public static String addVendorToUser(Request request) {

        try {
            JSONObject json = new JSONObject(request.body());
            String token = json.getString("token");
            Integer vendorsId = json.getInt("vendorsId");
            Integer userId = Authentication.decodeTokenToUserId(token);
            User u = Start.UserRepo.findById(userId).get();
            User v = Start.UserRepo.findById(vendorsId).get();
            u.getVendors().add(v);
            Start.UserRepo.save(u);
            return "Successfully";
        } catch (Exception e) {
            return "Error";
        }
    }

    /* {
         "token": token,
         "vendorsId": vendorsId,
     }*/
    public static JSONObject listOffersByOwners (Request request)  {
        JSONObject json = new JSONObject(request.body());
        String token = json.getString("token");
        Integer userId = Authentication.decodeTokenToUserId(token);
        User u = Start.UserRepo.findById(userId).get();
        Set<Offer> list = Start.OfferRepo.findAllByOwner(u.getVendors());
        JSONObject answer = new JSONObject(list);
        return answer;
    }

    /* {
         "token": token,
         "offerId": Integer offerId,
     }*/
    public static String signOfferByUserId (Request request)    {

        try {
            JSONObject json = new JSONObject(request.body());
            String token = json.getString("token");
            Integer userId = Authentication.decodeTokenToUserId(token);
            Integer offerId = json.getInt("offerId");
            User u = Start.UserRepo.findById(userId).get();
            Offer o = Start.OfferRepo.findById(offerId).get();
            u.getSigns().add(o);
            o.setSign(u);
            Start.UserRepo.save(u);
            Start.OfferRepo.save(o);
        }   catch (Exception e) {
            return "Error";

        }
        return "Successfully";
    }

    /* {
         "token": String,
         "start": long,
         "end": long,
         "note": String,
     }*/
    public static String createOffer (Request request)  {
        try {
            JSONObject json = new JSONObject(request.body());
            String token = json.getString("token");
            Integer userId = Authentication.decodeTokenToUserId(token);
            User u = Start.UserRepo.findById(userId).get();
            if (!u.getVendorFlag()) {
                throw new Exception();
            }
            Long start = json.getLong("start");
            Long end = json.getLong("end");
            String note = json.getString("note");
            Start.OfferRepo.save(new Offer(u, note, start, end));
        }   catch (Exception e) {
            return "Error";
        }
        return "Successfully";
    }

    /* {
         "token": String,
         "offerId": int,
     }*/
    public static String deleteOffer (Request request)  {
        try {
            JSONObject json = new JSONObject(request.body());
            String token = json.getString("token");
            Integer userId = Authentication.decodeTokenToUserId(token);
            User u = Start.UserRepo.findById(userId).get();
            Offer o = Start.OfferRepo.findById(json.getInt("offerId")).get();
            if (o.getOwner()==u){
                Start.OfferRepo.delete(o);
                return "Successfully";
            }
            throw new Exception();
        }   catch (Exception e) {
            return "Error";
        }
    }


}

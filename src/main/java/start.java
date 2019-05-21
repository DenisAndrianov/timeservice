import dbmanagement.DBconnection;
import login.Registration;
import user.ListOffers;
import user.UserProfile;
import vendor.OfferCreate;

import java.sql.Timestamp;

public class start {


    public static void main(String[] args) {
        new DBconnection();
        Registration reg = new Registration();
        reg.registration("ИМЯ", "ФАМИЛИЯ", true, "login", "pass");
        OfferCreate off = new OfferCreate();
        int i = 0;
        /*while (i < 15){
            off.createOffer(new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis() + ((int) (Math.random() * 5000000))), "TEST TEXT", 36);
            i++;
        }*/

        System.out.println(new ListOffers().listOffersByVenid(36).toString());
        //new UserProfile().addVendor(1,10001);
        //new UserProfile().removeVendor(1,10001);
    }
}

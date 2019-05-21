import dbmanagement.DBconnection;
import login.Registration;
import user.UserProfile;
import vendor.OfferCreate;

public class start {


    public static void main(String[] args) {
        new DBconnection();
        Registration reg = new Registration();
        System.out.println(reg.registration());
        OfferCreate off = new OfferCreate();
        off.createOffer();
        new UserProfile().addVendor(1,10001);
        new UserProfile().removeVendor(1,10001);
    }
}

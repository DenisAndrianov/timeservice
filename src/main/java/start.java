import dbmanagement.DBconnection;
import login.Registration;
import vendor.OfferCreate;

import java.util.HashSet;

public class start {


    public static void main(String[] args) {
        new DBconnection();
        Registration reg = new Registration();
        System.out.println(reg.registration());
        OfferCreate off = new OfferCreate();
        off.createOffer();
    }
}

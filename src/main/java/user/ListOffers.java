package user;

import dbmanagement.DBconnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class ListOffers {

    public HashSet listOffersByVenid(int venid) {
        String bdSelect = "SELECT o.timestart, o.id, u.firstname, u.lastname, o.note, o.timeend " +
                "FROM offer o, users u " +
                "WHERE " + venid + " = o.vendors AND o.users = 0 AND o.vendors = u.id;";
        System.out.println(bdSelect);
        HashSet<String> set = new HashSet<>();
        try (Statement reg = DBconnection.db.createStatement()) {
            ResultSet res = reg.executeQuery(bdSelect);
            res.next();
            while (true) {
                String buff = new String();
                for (int j = 1; j < 7; j++) {
                    buff += res.getString(j) + "; ";
                }
                set.add(buff);
                res.next();
            }
        } catch (SQLException e) {
            if (e.getMessage().equals("ResultSet not positioned properly, perhaps you need to call next.")) {
                System.out.println("okay");
                return set;
            }
            e.printStackTrace();
            return null;
        }
    }
}

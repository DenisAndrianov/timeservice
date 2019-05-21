package vendor;

import dbmanagement.DBconnection;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class OfferCreate {

    public boolean createOffer(Timestamp start, Timestamp end, String node, int vendorId) {
        String bdInsert = "INSERT INTO offer (vendors, note, timestart, timeend) " +
                "VALUES ('" + vendorId + "', '" + node + "' ,'" + start + "', '" + end + "');";
        System.out.println(bdInsert);
        try (Statement reg = DBconnection.db.createStatement()) {
            reg.executeQuery(bdInsert);
        } catch (SQLException e) {
            if (e.getMessage().equals("Запрос не вернул результатов.")) {
                System.out.println("OK");
                return true;
            }
            e.printStackTrace();
            return false;
        }
        return false;
    }


}

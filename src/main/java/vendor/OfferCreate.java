package vendor;

import dbmanagement.DBconnection;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class OfferCreate {
    Timestamp start = new Timestamp(System.currentTimeMillis());
    Timestamp end = new Timestamp(System.currentTimeMillis()+600000);
    String node = "123 йцукен qwerty";
    int vendorId = 1;

    public boolean createOffer() {
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

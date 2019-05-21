package user;

import dbmanagement.DBconnection;
import org.postgresql.jdbc.PgSQLXML;

import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class ChangeSelf {
    void addVendor (int venid, int usid)   {
        HashSet<Integer> set = new HashSet();
        set.add(2);
        set.add(26);
        set.add(123452);
        set.add(23623);
        String bdUpdate = "UPDATE INTO users SET vendors";
        System.out.println(bdUpdate);
        try (Statement reg = DBconnection.db.createStatement()){
            reg.executeQuery(bdUpdate);
            ObjectInputStream ois = new ObjectInputStream(set.);
        } catch (SQLException e) {
            if (e.getMessage().equals("Запрос не вернул результатов."))  {
                System.out.println("OK");
                return true;}
            e.printStackTrace();
            return false;
        }
        return false;
    }
}

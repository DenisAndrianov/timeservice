package user;

import dbmanagement.DBconnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserProfile {
    public boolean addVendor(int usid, int venid) {
        HashSet<Integer> set = new HashSet<>();
        set.add(venid);
        String resSelect;
        try (Statement reg = DBconnection.db.createStatement()) {
            String bdSelect = "SELECT vendors FROM users WHERE id=" + usid + ";";
            ResultSet res = reg.executeQuery(bdSelect);
            res.next();
            resSelect = res.getString(1);
            if (resSelect != null) {
                Pattern pat = Pattern.compile("[0-9]+");
                Matcher mat = pat.matcher(resSelect);
                while (mat.find()) {
                    set.add(Integer.valueOf(mat.group()));
                    System.out.println(set);
                }
            }
            String bdUpdate = "UPDATE users SET vendors='" + set + "' WHERE id = " + usid + ";";
            reg.executeQuery(bdUpdate);
        } catch (SQLException e) {
            if (e.getMessage().equals("Запрос не вернул результатов.")) {
                System.out.println("Vendor добавлен");
                return true;
            }
            e.printStackTrace();
            return false;
        }
        return false;
    }
}

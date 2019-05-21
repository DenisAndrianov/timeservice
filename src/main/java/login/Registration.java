package login;

import dbmanagement.DBconnection;

import java.sql.*;

public class Registration {
    public boolean registration (String fn, String ln, boolean role, String login, String pass)   {
        String lowerCaselog = login.toLowerCase();
        String bdInsert = "INSERT INTO users (firstname, lastname, role, login, pass) " +
                "VALUES ('"+fn+"', '"+ln+"' ,'"+role+"' ,'"+lowerCaselog+"' ,'"+pass+"');";
        System.out.println(bdInsert);
        try (Statement reg = DBconnection.db.createStatement();){
            reg.executeQuery(bdInsert);
        } catch (SQLException e) {
            if (e.getMessage().equals("ERROR: duplicate key value violates unique constraint \"users_login_key\"\n" +
                    "  Подробности: Key (login)=(" + lowerCaselog + ") already exists."))    {
                System.out.println("Данный логин уже существует");
                return false;
            }   if (e.getMessage().equals("Запрос не вернул результатов."))  {
                System.out.println("Успешная регистрация");
                return true;
            }
            e.printStackTrace();
        }

        return false;
    }

}

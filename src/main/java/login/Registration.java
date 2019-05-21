package login;

import dbmanagement.DBconnection;

import java.sql.*;

public class Registration {
    String firstname = "Odin";
    String lastname = "Dva";
    boolean role;
    String login = "AdMiN";
    String pass = "123312asdSdq";

    public boolean registration ()   {
        String lowerCaselog = login.toLowerCase();
        String bdInsert = "INSERT INTO users (firstname, lastname, role, login, pass) " +
                "VALUES ('"+firstname+"', '"+lastname+"' ,'"+role+"' ,'"+lowerCaselog+"' ,'"+pass+"');";
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

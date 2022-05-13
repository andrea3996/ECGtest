/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulb.lisa.projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;



/**
 *
 * @author user
 */
public class Main {
    public static void main(String args[]) throws SQLException{
    String driver = "com.mysql.cj.jdbc.Driver"; // connexion entre java et  mysql
    String userName = "student";
    String password = "1234";
    String url = "jdbc:mysql://localhost/test?serverTimezone=Europe/Brussels"; // ou est-ce qu'il y a 1 DB qui tourne
    
    
    //Connection conn = null;
    //Class.forName(driver).newInstance();
    Connection conn = DriverManager.getConnection(url, userName, password);
    System.out.println("Connected to the database.");
    PreparedStatement s = conn.prepareStatement("SELECT IDperson, Name, Surname, dateOfBirth, username, password FROM person;");
    ResultSet rs = s.executeQuery();
    while(rs.next()){
    int id = rs.getInt("IDperson");
    String firstName = rs.getString("Name");
    String lastName = rs.getString("Surname");
    Date dateOfBirth = rs.getDate("dateOfBirth");
//    String username = rs.getString("username");
//    String password = rs.getString("password");
    System.out.println("[" + id + "] " + firstName + " " +
    lastName.toUpperCase() + dateOfBirth);
    }
    rs.close();
    s.close(); }
}

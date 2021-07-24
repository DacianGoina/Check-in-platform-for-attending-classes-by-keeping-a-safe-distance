package com.example.springbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class SpringBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBackendApplication.class, args);
        System.out.println("da");

        // am testat baza de date
        /*try {
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "dacianG", "finalbijection@");
            Statement st = conn.createStatement();
            ResultSet rez = st.executeQuery("SELECT * FROM USERS");
            System.out.println("am reusit!");
            while(rez.next()){
                System.out.println(rez.getString(1) + " " + rez.getString(3));
            }
        }catch (SQLException e){
            e.printStackTrace();

        }*/
    }

}

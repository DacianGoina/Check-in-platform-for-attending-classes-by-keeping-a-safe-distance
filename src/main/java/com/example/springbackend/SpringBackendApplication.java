package com.example.springbackend;

import com.example.springbackend.controller.UserController;
import com.example.springbackend.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Query;
import java.sql.*;
import java.util.List;

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

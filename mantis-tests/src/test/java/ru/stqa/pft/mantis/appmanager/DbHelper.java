package ru.stqa.pft.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 18.06.2017.
 */
public class DbHelper {


    private  ApplicationManager app;

    public DbHelper(ApplicationManager app) {
        this.app = app;
    }


    public String getUserName(){
        Connection conn = null;
         List<String> result = new ArrayList<>();





        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bugtracker?user=root&password=");
            //mantisbt-2.5.1
            Statement st =conn.createStatement();
            ResultSet rs = st.executeQuery("select username from mantis_user_table where username<>'administrator'");


            while (rs.next()){
               result.add(rs.getString("username"));
            }
            rs.close();
            st.close();
            conn.close();
            return result.get(1);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        }

    }
}




package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

    public void connect() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rbcompany", "root", "123456");
            System.out.println("Success");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

}

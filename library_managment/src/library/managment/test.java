package library.managment;

import java.sql.*;
import static library.managment.books_issued.uName;

public class test {
    public static void main(String[] args) {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBMS_Project?useSSL=false", "root", "ani123");
            Statement stm = conn.createStatement();
            String query = "select count(*) from lib_book;";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                System.out.println("Next Book No. : B"+rs.getInt("count(*)"));
            }
            conn.close();
        }
        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}

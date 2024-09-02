import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection c=null;
    Statement s=null;
        Conn(){
            try {
                Class.forName("org.postgresql.Driver");
                // PostgreSQL
              // c= DriverManager.getConnection("jdbc:postgresql://localhost:5432/HotelManagementSystem","postgres","suraj123");

               // MySQL
               c= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","");

                s=c.createStatement();

            }
            catch (Exception e){
                System.out.println(e);
            }
        }
}

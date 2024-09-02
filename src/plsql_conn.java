import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class plsql_conn{
    public static void main(String args[]){
        System.out.println("Postgresql connection");
        Connection c=null;
        Statement stmt=null;
        try {
            Class.forName("org.postgresql.Driver");
            c= DriverManager.getConnection("jdbc:postgresql://localhost:5432/HotelManagementSystem","postgres","suraj123");
            stmt=c.createStatement();
            if(c!=null){
                System.out.println("Connected Successfully ");
//                String name="suraj aghav";
//                int id=123;
//                String query="insert into student values('"+id+"','"+name+"')";
//                stmt.executeUpdate(query);
//                System.out.println("value inserted");
//
                // retrive data from table
//                ResultSet rs=stmt.executeQuery("select *from student");
//                while (rs.next()){
//                    System.out.println(rs.getString(1)+rs.getString(2)+"\t"+rs.getString(3));
//                }
            }
        }
        catch (Exception e){
            System.out.println("error in DB"+e);
        }
    }
}
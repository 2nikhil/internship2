import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResourceBundle;
import java.sql.Statment;
import java.sql.ResultSet
public class test{

 public static void main(String args[]){

 try{

   String url="jdbc:mysql://localhost/asset_management";
    Class.forName("com.mysql.jdbc.Driver");
    Connection c= DriverManager.getConnection(url,"root","nikhil");
    Statement stmt= c.createStatement();
  ResultSet rs=stmt.executeQuery("select * from mi_mobiledevice");
   while(rs.next())
     System.out.println(rs.getBoolean("allowed_upgrade"));
	rs.asset_number("asset_number");
	}
   catch(SQLException e)
  {
     e.printstackTrace();
  }

   finally {
    c.close();
}  
   
 }
}
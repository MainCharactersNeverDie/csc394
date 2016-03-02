package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connector{
    private static Connection conn = null;
    public static Connection getConnection(){
        if(conn == null){
            try {
                conn = DriverManager.getConnection("jdbc:mysql://mako.arvixe.com/themoose_jobscam?" + "user=&password=");

            } catch (SQLException ex) {
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        }
        return conn;
    }
}

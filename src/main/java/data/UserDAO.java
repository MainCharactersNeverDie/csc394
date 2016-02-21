package data;
import java.util.*;
import java.util.Map.Entry;
import java.sql.*;
import data.*;

public class UserDAO{ 
    Connection conn = null;
    public UserDAO(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/csc394?" + "user=root&password=");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    public ResultSet retrieveData(Map<String, Map<String, String>> filters){
        String sql = 
            "SELECT * "               +
            "FROM "                   +
            "users u"                 +
            "LEFT JOIN"               +
            "experience e"            +
            "ON "                     +
            "e.entity_id = u.user_id" +
            "LEFT JOIN  "             +
            "experience_lookup l"     +
            "ON"                      +
            "e.exp_id = l.exp_id"     +
            "WHERE"                   +
            "l.type = 1";
        Iterator<Entry<String, Map<String, String>>> it = filters.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Map<String, String>> pair = (Map.Entry)it.next();
            sql += "AND";
            String operator = pair.getKey();
            Iterator<Entry<String, String>> values = pair.getValue().entrySet().iterator();
            while (values.hasNext()) {
                Map.Entry<String, String> key_value = (Map.Entry)values.next();
                sql += key_value.getKey() + operator + key_value.getValue();
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
        try{
            Statement stmt   = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            return result;
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }
    public int writeData(Map<String, String> data){
        String sql = "INSERT INTO users (first_name, last_name, address, phone, email, type, company_name, password_hash, salt, date_updated, date_created) VALUES(";
            sql += ((data.containsKey("first_name"))  ? "\'" + data.get("first_name") + "\'" :      "null") + "," ;
            sql += (data.containsKey("last_name")     ? "\'" + data.get("last_name") + "\'" :     "null") + "," ;
            sql += (data.containsKey("address")       ? "\'" + data.get("addresss") + "\'" :      "null") + "," ;
            sql += (data.containsKey("phone")         ? "\'" + data.get("phone") + "\'" :         "null") + "," ;
            sql += (data.containsKey("email")         ? "\'" + data.get("email") + "\'" :         "null") + "," ;
            sql += (data.containsKey("type")          ? "\'" + data.get("type") + "\'" :          "null") + "," ;
            sql += (data.containsKey("company_name")  ? "\'" + data.get("company_name") + "\'" :  "null") + "," ;
            sql += (data.containsKey("password_hash") ? "\'" + data.get("password_hash") + "\'" : "null") + "," ;
            sql += (data.containsKey("salt")          ? "\'" + data.get("salt") + "\'" :          "null") + "," ;
            sql += (data.containsKey("date_created")  ? "\'" + data.get("date_created") + "\'" :  "null") + "," ;
            sql += (data.containsKey("date_updated")  ? "\'" + data.get("date_updated") + "\'" :  "null");
            sql += ")";
        try{
            Statement stmt   = conn.createStatement();
            return stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return 0;
    }
    public int updateData(Map<String, String> data, String id){
        String sql = "UPDATE users SET "; 
        Iterator<Entry<String, String>> it = data.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pair = (Map.Entry)it.next();
            sql += pair.getKey() + '=' + "\'" + pair.getValue() + "\' "; 
            if(it.hasNext()){
                sql += ",";
            }
        }
        sql += " WHERE user_id = " + id;
        System.out.println(sql);
        try{
            Statement stmt   = conn.createStatement();
            return stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return 0;
    }
    public static void main(String[] args) {
        UserDAO user = new UserDAO();
        HashMap<String, String> test = new HashMap<String, String>();
        test.put("first_name", "Test");
        test.put("last_name", "Test");
    }
}


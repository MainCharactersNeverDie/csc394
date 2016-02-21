package data;
import java.util.*;
import java.util.Map.Entry;
import java.sql.*;
import data.*;

public class ExperienceDAO{ 
    Connection conn = null;
    public ExperienceDAO(){
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
            "SELECT * "                +
            "FROM "                    +
            "experience"               +
            "LEFT JOIN  "              +
            "experience_lookup lookup" +
            "ON"                       +
            "experience.exp_id = lookup.exp_id";
        Iterator<Entry<String, Map<String, String>>> it = filters.entrySet().iterator();
        if(it.hasNext())
            sql += " WHERE ";
        while (it.hasNext()) {
            Map.Entry<String, Map<String, String>> pair = (Map.Entry)it.next();
            sql += "AND";
            String operator = pair.getKey();
            Iterator<Entry<String, String>> values = pair.getValue().entrySet().iterator();
            while (values.hasNext()) {
                Map.Entry<String, String> key_value = (Map.Entry)values.next();
                sql += key_value.getKey() + operator + "\'" + key_value.getValue() + "\'";
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
        String sql = "INSERT INTO experience_lookup (entity_id, exp_id, modifier, weight, type) VALUES(";
        sql += ((data.containsKey("entity_id"))  ? "\'" + data.get("entity_id") + "\'" :      "null") + "," ;
        sql += ((data.containsKey("exp_id"))  ? "\'" + data.get("exp_id") + "\'" :      "null") + "," ;
        sql += ((data.containsKey("modifier"))  ? "\'" + data.get("modifier") + "\'" :      "null") + "," ;
        sql += ((data.containsKey("weight"))  ? "\'" + data.get("weight") + "\'" :      "null") + "," ;
        sql += ((data.containsKey("type"))  ? "\'" + data.get("type") + "\'" :      "null");
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
        String sql = "UPDATE experience_lookup SET "; 
        Iterator<Entry<String, String>> it = data.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pair = (Map.Entry)it.next();
            sql += pair.getKey() + '=' + "\'" + pair.getValue() + "\' "; 
            if(it.hasNext()){
                sql += ",";
            }
        }
        //@TODO make this more robust, we might not have the lookup_id
        sql += " WHERE lookup_id = " + id;
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
}


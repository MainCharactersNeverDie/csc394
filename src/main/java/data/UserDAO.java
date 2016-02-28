package data;
import java.util.*;
import java.util.Map.Entry;
import java.sql.*;
import data.*;

public class UserDAO implements DAO{ 
    Connection conn = null;
    public UserDAO(){
        conn = Connector.getConnection();
    }
    public HashMap<Integer, HashMap<String, Object>> retrieveData(HashMap<String, HashMap<String, String>> filters){
        String sql = 
            "SELECT * "                          +
            "FROM "                              +
            "users "                             +
            "LEFT JOIN "                         +
            "experience_lookup lookup "          +
            "ON "                                +
            "lookup.entity_id = users.user_id "  +
            "LEFT JOIN  "                        +
            "experience "                        +
            "ON "                                +
            "experience.exp_id = lookup.exp_id " +
            "WHERE "                             +
            "(lookup.type = 1 OR lookup.type IS NULL)";
        Iterator<Entry<String, HashMap<String, String>>> it = filters.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Map<String, String>> pair = (Map.Entry)it.next();
            String operator = pair.getKey();
            Iterator<Entry<String, String>> values = pair.getValue().entrySet().iterator();
            while (values.hasNext()) {
                sql += " AND ";
                Map.Entry<String, String> key_value = (Map.Entry)values.next();
                sql += key_value.getKey() + operator + "\'" + key_value.getValue() + "\'";
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
        try{
            sql += " GROUP BY user_id";
            Statement stmt   = conn.createStatement();
            ResultSet set = stmt.executeQuery(sql);
            HashMap<Integer, HashMap<String, Object>> result = new HashMap<Integer, HashMap<String, Object>>();
            while(set.next()){
                HashMap<String, Object> entry = new HashMap<String, Object>();
                entry.put("first_name",    set.getObject("first_name"));
                entry.put("last_name",     set.getObject("last_name"));
                entry.put("address",       set.getObject("address"));
                entry.put("phone",         set.getObject("phone"));
                entry.put("email",         set.getObject("email"));
                entry.put("type",          set.getObject("type"));
                entry.put("company_name",  set.getObject("company_name"));
                entry.put("password_hash", set.getObject("password_hash"));
                HashMap<String, HashMap<String, String>> experienceFilter = new HashMap<String, HashMap<String, String>>();
                HashMap<String, String> equalsFilter = new HashMap<String, String>();
                Integer user_id = set.getInt("user_id");
                equalsFilter.put("entity_id", user_id.toString());
                equalsFilter.put("type", "1");
                experienceFilter.put("=", equalsFilter);
                DTO experienceDTO = new DTO();
                experienceDTO.populateData("Experience", experienceFilter);
                HashMap<Integer, HashMap<String, Object>> experience = experienceDTO.getMap();
                entry.put("experience", experience);
                result.put(user_id, entry);
            }
            return result;
        } catch (SQLException ex) {
            System.out.println("TEST");
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
        HashMap<String, HashMap<String, String>> test = new HashMap<String, HashMap<String, String>>();
        HashMap<String, String> test2 = new HashMap<String, String>();
        test2.put("first_name", "test");
        test.put("=", test2);
        DTO dtoTest = new DTO();
        dtoTest.populateData("user", test);
        do{
            System.out.println(dtoTest.getId());
            System.out.println(dtoTest.getValue("address"));
        }while(dtoTest.next());
    }
}


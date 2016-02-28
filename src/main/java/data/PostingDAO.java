package data;
import java.util.*;
import java.util.Map.Entry;
import java.sql.*;
import data.*;

public class PostingDAO implements DAO{ 
    Connection conn = null;
    public PostingDAO(){
        conn = Connector.getConnection();
    }
    public HashMap<Integer, HashMap<String, Object>> retrieveData(HashMap<String, HashMap<String, String>> filters){
        String sql = 
            "SELECT * "                               +
            "FROM "                                   +
            "job_postings posting "                   +
            "LEFT JOIN "                              +
            "experience "                             +
            "ON "                                     +
            "experience.entity_id = posting.post_id " +
            "LEFT JOIN  "                             +
            "experience_lookup lookup "               +
            "ON "                                     +
            "experience.exp_id = lookup.exp_id "      +
            "WHERE "                                  +
            "lookup.type = 0";
        Iterator<Entry<String, HashMap<String, String>>> it = filters.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Map<String, String>> pair = (Map.Entry)it.next();
            sql += " AND ";
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
            ResultSet set = stmt.executeQuery(sql);
            HashMap<Integer, HashMap<String, Object>> result = new HashMap<Integer, HashMap<String, Object>>();
            do{
                HashMap<String, Object> entry = new HashMap<String, Object>();
                entry.put("user_id",     set.getObject("user_id"));
                entry.put("title",       set.getObject("title"));
                entry.put("description", set.getObject("description"));
                entry.put("pay_min",     set.getObject("pay_min"));
                entry.put("pay_max",     set.getObject("pay_max"));

                HashMap<String, HashMap<String, String>> experienceFilter = new HashMap<String, HashMap<String, String>>();
                HashMap<String, String> equalsFilter = new HashMap<String, String>();
                Integer post_id = set.getInt("post_id");
                equalsFilter.put("entity_id", post_id.toString());
                equalsFilter.put("type", "0");
                experienceFilter.put("=", equalsFilter);
                DTO experienceDTO = new DTO();
                experienceDTO.populateData("Experience", experienceFilter);
                HashMap<Integer, HashMap<String, Object>> experience = experienceDTO.getMap();
                entry.put("experience", experience);
                result.put(post_id, entry);
            }while(set.next());
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
        String sql = "INSERT INTO job_postings (user_id, title, description, pay_min, pay_max) VALUES(";
            sql += ((data.containsKey("user_id"))     ? "\'" + data.get("user_id") + "\'" :      "null") + "," ;
            sql += ((data.containsKey("title"))       ? "\'" + data.get("title") + "\'" :      "null") + "," ;
            sql += ((data.containsKey("description")) ? "\'" + data.get("description") + "\'" :      "null") + "," ;
            sql += ((data.containsKey("pay_min"))     ? "\'" + data.get("pay_min") + "\'" :      "null") + "," ;
            sql += ((data.containsKey("pay_max"))     ? "\'" + data.get("pay_max") + "\'" :      "null") + "," ;
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
        String sql = "UPDATE job_postings SET "; 
        Iterator<Entry<String, String>> it = data.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pair = (Map.Entry)it.next();
            sql += pair.getKey() + '=' + "\'" + pair.getValue() + "\' "; 
            if(it.hasNext()){
                sql += ",";
            }
        }
        sql += " WHERE post_id = " + id;
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


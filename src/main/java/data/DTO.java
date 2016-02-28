package data;
import java.util.*;
import java.util.Map.Entry;
import java.sql.*;
import data.*;

public class DTO{ 
    private Integer current_index;
    private HashMap<String, Object> current_row;
    private DAO table;
    private HashMap<Integer, HashMap<String, Object>> result;

    public HashMap<Integer, HashMap<String, Object>> getMap(){
        return result;
    }

    public void populateData(String type, HashMap<String, HashMap<String, String>> filter){
        if(type.toLowerCase().equals("experience"))
        { 
            table = new ExperienceDAO();
        }else
        {
            if(type.toLowerCase().equals("posting")){
                table = new PostingDAO();
            }else{
                table = new UserDAO();
            }
        }
        result = table.retrieveData(filter);
    }

    public Object getValue(String key, Integer idx){
        if(result.containsKey(idx)){
            current_index = idx;
            current_row = result.get(idx);
            return current_row.get(key);
        }
        return false;
    }
    public Object getValue(String key){
        return current_row.get(key);
    }
    public boolean goToIndex(Integer idx){
        if(result.containsKey(idx)){
            current_index = idx;
            return true;
        }
        return false;
    }
    public boolean next(){
        if(result.containsKey(current_index + 1)){
            ++current_index;
            current_row = result.get(current_index);
            return true;
        }
        return false;
    }
}

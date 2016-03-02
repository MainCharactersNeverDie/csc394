package data;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class DTO{ 
    private Iterator<Entry<Integer, HashMap<String, Object>>> iterator;
    private Map.Entry<Integer, Map<String, Object>> current_row;
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
        iterator = result.entrySet().iterator();
        if(iterator.hasNext()){
            current_row = (Map.Entry)iterator.next();
        }
    }

    public Object getValue(String key, Integer idx){
        if(result.containsKey(idx)){
            goToIndex(idx);
            return current_row.getValue().get(key);
        }
        return false;
    }
    public Object getValue(String key){
        if(current_row.getValue().containsKey(key))
            return current_row.getValue().get(key);
        return false;
    }
    public Integer getId(){
        return current_row.getKey();
    }
    public boolean goToIndex(Integer idx){
        if(result.containsKey(idx)){
            //Reset if requested idx is less than where we are
            if(idx < current_row.getKey())
                iterator = result.entrySet().iterator();

            while(current_row.getKey() != idx && iterator.hasNext()){
                current_row = (Map.Entry)iterator.next();
            }
            return true;
        }
        return false;
    }
    public boolean next(){
        if(iterator.hasNext()){
            current_row = (Map.Entry)iterator.next();
            return true;
        }
        return false;
    }
}

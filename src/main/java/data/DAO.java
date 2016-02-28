package data;
import java.util.*;
import java.util.Map.Entry;
import java.sql.*;
import data.*;
public interface DAO{
    public HashMap<Integer, HashMap<String, Object>> retrieveData(HashMap<String, HashMap<String, String>> filters);
    public int updateData(Map<String, String> data, String id);
    public int writeData(Map<String, String> data);
}

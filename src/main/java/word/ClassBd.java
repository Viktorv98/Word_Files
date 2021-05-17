package word;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
 
public class ClassBd {

    private static String url = "jdbc:mysql://localhost/productdb?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "0000";
     
    public static ArrayList<Words> select(String nameWord) {
         
        ArrayList<Words> words = new ArrayList<Words>();
        try{ 
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
            	String sqlSelect = ("SELECT words.idWords, words.name, files.nameFiles, countwords.CountWF FROM productdb.words\r\n"
                		+ "join productdb.countwords on words.idWords = countwords.idWord\r\n"
                		+ "join productdb.files on countwords.idFile = files.idFiles\r\n"
                		+ "where words.name = ? order by countwords.CountWF DESC;");
                PreparedStatement statement = conn.prepareStatement(sqlSelect);                
                statement.setString(1, nameWord);
                ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()){
                      
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String filename = resultSet.getString(3);
                    int countWF = resultSet.getInt(4);
                    Words ws = new Words(id, name, filename, countWF);
                    words.add(ws);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return words;
    }
   
    public static int insert(Map <String, Integer> maps, String filename) {
       
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sqlAddFile = "insert into productdb.files (nameFiles) values (?)";
                try(PreparedStatement statementAdd = conn.prepareStatement(sqlAddFile)){
                    statementAdd.setString(1, filename);
                    statementAdd.executeUpdate();
                    System.out.println(filename);
                }
                
                for (Map.Entry<String,Integer> entry: maps.entrySet()) {
                	String key = entry.getKey();
                	Integer value = entry.getValue();
                	try {
                	String sqlAddWord = "INSERT INTO productdb.words (name) VALUES (?)";
                    PreparedStatement statement = conn.prepareStatement(sqlAddWord);
                    statement.setString(1, key);
                    statement.executeUpdate();
                	}
                	catch(Exception ex){
                        System.out.println(ex);
                    }
                	
                	try {
                    	String sqlAddWord = "INSERT INTO productdb.countwords (idWord, idFile, CountWF) VALUES ((SELECT idWords FROM productdb.words WHERE name = ?), (SELECT idFiles FROM productdb.files WHERE nameFiles = ?), ?)";
                        PreparedStatement statement = conn.prepareStatement(sqlAddWord);
                        statement.setString(1, key.toString());
                        statement.setString(2, filename.toString());
                        statement.setString(3, value.toString());          
                        statement.executeUpdate();
                    }
                	catch(Exception ex){
                        System.out.println(ex);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    
    public static int delete() {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                
            	String sql3 = "DELETE FROM productdb.files";
            	String sql2 = "DELETE FROM productdb.words";
                String sql1 = "DELETE FROM productdb.countwords";
                Statement statementDelete = conn.createStatement();
                statementDelete.executeUpdate(sql1);
                statementDelete.executeUpdate(sql2);
                statementDelete.executeUpdate(sql3);
                System.out.println("Удаление прошло успешно!");
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}

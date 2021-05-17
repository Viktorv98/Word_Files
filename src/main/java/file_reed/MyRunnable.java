package file_reed;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import word.ClassBd;

public class MyRunnable implements Runnable{

    private File name;
    public MyRunnable (File name){
        this.name = name;
    }
    public void run(){ 
        try{
            HashMap<String,Integer> map = new HashMap<>();
            Scanner sc = new Scanner(new FileInputStream(name),"UTF-8");
            int count=0;
            while(sc.hasNext()){
            	count++;
                String str = sc.next();
                System.out.println("Number of words: " + str);
                str = str.replaceAll("\\p{Punct}", "");
                if (str.length() != 0)
                    if (map.containsKey(str)){
                        int k = map.get(str);
                        k++;
                        map.put(str,k);
                    } else{
                        map.put(str,1);
                    }
            }
           /* for(Object entryObj : map.entrySet()){
                Map.Entry entry =(Map.Entry) entryObj;
                Object key = entry.getKey();
                Object value = entry.getValue();
            }*/ 
            System.out.println("Number of words: " + count);

            sc.close();
            addDatabase(map, name);
         
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public synchronized void addDatabase(Map <String, Integer> maps, File filename) {
    	
    	   ClassBd.insert(maps,filename.toString());
    }
}

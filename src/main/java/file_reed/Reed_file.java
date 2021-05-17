package file_reed; 

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Reed_file {
	public static void poisk(File dir) throws IOException {
        if(dir.isDirectory())
        {
            // получаем все вложенные объекты в каталоге
            for(File item : dir.listFiles()){

                if(item.isDirectory()){
                    poisk(item);
                }
                else{ 
 
                    int nbThreads =  Thread.getAllStackTraces().keySet().size();
                    while (Thread.getAllStackTraces().keySet().size() >= 35){
                    }
                    System.out.println(nbThreads + "\t");
                    String fileType = Files.probeContentType(Path.of(item.getPath()));
                    if (fileType!=null && Files.probeContentType(Path.of(item.getPath())).contains("text/")){
                        Thread t = new Thread(new MyRunnable(item));
                        t.start();
                    System.out.println(item.getName() + "\t");

                    }
                }
            }
        }
    }
}

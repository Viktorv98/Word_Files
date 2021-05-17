package word;

import java.io.Serializable;

public class Words implements Serializable {
 
    private int id;
    private String name;
    private String filesname; 
    private int countWord;
     
    public Words(){ }
    public Words(String name, String filesname, int countWord){
         
        this.name = name;
        this.countWord = countWord;
        this.setFilesname(filesname);
    }
    public Words(int id, String name, String filesname, int countWord){
         
        this.id = id;
        this.name = name;
        this.setFilesname(filesname);
        this.countWord = countWord;
    }
     
    public int getId() {
        return id;
    }
     
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getcountWord() {
        return countWord;
    }
 
    public void setPrice(int countWord) {
        this.countWord = countWord;
    }
	public String getFilesname() {
		return filesname;
	}
	public void setFilesname(String filesname) {
		this.filesname = filesname;
	}
}

package BasicOOPS;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class FileProgramMainClass {
	
	public static ArrayList<File> fileList;
	static String worklocation = System.getProperty("user.dir");
	public static void main(String[] args) {		
		
		
		FileProgramMainClass.fileList= new ArrayList<File>();
		String worklocation = System.getProperty("user.dir");
		File file = new File(worklocation+"\\Files");
		FileOperation.deleteDirectory(file);

		File f1 = new File(worklocation+"\\Files");  
		
		if(f1.exists()==true){   
			f1.delete();
	      }else{  
	    	  
	    	  f1.mkdir();
	      } 
		
		fileList.add(new File(worklocation+"\\Files\\abc.txt"));
		fileList.add(new File(worklocation+"\\Files\\xyz.txt"));
		fileList.add(new File(worklocation+"\\Files\\pqr.txt"));
			
		System.out.println("We are Creating 3 Files in File Folder");
		for (int i = 0; i < fileList.size(); i++) {
			if (fileList.get(i).exists() == false) {
				try {
					fileList.get(i).createNewFile();
				} catch (IOException e) {
					System.out.println("File already Existed in File folder");
				}
			}
			System.out.println("The File Folder Contains "+fileList.get(i).getName());
		}
		System.out.println("\n");
		int userInput =MainMenuPage.menu();
		MainMenuPage.mainmenu(userInput, fileList);
		
		
		
		
	}

}

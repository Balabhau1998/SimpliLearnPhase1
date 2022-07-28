package BasicOOPS;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenuPage {
	static Scanner sc  = new Scanner(System.in);
	public static void mainmenu(int username,ArrayList<File> fileList)
	{
		
		switch (username) {
		case 1:
			FileOperation.fileinassesnding(FileProgramMainClass.fileList);
			
			System.out.println("Enter 1  to navigate Main Menu");
			int assending=sc.nextInt();
			if(assending==1)
			{
				int userInput =MainMenuPage.menu();
				MainMenuPage.mainmenu(userInput, FileProgramMainClass.fileList);
			}
			else {
				System.out.println("Entered Invalid Input So we are Queting Program");
				 System.exit(0);
			}
			break;
		case 2:
			FileOperation.addFile(FileProgramMainClass.fileList);
			break;
		case 3:
			FileOperation.deleteFile(FileProgramMainClass.fileList);
			break;
		case 4:
			FileOperation.searchFile(FileProgramMainClass.fileList);
			break;
		case 5:
			int userInput =MainMenuPage.menu();
			MainMenuPage.mainmenu(userInput, FileProgramMainClass.fileList);
			break;
		case 6:
            System.exit(0);
			break;

		default:
			System.out.println("You are Entering Unexpectd Input \n Enter Valid Number to perform Specific Operation");

		}
	}
		public static int menu()
		{
			System.out.println(" Enter 1 To Retriving File Name in Assesnding Order \n Enter 2 To Add  New File in Application"
					+ "\n Enter 3 to delete specific file from Application \n Enter 4 to Search Specific File in Application \n Enter 5 to go in Menu option of Application \n Enter 6 to Exit Application");
			int userinput = 0;
			try{
				 userinput = sc.nextInt();
			}catch(Exception e)
			{
				System.out.println("UnExpected Input given by User.So program has Quite");
			}
			return userinput;
		}
	

}

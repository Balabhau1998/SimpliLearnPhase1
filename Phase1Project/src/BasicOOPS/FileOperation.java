package BasicOOPS;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class FileOperation {

	static Scanner scr = new Scanner(System.in);

	public static void fileinassesnding(ArrayList<File> fileList) {
//		List<File> sorlist = FileProgramMainClass.fileList.stream()
//				.sorted(
//		                 Comparator.comparing(n->n.toString())).collect(Collectors.toList());

		if (fileList == null || fileList.size() == 0) {
			System.out.println("Files folder does not contains any file.");
		} else {
			System.out.println("****File in Assending Order is ***");
			Collections.sort(FileProgramMainClass.fileList);
			System.out.println("The Sorted File name is given below");
			for (File name1 : FileProgramMainClass.fileList)
				System.out.println(name1.getName());
		}
	}

	public static ArrayList<File> addFile(ArrayList<File> fileList) {
		String filename = "";
		System.out.println("Enter File Name which you want to Add");
		filename = scr.nextLine();
		File addFile = new File(FileProgramMainClass.worklocation + "\\Files" + "\\" + filename);
		if (addFile.exists() == false) {
			try {
				addFile.createNewFile();
				FileProgramMainClass.fileList.add(addFile);
				System.out.println("File has been created in " + addFile);
			} catch (IOException e) {
				System.out.println("File already Exist with Same Name");
			}
		} else {
			System.out.println("File already Exist with Same Name So we are quiting the program");
		}

		MainMenuPage.mainmenu(5, FileProgramMainClass.fileList);
		return fileList;

	}

	public static ArrayList<File> deleteFile(ArrayList<File> fileList) {
		String filename = "";
		System.out.println("Enter File Name which you want to Delete");
		filename = scr.nextLine();

		System.out.println("*********** Existing File In Files Folder***************************");
		for (int i = 0; i < fileList.size(); i++) {
			System.out.println(fileList.get(i).toString());
		}

		File deleteFile = new File(FileProgramMainClass.worklocation + "\\Files" + "\\" + filename);
		int result = checkdeleteFile(FileProgramMainClass.fileList, deleteFile);
		if (result == -1) {
			System.out.println("==========File Not Exist in Folder================");
		} else {
			deleteFile.delete();
			FileProgramMainClass.fileList.remove(deleteFile);
			System.out.println("==========File Deleted From Folder================");
		}
		System.out.println("**********After Delete Operation File Exist In Folder*******************");
		for (int i = 0; i < fileList.size(); i++) {
			System.out.println(fileList.get(i).toString());
		}
		MainMenuPage.mainmenu(5, FileProgramMainClass.fileList);
		return fileList;
	}

	public static void searchFile(ArrayList<File> fileList) {
		String filename = "";
		System.out.println("Enter File Name which you want to Search");
		filename = scr.nextLine();
		// String name=filename+".txt";
		String name = filename;

		File searchElement = new File(name);
		// String
		// finalfilename=FileProgramMainClass.worklocation+"\\Files"+"\\"+filename+".txt";
		int result = linearSearch(FileProgramMainClass.fileList, searchElement);
		if (result == -1) {
			System.out.println("File is not found in the ArrayList");
		} else {
			System.out.println("File is found at index : " + result + " in ArrayList");
		}
		MainMenuPage.mainmenu(5, FileProgramMainClass.fileList);
	}

	private static int linearSearch(List<File> fileList, File searchElement) {

		if (fileList == null || fileList.size() == 0) {
			return -1;
		}

		if (searchElement == null) {
			return -1;
		}

		for (int i = 0; i < fileList.size(); i++) {

			if (fileList.get(i).getName().equals(searchElement.getName())) {
				return i;
			}
		}

		return -1;
	}

	public static boolean deleteDirectory(File directoryToBeDeleted) {
		File[] allContents = directoryToBeDeleted.listFiles();
		if (allContents != null) {
			for (File file : allContents) {
				deleteDirectory(file);
			}
		}
		return directoryToBeDeleted.delete();
	}

	private static int checkdeleteFile(List<File> fileList, File deleteFile) {
		if (fileList == null || fileList.size() == 0) {
			return -1;
		}

		if (deleteFile == null) {
			return -1;
		}

		for (int i = 0; i < fileList.size(); i++) {

			if (fileList.get(i).getName().equals(deleteFile.getName())) {
				return i;
			}
		}

		return -1;
	}
}

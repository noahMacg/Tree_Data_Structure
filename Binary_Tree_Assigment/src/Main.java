
/*
  Noah MacGillivray
  Assignment: Tree Data Structure
  10/27/2024
  CSCI 2251 U01
  Purpose: This program reads in a file of human
  resources data into Person objects; adds them to
  a binary tree in SortedTreeSet.java; and prints 
  them to the consol and a .txt file. 
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {

		// if (args.length != 1) {
		// 	System.out.println("Please provide the file path.");
		// 	return;
		// }
		// String filePath = args[0];

		// Testing
		String filePath = "C:\\Users\\pilga\\code\\CS2251_code\\Tree_Data_Structure\\Binary_Tree_Assigment\\src\\hr.txt";

		//		Person noah = new Person("Noah", 172, 72);
		//		Person mario = new Person("Mario", 155, 90);
		//		Person noahDup = new Person("Noah", 172, 72); // Dup test
		//		Person peach = new Person("Peach", 183, 60);

		//		SortedTreeSet personSet = new SortedTreeSet();
		//		personSet.add(noah);
		//		   personSet.add(mario);
		//		   personSet.add(peach);
		//		   personSet.add(noahDup);
		//		personSet.inOrderTraversal();
		//		System.out.println();
		//
		String name; // Holds name while reading in
		double height; // Holds height while reading in<
		double weight; // Holds height while reading in
		SortedTreeSet binaryTree = new SortedTreeSet();

		// Reads in file
		try {

			Scanner fileReader = new Scanner(new File(filePath));
			if (fileReader.hasNextLine()) {
				fileReader.nextLine();
			}

			while (fileReader.hasNext()) {

				name = fileReader.next();
				height = fileReader.nextDouble();
				weight = fileReader.nextDouble();

				Person orderPerson = new Person(name, height, weight);
				binaryTree.add(orderPerson);

			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
			System.exit(1);
		}
		System.out.println("\n******** Nintendo's HR Data ********\n");
		System.out.printf("%-10s %10s %14s", "Name", "Height(cm)", "Weight(kg)" + "\n");
		System.out.print(binaryTree.getDataSet());

		//File writer
		try {
			FileWriter fileOrderedSet = new FileWriter("HRdata_BinarySortedTree.txt");
			fileOrderedSet.write(PersonSet.outputHeader() + binaryTree.getDataSet());
			fileOrderedSet.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
			System.exit(1);
		}
	}
}

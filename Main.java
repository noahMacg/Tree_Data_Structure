
/**
 * Noah MacGillivray
 * Assignment: Human Resources Part 1
 * 10/6/2024
 * CSCI 2251 U01
 * Purpose: This program reads in a file of human 
 * resources data; instantiates various test Persons;
 * tests / adds them to the ArrayList in PersonSet.java;
 * reads in a file of HR data and prints them; and
 * implements / test file output. 
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
		String filePath = "C:\\Users\\pilga\\code\\CS2251_code\\Human_Resources\\Human Resources\\hr.txt";
		/*
		 
		  Person noah = new Person("Noah", 172, 72);
		  Person mario = new Person("Mario", 155, 90);
		  Person noahDup = new Person("Noah", 172, 72); // Dup test
		  Person peach = new Person("Peach", 183, 60);
		 
		  PersonOrderedSet personSet = new PersonOrderedSet();
		  personSet.add(noah);
		  personSet.add(mario);
		  personSet.add(peach);
		  personSet.add(noahDup);
		  System.out.println(personSet.allPersonData());
		  System.out.println();
		 */

		// Two separate objects to hold ordered and imperial sets 
		PersonSet personOrderedSet = new PersonOrderedSet();
		//PersonSet personImperialSet = new PersonImperialSet();

		String name; // Holds name while reading in
		double height; // Holds height while reading in<
		double weight; // Holds height while reading in

		// Reads in file
		try {
			Scanner fileReader = new Scanner(new File(filePath));
			if (fileReader.hasNextLine()) {
				fileReader.nextLine();
			}
			while (fileReader.hasNextLine()) {
				name = fileReader.next();
				height = fileReader.nextDouble();
				weight = fileReader.nextDouble();

				Person orderPerson = new Person(name, height, weight);
				personOrderedSet.add(orderPerson);

			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
			System.exit(1);
		}
		/*
		 * System.out.printf("%-10s %10s %14s", "Name", "Height(cm)", "Weight(kg)" +
		 * "\n");
		 * System.out.println(personOrderedSet);
		 * System.out.printf("%-10s %10s %14s", "Name", "Height(ft)", "Weight(lb)" +
		 * "\n");
		 * System.out.println(personImperialSet);
		 */

		System.out.println(PersonSet.outputOrderedSet(personOrderedSet));

		// File writer
		try {
			FileWriter fileOrderedSet = new FileWriter("HR_data_ordered_set.txt");
			fileOrderedSet.write(PersonSet.outputOrderedSet(personOrderedSet));
			fileOrderedSet.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
			System.exit(1);
		}
	}
}

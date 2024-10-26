/*
 * This class implements and expands on the interface PersonList. It has a method to 
 * add people's information to an ArrayList; a toString override; and two methods to 
 * assist in printing the ordered and imperial sets.  
 */

import java.util.ArrayList;

public class PersonSet implements PersonList {

    // Source: CGPT: "arraylist syntax Java"
    protected ArrayList<Person> personSet = new ArrayList<>();

    // Adds a Person to the ArrayList as long as it is not a duplicate
    // as specified in the boolean personSet (Person.java).
    @Override
    public void add(Person p) {
        if (!personSet.contains(p)) {
            personSet.add(p);
        }
    }

    // Source "why will this not get the Person at the input index"
    // Gets the Person from the ArrayList with given index.
    public Person get(int index) {
        if (index >= 1 && index < personSet.size()) {
            return personSet.get(index);
        } else {
            System.out.println("The desired index for the ArrayList is out of bounds");
            return null;
        }
    }

    // Source: Claude: "what is the best way to iterate through an ArrayList of data
    // and concatenate it into a single returnable string"
    @Override
    public String toString() {
        String allData = "";
        for (int i = 0; i < personSet.size(); i++) {
            allData = allData + personSet.get(i) + "\n";
        }
        return allData;
    }
    // Returns header
    public static String outputHeader() {
        String title = "<<\"\\n******** Nintendo's HR Data ********\\n\">>";
        String header = String.format("%-10s %10s %14s", "Name", "Height(cm)", "Weight(kg)" + "\n");
        return title + "\n" + header;
    }
    // Prints header + the ordered set
    public static String outputOrderedSet(PersonSet p) {
        String title = "<<Nintendo's human resources data>>";
        String header = String.format("%-10s %10s %14s", "Name", "Height(cm)", "Weight(kg)" + "\n");
        return title + "\n" + header + p;
    }

    // Prints header + the imperial set
    public static String outputImperialSet(PersonSet p) {
        String title = "<<Nintendo's human resources data>>";
        String header = String.format("%-10s %10s %14s", "Name", "Height(ft)", "Weight(lbs)" + "\n");
        return title + "\n" + header + p.toString();
    }
}

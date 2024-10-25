/*Source: CGPT: why is this an incorrect way to use an interface: public interface PersonList {
    public Person get (Person p) {
        return Person;
    }
} 
Follow up question: "why do you not need to specify what you are returning in the method body"
*/

public interface PersonList {

    public void add(Person p);

    public Person get(int index);

}

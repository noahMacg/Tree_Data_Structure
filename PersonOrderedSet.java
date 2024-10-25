import java.util.Collections;
// This class adds persons in alphabetical order

/* Sources_Multiple: 
https://stackoverflow.com/questions/14154127/collections-sortlistt-comparator-super-t-method-example
Multiple conversations with Gemini, CGPT and Claude about how to use Collections.sort in different 
ways, how to implement them with different classes and why we need to implement them in the person().*/

public class PersonOrderedSet extends PersonSet {
    @Override
    public void add(Person p) {
        super.add(p);
        Collections.sort(personSet);
    }
}

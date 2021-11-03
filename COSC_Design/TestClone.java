//

public class TestClone {

    public static void main(String[] args) {
        Person p1 = new Person (21, "Joe", "Smith", "123-45-6789" );

        Person p2 = (Person)p1.clone();
    }
}

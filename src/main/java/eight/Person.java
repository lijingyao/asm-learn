package eight;

/**
 * Created by lijingyao on 15/11/2 19:14.
 */
public class Person {
    private String firstName;
    private String lastName;

    public Person(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}

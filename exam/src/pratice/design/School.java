package pratice.design;

/**
 * @author hubery.chen
 */
public class School {

    private Person person;

    public void performance(Person person) {
        //singleton will error
        //initPerson(person);
        System.out.println(person.doSomething());
    }

    private void initPerson(Person person) {
        this.person = person;
    }
}

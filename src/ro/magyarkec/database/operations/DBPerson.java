package ro.magyarkec.database.operations;

import ro.magyarkec.database.DBGeneral;
import ro.magyarkec.database.models.Person;

import java.util.ArrayList;

/**
 * Created by Jano on 21-Feb-15.
 */
public class DBPerson extends DBGeneral{

    public ArrayList<Person> getAllPerson(){
        ArrayList<Person> personArrayList = new ArrayList<Person>();
        personArrayList = (ArrayList<Person>) DBGeneral.getInstance().getEm().createQuery("SELECT Sz FROM Person Sz").getResultList();
        return personArrayList;
    }

    public static void addPerson(Person person){
        getEm().getTransaction().begin();
        if(person.getBirthAddress() != null) {
            getEm().persist(person.getBirthAddress());
        }
        getEm().persist(person);
        getEm().getTransaction().commit();
    }

    public static void updatePerson(Person person){
        getEm().getTransaction().begin();
        if(person.getBirthAddress() != null) {
            getEm().merge(person.getBirthAddress());
        }
        getEm().merge(person);
        getEm().getTransaction().commit();
    }

    public static void deletePerson(Person person){
        getEm().getTransaction().begin();
        getEm().remove(person);
        getEm().getTransaction().commit();
    }

}

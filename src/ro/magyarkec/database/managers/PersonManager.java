package ro.magyarkec.database.managers;

import ro.magyarkec.database.DBGeneral;
import ro.magyarkec.database.models.Person;
import ro.magyarkec.database.operations.DBPerson;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jano on 21-Feb-15.
 */
public class PersonManager {

    private PersonListener mCallback;

    public PersonManager(PersonListener mCallback){
        this.mCallback = mCallback;
    }

    public void fetchPerson(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(mCallback != null){
                    mCallback.onPersonListFetched(new DBPerson().getAllPerson());
                }
            }
        }).start();
    }

    public void updatePerson(final Person person){
        new Thread(new Runnable() {
            @Override
            public void run() {
                DBPerson.updatePerson(person);
                if(mCallback != null){
                    mCallback.onPersonUpdated(person);
                }
            }
        }).start();
    }

    public void savePerson(final Person person){

        new Thread(new Runnable() {
            @Override
            public void run() {
                DBPerson.addPerson(person);
                if(mCallback != null){
                    mCallback.onPersonSaved(person);
                }
            }
        }).start();
    }

    public void savePersonList(final ArrayList<Person> list){
        new Thread(new Runnable() {
            @Override
            public void run() {
                DBGeneral.getEm().getTransaction().begin();
                for(Person person:list) {
                    DBGeneral.getEm().persist(person.getBirthAddress());
                    DBGeneral.getEm().persist(person);
                }
                DBGeneral.getEm().getTransaction().commit();
                if(mCallback != null){
                    mCallback.onPersonListSaved(list);
                }
            }
        }).start();
    }

    public void updatePersonList(final ArrayList<Person> list){
        new Thread(new Runnable() {
            @Override
            public void run() {
                DBGeneral.getEm().getTransaction().begin();
                for(Person person:list) {
                    DBGeneral.getEm().merge(person.getBirthAddress());
                    DBGeneral.getEm().merge(person);
                }
                DBGeneral.getEm().getTransaction().commit();
                if(mCallback != null){
                    mCallback.onPersonListUpdated(list);
                }
            }
        }).start();
    }

    public void deletePerson(final Person person){
        new Thread(new Runnable() {
            @Override
            public void run() {
                DBPerson.deletePerson(person);
                if(mCallback != null){
                    mCallback.onPersonDeleted(person);
                }
            }
        }).start();
    }

    public void deletePersonList(final ArrayList<Person> personArrayList){
        new Thread(new Runnable() {
            @Override
            public void run() {
                DBGeneral.getEm().getTransaction().begin();
                for(Person person:personArrayList){
                    DBGeneral.getEm().remove(person);
                }
                DBGeneral.getEm().getTransaction().commit();
                if(mCallback != null){
                    mCallback.onPersonListDeleted(personArrayList);
                }
            }
        }).start();
    }

    public interface PersonListener {

        public void onPersonListFetched(ArrayList<Person> personArrayList);

        public void onPersonSaved(Person person);

        public void onPersonUpdated(Person person);

        public void onPersonListSaved(ArrayList<Person> personArrayList);

        public void onPersonListUpdated(ArrayList<Person> personArrayList);

        public void onPersonDeleted(Person person);

        public void onPersonListDeleted(ArrayList<Person> personArrayList);

    }

}

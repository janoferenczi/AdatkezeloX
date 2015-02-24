package ro.magyarkec.database.operations;

import ro.magyarkec.database.DBGeneral;
import ro.magyarkec.database.models.Address;

import java.util.ArrayList;

/**
 * Created by Jano on 22-Feb-15.
 */
public class DBAddress extends DBGeneral {

    public static ArrayList<Address> getAllAddress(){
        ArrayList<Address> addressArrayList = (ArrayList<Address>) DBGeneral.getEm().createQuery("SELECT A FROM Address A ORDER BY A.mStreet").getResultList();
        return addressArrayList;
    }

    public static void addAddress(Address address){
        persist(address);
    }

    public static void updateAddress(Address address){
        merge(address);
    }

    public static void deleteAddress(Address address){
        delete(address);
    }

}

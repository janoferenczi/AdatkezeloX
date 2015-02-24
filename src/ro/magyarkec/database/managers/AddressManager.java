package ro.magyarkec.database.managers;

import ro.magyarkec.database.DBGeneral;
import ro.magyarkec.database.models.Address;
import ro.magyarkec.database.operations.DBAddress;

import java.util.ArrayList;

/**
 * Created by Jano on 22-Feb-15.
 */
public class AddressManager {

    private AddressListener mCallback;

    public AddressManager(AddressListener mCallback){
        this.mCallback = mCallback;

    }

    public void fetchAllAddress(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(mCallback != null){
                    mCallback.onAddressFetched(DBAddress.getAllAddress());
                }
            }
        }).start();

    }

    public void addAddress(final Address address){
        new Thread(new Runnable() {
            @Override
            public void run() {
                DBAddress.addAddress(address);
                if(mCallback != null){
                    mCallback.onAddressAdded(address);
                }
            }
        }).start();
    }

    public void updateAddress(final Address address){
        new Thread(new Runnable() {
            @Override
            public void run() {
                DBAddress.updateAddress(address);
                if(mCallback != null){
                    mCallback.onAddressUpdated(address);
                }
            }
        }).start();
    }

    public void deleteAddress(final Address address){
        new Thread(new Runnable() {
            @Override
            public void run() {
                DBAddress.deleteAddress(address);
                if(mCallback != null){
                    mCallback.onAddressDeleted(address);
                }
            }
        }).start();
    }

    public interface AddressListener{

        public void onAddressFetched(ArrayList<Address> addressArrayList);

        public void onAddressAdded(Address address);

        public void onAddressUpdated(Address address);

        public void onAddressDeleted(Address address);

    }

}

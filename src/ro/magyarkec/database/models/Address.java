package ro.magyarkec.database.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String mStreet;

	public void setStreet(String street) {
		this.mStreet = street;
	}

	public String getStreet() {
		return mStreet;
	}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

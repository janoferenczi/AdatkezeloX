package ro.magyarkec.database.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String mFirstname;
	private String mLastname;
	private Date mBirthDate;
    @OneToOne(optional = true)
	private Address mBirthAddress;
    @OneToOne(optional = true)
    private Address mAddress;
	private String mReligion;
	private String mMinority;

    @Column(nullable = false)
	private String mJob;
    private boolean mFerfi;
    @OneToOne(cascade = CascadeType.DETACH,optional = true)
    private Person mMother;
    @OneToOne(cascade = CascadeType.DETACH,optional = true)
    private Person mFather;

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return mFirstname;
    }

    public void setFirstname(String firstname) {
        mFirstname = firstname;
    }

    public String getLastname() {
        return mLastname;
    }

    public void setLastname(String lastname) {
        mLastname = lastname;
    }

    public Date getBirthDate() {
        return mBirthDate;
    }

    public void setBirthDate(Date birthDate) {
        mBirthDate = birthDate;
    }

    public Address getBirthAddress() {
        return mBirthAddress;
    }

    public void setBirthAddress(Address birthAddress) {
        mBirthAddress = birthAddress;
    }

    public Address getAddress() {
        return mAddress;
    }

    public void setAddress(Address address) {
        mAddress = address;
    }

    public String getReligion() {
        return mReligion;
    }

    public void setReligion(String religion) {
        mReligion = religion;
    }

    public String getMinority() {
        return mMinority;
    }

    public void setMinority(String minority) {
        mMinority = minority;
    }

    public String getJob() {
        return mJob;
    }

    public void setJob(String job) {
        mJob = job;
    }

    public void setFerfi(boolean ferfi) {
        mFerfi = ferfi;
    }

    public boolean isFerfi() {
        return mFerfi;
    }

    public Person getMother() {
        return mMother;
    }

    public void setMother(Person mother) {
        mMother = mother;
    }

    public Person getFather() {
        return mFather;
    }

    public void setFather(Person father) {
        mFather = father;
    }
}

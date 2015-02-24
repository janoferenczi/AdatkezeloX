package ro.magyarkec.database;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Objects;

public class DBGeneral {

	private static DBGeneral instance;
	private static EntityManager em;

	protected DBGeneral() {
		this.em = Persistence.createEntityManagerFactory("AdatkezeloX")
				.createEntityManager();
	}

	public static DBGeneral getInstance() {
		if (instance == null) {
			instance = new DBGeneral();
		}
		return instance;
	}

    public static EntityManager getEm() {
        getInstance();
        return em;
    }

    public static void persist(Object obj){
        getEm().getTransaction().begin();
        getEm().persist(obj);
        getEm().getTransaction().commit();
    }

    public static void merge(Object obj){
        getEm().getTransaction().begin();
        getEm().merge(obj);
        getEm().getTransaction().commit();
    }

    public static void delete(Object obj){
        getEm().getTransaction().begin();
        getEm().remove(obj);
        getEm().getTransaction().commit();
    }
}

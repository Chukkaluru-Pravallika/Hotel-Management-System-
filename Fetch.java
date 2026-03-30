package hotelManagementSystem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Fetch {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Visitor visitor1 = entityManager.find(Visitor.class, 1);
		Visitor visitor2=  entityManager.find(Visitor.class, 2);

		entityTransaction.begin();
		entityManager.remove(visitor1);
		entityTransaction.commit();
	}
}

package hotelManagementSystem;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Driver {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Visitor visitor1=new Visitor();
		visitor1.setId(1);
		visitor1.setName("king");
		visitor1.setAadharNumber(1234);
		
		Visitor visitor2=new Visitor();
		visitor2.setId(2);
		visitor2.setName("Allen");
		visitor2.setAadharNumber(456);
		
		List<Visitor> list=new ArrayList<>();
		list.add(visitor1);
		list.add(visitor2);
		
		Room room=new Room();
		room.setHotelId(101);
		room.setHotelName("Taj");
		room.setVisitors(list);
		
		visitor1.setRoom(room);
		visitor2.setRoom(room);
		
		entityTransaction.begin();
		for(Visitor ele: list) {
			entityManager.persist(ele);
		}
		entityManager.persist(room);
		entityTransaction.commit();	
	}	
	}


package org.hibernate.bugs;

import static org.junit.Assert.assertEquals;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import org.hibernate.model.Customer;
import org.hibernate.model.CustomerId;
import org.hibernate.model.Invoice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void findByAssociationIdTest() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		Customer customer = new Customer(1, "Francisco");
		entityManager.persist(customer);

		Invoice invoice = new Invoice(1, customer);
		entityManager.persist(invoice);

		List<Invoice> invoices = entityManager.createQuery("from Invoice i where i.customer.id = :customerId")
				.setParameter("customerId", customer.getId())
				.getResultList();

		assertEquals(invoices.size(), 1);

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}

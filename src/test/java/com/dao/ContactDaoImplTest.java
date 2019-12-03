package com.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.model.Contact;



public class ContactDaoImplTest {
	ContactDao cdao = new ContactDaoImpl();

	@Test
	public void testFindAll() {
		Contact c = new Contact();
		c.setFirstname("Djamil"); c.setLastname("Mohamed"); c.setBirthdate(new Date());
		cdao.insert(c);
		List<Contact> contacts=cdao.findAll();
		Assert.assertTrue("List empty" , contacts.size()>=1);
	}

	@Test
	public void testFindByKey() {
		Contact c = new Contact();
		c.setFirstname("Djam"); c.setLastname("Moha"); c.setBirthdate(new Date());
		cdao.insert(c);
		Contact c1=cdao.findByKey(c.getId());
		Assert.assertTrue("Different", c.equals(c1));
	}

	@Test
	public void testInsert() {
		List<Contact> contacts=cdao.findAll();
		int a=contacts.size();
		Contact c = new Contact();
		c.setFirstname("Djamal"); c.setLastname("Mohammed"); c.setBirthdate(new Date());
		cdao.insert(c);
		List<Contact> contacts2=cdao.findAll();
		int b=contacts2.size();
		Assert.assertTrue("No cap" , b>a);
	}

	@Test
	public void testUpdate() {
		Contact c = new Contact();
		c.setFirstname("Djamal");
		c.setLastname("Mohammed");
		c.setBirthdate(new Date());
		cdao.insert(c); //18 a
		Contact c1 = new Contact();
		c1.setId(c.getId());
		c1.setFirstname("Djamel"); //18 e
		c1.setLastname("Muhammed");
		c1.setBirthdate(new Date());
		Contact c2=cdao.findByKey(c.getId()); 
		cdao.update(c1);
		Assert.assertTrue("Different", !c1.equals(c2));
	}

	@Test
	public void testDeleteByKey() {
		Contact c = new Contact();
		c.setFirstname("Djamul"); c.setLastname("Maki"); c.setBirthdate(new Date());
		cdao.insert(c);
		List<Contact> contacts=cdao.findAll();
		int a = contacts.size();
		cdao.deleteByKey(c.getId());
		List<Contact> contacts1=cdao.findAll();
		int b=contacts1.size();
		Assert.assertTrue("No cap" , b<a);
	}

}

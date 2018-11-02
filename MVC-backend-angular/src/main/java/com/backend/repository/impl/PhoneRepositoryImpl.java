package com.backend.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.entities.Phone;
import com.backend.repository.PhoneRepository;

@Repository
public class PhoneRepositoryImpl implements PhoneRepository {

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Phone> getAllPhones() {
		Query query = em.createQuery("FROM Phone");
		List<Phone> phones = query.getResultList();
		return phones;
	}

	@Override
	public Phone getPhoneByID(Long id) {
		Phone phone = em.find(Phone.class, id);
		return phone;
	}

	@Override
	public Phone updatePhone(Phone phone) {
		Phone phoneFound = em.find(Phone.class, phone.getId());
		if (phoneFound != null) {
			phoneFound = phone;
			em.merge(phoneFound);
		}
		return phone;
	}

	@Override
	public Boolean deletePhoneById(Long id) {
		Phone phone = this.getPhoneByID(id);
		if(phone != null) {
			em.remove(phone);
			return true;
		}
		return false;
	}

	@Override
	public Phone createPhone(Phone phone) {
		phone.setId(null);
		em.persist(phone);
		return phone;
	}
}

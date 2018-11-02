package com.backend.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.entities.PlageHoraire;
import com.backend.repository.PlageHoraireRepository;

@Repository
public class PlageHoraireRepositoryImpl implements PlageHoraireRepository {

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
	public List<PlageHoraire> getAllPlageHoraires() {
		Query query = em.createQuery("FROM PlageHoraire");
		List<PlageHoraire> plages = query.getResultList();
		return plages;
	}

	@Override
	public PlageHoraire getPlageHoraireByID(Long id) {
		PlageHoraire plage = em.find(PlageHoraire.class, id);
		return plage;
	}

	@Override
	public PlageHoraire updatePlageHoraire(PlageHoraire plageHoraire) {
		PlageHoraire plageHoraireFound = em.find(PlageHoraire.class, plageHoraire.getId());
		if (plageHoraireFound != null) {
			plageHoraireFound = plageHoraire;
			em.merge(plageHoraireFound);
		}
		return plageHoraire;
	}

	@Override
	public Boolean deletePlageHoraireById(Long id) {
		PlageHoraire plage = this.getPlageHoraireByID(id);
		if(plage != null) {
			em.remove(plage);
			return true;
		}
		return false;
	}

	@Override
	public PlageHoraire createPlageHoraire(PlageHoraire plageHoraire) {
		plageHoraire.setId(null);
		em.persist(plageHoraire);
		return plageHoraire;
	}
}

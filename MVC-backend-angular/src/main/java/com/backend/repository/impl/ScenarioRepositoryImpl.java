package com.backend.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.entities.Scenario;
import com.backend.repository.ScenarioRepository;

@Repository
public class ScenarioRepositoryImpl implements ScenarioRepository {

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
	public List<Scenario> getAllScenarios() {
		Query query = em.createQuery("FROM Scenario");
		List<Scenario> scenarios = query.getResultList();
		return scenarios;
	}

	@Override
	public Scenario getScenarioByID(Long id) {
		Scenario scenario = em.find(Scenario.class, id);
		return scenario;
	}

	@Override
	public Scenario updateScenario(Scenario scenario) {
		Scenario scenarioFound = em.find(Scenario.class, scenario.getId());
		if (scenarioFound != null) {
			scenarioFound = scenario;
			em.merge(scenarioFound);
		}
		return scenario;
	}

	@Override
	public Boolean deleteScenarioById(Long id) {
		Scenario scenario = this.getScenarioByID(id);
		if(scenario != null) {
			em.remove(scenario);
			return true;
		}
		return false;
	}

	@Override
	public Scenario createScenario(Scenario scenario) {
		scenario.setId(null);
		em.persist(scenario);
		return scenario;
	}
}

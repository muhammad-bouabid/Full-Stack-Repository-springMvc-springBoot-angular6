package com.backend.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.backend.entities.File;
import com.backend.repository.FileRepository;

@Repository(value="fileRepository")
public class FileRepositoryImpl implements FileRepository{

	
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
	public List<File> getAllFiles() {
		Query query = em.createQuery("FROM File");
		List<File> files = query.getResultList();
		return files;
	}

	@Override
	public File getFileByID(Long id) {
		File file = em.find(File.class, id);
		return file;
	}

	@Override
	public File updateFile(File file) {
		File fileFound = em.find(File.class, file.getId());
		if(fileFound != null) {
			fileFound = file;
			em.merge(fileFound);
		}
		return file;
	}

	@Override
	public Boolean deleteFileById(Long id) {
		File file = this.getFileByID(id);
		if(file != null) {
			em.remove(file);
			return true;
		}
		return false;
	}

	@Override
	public File createFile(File file) {
		TransactionStatus statu = TransactionAspectSupport.currentTransactionStatus(); // Test Transaction Opend or Closed
		System.out.println(statu); 
		file.setId(null);
		em.persist(file);
		return file;
	}
}

package com.jmdimalanta.license.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jmdimalanta.license.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
	//Get all licenses from the DB.
	List<License> findAll();
}

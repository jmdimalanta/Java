package com.jmdimalanta.license.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmdimalanta.license.models.License;
import com.jmdimalanta.license.repositories.LicenseRepository;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepository lRepository;
	
	//list all licenses
	public List<License> allLicenses(){
		return lRepository.findAll();
	}
	//Create a license
	public License createLicense(License newLicense) {
		return this.lRepository.save(newLicense);
	}
	//One License detail
	public License findLicense(Long id) {
		return lRepository.findById(id).orElse(null);
	}
}	

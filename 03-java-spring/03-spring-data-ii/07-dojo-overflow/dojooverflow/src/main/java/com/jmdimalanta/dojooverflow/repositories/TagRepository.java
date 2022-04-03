package com.jmdimalanta.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jmdimalanta.dojooverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
	//get all tags
	List<Tag> findAll();
	
	boolean existsBySubject(String subject);
	Tag findBySubject(String subject);
}

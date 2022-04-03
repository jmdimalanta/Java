package com.jmdimalanta.show.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jmdimalanta.show.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	// get all books
	List<Book> findAll();

	// get books with descriptions
	List<Book> findByDescriptionContaining(String search);

	// count titles by string
	Long countByTitleContaining(String search);

}

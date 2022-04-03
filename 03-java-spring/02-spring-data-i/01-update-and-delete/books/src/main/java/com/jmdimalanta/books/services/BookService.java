package com.jmdimalanta.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jmdimalanta.books.repositories.BookRepository;
import com.jmdimalanta.books.models.Book;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<com.jmdimalanta.books.models.Book> allBooks(){
		return bookRepository.findAll();
	}
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	public String deleteBook(Long id) {
		this.bookRepository.deleteById(id);
		return "The book has been deleted";
	}
}

package com.joe.sam.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joe.sam.po.Book;
import com.joe.sam.service.IBookService;
	
@RestController
@RequestMapping("/books")
@CrossOrigin(origins="*",maxAge=1000000)
public class BookController {
	
	@Resource(name="bookService")
	private IBookService bookService;
	
	@PostMapping
	public Book add(Book book) {
		System.out.println("BookController:add:book=" + book);
		if(book.getBookDate() == null) {
			book.setBookDate(new Date());
		}
		return bookService.add(book);
	}
	
	@PutMapping("/{bookId}")
	public Book update(@PathVariable String bookId, Book book) {
		if(book.getBookId() == null) {
			book.setBookId(bookId);
		}
		System.out.println("BookController:update:book=" + book);
		return bookService.update(book);
	}
	
	@DeleteMapping("/{bookId}")
	public Book deleteById(@PathVariable String bookId) {
		System.out.println("BookController:update:bookId=" + bookId);
		return bookService.deleteById(bookId);
	}
	
	@GetMapping
	public List<Book> listAll(){
		List<Book> list = bookService.listAll();
		System.out.println("BookController:listAll:" + list);
		return list;
	}
	
	@GetMapping("/{bookId}")
	public Book listOne(@PathVariable String bookId){
		Book book = bookService.listOneById(bookId);
		System.out.println("BookController:listOne:bookId=" + bookId + "," + book);
		return book;
	}
}

package com.joe.sam.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joe.sam.dao.IBookDao;
import com.joe.sam.po.Book;

@Repository("bookDao")
public class BookDaoImpl implements IBookDao {
	
	@PersistenceContext(name="em")
	private EntityManager em;

	@Override
	public Book save(Book book) {
		em.persist(book);
		return book;
	}

	@Override
	public Book update(Book book) {
		Book b = em.find(Book.class, book.getBookId());
		b.setBookAuthor(book.getBookAuthor());
		b.setBookName(book.getBookName());
		b.setBookDate(book.getBookDate());
		em.persist(b);
		return b;
	}

	@Override
	public Book deleteById(String bookId) {
		Book b = em.find(Book.class, bookId);
		em.remove(b);
		return b;
	}

	@Override
	public List<Book> queryAll() {
		String jpql = "from Book order by Book";
		Query query = em.createQuery(jpql);
		List<Book> list = query.getResultList();
		return list;
	}

	@Override
	public Book queryOneById(String bookId) {
		Book b = em.find(Book.class, bookId);
		return b;
	}

}

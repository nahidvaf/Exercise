package se.yrgo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
//@Table(name="TBL_BOOK")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	//@Column(name="ISBN_NUM")
	private String isbn;
	private String title;
	@ManyToOne
	private Author author;
	private String publisher;
	@Transient
	private Integer numberOfPages;
	
	public Book() {}
	
	public Book(String title ) {
		this.title= title;
	}
	public Book(String isbn, String title, Author author) {
		this.isbn= isbn;
		this.title = title;
		this.author= author;
		this.publisher= "AMAZON";
	}
	
	public void allocateAuthor(Author author) {
		this.author=author;	
	}
		
	public String getAuthorName() {
		return this.author.getName();
	}

	public int getId() {
		return id;
	}

	public String getPublisher() {
		return publisher;
	}
	public String getIsbn() {
		return isbn;
	}

	public Author getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String toString() {
		return  " isbn: " + isbn  + " , title: "+  title  + " , author: "+ author;
	}

}

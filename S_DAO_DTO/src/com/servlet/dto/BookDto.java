package com.servlet.dto;

public class BookDto {

	int bookId;
	String bookName;
	String bookLoc;
	
	public BookDto(int bookId, String bookName, String bookLoc) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookLoc = bookLoc;
	}
	
	
}

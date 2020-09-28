package com.setvlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.servlet.dto.BookDto;

public class BookDao {
	
	String driver = "oracle.jdbd.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl"; //이떄 @이후 내용은 내 컴퓨터와 
	String id = "c##scott";
	String pw = "tiger";
	
	public BookDao() {
		
		try {
			Class.forName(driver);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public ArrayList<BookDto> select() {
		
		ArrayList<BookDto> list = new ArrayList<BookDto>();
		
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			con =DriverManager.getConnection(url, id, pw);
			String sql = "SELECT * FROM book";
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeQuery();
			
			while(res.next()) {
				int bookId =res.getInt("book_id");
				String bookLoc = res.getNString("book_loc");
				String bookName = res.getNString("book_name");
				
				BookDto bookDto = new BookDto( bookId, bookName, bookLoc);
				list.add(bookDto);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(res!=null) res.close();
				if(con!=null) con.close();
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		
		return null;
		
	}

	public String getUrl() {
		return url;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

}

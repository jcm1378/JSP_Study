package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setvlet.dao.BookDao;

@WebServlet("/bs")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("Text/html; charset=UTF-8"); //한글화 
		PrintWriter out = response.getWriter();
		
		/*
		String driver = "oracle.jdbd.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl"; //이떄 @이후 내용은 내 컴퓨터와 
		String id = "c##scott";
		String pw = "tiger";
		
		Connection con  = null;
		Statement stmt = null;
		ResultSet res = null;
		
		
	try {
		Class.forName(driver); //드라이버 로딩
		con = DriverManager.getConnection(url, id, pw);
		stmt =con.createStatement();
		String sql ="SELECT * FROM book";
		res = stmt.executeQuery(sql);
		
		while(res.next()) {
			int bookId = res.getInt("book_id");
			String bookName = res.getString("book_name");
			String bookLoc = res.getString("book_loc");
			
			out.print("bookId : " + bookId);
			out.print("bookName : " + bookName);
			out.print("bookLoc : " + bookLoc);
		}
		
		
	} catch (Exception e) {
		e.getStackTrace();
	}finally {
		try {
		if(res != null) res.close();
		if(stmt !=null) stmt.close();
		if(con !=null) con.close();
		}catch (Exception e) {
			e.getStackTrace();
		}
		
	}
		*/
		
		BookDao bookDAO = new BookDao ();
		ArrayList
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

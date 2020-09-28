package com.servlet;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.pept.transport.Connection;

@WebServlet("/newBook")
public class NewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
PrintWriter out = response.getWriter();
		
		String bookName = request.getParameter("book_name");
		String bookLoc = request.getParameter("book_loc");
		
		String driver = "oracle.jdbc.driver.OracleDriver";//오라클 드라이버가 어디 있는지 그것을 드라이버에 변수에 저장
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";//jdbc의 위치
		String id = "c##scott";
		String pw = "tiger";
		
		java.sql.Connection con = null;//연결을위한 connection객체
		java.sql.Statement stmt = null;//통신을 위한 statement객체
		
		try { //그리고 항상 네트워크 연결이기 때문에 try catch로 묶어주어야함
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, id, pw); //위의 url과 id pw로 커넥션을 맺음
			stmt = con.createStatement();//통신을 위한 커넥션으로부터 통신하는 객체를 만듦!!
			String sql = "INSERT INTO book(book_id, book_name, book_loc)"; // sql쿼리를 작성
					sql += " VALUES (BOOK_SEQ.NEXTVAL, '" + bookName + "', '" + bookLoc + "')"; //여기서 bookName과 bookLoc은 사용자가 요청 한 것이고 sql 문법에 맞게 query문을 작성했음, ''그래서 작은 따움표를 썻는데 조금 번잡함
			int result = stmt.executeUpdate(sql);//excuteUpdate = sql이 데이터를 성공적으로 전송했으면 1을 반환함
			
			if(result == 1) { //통신의 결과를 result로 
				out.print("INSERT success!!");
			} else {
				out.print("INSERT fail!!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { //리소스를 사용했기 때문에 꼭 해제를 해주어야 함 해제하는 항목은 내가 생성했던 con과 stmt
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

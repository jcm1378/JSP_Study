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
		
		String driver = "oracle.jdbc.driver.OracleDriver";//����Ŭ ����̹��� ��� �ִ��� �װ��� ����̹��� ������ ����
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";//jdbc�� ��ġ
		String id = "c##scott";
		String pw = "tiger";
		
		java.sql.Connection con = null;//���������� connection��ü
		java.sql.Statement stmt = null;//����� ���� statement��ü
		
		try { //�׸��� �׻� ��Ʈ��ũ �����̱� ������ try catch�� �����־����
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, id, pw); //���� url�� id pw�� Ŀ�ؼ��� ����
			stmt = con.createStatement();//����� ���� Ŀ�ؼ����κ��� ����ϴ� ��ü�� ����!!
			String sql = "INSERT INTO book(book_id, book_name, book_loc)"; // sql������ �ۼ�
					sql += " VALUES (BOOK_SEQ.NEXTVAL, '" + bookName + "', '" + bookLoc + "')"; //���⼭ bookName�� bookLoc�� ����ڰ� ��û �� ���̰� sql ������ �°� query���� �ۼ�����, ''�׷��� ���� ����ǥ�� ���µ� ���� ������
			int result = stmt.executeUpdate(sql);//excuteUpdate = sql�� �����͸� ���������� ���������� 1�� ��ȯ��
			
			if(result == 1) { //����� ����� result�� 
				out.print("INSERT success!!");
			} else {
				out.print("INSERT fail!!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { //���ҽ��� ����߱� ������ �� ������ ���־�� �� �����ϴ� �׸��� ���� �����ߴ� con�� stmt
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

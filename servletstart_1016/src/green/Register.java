package green;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet({ "/Register", "/register" })
public class Register extends HttpServlet {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
    public Register() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Hellow there^^ Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n = request.getParameter("userName");
		String p = request.getParameter("userPass");
		String e = request.getParameter("userEmail");
		String c = request.getParameter("userCountry");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member?useSSL=false", "root", "1234");
			pst = conn.prepareStatement("insert into registerUser values(?,?,?,?)");
			pst.setString(1, n);
			pst.setString(2, p);
			pst.setString(3, e);
			pst.setString(4, c);
			int i = pst.executeUpdate();
			if(i>0) {
				out.print("You are successfully registered!!");
			}
		} catch (Exception ea) {
			out.print(ea.getMessage());
		}
		out.close();
		
		doGet(request, response);
		System.out.println("Check1" + request.getParameter("userName"));
	}

}

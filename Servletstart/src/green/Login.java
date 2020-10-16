package green;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet({ "/Login", "/login" })
public class Login extends HttpServlet {
	String id;
	int password;
	private Map<String, Signin> logIn = new HashMap<String, Signin>();
       
    public Login() {
    	logIn.put("1", new Green());
    	logIn.put("2", new Bus());
    	logIn.put("3", new Tire());

    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = request.getParameter("id");
		password = Integer.parseInt(request.getParameter("password"));
		
		response.setContentType("text/html; charset=utf-8");
PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.print("<h1>아이디: </h1>");
		out.println("<h1>"+ id + "</h1>");
		out.println("<h1>계산결과</h1>");
		out.println("결과: ");
		
		//연산수행
		try {
			Signin si = logIn.get(id);
			if (si==null) {
				out.println("존재하지 않는 아이디입니다.");
			} else {
				int result = si.go(4, 5);
				out.println(result);
			}
		} catch (Exception e) {
			out.println("연산오류가 발생하였습니다");
			out.println(e.getMessage());
		}
		out.println("</body></html>");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		doGet(request, response);
	}

}

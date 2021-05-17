

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  
 
import word.ClassBd; 
import word.Words;
 
@WebServlet("/")
public class HelloServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {          
        getServletContext().getRequestDispatcher("/hello.jsp").forward(request, response);
 	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String poisk = request.getParameter("poisk");
		System.out.println(poisk);
		ArrayList<Words> word = ClassBd.select(poisk);
        request.setAttribute("word", word);
        
        getServletContext().getRequestDispatcher("/select.jsp").forward(request, response);
 	}
}

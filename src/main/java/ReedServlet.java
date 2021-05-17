import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import file_reed.Reed_file;


@WebServlet("/create")
public class ReedServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	 
	        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
	    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		
	        try {
	            File name = new File("C:\\Users\\Pimini\\Desktop\\Маг-ра\\2 семестр");
	            Reed_file.poisk(name);
	            response.sendRedirect(request.getContextPath()+"/hello.jsp");
	        } 
	        catch(Exception ex) {
	             
	            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response); 
	        }
	    }

}

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import word.ClassBd;

 
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
         
        try {
            ClassBd.delete();
            response.sendRedirect(request.getContextPath() + "/select");
        }
        catch(Exception ex) {
            //getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}


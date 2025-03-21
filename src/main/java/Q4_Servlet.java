import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Q4_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String numstr = request.getParameter("num");
        int sum = 0;
        for (int i = 0; i< numstr.length(); i++){
            sum = sum + Integer.parseInt(numstr.substring(i, i+1));
        }
        out.println("The Sum of digits of the given number " + numstr + " is: " + sum);
    }
}

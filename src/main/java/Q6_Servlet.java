import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Q6_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String numstr = request.getParameter("num");
        int num = Integer.parseInt(numstr);
        int fact = 1;
        if (num == 0) {
            out.println("Factorial of 0 is: " + fact);
        } else {
            for (int i = 1; i <= num; i++){
                fact = fact * i;
            }
            out.println("Factorial of " + num + " is: " + fact);
        }
    }
}
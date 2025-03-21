import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Q8_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int year = Integer.parseInt(request.getParameter("year"));
        boolean isLeap = (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
        if (isLeap) {
            out.println("The Given Year: " + year + " is a Leap Year");
        } else {
            out.println("The Given Year: " + year + " is not a Leap Year");
        }
    }
}

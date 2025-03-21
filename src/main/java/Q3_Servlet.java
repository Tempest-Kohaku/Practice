import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Q3_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String numstr = request.getParameter("num");
        int num1 = Integer.parseInt(numstr);
        int sum = 0;
        if (num1 > 0){
            for(int i = 0; i <= num1; i++){
                sum = sum + i*i;
            }
            out.println("The Sum of Squares of N Integers is: " + sum);
        } else {
            out.println("Please Input a Number greater than 0");
        }
    }
}

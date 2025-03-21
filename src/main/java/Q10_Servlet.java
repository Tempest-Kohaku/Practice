import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Q10_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String numstr = request.getParameter("num");
        int num = Integer.parseInt(numstr);
        String reversestr = "";
        
        for (int i = 0; i < numstr.length(); i++){
            reversestr += numstr.substring(numstr.length() - 1 - i, numstr.length() - i);
        }
        
        if (reversestr.equals(numstr)){
            out.println("The given number: " + num + " is a Palindrome");
        } else {
            out.println("The given number: " + num + " is not a Palindrome");
        }
    }
}

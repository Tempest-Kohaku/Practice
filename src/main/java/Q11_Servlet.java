import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Q11_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String tempstr = request.getParameter("temp");
        Double temp = Double.parseDouble(tempstr);
        String convert = request.getParameter("tempconv");
        Double result;
        switch (convert) {
            case "Celsius" : {
                result = (temp - 32) * 5/9;
                out.println(temp + " degree fahrenheit to celsius = " + result);
                return;
            }
            case "Fahrenheit" : {
                result = (temp * 9/5) + 32;
                out.println(temp + " degree celsius to fahrenheit = " + result);
                return;
            }
            default : {
                out.println("Please choose a valid conversion operator");
                return;
            }
        }
    }
}

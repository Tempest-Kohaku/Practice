import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Q5_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String numstr1 = request.getParameter("num1");
            int num1 = Integer.parseInt(numstr1);
            String numstr2 = request.getParameter("num2");
            int num2 = Integer.parseInt(numstr2);
            String operator = request.getParameter("operator");
            double result = 0;
            switch (operator) {
                case "+" -> result = num1 + num2;
                case "-" -> result = num1 - num2;
                case "*" -> result = num1 * num2;
                case "/" -> {
                    if (num2 != 0){
                        result = num1 / num2;
                    } else {
                        out.println("<h2>0 Division Error</h2>");
                        return;
                    }
                }
                default -> {
                    out.println("Error: Invalid Operator");
                    return;
                }
            }
            out.println(num1 + " " + operator + " " + num2 + " = " + result);
            
        } catch (Exception e){
            out.println(e.toString());
        }
    }
}

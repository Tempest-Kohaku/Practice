import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Q9_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String str1 = request.getParameter("str1");
        String str2;
        int count = 0;
        for (int i = 0; i < str1.length(); i++){
            str2 = str1.substring(i,i+1);
            str2 = str2.toLowerCase();
            if ("a".equals(str2) || "e".equals(str2) || "i".equals(str2) || "o".equals(str2) || "u".equals(str2)){
                count = count + 1;
            }
        }
        out.println("The String: " + str1 + " contains " + count + " vowels");
    }
}
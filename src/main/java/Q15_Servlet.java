import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

public class Q15_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/practice", "root", "root");
            PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM EMPLOYEES");
            ResultSet rs =  pst.executeQuery();
            while (rs.next()){
                out.println("Total Number of Employees in the Table are: " + rs.getString(1));
            }
        } catch (Exception e) {
            out.println(e.toString());
        }
    }
}

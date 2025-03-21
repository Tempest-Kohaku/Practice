import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

public class Q14_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int empid = Integer.parseInt(request.getParameter("empid"));
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/practice", "root", "root");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM EMPLOYEES WHERE EMPID = ?");
            pst.setInt(1, empid);
            ResultSet rs =  pst.executeQuery();
            while (rs.next()){
                out.println("ID: " + rs.getInt(1) + "<br> Username: " + rs.getString(2) + "<br> Password: " + rs.getString(3) + "<br> Salary: " + rs.getInt(4) + "<br> Email: " + rs.getString(5) + "<br> Country: " + rs.getString(6));
            }
        } catch (Exception e) {
            out.println(e.toString());
        }
    }
}

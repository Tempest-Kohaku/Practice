import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

public class Q12_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int empid = Integer.parseInt(request.getParameter("empid"));
        int salary = Integer.parseInt(request.getParameter("salary"));
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/practice", "root", "root");
            PreparedStatement pst = con.prepareStatement("UPDATE EMPLOYEES SET salary = ? where empid = ?");
            pst.setInt(1,salary);
            pst.setInt(2,empid);
            pst.executeUpdate();
        } catch (Exception e) {
            out.println(e.toString());
        }
    }
}
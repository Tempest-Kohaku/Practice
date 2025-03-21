import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Q13_Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int empid = Integer.parseInt(request.getParameter("empid"));
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/practice", "root", "root");
            PreparedStatement pst = con.prepareStatement("Delete from Employees where empid=?");
            pst.setInt(1, empid);
            pst.executeUpdate();
            pst.close();
            con.close();
        } catch (Exception e) {
            out.println(e);
        }
    }
}

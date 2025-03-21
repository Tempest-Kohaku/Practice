import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

public class Q12_CreateTable extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/practice", "root", "root");
            Statement st = con.createStatement();
            String sql = "CREATE TABLE EMPLOYEES ("
                    + "  empid INTEGER PRIMARY KEY, "
                    + "  username VARCHAR(255), "
                    + "  password VARCHAR(255), "
                    + "  salary INTEGER, "
                    + "  email VARCHAR(255), "
                    + "  country VARCHAR(255) "
                    + ")";
            st.executeUpdate(sql);
            
            PreparedStatement pst = con.prepareStatement("INSERT INTO EMPLOYEES VALUES(1, 'Manas', '1234', 500000, 'test123@gmail.com', 'india')");
            pst.executeUpdate();
            
            pst.close();
            con.close();
            out.println("<h2>Table created and record inserted successfully.</h2>");
        } catch (Exception e) {
            out.println("<h2>Error: " + e.toString() + "</h2>");
        }
    }
}

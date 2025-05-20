import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Example validation
        if (username.equals("admin") && password.equals("1234")) {
            HttpSession session = request.getSession();

            // Get login count from session
            Integer count = (Integer) session.getAttribute("loginCount");
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            session.setAttribute("loginCount", count);

            out.println("<html><body>");
            out.println("<h2>Welcome, " + username + "!</h2>");
            out.println("<p>You have logged in <strong>" + count + "</strong> time(s) during this session.</p>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h3 style='color:red;'>Invalid username or password.</h3>");
            out.println("</body></html>");
        }
    }
}



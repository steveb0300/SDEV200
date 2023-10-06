/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sbaker
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Main extends HttpServlet
{
@Override
public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    int count = 0;

    int first = Integer.parseInt(req.getParameter("one").trim());
    int second = Integer.parseInt(req.getParameter("two").trim());
    int third = Integer.parseInt(req.getParameter("three").trim());
    int fourth = Integer.parseInt(req.getParameter("four").trim());
    int fifth = Integer.parseInt(req.getParameter("five").trim());
    int sixth = Integer.parseInt(req.getParameter("six").trim());
    int seventh = Integer.parseInt(req.getParameter("seven").trim());
    int eighth = Integer.parseInt(req.getParameter("eight").trim());
    int nineth = Integer.parseInt(req.getParameter("nine").trim());
    int tenth = Integer.parseInt(req.getParameter("ten").trim());

    if(20 + 6 == first)
           count++;
    if(27 + 6 == second)
        count++;
    if(28 + 8 == third)
        count++;
    if(28 + 10 == fourth)
        count++;
    if(28 + 7 == fifth)
        count++;
    if(29 + 10 == sixth)
        count++;
    if(22 + 9 == seventh)
        count++;
    if(29 + 12 == eighth)
        count++;
    if(21 + 6 == nineth)
        count++;
    if(27 + 12 == tenth)
        count++;

    out.println("<html><body>");

    out.println("20 + 6 = "+first+""+( 20 + 6 == first ? "Correct" : "Wrong" ) + "<br>");
    out.println("27 + 6 = "+second+""+( 27 + 6 == second ? "Correct" : "Wrong" )+ "<br>");
    out.println("\n28 + 8 = "+third+""+( 28 + 8 == third ? "Correct" : "Wrong" )+ "<br>");
    out.println("\n28 + 10 = "+fourth+""+( 28 + 10 == fourth ? "Correct" : "Wrong" )+ "<br>");
    out.println("\n28 + 7 = "+fifth+""+( 28 + 7 == fifth ? "Correct" : "Wrong" )+ "<br>");
    out.println("\n29 + 10 = "+sixth+""+( 29 + 10 == sixth ? "Correct" : "Wrong" )+ "<br>");
    out.println("\n22 + 9 = "+seventh+""+( 22 + 9 == seventh ? "Correct" : "Wrong" )+ "<br>");
    out.println("\n29 + 12 = "+eighth+""+( 29 + 12 == eighth ? "Correct" : "Wrong" )+ "<br>");
    out.println("\n21 + 6 = "+nineth+""+( 21 + 6 == nineth ? "Correct" : "Wrong" )+ "<br>");
    out.println("\n27 + 12 = "+tenth+""+( 27 + 12 == tenth ? "Correct" : "Wrong" )+ "<br>");

    out.println("The total Correct count is : "+count);

    out.println("</body></html>");

    out.close();
    }
}

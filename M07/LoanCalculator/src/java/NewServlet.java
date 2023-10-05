

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import loan.Loan;
/**
 *
 * @author sbaker
 */
@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub

            float loanAmount = Float.parseFloat(request.getParameter("loanAmount"));
            float interestRate = Float.parseFloat(request.getParameter("interestRate"));
            int noOfYears = Integer.parseInt(request.getParameter("noOfYears"));

            PrintWriter out = response.getWriter();
            out.println("<div style='font-size:30px;'>");
            out.println("Loan Amount: "+loanAmount);
            out.println("<br/>Annual Interest Rate: "+interestRate);
            out.println("<br/>Number of Years: "+noOfYears);
            Loan loan = new Loan(interestRate,noOfYears,loanAmount);
            out.println("<div style='color:RED'");
            out.println("<br/>Monthly Payment: "+loan.getMonthlyPayment());
            out.println("<br/>Total Payment: "+loan.getTotalPayment());
            out.println("</div></div>");
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
            doGet(request, response);
    }
}

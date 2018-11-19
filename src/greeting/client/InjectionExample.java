package greeting.client;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import greeting.Greeting;
import greeting.Informal;

/**
 * Servlet implementation class InjectionExample
 */
@WebServlet("/getResults")
@RequestScoped
public class InjectionExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InjectionExample() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Inject Greeting greet1;
    @Inject @Informal Greeting greet2;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		ServletOutputStream  out = response.getOutputStream();
		
		String msg = greet1.greet("Zulu") + greet2.greet("Zulu") + greet2.greet("Zulu");
		out.write(msg.getBytes());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package encoder.client;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encoder3.CoderBean;

/**
 * Servlet implementation class EncoderClient3
 */
@WebServlet("/ec3")
public class EncoderClient3 extends HttpServlet {
  @Inject CoderBean cB;
  
  
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EncoderClient3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cB.setInputString("What da Fuq");
		cB.setTransVal(5);
		cB.encodeString();
		
		String msg = cB.getCodedString();
		response.setContentType("text/plain");
    ServletOutputStream out = response.getOutputStream();
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

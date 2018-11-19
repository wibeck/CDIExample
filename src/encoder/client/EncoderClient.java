package encoder.client;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encoder.CoderBean;

/**
 * Servlet implementation class EncoderClient
 */
@WebServlet("/encoder")
public class EncoderClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject CoderBean cb;     

    public EncoderClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		cb.setInputString("What da Fuq");
		cb.setTransVal(5);
		cb.encodeString();
		String msg = cb.getInputString() + " encrypted to : " + cb.getCodedString();
		
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

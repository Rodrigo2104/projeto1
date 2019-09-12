package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cadastro
 */
@WebServlet("/cadastro")
public class cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastro() {
    	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String confirmar_senha = request.getParameter("confirmar senha");
		PrintWriter out = response.getWriter();
		System.out.println(senha);
		System.out.println(confirmar_senha);
		if(senha.contentEquals(confirmar_senha)) {
			try {
				System.out.println("foi");
				dao.cadastro(nome,senha);
				out.println("cadastro validado");
				dao.close();
				RequestDispatcher send = request.getRequestDispatcher("login.jsp");
				send.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			out.println("senha não bate");
		}
		
		
	}

}

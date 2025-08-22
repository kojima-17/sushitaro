package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.SushiDAO;
import model.Menu;
import model.Sushi;

/**
 * Servlet implementation class SushitaroBeginServlet
 */
@WebServlet("/Sushitaro")
public class SushitaroBeginServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SushiDAO dao = new SushiDAO(new Menu());
		List<Sushi> sushiList = dao.findAll();
		session.setAttribute("sushiList", sushiList);
		request.getRequestDispatcher("/WEB-INF/sushi_top.jsp").forward(request, response);
	}
}
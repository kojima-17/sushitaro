package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Cart;
import model.CartService;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session == null) {
			response.sendRedirect("Sushitaro");
		} else {
			Cart cart;
			if((cart = (Cart) session.getAttribute("cart")) == null) {
				cart = new Cart();
				session.setAttribute("cart", cart);
			}
			CartService service = new CartService(cart); 
			String action = request.getParameter("action");
			System.out.println(action);
			switch(action) {
			case "add":
				String addSushiName = request.getParameter("name");
				service.addCart(addSushiName);
				request.setAttribute("message", addSushiName + "をカートに追加しました");
				break;
			case "updateQuantity":
				String updateSushiName = request.getParameter("name");
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				if(quantity > 0) {
					service.updateQuantity(updateSushiName, quantity);
					request.setAttribute("message", updateSushiName + "を" + quantity + "にしました");
				} else {
					service.removeCartItem(updateSushiName);
					request.setAttribute("message", updateSushiName + "を削除しました");
				}
				break;
				
			case "remove":
				String removeSushiName = request.getParameter("name");
				service.removeCartItem(removeSushiName);
				request.setAttribute("message", removeSushiName + "を削除しました");
				break;
			
			case "removeCart":
				session.removeAttribute("cart");
				request.setAttribute("message", "カートを削除しました");
			}
			
			request.getRequestDispatcher("/WEB-INF/sushi_top.jsp").forward(request, response);
			return ;
		}
	}

}

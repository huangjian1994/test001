package t.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import t.Base;
import t.Base.Entity;

/**
 * @author hj
 * @date 2017-7-18
 * servlet 3.0
 */
public class EntityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Base base = new Base();
		List<Entity> list = base.getData();
		req.setAttribute("list1", list);
		String path = "/index.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	
	
}

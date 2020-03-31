package kr.or.project.todo.todoForm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Form")
public class TodoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoFormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/todoForm.jsp");
			requestDispatcher.forward(request, response);
	}

}


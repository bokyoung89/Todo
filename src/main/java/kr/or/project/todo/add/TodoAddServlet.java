package kr.or.project.todo.add;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.project.todo.dao.TodoDao;
import kr.or.project.todo.dto.TodoDto;

@WebServlet("/add")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoAddServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");    
		request.setCharacterEncoding("utf-8");    
		
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String priority = request.getParameter("sequence");
		
		TodoDao dao = new TodoDao();
		TodoDto todo = new TodoDto();
		
		int sequence = 0;
			if(priority.equals("1순위")) sequence = 1;
			else if(priority.equals("2순위")) sequence = 2;
			else sequence = 3;
			
		todo.setName(name);
		todo.setTitle(title);
		todo.setSequence(sequence);
		
		dao.addTodo(todo);
		
		String path = request.getContextPath();
		response.sendRedirect(path + "/main");

		
	}

}

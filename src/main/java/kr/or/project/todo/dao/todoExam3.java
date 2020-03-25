package kr.or.project.todo.dao;

import java.util.List;

import kr.or.project.todo.dto.TodoDto;

public class todoExam3 {

	public static void main(String[] args) {
		TodoDao dao = new TodoDao();
		
		List<TodoDto> list = dao.getTodos();
		
		for(TodoDto todo : list) {
			System.out.println(todo);
		}
		
	}

}

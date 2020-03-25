package kr.or.project.todo.dao;

import kr.or.project.todo.dao.TodoDao;
import kr.or.project.todo.dto.TodoDto;

public class todoExam1 {

	public static void main(String[] args) {
		TodoDao dao = new TodoDao();
		TodoDto todo = dao.getTodoDto(1);
		System.out.println(todo);
	}
}

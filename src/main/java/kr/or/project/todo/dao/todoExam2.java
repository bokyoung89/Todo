package kr.or.project.todo.dao;

import kr.or.project.todo.dto.TodoDto;
import kr.or.project.todo.dao.TodoDao;

public class todoExam2 {

	public static void main(String[] args) {
		long id = 1;
		String name = "�ź���";
		String regDate = null;
		int sequence = 2;
		String title = "���� ��å";
		String type = null;

		TodoDto todo = new TodoDto(id,name,regDate,sequence,title,type);
		
		TodoDao dao = new TodoDao();
		int insertCount = dao.addTodo(todo);
		
		System.out.println(insertCount);
		
	}

}

package kr.or.project.todo.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.project.todo.dto.TodoDto;

public class TodoDao {
	private static String dburl = "jdbc:mysql://localhost:3306/project";
	private static String dbUser = "shin";
	private static String dbpasswd = "1234";
	
	public List<TodoDto> getTodos(){ //getTodos 테이블 전체 조회
		List<TodoDto> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		String sql = "SELECT id,name,regDate,sequence, title, type FROM todo ORDER BY sequence";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			try (ResultSet rs = ps.executeQuery()){
				
				while(rs.next()) {
					Long id = rs.getLong(1);
					String name = rs.getString(2);
					String regDate = rs.getString(3);
					int sequence = rs.getInt(4);
					String title = rs.getString(5);
					String type = rs.getString(6);
					TodoDto todo = new TodoDto(id,name,regDate,sequence,title,type);
					list.add(todo);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	public int addTodo(TodoDto todo) { //addTodos insert문으로 데이터 한 건 입력
		
		int insertCount = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "INSERT INTO todo (title, name, sequence) VALUES (?, ?, ?)";
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());

			insertCount = ps.executeUpdate();	
		} catch(Exception ex){
			ex.printStackTrace();
		}
	return insertCount;
}

	public int updateTodo(TodoDto todo) { //updateTodo 데이터 수정(type)
		
		int updateCount = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = null;
		if(todo.getType().equals("TODO")) {
			sql = "UPDATE todo set type = 'DOING' where id = ?";
		} else { //"DOING"
			sql = "UPDATE todo set type = 'DONE' where id = ?";
		}
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
				ps.setString(1, todo.getType());
				ps.setLong(2, todo.getId());
				
				updateCount = ps.executeUpdate();
			} catch(Exception ex){
			ex.printStackTrace();
		}
		return updateCount;
	}
	
	public TodoDto getTodo(long todoId) { //getTodo 데이터 한 건 조회
		TodoDto todo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "SELECT id,name,regDate,sequence,title,type FROM todo where id = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setLong(1, todoId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Long id = rs.getLong(1);
				String name = rs.getString(2);
				String regDate = rs.getString(3);
				int sequence = rs.getInt(4);
				String title = rs.getString(5);
				String type = rs.getString(6);
				todo = new TodoDto(id,name,regDate,sequence,title,type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null){
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(ps != null){
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return todo;
	}

}

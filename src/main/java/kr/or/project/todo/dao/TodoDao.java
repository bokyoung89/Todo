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
	
	public List<TodoDto> getTodos(){
		List<TodoDto> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		String sql = "SELECT id,name,regDate,sequence,title,type FROM todo order by id desc";
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
	
	public int addTodo(TodoDto todo) {
		int insertCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "INSERT INTO todo (title, name, sequence) VALUES (?, ?, ?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());

			insertCount = ps.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (Exception ex) {} 
		} //if
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception ex) {}
		} //if 
	} //finally
	return insertCount;
}
	
	public TodoDto getTodo(long todoId) {
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

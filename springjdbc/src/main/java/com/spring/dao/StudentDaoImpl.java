package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public int insert(Student student) {

		// insert query
		String query = "insert into student(id,name,city) values(?,?,?)";
		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}

	public int change(Student student) {
		// updating data
		String query = "update student set name=?, city=? where id=?";
		int update = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return update;
	}

	public int delete(int studentId) {
		// delete operation
		String query = "delete from student where id=?";
		int r = this.jdbcTemplate.update(query, studentId);
		return r;
	}

	public Student getStudent(int studentId) {
		//Selcting single student data
		String query="select * from student where id=?";
		Student student = this.jdbcTemplate.queryForObject(query, new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student=new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setCity(rs.getString(3));
				return student;
			}
			
			
		},studentId);
		return student;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
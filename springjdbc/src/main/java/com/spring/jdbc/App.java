package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "MY program started........." );
        //Spring jdbc=> jdbcTemplate
        ApplicationContext context=new AnnotationConfigApplicationContext(jdbcConfig.class);
		/*
		 * ApplicationContext context=new
		 * ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		 */
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        //JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		/* INSERT
		 * StudentDao studentDao = context.getBean("studenDao",StudentDao.class);
		 * Student student=new Student(); student.setId(1145);
		 * student.setName("Rana pagla"); student.setCity("Cumilla");
		 * 
		 * int result = studentDao.insert(student);
		 * System.out.println("Student added "+result);
		 */
		/* UPDATE
		 * StudentDao studentDao = context.getBean("studenDao",StudentDao.class);
		 * Student student=new Student(); student.setId(1145);
		 * student.setName("Rana pagla"); student.setCity("Cumilla");
		 * 
		 * int result = studentDao.change(student);
		 * System.out.println("Student data changed... "+result);
		 */
        //DELETE
		/*
		 * StudentDao studentDao = context.getBean("studenDao",StudentDao.class); int
		 * result =studentDao.delete(1129);
		 * System.out.println("Student data deleted... "+result);
		 */
        //select single data
		/*
		 * Student student = studentDao.getStudent(11294);
		 * System.out.println("Student details data... "+student);
		 */
        //select all student
        List<Student> students=studentDao.getAllStudents();
        for (Student student : students) {
			System.out.println("\n"+student);
		}
        
        
    }
}

package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
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
        ApplicationContext context=new
        		ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        //JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		/*
		 * StudentDao studentDao = context.getBean("studenDao",StudentDao.class);
		 * Student student=new Student(); student.setId(1145);
		 * student.setName("Rana pagla"); student.setCity("Cumilla");
		 * 
		 * int result = studentDao.insert(student);
		 * System.out.println("Student added "+result);
		 */
        StudentDao studentDao = context.getBean("studenDao",StudentDao.class);
        Student student=new Student();
        student.setId(1145);
        student.setName("Rana pagla");
        student.setCity("Cumilla");
        
        int result = studentDao.change(student);
        System.out.println("Student data changed... "+result);
    }
}

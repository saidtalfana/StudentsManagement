package com.springmvc.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.beans.Student;  
  
public class StudentDao { 
	
	
JdbcTemplate template;  

public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Student student){  
    String sql="insert into students (name,email,number,address) values('"+student.getName()+"','"+student.getEmail()+"',"+student.getNumber()+",'"+student.getAddress()+"')";  
    return template.update(sql);  
}  
public int update(Student student){  
    String sql="update students set name='"+student.getName()+"', 'email="+student.getEmail()+"', number="+student.getNumber()+",address='"+student.getAddress()+"' where id="+student.getId()+"";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from students where id="+id+"";  
    return template.update(sql);  
}  
public Student getStudentById(int id){  
    String sql="select * from students where id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));  
}  
public List<Student> getStudents(){  
    return template.query("SELECT * FROM students", new RowMapper<Student>(){  
        public Student mapRow(ResultSet rs, int row) throws SQLException {  
            Student s = new Student();  
            s.setId(rs.getInt(1));  
            s.setName(rs.getString(2));  
            s.setEmail(rs.getString(3));  
            s.setNumber(rs.getInt(4));
            s.setAddress(rs.getString(5));  // 
            return s;  
        }  
    });  
} 

}  

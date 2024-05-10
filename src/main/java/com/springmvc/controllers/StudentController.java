package com.springmvc.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;   
import com.springmvc.beans.Student;  
import com.springmvc.dao.StudentDao;
import com.springmvc.beans.Student;
import com.springmvc.dao.StudentDao;  

@Controller  
public class StudentController { 
	
    @Autowired
    private StudentDao dao ;
   
    
   
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/studentform")  
    public String showForm(Model model){  
        model.addAttribute("command", new Student());
        return "studentform"; 
    }  
    
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("student") Student student){  
			try {
				dao.save(student);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        return "redirect:/viewstudent";//will redirect to viewemp request mapping  
    }  
    
    /* It provides list of employees in model object */  
    @RequestMapping("/viewstudent")  
    public String viewStudents(Model model) {  
        List<Student> list = new ArrayList<>();
		try {
			list = dao.getStudents();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        model.addAttribute("list", list);
        return "viewstudent";  
    }  
    
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editstudent/{id}")  
    public String edit(@PathVariable int id, Model model){  
        Student student = null;
		try {
			student = dao.getStudentById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        model.addAttribute("command", student);
        return "studenteditform";  
    }  
    
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editSave(@ModelAttribute("emp") Student student) {  
        try {
			dao.update(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return "redirect:/viewstudent";  
    }  
    
    /* It deletes record for the given id in URL and redirects to / */  
    @RequestMapping(value="/deletestudent/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        try {
			dao.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return "redirect:/viewstudent";  
    }   
}  

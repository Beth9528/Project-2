package com.Project2.Project2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	 @GetMapping("/student/{first_name}")
	    public Students  student(@PathVariable String first_name ) throws IOException {
	        System.out.println("search students by name : "+first_name);
	        List<Students>  students = readStudent();
	        for(Students student : students){
	            if( student.getFirst_name().equalsIgnoreCase(first_name)){
	                System.out.println("student was found."+student);
	                return student;
	            }
	        }
	        System.out.println(" No student found for the name"+first_name);
	        return null;
	    }
	 
	 @GetMapping("/student")
	    public Students  student(@RequestParam double gpa, @RequestParam String gender ) throws IOException {
	        System.out.println("search students by gpa : "+gpa+" gender : "+gender);
	        List<Students>  students = readStudent();
	        for(Students student : students){
	            if( student.getGpa() == gpa && student.getGender().equalsIgnoreCase(gender)){
	                System.out.println("student was found."+student);
	                return student;
	            }
	        }
	        System.out.println(" No student found for the name"+gpa +"and" + gender);
	        return null;
	    }
	 
	 @GetMapping("/gpa")
	    public  double averageGpa (double gpa) {
		return gpa;
	 }
	
	public List<Students> readStudent () throws IOException {
		List<Students> studentList = new ArrayList<>();
		
		FileReader fr = new FileReader("/Project 2/Student");
		BufferedReader br = new BufferedReader (fr);
		
		String header = br.readLine();
		String line = br.readLine();
		
		while (line != null) {
			String [] tokens = line.split(",");
			int id = Integer.parseInt(tokens [0]);
			String first_name = tokens [1];
			double gpa = Double.parseDouble(tokens [2]);
			String email = tokens [3];
			String gender = tokens [4];
			
			Students student = new Students (id, first_name, gpa, email, gender);
			studentList.add(student);
			
			line = br.readLine();
			
		}
		return studentList;
		
	}

}

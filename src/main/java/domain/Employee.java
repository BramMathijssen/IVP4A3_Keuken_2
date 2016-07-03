/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.domain;

/**
 *
 * @author Bram
 */
public class Employee {
	
        private String employeeId;
        private String employeeName;
	private String username;
	private String password;
       
	
	public Employee(String employeeId, String employeeName, String username, String password){
		this.employeeId = employeeId;
                this.employeeName = employeeName;
		this.username = username;
		this.password = password;
	}
        
        //Getters
        public String getEmployeeId(){
            return employeeId;
        }
        
        public String getEmployeeName(){
            return employeeName;
        }
	
	public String getUsername(){
	    
            return username;
        }
    
        public String getPassword(){
    
            return password;
        }
        
       public void setEmployeeId(String employeeId){
    
            this.employeeId = employeeId;
        }
       
        public void setEmployeeName(String employeeName){
    
            this.employeeName = employeeName;
        }
        
        public void setUsername(String username){
    
        this.username = username;
        }
    
        public void setPassword(String password){
    
            this.password = password;
        }

}

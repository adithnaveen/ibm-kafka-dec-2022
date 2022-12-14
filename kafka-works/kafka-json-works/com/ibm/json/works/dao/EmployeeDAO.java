package com.ibm.json.works.dao;

import com.ibm.json.works.beans.Employee;

// assume that you are connecting to DB 

public class EmployeeDAO {
	public Employee getEmployee(int empId) {
		if(empId == 100) {
			return new Employee(100, "Akshata");
		}
		
		return null;
	}
	
	public Employee getEmployee(int empId, String name) {
		return new Employee(empId, name);
	}
	
}

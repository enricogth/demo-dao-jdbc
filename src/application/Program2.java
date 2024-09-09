package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("====Test 1: department findById");
		Department department = departmentDao.findById(1);
		System.out.println(department);

		
		System.out.println("====Test 2: department findAll");
		List<Department> list = new ArrayList<>();	
		list = departmentDao.findAll();
		for (Department dep : list) {
			System.out.println(dep);
		}
		
		System.out.println("====Test 3: department insert");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n==== TEST 4: department update ====");
		Department dep = departmentDao.findById(1);
		dep.setName("Food");
		departmentDao.update(dep);
		System.out.println("Update completed");
		
		System.out.println("\n==== TEST 5: department delete ====");
		System.out.println("Enter id for delete test: ");
		int id = input.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		input.close();
		
		
	}

}

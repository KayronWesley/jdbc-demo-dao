/*
 * Class Program2 is to test
 * methods of DerpatmentDaoJDBC
 */
package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		Department dep = new Department();
		
		System.out.println("\nTest 01: Insert New Department");
		Department newDep = new Department(null, "NewDep");
		depDao.insert(newDep);
		System.out.println("Insert, New ID: " + newDep.getId());
		
		System.out.println("\nTest 02: Update Department");
		dep = depDao.findById(1);
		dep.setName("NewName");
		depDao.update(dep);
		System.out.println("Updated, New Name: " + dep.getName());
		
		System.out.println("\nTest 03: Delete Department");
		depDao.deleteById(6);
		System.out.println("Deleted!");
		
		System.out.println("\nTest 04: Find All Department");
		List<Department> list = depDao.findAll();
		for (Department obj: list) {
			System.out.println(obj);
		}
	}

}

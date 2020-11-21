package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("TEST 01: Find By ID: ");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\nTEST 02: Find By Department: ");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj: list) {
		System.out.println(obj);
		}
		
		System.out.println("\nTEST 03: FindAll: ");
		list = sellerDao.findAll();
		for (Seller obj: list) {
		System.out.println(obj);
		}
		
		System.out.println("\nTEST 04: New Seller ");
		Seller newSeller = new Seller(null, "Test Insert", "test@insert.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Insert, New ID: " + newSeller.getId());
		
		System.out.println("\nTEST 05: Update Seller ");
		seller = sellerDao.findById(1);
		seller.setName("Joao");
		sellerDao.update(seller);
		System.out.println("Updated!");
		
		System.out.println("\nTEST 06: Delete Seller ");
		sellerDao.deleteById(7);
		System.out.println("Deleted Completed!");

		
	}
}

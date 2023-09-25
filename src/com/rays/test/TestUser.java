package com.rays.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.dto.UserDTO;
import com.rays.model.UserModel;

public class TestUser {

	public static void main(String[] args) throws Exception {

		 testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		// testAuth();
		//testSearch();

	}

	private static void testSearch() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		UserDTO dto = new UserDTO();
		//dto.setFirstName("pradeep");
		//dto.setLastName("dhakad");
		dto.setDob(sdf.parse("16-04-2004"));

		UserModel model = new UserModel();
		List list = model.search(dto, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			 dto = (UserDTO) it.next();
          
			System.out.print("\t "+dto.getId());
			System.out.print("\t "+ dto.getFirstName());
			System.out.print( "\t"+dto.getLastName());
			System.out.print("\t "+dto.getLoginId());
			System.out.print("\t "+dto.getPassword());
			System.out.print("\t "+dto.getDob());
			System.out.println("\t "+dto.getAddress());

		}

	}

	private static void testAuth() {

		UserModel model = new UserModel();

		UserDTO dto = model.authenticate("rajat@123gmail.com", "pass@123");

		if (dto != null) {
            
			System.out.print(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLoginId());
			System.out.println(dto.getPassword());
			System.out.println(dto.getDob());
			System.out.println(dto.getAddress());

		} else {

			System.out.println("user not exist...!!!");
		}

	}

	private static void testFindByPk() {

		UserModel model = new UserModel();

		UserDTO dto = model.findByPk(2);

		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLoginId());
		System.out.println(dto.getPassword());
		System.out.println(dto.getDob());
		System.out.println(dto.getAddress());

	}

	private static void testDelete() {

		UserDTO dto = new UserDTO();
		dto.setId(7);

		UserModel model = new UserModel();
		model.delete(dto);
	}

	private static void testUpdate() {

		UserDTO dto = new UserDTO();

		dto.setId(7);
		dto.setFirstName("naman");
		dto.setLastName("sharma");
		dto.setLoginId("naman123@gmail.com");
		dto.setPassword("pass@111");
		dto.setDob(new Date());
		dto.setAddress("indore");

		UserModel model = new UserModel();
		model.update(dto);

	}

	private static void testAdd() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		

		UserDTO dto = new UserDTO();

		dto.setId(6);
		dto.setFirstName("namo");
		dto.setLastName("singh");
		dto.setLoginId("ravi23@gmail.com");
		dto.setPassword("pass@111");
		dto.setDob(sdf.parse("18-04-2004"));
		dto.setAddress("indore");

		UserModel model = new UserModel();
		model.add(dto);
	}

}

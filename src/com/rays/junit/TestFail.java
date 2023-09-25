package com.rays.junit;

import static org.junit.Assert.fail;

import org.junit.Test;

public class TestFail {
	
	@Test
	public void testAdd() throws Exception {

		UserBean bean = new UserBean();
		bean.setId(4);
		bean.setSalary(6000);
		bean.setName("ajay");

		UserModel.add(bean);
		bean = UserModel.findByPk(2);

		if (bean == null) {

			fail("Record is not added...!!!");

		} else {
			System.out.println("record is added..!!!");
		}

	}


}

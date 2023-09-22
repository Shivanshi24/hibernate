package com.rays.test;

import java.util.Iterator;
import java.util.List;

import com.rays.dto.MarksheetDTO;
import com.rays.model.MarksheetModel;

public class TestMarksheet {

	public static void main(String[] args) {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		testSearch();

	}

	private static void testSearch() {

		MarksheetDTO dto = new MarksheetDTO();
		//dto.setName("anvi");
		dto.setRollNo(103);

		MarksheetModel model = new MarksheetModel();
		List list = model.search(dto, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			dto = (MarksheetDTO) it.next();

			System.out.print("\t" + dto.getId());
			System.out.print("\t" + dto.getName());
			System.out.print("\t" + dto.getRollNo());
			System.out.print("\t" + dto.getPhysics());
			System.out.print("\t" + dto.getChemistry());
			System.out.println("\t" + dto.getMaths());

		}

	}

	private static void testFindByPk() {

		MarksheetModel model = new MarksheetModel();
		MarksheetDTO dto = model.findByPk(4);

		System.out.println(dto.getId());
		System.out.println(dto.getName());
		System.out.println(dto.getRollNo());
		System.out.println(dto.getPhysics());
		System.out.println(dto.getChemistry());
		System.out.println(dto.getMaths());
	}

	private static void testDelete() {

		MarksheetDTO dto = new MarksheetDTO();
		dto.setId(8);

		MarksheetModel model = new MarksheetModel();
		model.delete(dto);

	}

	private static void testUpdate() {

		MarksheetDTO dto = new MarksheetDTO();

		dto.setId(8);
		dto.setName("roshi");
		dto.setRollNo(108);
		dto.setPhysics(56);
		dto.setChemistry(58);
		dto.setMaths(75);

		MarksheetModel model = new MarksheetModel();
		model.update(dto);

	}

	private static void testAdd() {

		MarksheetDTO dto = new MarksheetDTO();

		dto.setId(8);
		dto.setName("aman");
		dto.setRollNo(108);
		dto.setPhysics(56);
		dto.setChemistry(58);
		dto.setMaths(75);

		MarksheetModel model = new MarksheetModel();
		model.add(dto);

	}

}

package Userboard.service;

import java.sql.SQLException;
import java.util.Scanner;

import Userboard.dao.UserDAO;
import Userboard.dto.UserDTO;

public class UserService {
	private UserDAO dao = new UserDAO();

	public void insertUser(Scanner input) throws SQLException {
		UserDTO user = new UserDTO();
		System.out.print("�̸� : ");
		user.setName(input.next());
		System.out.print("���̵� : ");
		user.setId(input.next());
		System.out.print("��й�ȣ : ");
		user.setPw(input.next());
		dao.insertUser(user);
	}

	public void readAll() throws SQLException {
		dao.readAll();
	}

	public void updateUser(Scanner input) throws SQLException {
		System.out.print("������ ȸ����ȣ �Է� : ");
		int mno = input.nextInt();
		UserDTO user = new UserDTO();
		System.out.print("�� �̸� : ");
		user.setName(input.next());
		System.out.print("�� ���̵� : ");
		user.setId(input.next());
		System.out.print("�� ��й�ȣ : ");
		user.setPw(input.next());
		dao.updateUser(mno, user);
	}

	public void deleteUser(Scanner input) throws SQLException {
		System.out.print("������ ȸ����ȣ �Է� : ");
		int mno = input.nextInt();
		dao.deleteUser(mno);
	}

	public void login(Scanner input) throws SQLException {
		System.out.print("���̵� : ");
		String id = input.next();
		System.out.print("��й�ȣ : ");
		String pw = input.next();

		UserDTO user = dao.readOne(id, pw);
		if (user != null) {
			System.out.println(user.getName() + "�� �α��� ����!");
		} else {
			System.out.println("�α��� ����: ���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
	}
}

package Userboard.service;

import java.sql.SQLException;
import java.util.Scanner;

import Userboard.dao.UserDAO;
import Userboard.dto.UserDTO;

public class UserService {
	private UserDAO dao = new UserDAO();

	public void insertUser(Scanner input) throws SQLException {
		UserDTO user = new UserDTO();
		System.out.print("이름 : ");
		user.setName(input.next());
		System.out.print("아이디 : ");
		user.setId(input.next());
		System.out.print("비밀번호 : ");
		user.setPw(input.next());
		dao.insertUser(user);
	}

	public void readAll() throws SQLException {
		dao.readAll();
	}

	public void updateUser(Scanner input) throws SQLException {
		System.out.print("수정할 회원번호 입력 : ");
		int mno = input.nextInt();
		UserDTO user = new UserDTO();
		System.out.print("새 이름 : ");
		user.setName(input.next());
		System.out.print("새 아이디 : ");
		user.setId(input.next());
		System.out.print("새 비밀번호 : ");
		user.setPw(input.next());
		dao.updateUser(mno, user);
	}

	public void deleteUser(Scanner input) throws SQLException {
		System.out.print("삭제할 회원번호 입력 : ");
		int mno = input.nextInt();
		dao.deleteUser(mno);
	}

	public void login(Scanner input) throws SQLException {
		System.out.print("아이디 : ");
		String id = input.next();
		System.out.print("비밀번호 : ");
		String pw = input.next();

		UserDTO user = dao.readOne(id, pw);
		if (user != null) {
			System.out.println(user.getName() + "님 로그인 성공!");
		} else {
			System.out.println("로그인 실패: 아이디 또는 비밀번호가 일치하지 않습니다.");
		}
	}
}

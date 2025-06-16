package Userboard;

import java.sql.SQLException;
import java.util.Scanner;

import Userboard.service.UserService;

public class UserBoardTest {
	public static Scanner inputStr = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		UserService service = new UserService();
		boolean run = true;
		while (run) {
			System.out.println("회원 사이트입니다.");
			System.out.println("1. 회원가입");
			System.out.println("2. 회원목록 조희");
			System.out.println("3. 회원정보 수정");
			System.out.println("4. 회원정보 삭제");
			System.out.println("5. 로그인");
			System.out.println("6. 종료");
			System.out.print(">>>");

			String select = inputStr.next();

			switch (select) {
			case "1":
				System.out.println("회원가입을 진행합니다.");
				service.insertUser(inputStr);
				break;
			case "2":
				System.out.println("회원목록 조회메뉴로 이동합니다.");
				service.readAll();
				break;
			case "3":
				System.out.println("회원정보 수정을 진행합니다.");
				service.updateUser(inputStr);
				break;
			case "4":
				System.out.println("회원정보 삭제를 진행합니다.");
				service.deleteUser(inputStr);
				break;
			case "5":
				System.out.println("로그인을 진행합니다.");
				service.login(inputStr);
				break;

			case "6":
				System.out.println("종료");
				run = false;
				break;

			default:
				System.out.println("1~6까지만 입력 바랍니다");
			}
		}
	}

}
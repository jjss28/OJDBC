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
			System.out.println("ȸ�� ����Ʈ�Դϴ�.");
			System.out.println("1. ȸ������");
			System.out.println("2. ȸ����� ����");
			System.out.println("3. ȸ������ ����");
			System.out.println("4. ȸ������ ����");
			System.out.println("5. �α���");
			System.out.println("6. ����");
			System.out.print(">>>");

			String select = inputStr.next();

			switch (select) {
			case "1":
				System.out.println("ȸ�������� �����մϴ�.");
				service.insertUser(inputStr);
				break;
			case "2":
				System.out.println("ȸ����� ��ȸ�޴��� �̵��մϴ�.");
				service.readAll();
				break;
			case "3":
				System.out.println("ȸ������ ������ �����մϴ�.");
				service.updateUser(inputStr);
				break;
			case "4":
				System.out.println("ȸ������ ������ �����մϴ�.");
				service.deleteUser(inputStr);
				break;
			case "5":
				System.out.println("�α����� �����մϴ�.");
				service.login(inputStr);
				break;

			case "6":
				System.out.println("����");
				run = false;
				break;

			default:
				System.out.println("1~6������ �Է� �ٶ��ϴ�");
			}
		}
	}

}
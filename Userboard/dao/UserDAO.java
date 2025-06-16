package Userboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Userboard.dto.UserDTO;

public class UserDAO {
	public UserDTO userDTO = new UserDTO();
	public Connection connection = null;
	public Statement statement = null;
	public PreparedStatement preparedStatement = null;
	public ResultSet resultSet = null;
	int result = 0;

	public UserDAO() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.174:1521:xe", "userboardtest",
					"userboardtest");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �̸��̳�, ojdbc6.jar ������ �߸��Ǿ����ϴ�.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("url, id, pw�� �߸��Ǿ����ϴ�. UserDAO�� �⺻ �����ڸ� Ȯ���ϼ���");
			System.exit(0);
			e.printStackTrace();
		}

	}

	public void insertUser(UserDTO userDTO) throws SQLException {
		try {
			String sql = "INSERT INTO member (mno, name, id, pw, regdate) VALUES (member_seq.NEXTVAL, ?, ?, ?, sysdate)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userDTO.getName());
			preparedStatement.setString(2, userDTO.getId());
			preparedStatement.setString(3, userDTO.getPw());
			result = preparedStatement.executeUpdate();
			if (result > 0) {
				System.out.println("ȸ�� ��� �Ϸ�");
				connection.commit();
			} else {
				System.out.println("ȸ�� ��� ����");
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("InsertUser ���ܹ߻�");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}

	}

	public void readAll() throws SQLException {
		try {
			String sql = "SELECT mno, name, id, pw, regdate FROM member ORDER BY mno";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			System.out.println("��ȣ \t �̸� \t ���̵� \t ��й�ȣ \t �����");

			while (resultSet.next()) {
				System.out.println(
						resultSet.getInt("mno") + "\t" + resultSet.getString("name") + "\t" + resultSet.getString("id")
								+ "\t" + resultSet.getString("pw") + "\t" + resultSet.getDate("regdate"));
			}
		} catch (SQLException e) {
			System.out.println("ReadAll ���� �߻�");
			e.printStackTrace();
		} finally {
			resultSet.close();
			statement.close();
		}
	}

	public void updateUser(int mno, UserDTO userDTO) throws SQLException {
		try {
			String sql = "UPDATE member SET name=?, id=?, pw=?, regdate=SYSDATE WHERE mno=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userDTO.getName());
			preparedStatement.setString(2, userDTO.getId());
			preparedStatement.setString(3, userDTO.getPw());
			preparedStatement.setInt(4, mno);
			result = preparedStatement.executeUpdate();
			if (result > 0) {
				System.out.println("ȸ�������� �����Ǿ����ϴ�.");
				connection.commit();
			} else {
				System.out.println("ȸ������ ���� ����");
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("UpdateUser ���ܹ߻�");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}

	}

	public void deleteUser(int mno) throws SQLException {
		try {
			String sql = "DELETE FROM member WHERE mno = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, mno);
			result = preparedStatement.executeUpdate();
			if (result > 0) {
				System.out.println("ȸ���� �����Ǿ����ϴ�.");
				connection.commit();
			} else {
				System.out.println("ȸ�� ���� ����");
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("deleteUser ���� �߻�");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}
	}

	public UserDTO readOne(String id, String pw) throws SQLException {
		UserDTO user = null;
		try {
			String sql = "SELECT mno, name, id, pw, regdate FROM member WHERE id = ? AND pw = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pw);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = new UserDTO();
				user.setMno(resultSet.getInt("mno"));
				user.setName(resultSet.getString("name"));
				user.setId(resultSet.getString("id"));
				user.setPw(resultSet.getString("pw"));
			}
		} catch (SQLException e) {
			System.out.println("�α��� ���� �߻�");
			e.printStackTrace();
		} finally {
			if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
		}
		return user;
	}
}

package daoPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beanPackage.UserInfo;

public class UserManagementDao {

	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/ordermanagement?characterEncoding=UTF-8";
	private String user = "root";
	private String password = "1234";
	private Connection conn;
	private Statement stat;

	private static UserManagementDao instance = new UserManagementDao();

	private UserManagementDao() {

		try {

			//加载驱动程序
			Class.forName(driver);
			System.out.println("成功加载MySQL驱动程序!");
			conn = DriverManager.getConnection(url, user, password);

			//数据库连接
			if (!conn.isClosed()) {
				System.out.println("数据库连接成功!");

			}
		} catch (Exception e) {
			System.out.println("数据库连接失败!");
			e.printStackTrace();
		}

	}

	public static UserManagementDao getInstance() {
		return instance;
	}

	public boolean checkName(UserInfo u) {

		boolean a = false;

		String userName = u.getUserName();
		String email = u.getEmail();
		String address = u.getAddress();

		String sql = "insert into user(userName,email,address) values (?,?,?)";

		try {

			java.sql.PreparedStatement p = conn.prepareStatement(sql);

			p.setString(1,userName);
			p.setString(2,email);
			p.setString(3,address);

			int b = p.executeUpdate();

			if(b > 0) {

				a = true;
			}
		} catch(SQLException e) {

			e.printStackTrace();

		}

		return a;
	}

	public List<UserInfo> getUserInfos() throws SQLException {

		ArrayList<UserInfo> userList = new ArrayList<UserInfo>();

		String sql = "select userName,email,address from user";

		return null;

	}

}

package daoPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beanPackage.UserInfo;

public class UserManagementDao {

	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://192.168.1.43/ordermanagement?characterEncoding=UTF-8";
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

	public boolean addUser(UserInfo u) {

		boolean a = false;

		String userName = u.getUserName();
		String email = u.getEmail();
		String address = u.getAddress();


		String sql = "insert into user(userName,email,address,exitStatus) values (?,?,?,?)";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1,userName);
			ps.setString(2,email);
			ps.setString(3,address);
			ps.setInt(4,1);

			int b = ps.executeUpdate();

			if(b > 0) {

				a = true;
				System.out.println("数据插入成功");

			}

		} catch(SQLException e) {

			System.out.println("数据插入出现错误");
			e.printStackTrace();

		}

		return a;
	}

	public List<UserInfo> getUserInfos() throws SQLException {

		ArrayList<UserInfo> userList = new ArrayList<UserInfo>();

		String sql = "select userName,email,address,exitStatus from user order by userName";


		try {

			stat = conn.createStatement();

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {

				UserInfo ui = new UserInfo();

				ui.setUserName(rs.getString("userName"));
				ui.setEmail(rs.getString("email"));
				ui.setAddress(rs.getString("address"));
				int isExit = rs.getInt("exitStatus");

				if(isExit == 1){

					userList.add(ui);
					System.out.println("数据查询成功");
				}

			}


		} catch(SQLException e) {

			System.out.println("数据查询出现错误");
			e.printStackTrace();

		}


		return userList;

	}

	public boolean updateUser(UserInfo uu) {

		boolean a = false;

		String email = uu.getEmail();
		String address = uu.getAddress();

		String sql = "update user set (email,address) values (?,?) where userName = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1,email);
			ps.setString(2,address);

			int b = ps.executeUpdate(sql);

			if(b > 0) {

				a = true;
				System.out.println("数据更新成功");
			}

		} catch(SQLException e) {

			System.out.println("数据更新出现错误");
			e.printStackTrace();

		}

		return a;
	}



}

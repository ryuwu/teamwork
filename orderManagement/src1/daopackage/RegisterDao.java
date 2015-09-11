package daopackage;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import dataFlowPackage.UserInfo;

public class RegisterDao {


	private String driver = "com.mysql.jdbc.Driver";//JDBC驱动

	private String url = "jdbc:mysql://127.0.0.1:3306/bbsdb";

	private String user = "root";

	private String password = "1234";

	private Connection conn;// 创建  CONNECTION 的变量 CONN 作为 当前数据连接



	private static RegisterDao instance=new RegisterDao();


	private RegisterDao (){

		try {

			// 加载驱动程序
			Class.forName(driver);

			// 获得 数据库的
			conn = (Connection) DriverManager.getConnection(url, user, password);

			if(!conn.isClosed()){

				System.out.println("Succeeded connecting to the Database!");
			}

		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("error");
		}


	}

	public static RegisterDao getInstance() {
		return instance;
	}



	public boolean checkName(UserInfo cs){

		boolean a = false;//声明一个布尔值用于返回方法参数

		String userName = cs.getUsername();//得到UserInfo变量值
		String userPassword = cs.getPassword();
		String userEmail = cs.getEmail();

		String sql = "insert into register	VALUES (?,?,?)";//执行SQL语句，返回到ResultSet的ret对象里；

		try {

			PreparedStatement ps = conn.prepareStatement(sql);//使用prepareStatement(sql)方法

			ps.setString(1, userName);//将UserInfo变量值插入数据库
			ps.setString(2, userPassword);
			ps.setString(3, userEmail);

			int b = ps.executeUpdate();//该方法，在插入成功后，将返回一个大于0的整数

			if(b>0) {
				a = true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return a;
	}
}

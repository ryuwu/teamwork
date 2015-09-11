package daopackage;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import dataFlowPackage.UserInfo;



public class LoginDao {

	private String driver = "com.mysql.jdbc.Driver";//JDBC驱动

	private String url = "jdbc:mysql://127.0.0.1:3306/bbsdb";

	private String user = "root";

	private String password = "1234";

	private Connection conn;

	private Statement statement;//用Statement接口向数据库发送SQL语句，


	private static LoginDao instance=new LoginDao();

	private LoginDao (){
		try {

			// 加载驱动程序
			Class.forName(driver);

			// 连续数据库
			conn = (Connection) DriverManager.getConnection(url, user, password);

			if(!conn.isClosed()){

				System.out.println("Succeeded connecting to the Database!");
			}

			statement = (Statement) conn.createStatement();//Statement接口与数据库对联

		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("error");
		}
	}

	public static LoginDao getInstance() {
		return instance;
	}


	public int checkUser(UserInfo uc) {

		String sql = "select name,password from register";//将MYSQL文保存在sql对象里

		boolean result1 = false;
		boolean result2 = false;

		try {
			ResultSet ret = statement.executeQuery(sql);//使用executeQuery(sql)方法
			                                           //执行SQL语句，返回到ResultSet的ret对象里；
			//ret.next()是遍历的方法
			while (ret.next()) {
				if(ret.getString(1).equals(uc.getUsername())) {
					result1 = true;

					if(ret.getString(2).equals(uc.getPassword())){
						result2 =true;
						break;
					}
					break;
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		if(result1==false){
			return 1;
		}
		else if(result2==false){
			return 2;
		}
		else{
			return 0;
		}
	}


	public boolean update(UserInfo ps){

		boolean a = false;


		String userName = ps.getUsername();//得到UserInfo变量值
		String userPassword = ps.getPassword();
		String userEmail = ps.getEmail();

		String sql = "update register set name = ?, password = ?,email = ? where name = 'wangbin'";
		try {
			PreparedStatement up = conn.prepareStatement(sql);//执行SQL语句
			up.setString(1, userName);//把值设置进去
			up.setString(2, userPassword);
			up.setString(3, userEmail);

			int b = up.executeUpdate();///该方法，在更新后，将返回一个大于0的整数
			if(b>0){
				a = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}


	public boolean delete(UserInfo ps){

		boolean a = false;

		String userName = ps.getUsername();//得到UserInfo变量值

		String sql = "delete from register where name =？";

		try {
			PreparedStatement de = conn.prepareStatement(sql);//执行语句

			de.setString(1, userName);//将值带进去

			de = (PreparedStatement) conn.createStatement();//删除该语句

			int b = de.executeUpdate(sql);//该方法，在插入成功后，将返回一个大于0的整数

			if(b>1){
				a = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}













}



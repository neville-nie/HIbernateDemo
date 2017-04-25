/*
 *abstract: 
 *
 *@author NW
 *
 *Created on 2017-4-25
 *
 */
package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * JdbcTest.java 
 * abstract:
 * 
 * hostory:
 * 	 NW 2017-4-25 初始化
 */
public class JdbcTest {
	String url = "jdbc:mysql://localhost:3306/hibernate";
	String username = "root";
	String password = "nw";
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url, username, password);
	}
	
	@Test
	public void test() throws SQLException, ClassNotFoundException {
		Connection conn = getConnection();
		//conn.setAutoCommit(false);
		Statement stmt = conn.createStatement();
		//stmt.executeUpdate("create table student(id integer primary key, name char(30))");
		stmt.executeUpdate("insert into user(user_name,user_email,version) values( 'auser', 'Peteremail',1)");
		stmt.executeUpdate("insert into user(user_name,user_email,version) values( 'buser', 'Samemail',1)");
		//conn.commit();
		conn.close();
	}
}

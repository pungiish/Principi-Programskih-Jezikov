package si.um.feri.database;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBHelper {

	public void Povezi(String query) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			InputStream input = DBHelper.class.getResourceAsStream("./config.properties");
			Properties prop = new Properties();

			if (input == null) {
				System.out.println("Sorry, unable to find config.properties");
				return;
			}

			//load a properties file from class path, inside static method
			prop.load(input);
			String url = prop.getProperty("db.url");
			String user = prop.getProperty("db.user");
			String pass = prop.getProperty("db.password");
			Connection con = DriverManager.getConnection(
					url, user, pass);
//here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
				System.out.println(rs.getString(1));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

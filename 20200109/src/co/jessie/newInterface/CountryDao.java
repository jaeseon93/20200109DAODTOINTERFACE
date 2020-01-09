package co.jessie.newInterface;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CountryDao {
	public Connection conn;
	

	private String driver;
	private String url;
	private String user;
	private String password;

	private void configuProperties() throws IOException { // CountryDao안에서만 쓰겠다는 뜻 (private) throws IOException:이구문쓰면
															// try-catch구문 안써두됨.
		Properties properties = new Properties();
		Reader reader = new FileReader("config/db.properties");
		properties.load(reader);
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
	}

	public CountryDao() { //DAO 에서 try-catch구문만 써주기
		try {
			configuProperties();
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (IOException | ClassNotFoundException | SQLException e) {

		}

	}

}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public void readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/feedback?"
		              + "user=sqluser&password=sqluserpw");
			
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * from COMMENTS");
			while (resultSet.next()) {
				String line = resultSet.getString(1);
				System.out.println("First Column: " + line);
			}
			connect.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MySQLAccess dco = new MySQLAccess();
		dco.readDataBase();
	}

}

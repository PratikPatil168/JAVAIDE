import java.sql.*;

public class JdbcTest18
{
	public static void main(String args[]) throws Exception
	{

		Class.forName( "UcanaccessDriver");
		Connection conn =
		DriverManager.getConnection("jdbc:ucanaccess://d:\\Database1.accdb");
	 	Statement stmt = conn.createStatement();

	stmt.executeUpdate("create table greetings1 (SNAME char(50))");
	stmt.executeUpdate("insert into greetings1 values ('Hello World')");

		ResultSet set = stmt.executeQuery("select * from greetings1");

		while(set.next())
		{
			System.out.println(set.getString(1));
		System.out.println("------------------------------------------------------------");
	}

		set.close();
		stmt.close();
		conn.close();
	}
}








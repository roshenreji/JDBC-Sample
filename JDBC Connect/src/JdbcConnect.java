import java.sql.*;

import java.util.Scanner;

public class JdbcConnect {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		
		int id=8;
		String name="Jackie";
		String city="America";
		String query="Select name,city from Student";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Helloworld1234");
		String insertQuery="Insert into Student values(?,?,?)";
		//Statement st=con.createStatement();
		
		PreparedStatement st=con.prepareStatement(insertQuery);
		st.setInt(1, 8);
		st.setString(2, "Kevin");
		st.setString(3, "Bombay");
		int count=st.executeUpdate();
		ResultSet rs=st.executeQuery(query);
		
		
		
		System.out.println(count +" row/s affected");
		

		while(rs.next()) {
			String nameOfStudent=rs.getString(1);
			String cityOfStudent=rs.getString(2);
			
			System.out.println(nameOfStudent+" : "+cityOfStudent);
		}
		//int roll_no=rs.getInt("Roll_no");
		
		st.close();
		con.close();
		
	}

}
	
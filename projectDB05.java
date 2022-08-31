package projectD02;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class projectDB05 {

	public static void main(String[] args) {
		Connection cn= null;
		PreparedStatement pe =null;
		ResultSet rs= null;
		String dbURL="jdbc:mariadb://127.0.0.1:3306/projectshow";
		String dbID="user";
        String dbPassword ="123456";	
        Scanner in =new Scanner(System.in);
        System.out.println("검색할 프로젝트 명을 입력:");
        String searchtext =in.nextLine();
        
        
        try {
        	Class.forName("org.mariadb.jdbc.Driver");
        	cn = DriverManager.getConnection(dbURL, dbID, dbPassword);
        	
        	String SQL = "SELECT * FROM  projecttable WHERE name LIKE ?";
        	
        	pe = cn.prepareStatement(SQL);
        	pe.setString(1, searchtext);
        	rs = pe.executeQuery();
        	
        	System.out.println("검색한 결과:");
        	while(rs.next()) {
        		
        		System.out.println(rs.getInt(1));
        		System.out.println(rs.getString(2));
        		System.out.println(rs.getInt(3));
        		System.out.println(rs.getString(4));
        		
        		
        	}
        	
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        
	}

}

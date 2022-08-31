package projectD02;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class projectDB07 {

	public static void main(String[] args) {
		Connection cn = null;
		ResultSet rs =null;
		PreparedStatement pe =null;
		String dbURL="jdbc:mariadb://127.0.0.1:3306/user";
		String dbID="user";
        String dbPassword ="123456";
        try {
        	Class.forName("org.mariadb.jdbc.Driver");
        	cn = DriverManager.getConnection(dbURL, dbID, dbPassword);
//        	String SQL= "SELECT *"
//        			   +" FROM Book"
//        			   +" WHERE price BETWEEN ? AND ?";
//        	String SQL="SELECT *"
//        			  +" FROM Book"
//        			  +" WHERE publisher IN(?,?)";
        	String SQL="SELECT *"
        			  +" FROM Book"
        			  +" WHERE bookname LIKE '_구%'";
        	
        	
        	pe= cn.prepareStatement(SQL);
//        	pe.setInt(1, 1000);
//        	pe.setInt(2, 200000);
//        	pe.setString(1, "굿스포츠");
//        	pe.setString(2, "대한미디어");
//          pe.setString(1, "_구%"); 똑같음
        	rs= pe.executeQuery();
        	while(rs.next()) {
        		System.out.println("----------");
        		System.out.println(rs.getInt(1));
        		System.out.println(rs.getString(2));
        		System.out.println(rs.getString(3));
        		System.out.println(rs.getInt(4));
        		System.out.println("----------");
        		
        		
        	}
        	
         
        	
        }catch (Exception e) {
        	e.printStackTrace();
        }
	}

}

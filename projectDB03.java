package projectD02;
  
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
public class projectDB03 {

	public static void main(String[] args) {
		Connection cn = null;
		PreparedStatement pe = null;
		ResultSet rs =null;
		String dbURL="jdbc:mariadb://127.0.0.1:3306/projectshow";
		String dbID="user";
        String dbPassword ="123456";	
        
        try {
        	Class.forName("org.mariadb.jdbc.Driver");
        	cn = DriverManager.getConnection(dbURL, dbID, dbPassword);
        	String SQL="CREATE TABLE projecttable( "
        			+" id INT,"
        			+" name VARCHAR(255),"
        			+" day INT,"
        			+" content VARCHAR(4000)"
        			+")";
		
        	pe = cn.prepareStatement(SQL);
        	rs = pe.executeQuery();
		

        }catch(Exception e) {
        	e.printStackTrace();
        }
	}

}

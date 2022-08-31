package projectD02;
         
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.DriverManager;

public class projectDB01 {

	public static void main(String[] args) {
		
		Connection cn =null;
		PreparedStatement pe=null;
		ResultSet rs =null;
		
		String dbURL="jdbc:mariadb://127.0.0.1:3306/user";
		String dbID="user";
		String dbPassword="123456";
		
		try {
			
			Class.forName("org.mariadb.jdbc.Driver");
			cn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			String SQL="SELECT distinct publisher AS pub FROM Book";
			pe = cn.prepareStatement(SQL);
			rs = pe.executeQuery();
			while(rs.next()) {
				
				System.out.println(rs.getString(1));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

}

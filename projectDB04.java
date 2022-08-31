package projectD02;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
import java.util.Scanner;
  
public class projectDB04 {

	public static void main(String[] args) {
		Connection cn= null;
		PreparedStatement pe =null;
		ResultSet rs= null;
		String dbURL="jdbc:mariadb://127.0.0.1:3306/projectshow";
		String dbID="user";
        String dbPassword ="123456";	
		
		Scanner in =new Scanner(System.in);
		System.out.println("숫자로만 입력하세요:");
		String pid=in.nextLine();
		int id =Integer.parseInt(pid);
		System.out.println("프로젝트 이름을 입력하세요:");
		String pname = in.nextLine();
		System.out.println("프로젝트 기간을 숫자로 입력하세요:");
		String pday =in.nextLine();
		int day =Integer.parseInt(pday);
		System.out.println("프로젝트 내용을 입력하세요:");
		String pcontent = in.nextLine();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			cn=DriverManager.getConnection(dbURL, dbID, dbPassword);
			
		   String SQL=" INSERT INTO projecttable(id,name,day,content)"
		   		+ " VALUES (?,?,?,?)";
		   pe = cn.prepareStatement(SQL);
		   pe.setInt(1, id);
		   pe.setString(2, pname);
		   pe.setInt(3, day);
		   pe.setString(4, pcontent);
		   
		   int result = pe.executeUpdate();
		   System.out.println("결과:"+result);
		   
		   String SQL1=" SELECT * FROM projecttable";
		   pe = cn.prepareStatement(SQL1);
		   rs = pe.executeQuery();
		   System.out.println("프로젝트 관련 내용 출력");
		   
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

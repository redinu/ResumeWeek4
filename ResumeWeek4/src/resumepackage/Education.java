
package resumepackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Education {
	
	private int eduId;
	private String degree; 
	private String institute; 
	private int year;
	private int personId;
	
	
	public int getEduId() {
		return eduId;
	}
	public void setEduId(int eduId) {
		this.eduId = eduId;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	} 	
	
	@SuppressWarnings("null")
	public void addEduToDB(int personId){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String addEdu = "insert into education(degree,institute, year, personId) values(?,?,?,?); ";
		String getEduId= "select eduId from education where personId = ? and degree = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost/resumeapp?"+ "user=root&password=passw0rd");
			pstmt = con.prepareStatement(addEdu);
			pstmt.setString(1, this.getDegree());
			pstmt.setString(2, this.getInstitute());
			pstmt.setInt(3, this.year);
			pstmt.setInt(4, personId);
			
			pstmt.executeUpdate();
			
			con.prepareStatement(getEduId);
			pstmt.setInt(1, personId);
			pstmt.setString(2, this.degree);
			rs = pstmt.executeQuery();
			rs.next();
			
			this.setEduId(rs.getInt("eduId"));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
}

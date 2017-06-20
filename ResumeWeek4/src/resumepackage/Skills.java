
package resumepackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Skills {
	private int skillId;
	private String skill; 
	private int proficiency;
	
	
	
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public int getProficiency() {
		return proficiency;
	}
	public void setProficiency(int proficiency) {
		this.proficiency = proficiency;
	} 
	
	public void addSkill(int personId){
		String addSkill = "insert into skills(skill, proficiency,personId) values (?,?,?)";
		String getskillId ="select skillid from skills where personid = ? and skill = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/resumeapp?"+ "user=root&password=passw0rd");
			pstmt = con.prepareStatement(addSkill);
			pstmt.setString(1, this.skill);
			pstmt.setInt(2, this.proficiency);
			pstmt.setInt(3, personId);
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(getskillId);
			pstmt.setInt(1, personId);
			pstmt.setString(2, this.skill);
			rs = pstmt.executeQuery();
			rs.next();
			
			this.setSkillId(rs.getInt("skillId"));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	
	
	}
}

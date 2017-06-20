
package resumepackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Job {
	private int jobID; 
	private String jtitle; 
	private String jcompany; 
	private LocalDateTime sdate; 
	private LocalDateTime edate;
	private ArrayList <String> jduties;
	private Object title;
	private Object company; 
	
	public Job(){	
		
		this.jduties = new ArrayList<String>(); 
	}
	
	public void addDuty(String dutystring, int PersonID)
	{		
		
		String insertSQL = "insert into jobduties(jobid,jobduty,personid) values(?,?,?)"; 
		
		
		PreparedStatement stmt=null;	
		try{
			Class.forName("com.mysql.jdbc.Driver");
	        java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/resumeapp?"+ "user=root&password=passw0rd");
			stmt = con.prepareStatement(insertSQL);
			stmt.setInt(1,this.getJobID());
			stmt.setString(2,dutystring);
			stmt.setInt(3,PersonID);
			stmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			
		}
		finally{
			
		}

		this.jduties.add(dutystring+this.jobID);
		System.out.println("Your duties have been successfully saved to the database");
		
	}
	
	public ArrayList <String> getJobDuties()
	{
		return this.jduties;
	}
	
	public String getJtitle() {
		return jtitle;
	}
	public void setJtitle(String jtitle) {
		this.jtitle = jtitle;
	}
	public String getJcompany() {
		return jcompany;
	}
	public void setJcompany(String jcompany) {
		this.jcompany = jcompany;
	}
	public LocalDateTime getSdate() {
		return sdate;
	}
	public void setSdate(LocalDateTime sdate) {
		this.sdate = sdate;
	}
	public LocalDateTime getEdate() {
		return edate;
	}
	public void setEdate(LocalDateTime edate) {
		this.edate = edate;
	}
	public void addJobtoDB(int personID)
	{
		PreparedStatement stmt=null;
		String jDutiesList = null; 
		String insertJobSQL = "insert into jobtable(jobtitle,company,personid) values(?,?,?)";
		String getCurrentJobID = "select id from jobtable where company=? and jobtitle =? and personid = ? ";
		
		ResultSet rs = null; 
		
		for(String aDuty:this.jduties)
		{
			jDutiesList+=aDuty;
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
	        java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/resumeapp?"+ "user=root&password=passw0rd");
			stmt = con.prepareStatement(insertJobSQL);
			stmt.setString(1,this.jtitle);
			stmt.setString(2,this.jcompany);
			stmt.setInt(3,personID);
			stmt.executeUpdate();
			
			stmt = con.prepareStatement(getCurrentJobID);
			stmt.setString(1,this.getJcompany());
			stmt.setString(2,this.getJtitle());
			stmt.setInt(3, personID);
			rs = stmt.executeQuery();
			rs.next();
			this.setJobID(rs.getInt("id"));			
		}
		catch(Exception e)
		{
			
		}
		finally{
			
		}
		
		System.out.println("Your job and duties successfully saved to the database");

		
	}

	public int getJobID() {
		return jobID;
	}

	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	
}

package resumepackage;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Person {
	private int personid; 
	private String fname;
	private String lname;
	private String email;
	private ArrayList <Job> myjoblist; 
	private ArrayList <Education> myedulist; 
	private ArrayList <Skills> myskilllist;
	
	public Person(String pfname, String plname, String pemail) {	
		this.fname = pfname; 
		this.lname = plname; 
		this.email = pemail; 
		myjoblist = new ArrayList <Job>(); 
		myedulist = new ArrayList<Education>(); 
		myskilllist = new ArrayList<Skills>();
	}
	
	public void addMe()
	{
		//DO THIS WITH YOUR DATABASE UTILITY!!! 
		
		java.sql.Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int personID;		
		String insertsql;
		String getIDSQL; 
		
		
		insertsql = "insert into persontable(email,fname,lname) values(?,?,?)";
		getIDSQL = "select id from persontable where email = ?";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/resumeapp?"+ "user=root&password=passw0rd");
			stmt = con.prepareStatement(insertsql);
            stmt.setString(2,this.fname);
			stmt.setString(3,this.lname);
			stmt.setString(1,this.email);
			stmt.executeUpdate();
			
			stmt = con.prepareStatement(getIDSQL);
			stmt.setString(1,this.email);	
			rs = stmt.executeQuery();
			rs.next(); 
			
			this.setPersonid(rs.getInt("id"));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
		}
			System.out.println("You have saved your data to the database"); 
		
	}

	public int getPersonid() {
		return personid;
	}

	public void setPersonid(int personid) {
		this.personid = personid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addJob(Job jobtoadd){
		myjoblist.add(jobtoadd);
		
	}
	
	public void addEducation(Education e){
		
		myedulist.add(e);
	}
	public void addSkill(Skills sk){
		myskilllist.add(sk);
	}
	
	public void listMyJobs(){

		for(Job job : myjoblist){
			
			System.out.println(job.getJobID());
			System.out.println(job.getJcompany());
			System.out.println(job.getJtitle());
			for(String duty : job.getJobDuties())
			{
				System.out.println(duty);
			}
		}
		
	}
	
	public void printEducation(){
		
		for(Education edu: myedulist){
			
			System.out.println(edu.getEduId());
			System.out.println(edu.getDegree());
			System.out.println(edu.getInstitute());
			System.out.println(edu.getYear());
			
		}
	}
	
	public void printSkills(){
		for(Skills sk: myskilllist){
			System.out.println(sk.getSkillId());
			System.out.println(sk.getSkill());
			System.out.println(sk.getProficiency());
		}
	}
}


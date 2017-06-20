
package resumepackage;

public class ResumeAppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//Instantiate a person with details of the person's details - first & last name, e-mail
		
		
		//Initilise variables to be used in this method
		
		int thisPersonID; 
		
		Person me = new Person("Mateus","Cocco","mcocco@montgomerycollege.edu");
		me.addMe();
		thisPersonID = me.getPersonid();
		System.out.println("Your full name name is: "+me.getFname()+" "+me.getLname()+" and your e-mail address is "+me.getEmail());
		System.out.println(me.getFname()+"'s user id is:"+me.getPersonid());
		
		//Create a new job 
		Job job1 = new Job(); 
		job1.setJcompany("Another College");
		job1.setJtitle("Doer of even more stuff");
		job1.addJobtoDB(me.getPersonid());
		job1.addDuty("Got 100% more of nothing done than colleagues",me.getPersonid());

		me.addJob(job1);
		
		Job job2 = new Job(); 
		job2.setJcompany("Montgomery College");
		job2.setJtitle("Doer of stuff");
		job2.addJobtoDB(me.getPersonid());
		job2.addDuty("Was responsible for doing stuff",me.getPersonid());
		job2.addDuty("Got 100% more of nothign done than colleagues",me.getPersonid());
		job2.addDuty("Set a record for something",me.getPersonid());
		me.addJob(job2);
			
		System.out.println("Name:"+me.getFname()+" "+me.getLname());
		System.out.println("Email:"+me.getEmail());
		System.out.println("\nJob:");
		me.listMyJobs();
		
		Education ed1 = new Education();
		ed1.setDegree("Bsc in Computer Science");
		ed1.setInstitute("AAU");
		ed1.setYear(2011);
		ed1.addEduToDB(thisPersonID);
		me.addEducation(ed1);
		me.printEducation();
		
		Skills sk = new Skills();
		sk.setSkill("Java");
		sk.setProficiency(7);
		sk.addSkill(thisPersonID);
		me.addSkill(sk);
		me.printSkills();
	
	}

}
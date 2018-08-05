package ccc;

public class job {


	private String jobname;
	private String salary;
private String requir;
private String jobdes;
	private String publishtime;
	public job( String jobname, String salary,String requir,String jobdes,String publishtime) {
	this.jobname=jobname;
	this.salary=salary;
	this.requir=requir;
	this.jobdes=jobdes;
	this.publishtime=publishtime;
	}
	
	
	public String getjobname() {
		return jobname;
	}


	public String getsalary() {
		return salary;
	}


	public String getrequir() {
		return requir;
	}
	
	public String getjobdes() {
		return jobdes;
	}
	
	public String getpublishtime (){
		
		return publishtime;
		
	}

	
	
	
}

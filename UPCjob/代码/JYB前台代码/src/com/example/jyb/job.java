package com.example.jyb;

public class job {


	public String jobname;
	public String salary;
	public String requir;
	public String jobdes;
	public String publishtime;
	public String addr;
	public String company;
	public String hangye;
	public String numb;
	public String guimo;
	public String xingzhi;
	public job( String jobname, String salary,String requir,String jobdes,String publishtime,String addr, String company,String hangye,String numb,String guimo,String xingzhi) {
	this.jobname=jobname;
	this.salary=salary;
	this.requir=requir;
	this.jobdes=jobdes;
	this.publishtime=publishtime;
	this.addr=addr;
	this.company=company;
	this.hangye=hangye;
	this.numb=numb;
	this.guimo=guimo;
	this.xingzhi=xingzhi;
	}
	
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

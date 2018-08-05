package ccc;

import java.sql.Date;

public class person 
{
	 private String username;  
	 private String studentnumber;  
	 private String grade;  
	 private String major;   
	 private String password;  
	  
	    public person() 
	    {  
	        super();  
	    }  
	  
	    public person(String name, String studentnum, String grade,String major,String password) {  
	        super();  
	        this.username = name;  
	        this.studentnumber = studentnum;  
	        this.grade=grade; 
	        this.major=major;
	        this.password =password;
	        
	    }  
	  
	    public String getName() {  
	        return username;  
	    }  
	  
	    public void setName(String name) {  
	        this.username = name;  
	    }  
	  
	    public String getStudentnumber() {  
	        return studentnumber;  
	    }  
	  
	    public void setStudentnumber(String studentnum) {  
	        this.studentnumber=studentnum;  
	    }  
	  
	    public String getGrade() {  
	        return grade;  
	    }  
	  
	    public void setGrade(String grade) {  
	        this.grade=grade;  
	    }  
	    public String getMajor() {  
	        return major;  
	    }  
	  
	    public void setMajor(String major) {  
	        this.major=major;  
	    }  
	   
	    public String getPassword() {  
	        return password;  
	    }  
	  
	    public void setPassword(String password) {  
	        this.password=password;  
	    }  
	    
	    public String toString() {  
	        return "Person [name=" + username + ", studentnumber=" + studentnumber+ ", grade=" + grade  
	                + ",major=" + major + ",password=" + password + "]";  
	    }  
	      
	      
	  
	}  




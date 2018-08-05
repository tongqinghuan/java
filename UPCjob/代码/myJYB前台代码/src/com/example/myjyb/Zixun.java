package com.example.myjyb;

public class Zixun {
	private String title;
	private String type;
    private String pub_time;
	private String content;
	public Zixun( String title, String type,String pub_time,String content) {
	this.title=title;
	this.type=type;
	this.pub_time=pub_time;
	this.content=content;
	}
	
	
	public String getTitle() {
		return title;
	}


	public String getType() {
		return type;
	}
	
	
	public String getContent (){
		
		return content;
		
	}
public String getPub_time (){
		
		return pub_time;
		
	}

	
	
}

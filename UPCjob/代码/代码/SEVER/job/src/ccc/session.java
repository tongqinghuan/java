package ccc;


public class session {
	private Integer userid;
	private String title;
private String user;
private String value;
	private String tell;
	public session( String title, String user,String value,String tell) {
	
		this.title = title;
		this.user = user;
		this.value=value;
		this.tell=tell;
	}
	public Integer getId() {
		return userid;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getuser() {
		return user;
	}
	public void setuser(String user) {
		this.user = user;
	}
	public String getvalue() {
		return value;
	}
	public void setvalue(String value) {
		this.value = value;
	}
	public String getell() {
		return tell;
	}
	public void settell(String tell) {
		this.tell = tell;
	}
}

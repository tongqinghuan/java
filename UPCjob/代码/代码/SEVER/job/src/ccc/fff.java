package ccc;
import java.sql.ResultSet;
public class fff {
	public static void main(String args[])
	{
	DBConnection db=new DBConnection();
	
	ResultSet bl=db.executeQuery("SELECT*FROM campus_talk");
	try
	{
	if(bl.next())
	{
       
		System.out.println(bl.getInt("campus_talkID"));
	}
	}
	catch(Exception e)
	{

		
	}
	
	}

}

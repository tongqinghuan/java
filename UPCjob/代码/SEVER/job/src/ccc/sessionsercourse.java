package ccc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class sessionsercourse {
	public List<session> gettoptensession(String  kind){
		int i=0;
		ArrayList value=new ArrayList ();
		ArrayList userid =new ArrayList ();
		ArrayList user =new ArrayList ();
		ArrayList title =new ArrayList ();
		ArrayList tell =new ArrayList ();
		String  sql ="SELECT * FROM detail where kind='"+kind+"'";
		DBConnection db=new DBConnection ();
		ResultSet rs= db.executeQuery(sql);
		try {
		while (rs.next()){
			String tempvalue=rs.getString("value");
			
			String tempuser=rs.getString("user");
			String temptitle=rs.getString("title");
			String temptell=rs.getString("tell");
				value.add(tempvalue);
				
				user.add(tempuser);
				title.add(temptitle);
				tell.add(temptell);
			
			
			
		}
		}catch (Exception e){
			
			System.out.println("数据库出错"+e.getMessage());
			
		}
	
		
		List<session> session = new ArrayList<session>();
		for (int k=0;k<value.size();k++)
			session.add(new session(title.get(k).toString(),user.get(k).toString(),value.get(k).toString(),tell.get(k).toString()));
		
		return session;
	}
}

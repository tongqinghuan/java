package ccc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class XuanjService implements XuanjiangService {
	ArrayList title=new ArrayList ();
	ArrayList time =new ArrayList ();
	ArrayList place =new ArrayList ();
	ArrayList pub_time =new ArrayList ();
	ArrayList content =new ArrayList ();
	public List<Xuanj> getLastNews() {
		DBConnection db=new DBConnection ();
		String  sql;
		sql="select * from xuanjiang";   
        System.out.println("sql 语句"+sql);
		ResultSet rs1=new DBConnection ().executeQuery(sql);
		try{
		while (rs1.next()){
			title.add(rs1.getString("title"));
			time.add(rs1.getString("time"));
			place.add(rs1.getString("place"));
			pub_time.add(rs1.getString("pub_time"));
			content.add(rs1.getString("content"));
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

}

package StaticProxy;

public class Student implements Person {
    String name;
    public Student(String name) {
    	this.name=name;
    }
	public void giveMoney() {
		// TODO Auto-generated method stub
	   System.out.println(name + "�Ͻ����50Ԫ");
	}
	
	

}

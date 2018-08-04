package StaticProxy;

public class StudentProxy implements Person{
	Student stu;
	public StudentProxy(Person stu) {
		if(stu.getClass() == Student.class) {
            this.stu = (Student)stu;
        }
		
	}
	public void giveMoney() {
		stu.giveMoney();
		
	}

}

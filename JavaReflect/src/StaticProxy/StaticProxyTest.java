package StaticProxy;

public class StaticProxyTest {
	 public static void main(String[] args) {
	        //�������ѧ�����������İ���Ͻ��д������monitor���೤�����
	        Person zhangsan = new Student("����");
	        
	        //���ɴ�����󣬲������������������
	        Person monitor = new StudentProxy(zhangsan);
	        
	        //�೤�����Ͻ����
	        monitor.giveMoney();
	    }
}

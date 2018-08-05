package Tyepinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class TypeTest {
	public static void main(String[] args) {
		Class<?> cl = null;
		
		try {
			 cl=Class.forName("Tyepinfo.Triangle");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取类所实现的所有接口
		Class<?>[] interfaces=cl.getInterfaces();
		for(Class<?> cla:interfaces) {
			System.out.println(cla.getName());
		}
		//获取类中申明的所有方法，但不包括构造方法
		Method[] methods=cl.getDeclaredMethods();
		for(Method m : methods) {
            System.out.println(m);
        }
		//获取类中公有方法
		Method[] methods_public =cl.getMethods();
		for(Method m : methods_public) {
            System.out.println(m);
            m.invoke(obj, args);
        }
		Constructor<?>[] publicConstructors = cl.getConstructors();
        for(Constructor<?> c : publicConstructors) {
            System.out.println(c);
        }
        Field[] fields = cl.getDeclaredFields();
        for(Field field : fields) {
            System.out.println("filed"+field);
        }

	}

}

package Tyepinfo;

public class Triangle implements Shape{
	    String point1;
	    String point2;
	    String point3;
	    public Triangle() {
	    	
	    }
	    public Triangle(String point1,String point2,String point3) {
	    	this.point1=point1;
	    	this.point2=point2;
	    	this.point3=point3;
	    }
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("drawing triangle");
		
	}

	@Override
	public void area() {
		// TODO Auto-generated method stub
		System.out.println("calculate area of triangle");
		
	}

	@Override
	public void length() {
		// TODO Auto-generated method stub
		System.out.println("calculate length of triangle");
		
	}
	private void getName() {
		System.out.println("get name of triangle");
	}
	protected void getShapeType() {
		System.out.println("return shape type");
	}

}

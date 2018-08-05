
public class cal_energy {
	public  final static double BASE=9;
	public final static double base=1;
	public final static double mid_base=5;
    public static double nomal_energy;
    public static double neergy_less;
    public static double calnormal_energy()
    {

    	nomal_energy=12*BASE+40*base+8*mid_base;
    	System.out.println(String.valueOf(nomal_energy));
    	return nomal_energy;
    }
    public static double calenergy_less()
    {
    	CountPort.calport();
    	neergy_less=CountPortNum.sum*base+Routing.host_number *mid_base+CountPortNum.mac_count*BASE;
    	System.out.println(String.valueOf(CountPortNum.mac_count));
    	System.out.println(String.valueOf(CountPortNum.sum));
    	System.out.println(String.valueOf(neergy_less));
    	return neergy_less;
    	
    }
    
	

}

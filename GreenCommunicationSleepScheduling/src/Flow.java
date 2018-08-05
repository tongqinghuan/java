
public class Flow {
	public String  name, priority, cookie, idleTimeOut, hardTimeOut,  sw,
	active;
	public String IngressPort,Ethersource,Etherdst,Ethertype,VLANid,VLANpriority,IPsrc,IPdst,IPproto,IPtos,srcport,dstport;
	public String actions;
	public String serialize() {
		String serial = "{";

		if (this.name != null&&!this.name.equals("")) {
			if (serial.length() > 15)
				serial = serial.concat(", ");
			serial = serial.concat("\"name\":\"" + this.name + "\"");
		}
		
		if (this.priority!= null&&!priority.equals("")) {
			if (serial.length() > 15)
				serial = serial.concat(", ");
			serial = serial.concat("\"priority\":\"" + this.priority + "\"");
		}
		if (this.cookie!= null&&!cookie.equals("")) {
			if (serial.length() > 15)
			serial = serial.concat(", ");
			serial = serial.concat("\"cookie\":\"" + this.cookie + "\"");
		}
		if (this.idleTimeOut!= null) {
			if (serial.length() > 15)
			serial = serial.concat(", ");
			serial = serial.concat("\"idle_timeout\":\"" + idleTimeOut + "\"");
		}
		if (this.hardTimeOut!= null) {
			if (serial.length() > 15)
			serial = serial.concat(", ");
			serial = serial.concat("\"hard_timeout\":\"" + hardTimeOut + "\"");
		}
		if (this.sw!= null) {
			if (serial.length() > 15)
			serial = serial.concat(", ");
			serial = serial.concat("\"switch\":\"" +sw + "\"");
		}
		
		
		if (this.Ethersource!= null&&!Ethersource.equals("")) {
			if (serial.length() > 15)
			serial = serial.concat(", ");
			serial = serial.concat("\"eth_src\":\"" + Ethersource + "\"");
			
		}
		if (this.Etherdst != null&&!Etherdst.equals("")) {
			if (serial.length() > 15)
				serial = serial.concat(", ");
				serial = serial.concat("\"eth_dst\":\"" + Etherdst + "\"");
			
		}
		if (this.Ethertype != null&&!Ethertype.equals("")) {
			if (serial.length() > 15)
				serial = serial.concat(", ");
				serial = serial.concat("\"eth_type\":\"" + Ethertype  + "\"");
			
		}
		if (this.VLANid != null&&!VLANid.equals("")) {
			if (serial.length() > 15)
				serial = serial.concat(", ");
				serial = serial.concat("\"eth_vlan_vid\":\"" + VLANid  + "\"");
			
		}
	
		if (this.VLANpriority != null&&!VLANpriority.equals("")) {
			if (serial.length() > 15)
				serial = serial.concat(", ");
				serial = serial.concat("\"eth_vlan_pcp\":\"" + VLANpriority + "\"");
			
		}
		if (this.IngressPort!= null&&!IngressPort.equals("")) {
			if (serial.length() > 15)
				serial = serial.concat(", ");
				serial = serial.concat("\"in_port\":\"" + IngressPort + "\"");
			
		}
		if (this.IPdst != null&&!this.IPdst.equals("")) {
			if (serial.length() > 15)
				serial = serial.concat(", ");
				serial = serial.concat("\"ipv4_dst\":\"" + IPdst + "\"");
			
		}
		if (this.IPsrc != null&&!this.IPsrc.equals("")) {
			if (serial.length() > 15)
				serial = serial.concat(", ");
				serial = serial.concat("\"ipv4_src\":\"" + IPsrc  + "\"");
			
		}
		if (this.IPtos!= null&&!this.IPtos.equals("")) {
			if (serial.length() > 15)
				serial = serial.concat(", ");
				serial = serial.concat("\"ip_tos\":\"" + IPtos + "\"");
			
		}
		if (this.dstport != null&&!this.dstport.equals("")) {
			if (serial.length() > 15)
				serial = serial.concat(", ");
				serial = serial.concat("\"tp_dst\":\"" + dstport + "\"");
			
		}
		if (this.srcport != null&&!this.srcport.equals("")) {
			if (serial.length() > 15)
				serial = serial.concat(", ");
				serial = serial.concat("\"tp_src\":\"" + srcport + "\"");
			
		}
		if (this.actions != null&&!this.actions.equals("")) {
			if (serial.length() > 15)
				serial = serial.concat(", ");
				serial = serial.concat("\"actions\":\"" + actions + "\"");
		}
		if (this.active!= null&&!this.active.equals("")) {
			if (serial.length() > 15)
				serial = serial.concat(", ");
				serial = serial.concat("\"active\":\"" + active + "\"");
		}
		serial = serial.concat("}");
		System.out.println(serial);
		return serial;
	}
	
	public String deleteString() {
		return "{\"name\":\"" + name + "\"}";
	}
}




public class NodePortTuple {
	    protected String nodeId; // switch DPID
	    protected String src_portId; // switch port id
	    protected String dst_portId;
	    /**
	     * Creates a NodePortTuple
	     * @param nodeId The DPID of the switch
	     * @param portId The port of the switch
	     */
	    public NodePortTuple()
	    {

	    	
	    }
	    public NodePortTuple(String nodeId, String src_portId,String dst_portId) {
	        this.nodeId = nodeId;
	        this.src_portId = src_portId;
	        this.dst_portId=dst_portId;
	    }

	   
	    public String toString() {
	        return "{\"nodeId\":\""+nodeId+"\",\"src_portId\":"+src_portId+",\"dst_portId\":"+dst_portId+"}";
	    }


}

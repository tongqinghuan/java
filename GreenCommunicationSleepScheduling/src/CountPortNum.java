/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author aqua
 */
public class CountPortNum {
    //public static ArrayList<NodePortTuple> route = new ArrayList<NodePortTuple>(50);
    final int MAX_LINK_NUM = 30;
    LinkCount[] link_list = new LinkCount[MAX_LINK_NUM];
    
    public static int mac_count = 0;
    public static int sum=0;
    
    public void initialroute()
    {
        for(int intital_link_array_i = 0;intital_link_array_i<MAX_LINK_NUM;intital_link_array_i++)
        {
            link_list[intital_link_array_i] = new LinkCount();
        }
        NodePortTuple[] tempTuple = new NodePortTuple[MAX_LINK_NUM];
        for(int initial_tuple_i=0;initial_tuple_i<MAX_LINK_NUM;initial_tuple_i++)
        {
            tempTuple[initial_tuple_i] = new NodePortTuple();
        }
        
        
    }
    
    public void countPortNum()
    {
        System.out.println("Hello, this is countPortNum()");
        
        System.out.println("the value of route.size is "+Routing.route.size());
outterLoop:      
        for(int route_i=0; route_i< Routing.route.size() ;route_i++)
        {            
            LinkCount link_temp = new LinkCount();
            NodePortTuple temp_tuple = new NodePortTuple();
            temp_tuple = Routing.route.get(route_i);
            if(mac_count == 0 && !Routing.route.isEmpty())
            {                
                link_list[mac_count].mac_add = temp_tuple.nodeId;
                link_list[mac_count].port_id[link_list[mac_count].port_num] = Integer.parseInt(temp_tuple.dst_portId);
                link_list[mac_count].port_num++;
                link_list[mac_count].port_id[link_list[mac_count].port_num] = Integer.parseInt(temp_tuple.src_portId);
                link_list[mac_count].port_num++;

                System.out.println("the first mac address is "+link_list[mac_count].mac_add);
                System.out.println("the first two port num is "+ link_list[mac_count].port_id[0]+" and "+link_list[mac_count].port_id[1]);
                mac_count ++;                
                continue;
            }
            
            link_temp.mac_add = temp_tuple.nodeId;
            System.out.println("current mac count is "+mac_count);
            for(int count_mac_i = 0; count_mac_i<mac_count; count_mac_i++)
            {
                if(link_temp.mac_add.equals(link_list[count_mac_i].mac_add))
                {
                    int pre_portid;
                    pre_portid = Integer.parseInt(temp_tuple.src_portId);
                    for(int find_port_i = 0;find_port_i<link_list[count_mac_i].port_num;find_port_i++)
                    {
                        //循环寻找当前端口号是否已在对应mac地址的指定的LinkCount数据中出现
                        if(pre_portid == link_list[count_mac_i].port_id[find_port_i])
                        {
                            //找到mac地址且端口号已被保存，则直接跳出本次循环。
                            System.out.println("current mac add is "+ link_temp.mac_add);
                            continue outterLoop;
                        }
                    }
                    //找到mac地址但未找到端口号，人工添加新的端口号
                    link_list[count_mac_i].port_id[link_list[0].port_num] = Integer.parseInt(temp_tuple.dst_portId);
                    link_list[count_mac_i].port_num++;
                    link_list[count_mac_i].port_id[link_list[0].port_num] = Integer.parseInt(temp_tuple.src_portId);
                    link_list[count_mac_i].port_num++;
                    System.out.println("mac address is "+ link_list[count_mac_i].mac_add+ " and the port num is "+ link_list[count_mac_i].port_num);
                    continue outterLoop;
                }               
                
            }
            //连mac地址都没找到，则人工添加新的端口号
            {
                link_list[mac_count].mac_add = temp_tuple.nodeId;
                link_list[mac_count].port_id[link_list[mac_count].port_num] = Integer.parseInt(temp_tuple.dst_portId);
                link_list[mac_count].port_num++;
                link_list[mac_count].port_id[link_list[mac_count].port_num] = Integer.parseInt(temp_tuple.src_portId);
                link_list[mac_count].port_num++;
                mac_count ++;
                    
            }
            
        }
    }
    
    public void doCountPortNum()
    {
        for(int i=0;i<mac_count;i++)
        {
            sum = sum + link_list[i].port_num; 
        }
        System.out.println("the total port num is "+ sum);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author aqua
 */
public class LinkCount {
    String mac_add;
    int[] port_id = new int[10];
    int port_num;
    
    
    LinkCount()
    {
        for(int i=0;i<10;i++)
        {
            port_id[i] = 0;
        }
        port_num = 0;
        mac_add = "00000";
    }
    
}

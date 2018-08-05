/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class EnergySavingPath {
    
    final static int  MAX_POTENTIAL_PATH_NUM = 5;
    int current_link_num;
    CNode nodes = new CNode();
    // 规则2，跳数最少，本题中已满足，因此省略
    int[] current_link_record = new int[MAX_POTENTIAL_PATH_NUM];
    int thechosenPath;
    public static int[] finalRouter = new int[CNode.NODE_NUMBER];
    public static int finalRouterSize = 0;
    EnergySavingPath()
    {
        thechosenPath = 0;
        for(int i=0;i<MAX_POTENTIAL_PATH_NUM;i++)
        {
            current_link_record[i] = 0;
        }
    }
    
    public static String convertToDeviceID(int id)
    {
    	String idstr = "";
    	switch (id) {
		case 0:
			idstr = "00:00:00:00:00:00:00:01";
			break;
		case 1:
			idstr = "00:00:00:00:00:00:00:02";
			break;
		case 2:
			idstr = "00:00:00:00:00:00:00:03";
			break;
		case 3:
			idstr = "00:00:00:00:00:00:00:04";
			break;
		case 4:
			idstr = "00:00:00:00:00:00:00:05";
			break;
		case 5:
			idstr = "00:00:00:00:00:00:00:06";
			break;
		case 6:
			idstr = "00:00:00:00:00:00:00:07";
			break;
		case 7:
			idstr = "00:00:00:00:00:00:00:08";
			break;
		case 8:
			idstr = "00:00:00:00:00:00:00:09";
			break;
		case 9:
			idstr = "00:00:00:00:00:00:00:0a";
			break;
		case 10:
			idstr = "00:00:00:00:00:00:00:0b";
			break;
		case 11:
			idstr = "00:00:00:00:00:00:00:0c";
			break;
		case 12:
			//idstr = "0.0.0.0";
			idstr = "10.0.0.1";
			break;
		case 13:
			idstr = "10.0.0.2";
			break;
		case 14:
			idstr = "10.0.0.3";
			break;
		case 15:
			idstr = "10.0.0.4";
			break;
		case 16:
			idstr = "10.0.0.5";
			break;
		case 17:
			idstr = "10.0.0.6";
			break;
		case 18:
			idstr = "10.0.0.7";
			break;
		case 19:
			//idstr = "10.0.0.8";
			idstr = "0.0.0.0";
			break;
		default:
			break;
		}
    	return idstr;
    }


    
    void getAllLinkInfo(int start, int ends)
{
	//start=12,ends=17;
	nodes.setStartAndEnds(start,ends);
	nodes.doFindPaths();
	String str;
	int count;
	count = nodes.pathsNum[0];
//	str.Format(_T("%d"),count);
//	AfxMessageBox(str);
	nodes.recordUsedLinks();
	nodes.getLinkUtilizationRate(0);
	current_link_num = nodes.simppathsNum;

	for (int i=0;i<current_link_num;i++)
	{
		current_link_record[i] = 1;
	}

}
    
    
    void roleOne_MaxUtilization()
{
	int[] link_utilization = new int[MAX_POTENTIAL_PATH_NUM];
        for(int i=0;i<MAX_POTENTIAL_PATH_NUM;i++)
        {
            link_utilization[i] = 0;
        }
	int max_utilization = 0;
	if (current_link_num == 0)
	{
		System.exit(989);
	}
	if (current_link_num == 1)
	{
		return;
	}
	for (int i=0;i<current_link_num;i++)
	{
		int link_num;
		link_num = nodes.getLinkUtilizationRate(i);	
		link_utilization[i] = nodes.getLinkBandwidth(link_num)/nodes.getLinkLoadNum(link_num);

		String str = "";
//		str.Format(_T("current link utilization is %d"),link_utilization[i]);
//		AfxMessageBox(str);
		if (link_utilization[i] > max_utilization)
		{
			max_utilization = link_utilization[i];
		}
	}

	int temp_current_link_num = 0;
	for (int i=0;i<MAX_POTENTIAL_PATH_NUM;i++)
	{
		if (link_utilization[i] < max_utilization)
		{
			current_link_record[i] = 0;
		}
		else if (link_utilization[i] == max_utilization)
		{
			current_link_record[i] = 1;
			temp_current_link_num++;
		}
		else if (link_utilization[i] > max_utilization)
		{
			System.exit(988);
		}
	}
	current_link_num = temp_current_link_num;
	String str_t = "";
//	str.Format(_T("the number of link left is %d"),current_link_num);
//	AfxMessageBox(str);
}
    void roleTwo_LeastTTL()
{
}
    
    
    void roleThree_MaxIncludedPath()
{

	int[] link_path_included = new int[MAX_POTENTIAL_PATH_NUM];
        for(int i=0;i<MAX_POTENTIAL_PATH_NUM;i++)
        {
            link_path_included[i] = 0;
        }
	int max_path_included=0;
	if (current_link_num == 0)
	{
		System.exit(987);
	}
	if (current_link_num == 1)
	{
                String str;
                str = "there is only one link left in role two";
                System.out.println(str);
		return;
	}
        String str_t = "the num of link left is " + current_link_num;
        System.out.println(str_t);
	for (int i=0;i<MAX_POTENTIAL_PATH_NUM;i++)
	{
		if (current_link_record[i] == 0)
		{
			continue;
		}
                showPathRoute(i);
		link_path_included[i] = nodes.getLinkPathIncluded(i);
		String str = "";
//		str.Format(_T("the path included is %d"),link_path_included[i]);
//		AfxMessageBox(str);
		if (link_path_included[i] > max_path_included)
		{
			max_path_included = link_path_included[i];
		}
	}
	int temp_current_link_num = 0;
	for (int i=0;i<MAX_POTENTIAL_PATH_NUM;i++)
	{
		if (link_path_included[i] < max_path_included)
		{
			current_link_record[i] = 0;
		}
		else if (max_path_included == link_path_included[i])
		{
			temp_current_link_num++;
			current_link_record[i] = 1;
		}
		else if (max_path_included < link_path_included[i])
		{
			System.exit(986);
		}
	}
	current_link_num = temp_current_link_num;
	String str = "";
//	str.Format(_T("the number of path included left is %d"),current_link_num);
//	AfxMessageBox(str);
}
    
    
    void roleFour_UniquePath()
{
	if (current_link_num == 0)
	{
		System.exit(969);
	}
	if (current_link_num == 1)
	{
		String str = "there is only one link left in role three";
                System.out.println(str);
	}
	for (int i=0;i<MAX_POTENTIAL_PATH_NUM;i++)
	{
		if (current_link_record[i] !=1)
		{
			continue;
		}
		thechosenPath = i;
		String str;
                str = "the final chosen pathID is " + thechosenPath;
		System.out.println(str);
		break;
	}
}

    
    void showThechosenPath()
{
	int link_length;
	link_length = nodes.link_record[thechosenPath].size;
	
	String str = "",str1;
	for (int i=0;i<link_length;i++)
	{
            str1 = nodes.link_record[thechosenPath].linksID[i] + "->";		
            str = str+str1;
	}
        System.out.println(str);
}
    void showPathRoute(int route_id)
{
	int link_length;
	link_length = nodes.link_record[route_id].size;
	
	String str = "",str1;
	for (int i=0;i<link_length;i++)
	{
            str1 = nodes.link_record[route_id].linksID[i] + "->";		
            str = str+str1;
	}
        System.out.println(str);
}
    
    void getFinalRouter()
    {
        int router_length = nodes.link_record[thechosenPath].size;
        int linkID = nodes.link_record[thechosenPath].linksID[0];
        if(nodes.links[linkID].pre_node_id > 11 && nodes.links[linkID].pre_node_id < 20)
        {
            finalRouter[0] = nodes.links[linkID].pre_node_id;
        }
        else
        {
            finalRouter[0] = nodes.links[linkID].aft_node_id;                  
        }
        for(int i=0;i<router_length;i++)
        {
            linkID = nodes.link_record[thechosenPath].linksID[i];
            if( nodes.links[linkID].pre_node_id == finalRouter[i])
            {
                finalRouter[i+1] = nodes.links[linkID].aft_node_id;
            }
            else
            {
                finalRouter[i+1] = nodes.links[linkID].pre_node_id;
            }
        }
        
        finalRouterSize = router_length + 1;
        System.out.println("the number of router is " + finalRouterSize);
        for(int i=0;i<finalRouterSize;i++)
        {
            System.out.print(finalRouter[i] + "->");
        }
        System.out.println();
    }
    public static String  showpath()
    {
    	String str="";
    	for(int i=0;i<finalRouterSize;i++)
    	{
    		if(i!=finalRouterSize-1)
           str=str+String.valueOf(finalRouter[i])+"->";
    		else
    		{
    			str=str+String.valueOf(finalRouter[i]);
    			
    		}
    		
    	}
    	return str;
    }
}

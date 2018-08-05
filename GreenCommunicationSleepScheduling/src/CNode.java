/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class CNode {

    /**
     * @param args the command line arguments
     */
    final static int NODE_NUMBER = 20;
    node[] nodes;
    
    final static int MAX_LINK_NUM = NODE_NUMBER*NODE_NUMBER;
    link[] links;
    
    final static int NOTLINK = 0;
    final static int ISLINK = 1;
    final static int REACHABLE = 1;
    final static int LINK_NUM = 7;
    
    LinkRecord[] link_record ;
    Path[] paths ;
    Path[] simppaths ;
   // public static int  PathsNum;
    int map[][];
    
    int[][] adjacency_matrix ;
    int[] pathsNum ;
    int simppathsNum = 0;
    int start;
    int ends;

    
    public static void get_path(int start,int end) {
        // TODO code application logic here
        
        CNode s1 = new CNode(); 
        s1.doFindPaths();
        EnergySavingPath energySavingPaths = new EnergySavingPath();
        
        energySavingPaths.getAllLinkInfo(start,end);
	energySavingPaths.roleOne_MaxUtilization();
	energySavingPaths.roleTwo_LeastTTL();
	energySavingPaths.roleThree_MaxIncludedPath();
	energySavingPaths.roleFour_UniquePath();
	energySavingPaths.nodes.pathsNum[0] = 0;
	energySavingPaths.nodes.simppathsNum = 0;
        
	int change_path_id = energySavingPaths.thechosenPath;
	for (int i=0;i<energySavingPaths.nodes.link_record[change_path_id].size;i++)
	{
		int linkID = energySavingPaths.nodes.link_record[change_path_id].linksID[i];
		energySavingPaths.nodes.links[linkID].load_num++;
	}
/*        for(int i=0;i<20;i++)
        {
            int load = energySavingPaths.nodes.links[i].load_num;
            System.out.println("the link "+ i +"'s load num is " + load);
        }*/
	energySavingPaths.showThechosenPath();
        
        energySavingPaths.getFinalRouter();
        
        System.out.println();
        System.out.println("=========================");
        System.out.println();
    
    }
  
    CNode()
    {
        nodes = new node[NODE_NUMBER];
        for (int i=0; i < nodes.length; i++)
            nodes[i] = new node();      
        links = new link[MAX_LINK_NUM];
        for (int i=0; i < links.length; i++)
            links[i] = new link();
        link_record = new LinkRecord[4];
        for (int i=0; i < link_record.length;i++)
            link_record[i] = new LinkRecord();
        paths = new Path[1000];
        for (int i = 0; i < paths.length; i++)
            paths[i] = new Path();
        simppaths =  new Path[1000];
        for (int i = 0; i < simppaths.length; i++)
            simppaths[i] = new Path();
        map=  new int[1000][1000];
        adjacency_matrix = new int[NODE_NUMBER][NODE_NUMBER] ;
        pathsNum = new int[10];
        pathsNum[0] = 0;
      //  start = 12;
      //  ends = 17;
        simppathsNum = 0;
        for(int i=0;i<MAX_LINK_NUM;i++)
        {
            links[i].bandwidth = 1000;  //初始化带宽为1000M       
            links[i].load_num = 1;      //初始化流数量均为1，防止出现除零错误
        }
    }
    
    
    //初始化邻接矩阵
     void initialMatrix()
{
//	CString str;
//	str = "Initial Matrix start";
//	AfxMessageBox(str);
	for (int i=0;i<NODE_NUMBER;i++)
	{
		for(int j=0;j<NODE_NUMBER;j++)
			adjacency_matrix[i][j] = NOTLINK;
	}
	for(int i=0;i<MAX_LINK_NUM;i++)
	{
		links[i].aft_node_id=0;
		links[i].pre_node_id=0;
	}
//	str = "Initial Matrix success";
//	AfxMessageBox(str);
}
    
     //初始化各个数据结构
     void updateMatrix()
{
	for(int i=0;i<MAX_LINK_NUM;i++)
	{
//		CString str;
//		str.Format(_T("the,no.%d links,%d,%d"),i,links[i].pre_node_id,links[i].aft_node_id);
//		AfxMessageBox(str);
		if (links[i].pre_node_id == 0 && links[i].aft_node_id == 0)
                {
                }
		else if (links[i].pre_node_id != 0 || links[i].aft_node_id != 0)
		{
			adjacency_matrix[links[i].pre_node_id][links[i].aft_node_id] = ISLINK;
			adjacency_matrix[links[i].aft_node_id][links[i].pre_node_id] = ISLINK;
		}
      //          System.out.print("result:adjacency_matrix["+links[i].pre_node_id+"]["+links[i].aft_node_id+"] = "+adjacency_matrix[links[i].pre_node_id][links[i].aft_node_id]);
//		str.Format(_T("result:adjacency_matrix[%d][%d] = %d"),links->pre_node_id,links->aft_node_id,adjacency_matrix[links->pre_node_id][links->aft_node_id]);
//		AfxMessageBox(str);
		//else exit(0);
	}
}
     
     //将图的信息输入
     void initialLinks()
{
	links[0].pre_node_id = 0;
	links[0].aft_node_id = 4;

	links[1].pre_node_id = 0;
	links[1].aft_node_id = 6;

	links[2].pre_node_id = 1;
	links[2].aft_node_id = 4;

	links[3].pre_node_id = 1;
	links[3].aft_node_id = 6;

	links[4].pre_node_id = 2;
	links[4].aft_node_id = 5;

	links[5].pre_node_id = 2;
	links[5].aft_node_id = 7;

	links[6].pre_node_id = 3;
	links[6].aft_node_id = 5;

	links[7].pre_node_id = 3;
	links[7].aft_node_id = 7;
//////////////////////////////////////////////////////////////////////////level-1
	links[8].pre_node_id = 4;
	links[8].aft_node_id = 8;

	links[9].pre_node_id = 4;
	links[9].aft_node_id = 9;

	links[10].pre_node_id = 5;
	links[10].aft_node_id = 8;

	links[11].pre_node_id = 5;
	links[11].aft_node_id = 9;

	links[12].pre_node_id = 6;
	links[12].aft_node_id = 10;

	links[13].pre_node_id = 6;
	links[13].aft_node_id = 11;

	links[14].pre_node_id = 7;
	links[14].aft_node_id = 10;

	links[15].pre_node_id = 7;
	links[15].aft_node_id = 11;
//////////////////////////////////////////////////////////////////////////
	links[16].pre_node_id = 8;
	links[16].aft_node_id = 12;

	links[17].pre_node_id = 8;
	links[17].aft_node_id = 13;

	links[18].pre_node_id = 9;
	links[18].aft_node_id = 14;

	links[19].pre_node_id = 9;
	links[19].aft_node_id = 15;

	links[20].pre_node_id = 10;
	links[20].aft_node_id = 16;

	links[21].pre_node_id = 10;
	links[21].aft_node_id = 17;

	links[22].pre_node_id = 11;
	links[22].aft_node_id = 18;

	links[23].pre_node_id = 11;
	links[23].aft_node_id = 19;
//////////////////////////////////////////////////////////////////////////
	//	CString str;
	//	str = "Initial Links Success";
	//	AfxMessageBox(str);
}

     
     
     //递归查找从start到ends之间所有可达的路径。
void getPaths(int map[][],int n ,int start,int ends,boolean[] isNodeUsed,Path[] paths,int[] pathsNum)
{
    int i,j;
    Path[] tempPaths=new Path[100];
    for(int k = 0;k<tempPaths.length;k++)
    {
        tempPaths[k] = new Path(); 
    }
	//	struct Path tempPaths[MAX_PATHS_BETWEEN_TWO_NODES_NUM];
	int[] tempPathsNum = new int[2];

	// 标记当前起点不可用
	isNodeUsed[start] = true;

	for(i=0;i<n;i++)
	{
		// 节点不在路径中，且可以到达// isNodeUsed数组初始值都为0
		if(isNodeUsed[i] == false && map[start][i]== REACHABLE) //start与i相连
		{
			// 当前起点能直接到达终点
			if(i == ends)
			{
				paths[pathsNum[0]].size = 2;
				paths[pathsNum[0]].nodes[0] = ends;
				paths[pathsNum[0]].nodes[1] = start;
				pathsNum[0]++;
			}
			// 当前起点能不能直接到达终点，尝试当前节点通过其他节点达到终点
			else
			{
				// 递归计算从当前起点到达终点的所有路径
				tempPathsNum[0] = 0;
				getPaths(map,n,i,ends,isNodeUsed,tempPaths,tempPathsNum);

				// 处理找到的，从当前起点到达终点的所有路径
				for(j=0;j<tempPathsNum[0];j++)
				{
					// 在当前起点到达终点的所有路径中，添加当前起点
					tempPaths[j].nodes[tempPaths[j].size] = start;
					tempPaths[j].size ++;

					// 合并到最终的路径中
					//paths[pathsNum[0]] = tempPaths[j];
                                        paths[pathsNum[0]].size = tempPaths[j].size;
                                    System.arraycopy(tempPaths[j].nodes, 0, paths[pathsNum[0]].nodes, 0, tempPaths[j].size);
					pathsNum[0]++;
				}
			}
		}
	}
	isNodeUsed[start] = false;

}



     
     
     //寻找最短可达链路的的函数
     void doFindPaths()
{
	boolean[] isNodeUsed = new boolean[MAX_LINK_NUM];      //用来标记某节点是否已被使用过
	for(int k=0;k<MAX_LINK_NUM;k++)
		isNodeUsed[k]=false;
	for(int k=0;k<MAX_LINK_NUM;k++)
	{
		paths[k].size=0;
		for(int z=0;z<NODE_NUMBER;z++)
		{
			paths[k].nodes[z]=0;////////?????????????????????
		}
	}
	int y;

	initialMatrix();
	initialLinks();
	updateMatrix();

//	str.Format(_T("before:ends point is %d, pathsNumber is %d"),ends,pathsNum);
//	AfxMessageBox(str);
	getPaths(adjacency_matrix,NODE_NUMBER,start,ends,isNodeUsed,paths,pathsNum);

 /*     String st = null ;

        st = "later: ends point is "+ends+", pathsNumber is "+ pathsNum[0];
        System.out.println(st);*/
        
 /*     String str_out = null,str_out_t = null;
        for(int i=0; i<pathsNum[0]; i++)
        {
            for(int j=0;j<paths[i].size;j++)
            {
                str_out_t = paths[i].nodes[j] + "-->";
                str_out = str_out + str_out_t;
            }         
            System.out.println(str_out);
            str_out = "";
        }*/
//	str.Format(_T("later: ends point is %d, pathsNumber is %d"),ends,pathsNum);
//	AfxMessageBox(str);
	int getshortestpath=999;
	for (int i=0;i<pathsNum[0];i++)
	{
		if (paths[i].size<getshortestpath)
		{
			getshortestpath = paths[i].size;
		}
	}
//	str.Format(_T("the shortest path length is %d"),getshortestpath);
//	AfxMessageBox(str);

	for(int i=0;i<pathsNum[0];i++)
	{
		if (paths[i].size == getshortestpath)
		{
                    simppaths[simppathsNum].size = paths[i].size;
                    System.arraycopy(paths[i].nodes, 0, simppaths[simppathsNum].nodes, 0, paths[i].size);
                    simppathsNum++;
		}
	}
        
//	str.Format(_T("起点为：%d，终点为：%d，共有路径：%d。"),start,ends,simppathsNum);
//	AfxMessageBox(str);
//	str = "";
 //       System.out.println("起点为："+start+"终点为："+ends+"共有路径："+simppathsNum);
	String str_t,str;
        str = "";
	for(int x=0;x<simppathsNum;x++)
	{
		for(y=simppaths[x].size-1;y>=1;y--)
		{
                    str_t = simppaths[x].nodes[y]+"->";
                    str = str+str_t;

		}
	//	str+=paths[x].nodes[y];
		//cout<<(paths[x].nodes[y])<<endl;
                str_t = simppaths[x].nodes[y]+"";
               // str = str+str_t;
  //              System.out.println(str);
                //System.out.print();

		str = "";
	}

}
     
     // 设置开始节点与结束节点
void setStartAndEnds(int start_t, int end_t)
{
	start = start_t;
	ends  = end_t;
}

        // 返回当前链路段的带宽信息
int getLinkBandwidth(int link_order)
{
	int current_bandwidth;
	current_bandwidth = links[link_order].bandwidth;
	return current_bandwidth;
	
}

	// 返回当前链路段中已存在的流量数目
int getLinkLoadNum(int link_order)
{
	int current_linknum;
	current_linknum = links[link_order].load_num;
	return current_linknum;
}

	// 返回当前路径包含的链路段中已有的流的总数目
int getLinkPathIncluded(int link_order)
{
	int link_length = link_record[link_order].size;
	int load_sum = 0;
	for (int i=0;i<link_length;i++)
	{
		int order = link_record[link_order].linksID[i];
		load_sum += links[order].load_num;
	}
	load_sum = load_sum - link_length; //由于每条链路都被赋予了基数1（防止除0），因此在此需要减去1，一共link_length段
	if (load_sum < 0)
	{
		System.exit(996);
	}
	return load_sum;
}



int getLinkID(int preNodeID, int aftNodeID)
{
	int temp;
	if (preNodeID>aftNodeID) //交换，保证preNodeID<aftNodeID
	{
		temp = preNodeID;
		preNodeID  = aftNodeID;
		aftNodeID = temp;
	}
	for (int i=0;i<MAX_LINK_NUM;i++)
	{
		if (links[i].pre_node_id == preNodeID && links[i].aft_node_id == aftNodeID)
		{
			return i;
		}
	}
	System.exit(998);
        return 0;
}

 int getLinkUtilizationRate(int link_order)
{
	int link_length = link_record[link_order].size;
	int bandwidth_usage_min = 9999;
	int min_link_chain = link_record[link_order].linksID[link_length-1];
	String str;
//	str.Format(_T("the initial chain_num is %d"),max_link_chain);
//	AfxMessageBox(str);

	for (int i=0;i<link_length;i++)
	{
		int current_link_order = link_record[link_order].linksID[i];
		int link_bandwidth = links[current_link_order].bandwidth;
		int link_num = links[current_link_order].load_num;
		int bandwidth_usage = link_bandwidth/link_num; 
		if (bandwidth_usage < bandwidth_usage_min) //说明某一段的值比当前值要高，即需要更新记录
		{
			min_link_chain = current_link_order;
			bandwidth_usage_min = bandwidth_usage;
		}
	}
	if (min_link_chain>=0 && min_link_chain <=MAX_LINK_NUM)
	{
//		str.Format(_T("the changed chain_num is%d"),max_link_chain);
//		AfxMessageBox(str);
		return min_link_chain; //返回本链路中拥有最大利用率比值的链路号。
	}
	
	System.exit(997);
	return 0;
}
    


        void recordUsedLinks()
{
	String outprint = "hello, this is recordUsedLinks";
 //       System.out.println(outprint);
//	outprint.Format(_T("共有%d条路径"),simppathsNum);
//	AfxMessageBox(outprint);
	for (int i=0;i<simppathsNum;i++)
	{
		link_record[i].size = simppaths[i].size - 1; 
		for(int j=0;j<simppaths[i].size-1;j++)
		{
			link_record[i].linksID[j] = getLinkID(simppaths[i].nodes[j+1],simppaths[i].nodes[j]);
		}
	}

	String str = "";
	String str1;
	int j;
	for (int i=0;i<simppathsNum;i++)
	{
		for (j=link_record[i].size-1;j>=1;j--)
		{
                    str1 = link_record[i].linksID[j] + "->";
                    str = str + str1;
		}
                str1 = link_record[i].linksID[0] + "";
		str = str + str1;
//		AfxMessageBox(str);
//                System.out.println(str);
		str = "";
	}
}       
    
}

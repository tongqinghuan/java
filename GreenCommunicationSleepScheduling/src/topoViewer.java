import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.json.JSONException;
import org.json.JSONObject;

import twaver.Link;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverUtil;
import twaver.network.TNetwork;

@SuppressWarnings("serial")
public class topoViewer extends JFrame {

	static String ip = null;
	@SuppressWarnings("rawtypes")
	static List oldNodes;
	@SuppressWarnings("rawtypes")
	static TDataBox box = new TDataBox("Topo Info");
	private TNetwork network;
	private JPanel networkPane = new JPanel(new BorderLayout());
	private JPanel treePane = new JPanel(new BorderLayout());
	private JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,networkPane,treePane);
	JTable table = new JTable();
	JFrame jf;
	JScrollPane scrollPane = new JScrollPane();
	static JSONObject vtopo=null;
	
	
	
	
	//treepane
	
	JLabel jlable;
	JTextField edit;
	JLabel showpath;
	JTextArea textArea;
	JScrollBar scrollBar;
    JButton barchart;
    JButton linechart;
	
	Routing routing;
	
	public topoViewer()
	{
 		
		
		
			
		jlable = new JLabel(" get the ID of src_host and dst_host");
		jlable.setBackground(Color.RED);
		jlable.setFont(new Font("宋体", Font.PLAIN, 17));
		jlable.setBounds(44, 10, 341, 24);
		jlable.setLocation(50, 100);
		treePane.add(jlable);
		
		
		edit= new JTextField();
		edit.setFont(new Font("宋体", Font.PLAIN, 17));
		edit.setBounds(44, 10, 341, 24);
		edit.setLocation(50,130);
		edit.setColumns(10);
		treePane.add(edit);
		
		
		
		showpath = new JLabel("display the list of path");
		showpath.setBackground(Color.RED);
		showpath.setFont(new Font("宋体", Font.PLAIN, 17));
		showpath.setBounds(29, 10, 290, 24);
		showpath.setLocation(50, 210);
		treePane.add(showpath);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(384, 197, -196, -130);
		treePane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(213, 83, 178, 97);
		textArea.setLocation(60, 240);
		treePane.add(textArea);
		
		
	    scrollBar = new JScrollBar();
		scrollBar.setBounds(341, 83, 23, 97);
		scrollBar.setLocation(236, 240);
		treePane.add(scrollBar);
		
		 
		
		
 		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().add(split, BorderLayout.CENTER);
		split.setDividerLocation(550);
		network = new TNetwork(box);
		networkPane.add(network, BorderLayout.CENTER);
		networkPane.setBackground(Color.pink);
		network.setToolbarByName("");
		
	    
	    
	    System.out.println(EnergySavingPath.showpath()+"\n");
	    textArea.append(EnergySavingPath.showpath()+"\n");
		topoView(box);
		
		
		
		
	    
	    treePane.setBackground(Color.white);
	    treePane.setLayout(null);
	    
	    
	    final JButton btnNewButton = new JButton("test");
		btnNewButton.setBounds(350, 50, 167, 27);
		btnNewButton.setLocation(60, 350);
		treePane.add(btnNewButton);
		
		
		 barchart= new JButton("barchart");
		 barchart.setBounds(350, 50, 167, 27);
		 barchart.setLocation(60, 400);
		 treePane.add(barchart);
		 
		 
		 
		 linechart= new JButton("linechart");
		 linechart.setBounds(350, 50, 167, 27);
		 linechart.setLocation(60, 450);
		 treePane.add(linechart);
		
		 
		 Routing.route=new ArrayList<NodePortTuple>(50);
		
		btnNewButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(e.getSource() == btnNewButton)
				{      
					int[] x;
					int m=0;
					int[] temp =new int[13];
					
					int i;
					int k;
					String src;
					String dst;
					x=getHost();
					
					//the number of the host
					//System.out.println(String.valueOf(x.length));
					temp[m]=x[0];
					Routing.host_number ++;
					m++;
					k=1;
					while(x[k]!=0)
					{
                      
						int f;
						for(f=0;f<m;f++)
						{

							if(temp[f]==x[k])
							{

								break;
							}
						}
						if(f==m)
						{

							Routing.host_number ++;
							temp[m]=x[k];
							m++;
						}
						k++;
					}
					System.out.println(String.valueOf("display the number of host"));
					System.out.println(String.valueOf(Routing.host_number));
					
					
					i=0;
				 while(x[i]!=0)	
				 {
					CNode.get_path(x[i],x[i+1]);
				    Routing.calpath(x[i],x[i+1]);// get NodePortTple
				    Routing.showPutle();//display NodePortTuple  
					routing=new Routing();
				    
				    textArea.append(EnergySavingPath.showpath()+"\n");
				    for(int j=0;j<EnergySavingPath.finalRouterSize-1;j++)
			    	{
				    	String s = EnergySavingPath.convertToDeviceID(EnergySavingPath.finalRouter[j])+EnergySavingPath.convertToDeviceID(EnergySavingPath.finalRouter[j+1]);
				    	step9(s);
				    	s = EnergySavingPath.convertToDeviceID(EnergySavingPath.finalRouter[j+1])+EnergySavingPath.convertToDeviceID(EnergySavingPath.finalRouter[j]);
				    	step9(s);
			    	}

				    i=i+2;
				    
				    
				   
				       
				    System.out.println("hello world2!");
				    routing.showPutle();
				    
				 }
				 routing.srategy();
				
			     
				}
			}});
		
		
		
		
		
		barchart.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(e.getSource() == barchart)
				{      
					BarChart.drawchart();
			     
				}
			}});
		
		
		
		linechart.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(e.getSource() == linechart)
				{      
					jfreeChart.drawlinechart();
			     
				}
			}});
				
	}
	
	
		 
		
		//get the link element.
		private void step9(String str) {
			 
			//get the link element.
			Link element = (Link)box.getElementByID(str);
			System.out.println("links" + str);
			  //Link element = (Link)box.getElementByName(str);
			  if (element != null) {
				  System.out.println("getLink" + element.getName());
				//make the link animating flowing
				  element.putLinkFlowing(true);
				  //set the link flowing color
				  element.putLinkFlowingColor(Color.green);
				  //set the link outline color
				  element.putLinkOutlineColor(Color.black);
				  //set the link body color.
				  element.putLinkColor(Color.RED);
				  //set the link lable font
				  element.putLabelFont(new Font("Impact", 1, 20));
				  //set the link lable color
				  element.putLabelColor(Color.MAGENTA);	
			}
		}
	
	
	public int[]  getHost()
	{
		StringTokenizer token;
		
		int[] host;
		int i;
		host=new int[10];
		
		i=0;
		
		String str=edit.getText();
		System.out.println(str);
		token=new StringTokenizer(str);
		 while(token.hasMoreElements())
		  {
			  String s=token.nextToken();
			  host[i]=Integer.parseInt(s);
			  i++;
			  
		  }
		 host[i]=0;
		 return host;
	}
	
	 
	
 	@SuppressWarnings("rawtypes")
	public void Refresh(TDataBox box)
	{
		network.updateUI();
		List newNodes = nodesGetter();//点击刷新后的结点列表
		//System.out.print("当前结点列表：");
		//System.out.println(newNodes);
		//System.out.println("old"+oldNodes);
		
		//移除已经不存在的结点
		for(int i =0;i<oldNodes.size();i++)
		{
			if(!(newNodes.contains(oldNodes.get(i))))//如果旧结点列表中有新结点列表中不包含的元素，则删除之。
			{
				box.removeElementByID(oldNodes.get(i).toString());
				System.out.println(getTime()+"设备["+oldNodes.get(i).toString()+"]断开连接");
			}
			network.updateUI();
		}
				
		for(int i=0;i<newNodes.size();i++)
		{			
			//System.out.println(!(oldNodes.contains(newNodes.get(i))));
			if(newNodes.get(i).toString().length() == 23 && !(oldNodes.contains(newNodes.get(i))))
			{
				//随机生成结点坐标位置，在窗体范围内
				double x = 30+Math.random()*400;
				double y = 30+Math.random()*450;
				
				Node switcher = new Node(newNodes.get(i).toString());//用IP/DPID作为结点ID
				switcher.setImage("/switch.png");
				switcher.setName(newNodes.get(i).toString());
				switcher.setLocation(x, y);
				box.addElement(switcher);
				
				String right = findRight(newNodes.get(i).toString());
				int bandwidth = findBandwidth(newNodes.get(i).toString());
				
				Link link = new Link("NewLinks"+String.valueOf(i),switcher,(Node)box.getElementByID(right));
				link.setName("bandwidth:"+String.valueOf(bandwidth)+" Mbps");
				box.addElement(link);
				System.out.println(getTime()+"Switch:["+newNodes.get(i).toString()+"]已连接");
			}
			else if(!(oldNodes.contains(newNodes.get(i))))
			{
				double x = 30+Math.random()*400;
				double y = 30+Math.random()*450;
				
				Node host = new Node(newNodes.get(i).toString());
				host.setImage("/host.png");
				host.setName(newNodes.get(i).toString());
				host.setLocation(x, y);
				box.addElement(host);
				
				String right = findRight(newNodes.get(i).toString());
				//System.out.println(right);
				int bandwidth = findBandwidth(newNodes.get(i).toString());
				
				Link link = new Link("links"+String.valueOf(i),host,(Node)box.getElementByID(right));
				link.setName("bandwidth:"+String.valueOf(bandwidth)+" Mbps");
			   	box.addElement(link);
				System.out.println(getTime()+"Host:["+newNodes.get(i).toString()+"]已连接");
			}
		}
		oldNodes = newNodes;
		network.updateUI();
	}
 	
	public String findRight(String l)
	{
		JSONObject links = topoGetter.topogetter();
		String r=null;
		int length=0;
		try {
			length = links.getJSONArray("links").length();
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		for(int i=0;i<length;i++)
		{
			try{
				String left = links.getJSONArray("links").getJSONObject(i).getString("left");
				String right = links.getJSONArray("links").getJSONObject(i).getString("right");
				
				if(left.equals(l))
				{
					r = right;
				}
				
			}catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return r;
	}
	
	public int findBandwidth(String l)
	{
		JSONObject links = topoGetter.topogetter();
		int bw=0;
		int length=0;
		try {
			length = links.getJSONArray("links").length();
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		for(int i=0;i<length;i++)
		{
			try{
				String left = links.getJSONArray("links").getJSONObject(i).getString("left");
				int bandwidth = links.getJSONArray("links").getJSONObject(i).getInt("bandwidth");
				
				
				if(left.equals(l))
				{
					bw = bandwidth;
				}
				
			}catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return bw;
	}
	
 	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List nodesGetter()
	{	
		JSONObject topo = topoGetter.topogetter();
		//String pre = "{\"nodes\":8,\"flows\":[{\"src\":\"1\",\"dst\":\"6\",\"bandwidth\":90}],\"links\":[{\"left\":\"1\",\"right\":\"2\",\"left-port\":2,\"right-port\":2,\"bandwidth\":100},{\"left\":\"1\",\"right\":\"3\",\"left-port\":1,\"right-port\":2,\"bandwidth\":100},{\"left\":\"2\",\"right\":\"3\",\"left-port\":1,\"right-port\":2,\"bandwidth\":100},{\"left\":\"2\",\"right\":\"4\",\"left-port\":1,\"right-port\":2,\"bandwidth\":100},{\"left\":\"2\",\"right\":\"5\",\"left-port\":1,\"right-port\":2,\"bandwidth\":100},{\"left\":\"3\",\"right\":\"4\",\"left-port\":1,\"right-port\":2,\"bandwidth\":100},{\"left\":\"3\",\"right\":\"7\",\"left-port\":1,\"right-port\":2,\"bandwidth\":100},{\"left\":\"4\",\"right\":\"6\",\"left-port\":1,\"right-port\":2,\"bandwidth\":100},{\"left\":\"4\",\"right\":\"8\",\"left-port\":1,\"right-port\":2,\"bandwidth\":100},{\"left\":\"5\",\"right\":\"8\",\"left-port\":1,\"right-port\":2,\"bandwidth\":100},{\"left\":\"6\",\"right\":\"7\",\"left-port\":1,\"right-port\":2,\"bandwidth\":100},{\"left\":\"6\",\"right\":\"8\",\"left-port\":1,\"right-port\":2,\"bandwidth\":100}]}";
		//JSONObject topo=null;
		
		int length=0;
		try {
			length = topo.getJSONArray("links").length();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	
		List nodes = new ArrayList();
		for(int i=0;i<length;i++)
		{
			try{
			String left = topo.getJSONArray("links").getJSONObject(i).getString("left");
			String right = topo.getJSONArray("links").getJSONObject(i).getString("right");
			if(!nodes.contains(left))
			{
				nodes.add(left);
			}
			if(!nodes.contains(right))
			{
				nodes.add(right);
			}
			}catch(JSONException e) {
				e.printStackTrace();
				
			}
		}
		return nodes;
	}
     
 	
 	
 	
 	
 	
	public void topoView(TDataBox box)
	{
		
		@SuppressWarnings("rawtypes")
		List nodes = nodesGetter();
		System.out.println("this is the first time to get the links");
		JSONObject links = topoGetter.topogetter();
		System.out.print(getTime()+"links:");
		//System.out.println(links);
		
		int length=0;
		try {
			length = links.getJSONArray("links").length();
		} catch (JSONException e) {e.printStackTrace();}
		
		
		for(int i=0;i<nodes.size();i++)
		{
			if(nodes.get(i).toString().length() == 23)
			{
				double x = 30+Math.random()*400;
				double y = 30+Math.random()*450;
				Node switcher = new Node(nodes.get(i).toString());
				switcher.setImage("/switch.png");
				switcher.setName(nodes.get(i).toString());
				switcher.setLocation(x, y);
				box.addElement(switcher);
			}
			else
			{
				double x = 30+Math.random()*400;
				double y = 30+Math.random()*450;
				Node host = new Node(nodes.get(i).toString());
				host.setImage("/host.png");
				host.setName(nodes.get(i).toString());
				host.setLocation(x, y);
				box.addElement(host);
			}
		}
		
		for(int i=0;i<length;i++)
		{
			try{
				String left = links.getJSONArray("links").getJSONObject(i).getString("left");
				String right = links.getJSONArray("links").getJSONObject(i).getString("right");
				int bandwidth = links.getJSONArray("links").getJSONObject(i).getInt("bandwidth");
				//Link link = new Link("links"+String.valueOf(i),(Node)box.getElementByName(left),(Node)box.getElementByName(right));
				Link link = new Link(left+right,(Node)box.getElementByName(left),(Node)box.getElementByName(right));
				//link.setName(left+right);/////////////////////
				System.out.println("crate links"+left+right);
				//step9(link);
				link.setName("bandwidth:"+String.valueOf(bandwidth)+" Mbps");
				box.addElement(link);
			}catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static String getTime()
	{
		Date time = new Date();
		SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
		String t = "["+f.format(time)+" Topo View] ";
		return t;
	}
	
	private static void CreatWindow()
	{
		try { 
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
		} catch (Exception e) {
			e.printStackTrace();
			} 
		topoViewer frame = new topoViewer();
		Image img = Toolkit.getDefaultToolkit().getImage(frame.getClass().getResource("/icon.png"));
		frame.setIconImage(img);
		frame.setSize(1200, 600);
		frame.setTitle("Floodlight Network Manager");
		TWaverUtil.centerWindow(frame);
		frame.setVisible(true);
		
	}
	
	private static void Init()
	{
		final JFrame initFrame = new JFrame("Floodlight Network Manager");
		Image img = Toolkit.getDefaultToolkit().getImage(initFrame.getClass().getResource("/icon.png"));
		initFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initFrame.setIconImage(img);
		initFrame.setBounds(500, 400, 400, 160);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		final JLabel l = new JLabel("请输入控制器IP地址，默认为127.0.0.1");
		l.setFont(new Font("宋体",Font.BOLD,20));
		panel.add(l);
		
		final JTextField t = new JTextField(25);
		ip = t.getText();
		panel.add(t);
		
		final Button startbtn = new Button("启动");
		startbtn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
				if(e.getSource() == startbtn)
				{
					ip = t.getText();
					if(ConnectTest(ip))
					{
						oldNodes = nodesGetter();
						initFrame.dispose();//释放当前窗口
						CreatWindow();
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"无法连接至控制器"+ip+"，请检查输入的IP地址并确认控制器为Floodlight","ERROR",JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}});
		panel.add(startbtn);
		initFrame.add(BorderLayout.CENTER,panel);
		initFrame.setVisible(true);
	}

	private static boolean ConnectTest(String ip)
	{
		String address = "http://"+ip+":8080/wm/core/memory/json ";
		URL url=null;
		try {
			url = new URL(address);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		try {
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.connect();
			System.out.println(getTime()+"Controller IP:"+ip);
			return true;
		} catch (IOException e) {
			System.out.println(getTime()+"Controller IP "+ip+" Error!");
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		Init();	
		
		
	}
}

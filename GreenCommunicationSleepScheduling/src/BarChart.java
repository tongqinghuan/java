
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart {

  public static void drawchart() {
    // TODO Auto-generated method stub
    DefaultCategoryDataset dataset=new DefaultCategoryDataset();
    //添加数据
    dataset.addValue(cal_energy.calnormal_energy(), "正规路由", "正规路由");
    dataset.addValue(cal_energy.calenergy_less(), "节能路由", "节能路由");
  
    
    JFreeChart chart=ChartFactory.createBarChart3D(
        "能耗模型",
        "路由策略",//X轴的标签 
        "能耗度量",//Y轴的标签 
  dataset, //图标显示的数据集合
  PlotOrientation.VERTICAL, //图像的显示形式（水平或者垂直）
  true,//是否显示子标题 
  true,//是否生成提示的标签 
  true); //是否生成URL链接		
           //处理图形上的乱码
        //处理主标题的乱码
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,18));
        //处理子标题乱码
        chart.getLegend().setItemFont(new Font("宋体",Font.BOLD,15));
        //获取图表区域对象
        CategoryPlot categoryPlot = (CategoryPlot)chart.getPlot();
        //获取X轴的对象
        CategoryAxis3D categoryAxis3D = (CategoryAxis3D)categoryPlot.getDomainAxis();
        //获取Y轴的对象
        NumberAxis3D numberAxis3D = (NumberAxis3D)categoryPlot.getRangeAxis();
        //处理X轴上的乱码
        categoryAxis3D.setTickLabelFont(new Font("宋体",Font.BOLD,15));
        //处理X轴外的乱码
        categoryAxis3D.setLabelFont(new Font("宋体",Font.BOLD,15));
        //处理Y轴上的乱码
        numberAxis3D.setTickLabelFont(new Font("宋体",Font.BOLD,15));
        //处理Y轴外的乱码
        numberAxis3D.setLabelFont(new Font("宋体",Font.BOLD,15));
        //处理Y轴上显示的刻度，以10作为1格
        numberAxis3D.setAutoTickUnitSelection(false);
        NumberTickUnit unit = new NumberTickUnit(10);
        numberAxis3D.setTickUnit(unit);
        //获取绘图区域对象
        BarRenderer3D barRenderer3D = (BarRenderer3D)categoryPlot.getRenderer();
        //设置柱形图的宽度
        barRenderer3D.setMaximumBarWidth(0.07);
        //在图形上显示数字
        barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        barRenderer3D.setBaseItemLabelsVisible(true);
        barRenderer3D.setBaseItemLabelFont(new Font("宋体",Font.BOLD,15));
        
        //在D盘目录下生成图片
        File file = new File("chart.jpeg");
        try {
          ChartUtilities.saveChartAsJPEG(file, chart, 800, 600);
        } catch (IOException e) {
          e.printStackTrace();
        }
        
        //使用ChartFrame对象显示图像
        ChartFrame frame = new ChartFrame("正规路由与节能路由在相同的负载情况下的能耗模型",chart);
        frame.setVisible(true);
        frame.pack();
  }

}
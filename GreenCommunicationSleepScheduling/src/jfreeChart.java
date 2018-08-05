
import java.awt.Font;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class jfreeChart {
  
  public static void drawlinechart() {
	  
	  flowop.getPacket();
    // TODO Auto-generated method stub
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    // 添加数据
    for(int i=0;i<flowop.packet.size();i++)
    {
    	dataset.addValue(flowop.packet.get(i).packetcount, "节能路由",flowop.packet.get(i).switchId);
    	
    }
   
    JFreeChart chart = ChartFactory.createLineChart("不同交换机转发的数据包", // 主标题的名称
        "交换机ID",// X轴的标签
        "转发的数据包",// Y轴的标签
        dataset, // 图标显示的数据集合
        PlotOrientation.VERTICAL, // 图像的显示形式（水平或者垂直）
        true,// 是否显示子标题
        true,// 是否生成提示的标签
        true); // 是否生成URL链接
    // 处理图形上的乱码
    // 处理主标题的乱码
    chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
    // 处理子标题乱码
    chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));
    // 获取图表区域对象
    CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();
    // 获取X轴的对象
    CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
    // 获取Y轴的对象
    NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
    // 处理X轴上的乱码
    categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
    // 处理X轴外的乱码
    categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));
    // 处理Y轴上的乱码
    numberAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
    // 处理Y轴外的乱码
    numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));
    // 处理Y轴上显示的刻度，以10作为1格
    numberAxis.setAutoTickUnitSelection(false);
    NumberTickUnit unit = new NumberTickUnit(10);
    numberAxis.setTickUnit(unit);
    // 获取绘图区域对象
    LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer) categoryPlot
        .getRenderer();
    // 在图形上显示数字
    lineAndShapeRenderer
        .setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
    lineAndShapeRenderer.setBaseItemLabelsVisible(true);
    lineAndShapeRenderer
        .setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));
    // 在图形上添加转折点（使用小矩形显示）
    Rectangle shape = new Rectangle(10, 10);
    lineAndShapeRenderer.setSeriesShape(0, shape);
    lineAndShapeRenderer.setSeriesShapesVisible(0, true);

    //在D盘目录下生成图片
    File file = new File("chart1.jpg");
    try {
      ChartUtilities.saveChartAsJPEG(file, chart, 800, 600);
    } catch (IOException e) {
      e.printStackTrace();
    }
    // 使用ChartFrame对象显示图像
    ChartFrame frame = new ChartFrame("交换机流量统计", chart);
    frame.setVisible(true);
    frame.pack();
  }

}

/*
 * Created By Alex Kearney (konga.kearney@gmail.com)
 * On: 13/2/13
 * Last Edited: 12/2/13 By Alex Kearney 
 */
package rlbroker;

import java.awt.Panel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.experimental.chart.swt.demo.SWTBarChartDemo1;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Alexandr
 */
public class Grapher extends ApplicationFrame{
    
    XYSeries series;
    XYDataset xYDataset;
    JFreeChart chart;
    ChartPanel chartPanel;
    
    public Grapher(
            final String title,
            String seriesName,
            String xAxis,
            String yAxis){
          
          super(title);
          
          final NumberAxis DOMAIN_AXIS = new NumberAxis("X-Axis");
          
          series = new XYSeries(seriesName);
          xYDataset = new XYSeriesCollection(series);
          chart = ChartFactory.createXYLineChart(
                  title,
                  xAxis,
                  yAxis,
                  xYDataset,
                  PlotOrientation.VERTICAL,
                  rootPaneCheckingEnabled,
                  rootPaneCheckingEnabled,
                  rootPaneCheckingEnabled);
          chartPanel = new ChartPanel(chart);
      
          chartPanel.setVisible(true);     
          chartPanel.setPreferredSize(new java.awt.Dimension(500,270));
          setContentPane(chartPanel);
          
    }   
      
    public void update(double xPoint, double yPoint){
        series.add(xPoint,yPoint); 
    }
    
    public ChartPanel get(){
        return chartPanel;
    }
}

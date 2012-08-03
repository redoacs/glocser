/*
 * GapSizeChartPanel.java
 *
 * Created on October 21, 2008, 1:59 AM
 */
package edu.unam.iimas.glocsa.glocser.glocsadetails;

import edu.unam.iimas.alignment.Alignment;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

/**
 *
 * @author  xaltonalli
 */
public class GapSizeChartPanel extends javax.swing.JPanel {

    private Alignment alignment = null;
    private ArrayList<Integer> allGapSizes = null;
    private Integer biggestGapSize = null;
    private Integer smallerGapSize = null;
    
    /** Creates new form GapSizeChartPanel */
    public GapSizeChartPanel() {
        initComponents();
    }

    public void createChart() {
        if ((alignment != null)) {

            int gaps = allGapSizes.size();

            double[] allGaps = new double[gaps];

            for (int i = 0; i < gaps; i++) {
                allGaps[i] = (double) allGapSizes.get(i);
                //System.out.println("allGaps[" + i + "] = " + allGaps[i]);
            }


            HistogramDataset dataset = new HistogramDataset();
            dataset.setType(HistogramType.FREQUENCY);
            dataset.addSeries("Gaps size", allGaps, biggestGapSize.intValue() - smallerGapSize.intValue() + 1, (double) (smallerGapSize.intValue()) - 0.5, (double) (biggestGapSize.intValue()) + 0.5);

            JFreeChart chart = ChartFactory.createHistogram(
                    "Gap Size Histogram",
                    "gap size",
                    "occurrences",
                    dataset,
                    PlotOrientation.VERTICAL,
                    false,
                    false,
                    false);
            chart.getXYPlot().setForegroundAlpha(0.75f);

            TickUnitSource source = NumberAxis.createIntegerTickUnits();

            ValueAxis domainAxis = chart.getXYPlot().getDomainAxis();
            domainAxis.setStandardTickUnits(source);
            //domainAxis.setLowerBound((double)(smallerGapSize.intValue()) - 0.5);
            //domainAxis.setUpperBound((double)(biggestGapSize.intValue()) + 0.5);

            ValueAxis rangeAxis = chart.getXYPlot().getRangeAxis();
            rangeAxis.setStandardTickUnits(source);
            
            

            ///////// GUI

            ChartPanel chartPanel = new ChartPanel(chart);

            javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(chartPanel);
            chartPanel.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 380, Short.MAX_VALUE));
            panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 280, Short.MAX_VALUE));

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));


        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public ArrayList<Integer> getAllGapSizes() {
        return allGapSizes;
    }

    public void setAllGapSizes(ArrayList<Integer> allGapSizes) {
        this.allGapSizes = allGapSizes;
    }

    public Integer getBiggestGapSize() {
        return biggestGapSize;
    }

    public void setBiggestGapSize(Integer biggestGapSize) {
        this.biggestGapSize = biggestGapSize;
    }

    public Integer getSmallerGapSize() {
        return smallerGapSize;
    }

    public void setSmallerGapSize(Integer smallerGapSize) {
        this.smallerGapSize = smallerGapSize;
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
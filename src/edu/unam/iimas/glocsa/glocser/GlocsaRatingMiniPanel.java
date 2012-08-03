/*
 * GlocsaRatingMiniPanel.java
 *
 * Created on September 11, 2008, 12:43 AM
 */

package edu.unam.iimas.glocsa.glocser;

import edu.unam.iimas.alignment.glocsa.core.EventCount;
import edu.unam.iimas.alignment.glocsa.core.GlocsaRating;
import java.text.DecimalFormat;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author  xaltonalli
 */
public class GlocsaRatingMiniPanel extends javax.swing.JPanel {
    
    private final String formatterPattern = "#.0000000000";
    private GlocsaRating rating = null;
    private EventCount eventCount = null;
    
    public void refreshAllData() {
        
        DecimalFormat formatter = new DecimalFormat(formatterPattern);
        
        jTextFieldGlocsaRatingValue.setText(formatter.format(rating.getRatingValue()));
        jTextFieldMeanColumnRatingValue.setText(formatter.format(rating.getMeanColumnValue()));
        jTextFieldGapConcentrationValue.setText(formatter.format(rating.getGapConcentration()));
        jTextFieldColumnIncrementRatioValue.setText(formatter.format(rating.getColumnIncrementRatio()));
        
        jTextFieldPotentialSynapomorphiesValue.setText(Integer.toString(eventCount.getTotalEvents()));
        jTextFieldMinimumNumberOfSubsitutionsValue.setText(Integer.toString(eventCount.getSubstitutionEvents()));
        jTextFieldMinimumNumberOfGapsValue.setText(Integer.toString(eventCount.getInDelEvents()));
        
        jTextFieldNumberColumnsIncremented.setText(Integer.toString(rating.getColumnsAligned() - rating.getColumnsNotAligned()));
        jTextFieldTotalGapPositions.setText(Integer.toString(rating.getTotalGapPositions()));
        jTextFieldMeanGapBlockSize.setText(formatter.format(rating.getMeanGapBlockSize()));
        
    }

    public void clearPanel(){
        rating = null;
        eventCount = null;

        jTextFieldGlocsaRatingValue.setText("n/a");
        jTextFieldMeanColumnRatingValue.setText("n/a");
        jTextFieldGapConcentrationValue.setText("n/a");
        jTextFieldColumnIncrementRatioValue.setText("n/a");
        jTextFieldPotentialSynapomorphiesValue.setText("n/a");
        jTextFieldMinimumNumberOfSubsitutionsValue.setText("n/a");
        jTextFieldMinimumNumberOfGapsValue.setText("n/a");
        jTextFieldNumberColumnsIncremented.setText("n/a");
        jTextFieldTotalGapPositions.setText("n/a");
        jTextFieldMeanGapBlockSize.setText("n/a");
    }

    /** Creates new form GlocsaRatingMiniPanel */
    public GlocsaRatingMiniPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelGLOCSA = new javax.swing.JLabel();
        jTextFieldGlocsaRatingValue = new javax.swing.JTextField();
        jLabelMCH = new javax.swing.JLabel();
        jLabelRGB = new javax.swing.JLabel();
        jLabelCI = new javax.swing.JLabel();
        jTextFieldMeanColumnRatingValue = new javax.swing.JTextField();
        jTextFieldGapConcentrationValue = new javax.swing.JTextField();
        jTextFieldColumnIncrementRatioValue = new javax.swing.JTextField();
        jLabelEstEvents = new javax.swing.JLabel();
        jLabelEstSubst = new javax.swing.JLabel();
        jLabelEstIndels = new javax.swing.JLabel();
        jTextFieldPotentialSynapomorphiesValue = new javax.swing.JTextField();
        jTextFieldMinimumNumberOfSubsitutionsValue = new javax.swing.JTextField();
        jTextFieldMinimumNumberOfGapsValue = new javax.swing.JTextField();
        jLabelNumberColumnsIncrement = new javax.swing.JLabel();
        jTextFieldNumberColumnsIncremented = new javax.swing.JTextField();
        jLabelTotalGapPositions = new javax.swing.JLabel();
        jTextFieldTotalGapPositions = new javax.swing.JTextField();
        jLabelMeanGapBlockSize = new javax.swing.JLabel();
        jTextFieldMeanGapBlockSize = new javax.swing.JTextField();

        jLabelGLOCSA.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jLabelGLOCSA.setText("GLOCSA: ");

        jTextFieldGlocsaRatingValue.setEditable(false);
        jTextFieldGlocsaRatingValue.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jTextFieldGlocsaRatingValue.setText("n/a");
        jTextFieldGlocsaRatingValue.setBorder(null);
        jTextFieldGlocsaRatingValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGlocsaRatingValueActionPerformed(evt);
            }
        });

        jLabelMCH.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jLabelMCH.setText("MCH:");

        jLabelRGB.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jLabelRGB.setText("RGB:");

        jLabelCI.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jLabelCI.setText("CI:");

        jTextFieldMeanColumnRatingValue.setEditable(false);
        jTextFieldMeanColumnRatingValue.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jTextFieldMeanColumnRatingValue.setText("n/a");
        jTextFieldMeanColumnRatingValue.setBorder(null);

        jTextFieldGapConcentrationValue.setEditable(false);
        jTextFieldGapConcentrationValue.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jTextFieldGapConcentrationValue.setText("n/a");
        jTextFieldGapConcentrationValue.setBorder(null);

        jTextFieldColumnIncrementRatioValue.setEditable(false);
        jTextFieldColumnIncrementRatioValue.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jTextFieldColumnIncrementRatioValue.setText("n/a");
        jTextFieldColumnIncrementRatioValue.setBorder(null);

        jLabelEstEvents.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jLabelEstEvents.setText("Est. Events:");

        jLabelEstSubst.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jLabelEstSubst.setText("Est. Subst:");

        jLabelEstIndels.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jLabelEstIndels.setText("Est. Indels:");

        jTextFieldPotentialSynapomorphiesValue.setEditable(false);
        jTextFieldPotentialSynapomorphiesValue.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jTextFieldPotentialSynapomorphiesValue.setText("n/a");
        jTextFieldPotentialSynapomorphiesValue.setBorder(null);

        jTextFieldMinimumNumberOfSubsitutionsValue.setEditable(false);
        jTextFieldMinimumNumberOfSubsitutionsValue.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jTextFieldMinimumNumberOfSubsitutionsValue.setText("n/a");
        jTextFieldMinimumNumberOfSubsitutionsValue.setBorder(null);

        jTextFieldMinimumNumberOfGapsValue.setEditable(false);
        jTextFieldMinimumNumberOfGapsValue.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jTextFieldMinimumNumberOfGapsValue.setText("n/a");
        jTextFieldMinimumNumberOfGapsValue.setBorder(null);

        jLabelNumberColumnsIncrement.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jLabelNumberColumnsIncrement.setText("# Cols. inc.:");

        jTextFieldNumberColumnsIncremented.setEditable(false);
        jTextFieldNumberColumnsIncremented.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jTextFieldNumberColumnsIncremented.setText("n/a");
        jTextFieldNumberColumnsIncremented.setBorder(null);

        jLabelTotalGapPositions.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jLabelTotalGapPositions.setText("Total gap pos.:");

        jTextFieldTotalGapPositions.setEditable(false);
        jTextFieldTotalGapPositions.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jTextFieldTotalGapPositions.setText("n/a");
        jTextFieldTotalGapPositions.setBorder(null);

        jLabelMeanGapBlockSize.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jLabelMeanGapBlockSize.setText("Mean gap size:");

        jTextFieldMeanGapBlockSize.setEditable(false);
        jTextFieldMeanGapBlockSize.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jTextFieldMeanGapBlockSize.setText("n/a");
        jTextFieldMeanGapBlockSize.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelNumberColumnsIncrement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNumberColumnsIncremented, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelTotalGapPositions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTotalGapPositions, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMeanGapBlockSize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMeanGapBlockSize, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelGLOCSA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldGlocsaRatingValue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelMCH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMeanColumnRatingValue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelRGB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldGapConcentrationValue, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelEstEvents)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPotentialSynapomorphiesValue, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelEstSubst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMinimumNumberOfSubsitutionsValue, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelEstIndels)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMinimumNumberOfGapsValue, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelCI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldColumnIncrementRatioValue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGLOCSA)
                    .addComponent(jTextFieldGlocsaRatingValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMCH)
                    .addComponent(jTextFieldMeanColumnRatingValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRGB)
                    .addComponent(jTextFieldGapConcentrationValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCI)
                    .addComponent(jTextFieldColumnIncrementRatioValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEstEvents)
                    .addComponent(jTextFieldPotentialSynapomorphiesValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstSubst)
                    .addComponent(jTextFieldMinimumNumberOfSubsitutionsValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstIndels)
                    .addComponent(jTextFieldMinimumNumberOfGapsValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumberColumnsIncrement)
                    .addComponent(jTextFieldNumberColumnsIncremented, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTotalGapPositions)
                    .addComponent(jTextFieldTotalGapPositions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMeanGapBlockSize)
                    .addComponent(jTextFieldMeanGapBlockSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

private void jTextFieldGlocsaRatingValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGlocsaRatingValueActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jTextFieldGlocsaRatingValueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelCI;
    private javax.swing.JLabel jLabelEstEvents;
    private javax.swing.JLabel jLabelEstIndels;
    private javax.swing.JLabel jLabelEstSubst;
    private javax.swing.JLabel jLabelGLOCSA;
    private javax.swing.JLabel jLabelMCH;
    private javax.swing.JLabel jLabelMeanGapBlockSize;
    private javax.swing.JLabel jLabelNumberColumnsIncrement;
    private javax.swing.JLabel jLabelRGB;
    private javax.swing.JLabel jLabelTotalGapPositions;
    private javax.swing.JTextField jTextFieldColumnIncrementRatioValue;
    private javax.swing.JTextField jTextFieldGapConcentrationValue;
    private javax.swing.JTextField jTextFieldGlocsaRatingValue;
    private javax.swing.JTextField jTextFieldMeanColumnRatingValue;
    private javax.swing.JTextField jTextFieldMeanGapBlockSize;
    private javax.swing.JTextField jTextFieldMinimumNumberOfGapsValue;
    private javax.swing.JTextField jTextFieldMinimumNumberOfSubsitutionsValue;
    private javax.swing.JTextField jTextFieldNumberColumnsIncremented;
    private javax.swing.JTextField jTextFieldPotentialSynapomorphiesValue;
    private javax.swing.JTextField jTextFieldTotalGapPositions;
    // End of variables declaration//GEN-END:variables

    public GlocsaRating getRating() {
        return rating;
    }

    public void setRating(GlocsaRating rating) {
        this.rating = rating;
    }

    public EventCount getEventCount() {
        return eventCount;
    }

    public void setEventCount(EventCount eventCount) {
        this.eventCount = eventCount;
    }

}

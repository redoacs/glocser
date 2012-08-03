/*
 * GlocsaRatingPanel.java
 *
 * Created on January 16, 2008, 11:06 PM
 */
package edu.unam.iimas.glocsa.glocser.glocsadetails;

import edu.unam.iimas.alignment.Alignment;
import edu.unam.iimas.alignment.DynamicAlignment;
import edu.unam.iimas.alignment.glocsa.core.EventCount;
import edu.unam.iimas.alignment.glocsa.core.GlocsaRating;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author  xaltonalli
 */
public class GlocsaRatingPanel extends javax.swing.JPanel {

    private GlocsaRating rating = null;
    private EventCount eventCount = null;
    private DynamicAlignment dynamicAlignment = null;
    private File alignmentFile = null;

    /** Creates new form GlocsaRatingPanel */
    public GlocsaRatingPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldGlocsaRatingValue = new javax.swing.JTextField();
        jTextFieldMeanColumnRatingValue = new javax.swing.JTextField();
        jTextFieldReciprocalGapBlocksValue = new javax.swing.JTextField();
        jTextFieldColumnIncrementRatioValue = new javax.swing.JTextField();
        jTextFieldMeanGapSizeValue = new javax.swing.JTextField();
        jTextFieldColumnsUnalignedValue = new javax.swing.JTextField();
        jTextFieldColumnsAlignedValue = new javax.swing.JTextField();
        jTextFieldTotalGapPositionsValue = new javax.swing.JTextField();
        jTextFieldFileName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldAllGapColumnsValue = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldNumberOfSequencesValue = new javax.swing.JTextField();
        jTextFieldLongestSequenceValue = new javax.swing.JTextField();
        jTextFieldShortestSequenceValue = new javax.swing.JTextField();
        jTextFieldTotalNumberBasesValue = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldPotentialSynapomorphiesValue = new javax.swing.JTextField();
        jTextFieldMinimumNumberOfSubsitutionsValue = new javax.swing.JTextField();
        jTextFieldMinimumNumberOfGapsValue = new javax.swing.JTextField();

        setEnabled(false);

        jLabel1.setText("GLOCSA Rating: ");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel2.setText("Mean colunm rating:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Reciprocal of Gap Blocks:");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel4.setText("Column increment ratio:");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 10));
        jLabel5.setText("Mean gap size:");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 10));
        jLabel6.setText("# columns when unaligned:");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 10));
        jLabel7.setText("# columns when aligned:");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 10));
        jLabel8.setText("Total gap positions:");

        jTextFieldGlocsaRatingValue.setEditable(false);
        jTextFieldGlocsaRatingValue.setFont(new java.awt.Font("SansSerif", 1, 12));
        jTextFieldGlocsaRatingValue.setText("n/a");
        jTextFieldGlocsaRatingValue.setBorder(null);
        jTextFieldGlocsaRatingValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGlocsaRatingValueActionPerformed(evt);
            }
        });

        jTextFieldMeanColumnRatingValue.setEditable(false);
        jTextFieldMeanColumnRatingValue.setText("n/a");
        jTextFieldMeanColumnRatingValue.setBorder(null);

        jTextFieldReciprocalGapBlocksValue.setEditable(false);
        jTextFieldReciprocalGapBlocksValue.setText("n/a");
        jTextFieldReciprocalGapBlocksValue.setBorder(null);

        jTextFieldColumnIncrementRatioValue.setEditable(false);
        jTextFieldColumnIncrementRatioValue.setText("n/a");
        jTextFieldColumnIncrementRatioValue.setBorder(null);

        jTextFieldMeanGapSizeValue.setEditable(false);
        jTextFieldMeanGapSizeValue.setFont(new java.awt.Font("SansSerif", 0, 10));
        jTextFieldMeanGapSizeValue.setText("n/a");
        jTextFieldMeanGapSizeValue.setBorder(null);

        jTextFieldColumnsUnalignedValue.setEditable(false);
        jTextFieldColumnsUnalignedValue.setFont(new java.awt.Font("SansSerif", 0, 10));
        jTextFieldColumnsUnalignedValue.setText("n/a");
        jTextFieldColumnsUnalignedValue.setBorder(null);

        jTextFieldColumnsAlignedValue.setEditable(false);
        jTextFieldColumnsAlignedValue.setFont(new java.awt.Font("SansSerif", 0, 10));
        jTextFieldColumnsAlignedValue.setText("n/a");
        jTextFieldColumnsAlignedValue.setBorder(null);

        jTextFieldTotalGapPositionsValue.setEditable(false);
        jTextFieldTotalGapPositionsValue.setFont(new java.awt.Font("SansSerif", 0, 10));
        jTextFieldTotalGapPositionsValue.setText("n/a");
        jTextFieldTotalGapPositionsValue.setBorder(null);

        jTextFieldFileName.setEditable(false);
        jTextFieldFileName.setFont(new java.awt.Font("SansSerif", 0, 14));
        jTextFieldFileName.setText("n/a");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel9.setText("Columns only with \"-\" :");

        jTextFieldAllGapColumnsValue.setEditable(false);
        jTextFieldAllGapColumnsValue.setText("n/a");
        jTextFieldAllGapColumnsValue.setBorder(null);

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel10.setText("# of sequences:");

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel11.setText("Longest sequence:");

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel12.setText("Shortest sequence:");

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel13.setText("Total # of bases in all taxas:");

        jTextFieldNumberOfSequencesValue.setEditable(false);
        jTextFieldNumberOfSequencesValue.setText("n/a");
        jTextFieldNumberOfSequencesValue.setBorder(null);

        jTextFieldLongestSequenceValue.setEditable(false);
        jTextFieldLongestSequenceValue.setText("n/a");
        jTextFieldLongestSequenceValue.setBorder(null);

        jTextFieldShortestSequenceValue.setEditable(false);
        jTextFieldShortestSequenceValue.setText("n/a");
        jTextFieldShortestSequenceValue.setBorder(null);

        jTextFieldTotalNumberBasesValue.setEditable(false);
        jTextFieldTotalNumberBasesValue.setText("n/a");
        jTextFieldTotalNumberBasesValue.setBorder(null);

        jLabel14.setText("Potential Synapomorphies:");

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel15.setText("Minimum number of substitutions:");

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel16.setText("Minimum number of gaps:");

        jTextFieldPotentialSynapomorphiesValue.setEditable(false);
        jTextFieldPotentialSynapomorphiesValue.setText("n/a");
        jTextFieldPotentialSynapomorphiesValue.setBorder(null);

        jTextFieldMinimumNumberOfSubsitutionsValue.setEditable(false);
        jTextFieldMinimumNumberOfSubsitutionsValue.setText("n/a");
        jTextFieldMinimumNumberOfSubsitutionsValue.setBorder(null);

        jTextFieldMinimumNumberOfGapsValue.setEditable(false);
        jTextFieldMinimumNumberOfGapsValue.setText("n/a");
        jTextFieldMinimumNumberOfGapsValue.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldFileName, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel3)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldNumberOfSequencesValue, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jTextFieldGlocsaRatingValue, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jTextFieldColumnIncrementRatioValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jTextFieldReciprocalGapBlocksValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jTextFieldMeanColumnRatingValue, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jTextFieldMeanGapSizeValue, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jTextFieldColumnsUnalignedValue, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jTextFieldColumnsAlignedValue, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jTextFieldTotalGapPositionsValue, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jTextFieldLongestSequenceValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jTextFieldShortestSequenceValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jTextFieldTotalNumberBasesValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jTextFieldPotentialSynapomorphiesValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jTextFieldMinimumNumberOfSubsitutionsValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jTextFieldMinimumNumberOfGapsValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jTextFieldAllGapColumnsValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldNumberOfSequencesValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLongestSequenceValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldShortestSequenceValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldTotalNumberBasesValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldAllGapColumnsValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldGlocsaRatingValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMeanColumnRatingValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldReciprocalGapBlocksValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldColumnIncrementRatioValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMeanGapSizeValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldColumnsUnalignedValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldColumnsAlignedValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTotalGapPositionsValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldPotentialSynapomorphiesValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldMinimumNumberOfSubsitutionsValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldMinimumNumberOfGapsValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldGlocsaRatingValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGlocsaRatingValueActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextFieldGlocsaRatingValueActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldAllGapColumnsValue;
    private javax.swing.JTextField jTextFieldColumnIncrementRatioValue;
    private javax.swing.JTextField jTextFieldColumnsAlignedValue;
    private javax.swing.JTextField jTextFieldColumnsUnalignedValue;
    private javax.swing.JTextField jTextFieldFileName;
    private javax.swing.JTextField jTextFieldGlocsaRatingValue;
    private javax.swing.JTextField jTextFieldLongestSequenceValue;
    private javax.swing.JTextField jTextFieldMeanColumnRatingValue;
    private javax.swing.JTextField jTextFieldMeanGapSizeValue;
    private javax.swing.JTextField jTextFieldMinimumNumberOfGapsValue;
    private javax.swing.JTextField jTextFieldMinimumNumberOfSubsitutionsValue;
    private javax.swing.JTextField jTextFieldNumberOfSequencesValue;
    private javax.swing.JTextField jTextFieldPotentialSynapomorphiesValue;
    private javax.swing.JTextField jTextFieldReciprocalGapBlocksValue;
    private javax.swing.JTextField jTextFieldShortestSequenceValue;
    private javax.swing.JTextField jTextFieldTotalGapPositionsValue;
    private javax.swing.JTextField jTextFieldTotalNumberBasesValue;
    // End of variables declaration//GEN-END:variables
    
    public void setRating(GlocsaRating rating) {
        
        this.rating = rating;

        jTextFieldColumnIncrementRatioValue.setText(Double.toString(rating.getColumnIncrementRatio()));
        jTextFieldColumnsAlignedValue.setText(Double.toString(rating.getColumnsAligned()));
        jTextFieldColumnsUnalignedValue.setText(Double.toString(rating.getColumnsNotAligned()));
        jTextFieldReciprocalGapBlocksValue.setText(Double.toString(rating.getGapConcentration()));
        jTextFieldGlocsaRatingValue.setText(Double.toString(rating.getRatingValue()));
        jTextFieldMeanColumnRatingValue.setText(Double.toString(rating.getMeanColumnValue()));
        jTextFieldMeanGapSizeValue.setText(Double.toString(rating.getMeanGapBlockSize()));
        jTextFieldTotalGapPositionsValue.setText(Double.toString(rating.getTotalGapPositions()));

    }
    
    public void setEventCount(EventCount eventCount) {
        
        this.eventCount = eventCount;
        
        jTextFieldPotentialSynapomorphiesValue.setText( Integer.toString(eventCount.getTotalEvents()) );
        jTextFieldMinimumNumberOfSubsitutionsValue.setText( Integer.toString(eventCount.getSubstitutionEvents()));
        jTextFieldMinimumNumberOfGapsValue.setText( Integer.toString(eventCount.getInDelEvents()) );
        
    }
    
    
    public void setDynamicAlignment(DynamicAlignment dynamicAlignment){
        
        this.dynamicAlignment = dynamicAlignment;

        jTextFieldAllGapColumnsValue.setText( Integer.toString(dynamicAlignment.countAllGapColumns()) );
        jTextFieldNumberOfSequencesValue.setText( Integer.toString(dynamicAlignment.getNumberOfSequences()) );
        jTextFieldLongestSequenceValue.setText( Integer.toString(dynamicAlignment.getMaxNumberSymbolsUnAligned()) );
        jTextFieldShortestSequenceValue.setText( Integer.toString(dynamicAlignment.getMinNumberOfSymbolsInTaxa()) );
        jTextFieldTotalNumberBasesValue.setText( Integer.toString(dynamicAlignment.getTotalSymbols()) );
    }
    
    public void setAlignmentFile(File alignmentFile) {
        try {

            this.alignmentFile = alignmentFile;

            jTextFieldFileName.setText(alignmentFile.getCanonicalPath());
        } catch (IOException ex) {
            Logger.getLogger(GlocsaRatingPanel.class.getName()).log(Level.SEVERE, null, ex);
            jTextFieldFileName.setText("Cannot get file name.");
        }
        
    }
    
    
}

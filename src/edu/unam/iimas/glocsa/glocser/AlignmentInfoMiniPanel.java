/*
 * AlignmentInfoMiniPanel.java
 *
 * Created on September 25, 2008, 9:07 PM
 */
package edu.unam.iimas.glocsa.glocser;

import edu.unam.iimas.alignment.Alignment;
import edu.unam.iimas.alignment.DynamicAlignment;

/**
 *
 * @author  xaltonalli
 */
public class AlignmentInfoMiniPanel extends javax.swing.JPanel {
    
    private DynamicAlignment openDynamicAlignment;

    /** Creates new form AlignmentInfoMiniPanel */
    public AlignmentInfoMiniPanel() {
        initComponents();
    }

    public void clearPanel(){
        openDynamicAlignment = null;
        jLabelNumberOfSequencesValue.setText("n/a");
        jLabelColumnsAlignedValue.setText("n/a");
        jLabelColumnsUnalignedValue.setText("n/a");
    }

    public void refreshAllData() {

        jLabelColumnsAlignedValue.setText(Integer.toString(openDynamicAlignment.getMaxPositions()));
        jLabelColumnsUnalignedValue.setText(Integer.toString(openDynamicAlignment.getMaxNumberSymbolsUnAligned()));
        jLabelNumberOfSequencesValue.setText(Integer.toString(openDynamicAlignment.getNumberOfSequences()));
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNumberOfSequences = new javax.swing.JLabel();
        jLabelNumberOfSequencesValue = new javax.swing.JLabel();
        jLabelColumnsAligned = new javax.swing.JLabel();
        jLabelColumnsAlignedValue = new javax.swing.JLabel();
        jLabelColumnsUnaligned = new javax.swing.JLabel();
        jLabelColumnsUnalignedValue = new javax.swing.JLabel();

        jLabelNumberOfSequences.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jLabelNumberOfSequences.setText("# of Seqs.:");

        jLabelNumberOfSequencesValue.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jLabelNumberOfSequencesValue.setText("n/a");

        jLabelColumnsAligned.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10)); // NOI18N
        jLabelColumnsAligned.setText("# of Cols.:");

        jLabelColumnsAlignedValue.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jLabelColumnsAlignedValue.setText("n/a");

        jLabelColumnsUnaligned.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10)); // NOI18N
        jLabelColumnsUnaligned.setText("# of Cols. unal.:");

        jLabelColumnsUnalignedValue.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));
        jLabelColumnsUnalignedValue.setText("n/a");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelNumberOfSequences)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNumberOfSequencesValue, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelColumnsAligned)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelColumnsAlignedValue, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelColumnsUnaligned)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelColumnsUnalignedValue, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelNumberOfSequences)
                .addComponent(jLabelNumberOfSequencesValue)
                .addComponent(jLabelColumnsAligned)
                .addComponent(jLabelColumnsAlignedValue)
                .addComponent(jLabelColumnsUnaligned)
                .addComponent(jLabelColumnsUnalignedValue))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelColumnsAligned;
    private javax.swing.JLabel jLabelColumnsAlignedValue;
    private javax.swing.JLabel jLabelColumnsUnaligned;
    private javax.swing.JLabel jLabelColumnsUnalignedValue;
    private javax.swing.JLabel jLabelNumberOfSequences;
    private javax.swing.JLabel jLabelNumberOfSequencesValue;
    // End of variables declaration//GEN-END:variables

    public DynamicAlignment getOpenDynamicAlignment() {
        return openDynamicAlignment;
    }

    public void setOpenDynanicAlignment(DynamicAlignment openDynamicAlignment) {
        this.openDynamicAlignment = openDynamicAlignment;
    }
}

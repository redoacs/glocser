/*
 * AlignmentOnlyPanel.java
 *
 * Created on January 18, 2008, 9:21 PM
 */
package edu.unam.iimas.glocsa.glocser.alignmentpanel;

import edu.unam.iimas.alignment.DynamicAlignment;
import edu.unam.iimas.glocsa.glocser.GlocserFrame;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author  xaltonalli
 */
public class AlignmentOnlyPanel extends javax.swing.JPanel {

    private DynamicAlignment openDynamicAlignment;
    private AlignmentTableModel alignmentTableModel;
    private BaseCellRenderer baseCellRenderer;
    private DefaultTableCellRenderer headerRenderer;
    private static final int TABSIZE = 3;
    private int columnWidth = 11;
    private AlignmentTableModelHelper alignmentTableModelHelper = null;
    private GlocserFrame glocserFrame = null;
    //private boolean autorefresh = false;
    private HighLightMatrix highLightMatrix;
    private Point lastTNPopUpPosition;
    private TaxaOrderManager taxaOrderManager;

    /** Creates new form AlignmentOnlyPanel */
    public AlignmentOnlyPanel() {

        initComponents();

        //jScrollPaneAlignment.getVerticalScrollBar().setModel(jScrollPaneTaxaNames.getVerticalScrollBar().getModel());
        jScrollPaneTaxaNames.getVerticalScrollBar().setModel(jScrollPaneAlignment.getVerticalScrollBar().getModel());

        headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBorder(BorderFactory.createEmptyBorder());
        headerRenderer.setBackground(this.getBackground());

        lastTNPopUpPosition = new Point();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuTaxaNames = new javax.swing.JPopupMenu();
        jMenuItemMoveTop = new javax.swing.JMenuItem();
        jMenuItemMoveBottom = new javax.swing.JMenuItem();
        jMenuItemMoveHere = new javax.swing.JMenuItem();
        jMenuItemResetOrder = new javax.swing.JMenuItem();
        jMenuItemSortAlphabetically = new javax.swing.JMenuItem();
        jPopupMenuAlignment = new javax.swing.JPopupMenu();
        jMenuItemInvert = new javax.swing.JMenuItem();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPaneTaxaNames = new javax.swing.JScrollPane();
        jTableTaxaNames = new javax.swing.JTable();
        jScrollPaneAlignment = new javax.swing.JScrollPane();
        jTableAlignment = new javax.swing.JTable();

        jMenuItemMoveTop.setText("Move to top");
        jMenuItemMoveTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMoveTopActionPerformed(evt);
            }
        });
        jPopupMenuTaxaNames.add(jMenuItemMoveTop);

        jMenuItemMoveBottom.setText("Move to bottom");
        jMenuItemMoveBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMoveBottomActionPerformed(evt);
            }
        });
        jPopupMenuTaxaNames.add(jMenuItemMoveBottom);

        jMenuItemMoveHere.setText("Move to this position");
        jMenuItemMoveHere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMoveHereActionPerformed(evt);
            }
        });
        jPopupMenuTaxaNames.add(jMenuItemMoveHere);

        jMenuItemResetOrder.setText("Reset original order");
        jMenuItemResetOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemResetOrderActionPerformed(evt);
            }
        });
        jPopupMenuTaxaNames.add(jMenuItemResetOrder);

        jMenuItemSortAlphabetically.setText("Sort alphabetically");
        jMenuItemSortAlphabetically.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSortAlphabeticallyActionPerformed(evt);
            }
        });
        jPopupMenuTaxaNames.add(jMenuItemSortAlphabetically);

        jMenuItemInvert.setText("Invert selection");
        jMenuItemInvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInvertActionPerformed(evt);
            }
        });
        jPopupMenuAlignment.add(jMenuItemInvert);

        jSplitPane1.setDividerLocation(120);

        jScrollPaneTaxaNames.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jTableTaxaNames.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 12));
        jTableTaxaNames.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableTaxaNames.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableTaxaNames.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jTableTaxaNames.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableTaxaNamesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableTaxaNamesMouseReleased(evt);
            }
        });
        jScrollPaneTaxaNames.setViewportView(jTableTaxaNames);

        jSplitPane1.setLeftComponent(jScrollPaneTaxaNames);

        jScrollPaneAlignment.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 12));

        jTableAlignment.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        jTableAlignment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableAlignment.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableAlignment.setCellSelectionEnabled(true);
        jTableAlignment.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTableAlignment.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jTableAlignment.setShowHorizontalLines(false);
        jTableAlignment.setShowVerticalLines(false);
        jTableAlignment.getTableHeader().setResizingAllowed(false);
        jTableAlignment.getTableHeader().setReorderingAllowed(false);
        jTableAlignment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableAlignmentMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableAlignmentMouseReleased(evt);
            }
        });
        jTableAlignment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableAlignmentKeyPressed(evt);
            }
        });
        jScrollPaneAlignment.setViewportView(jTableAlignment);

        jSplitPane1.setRightComponent(jScrollPaneAlignment);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableAlignmentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableAlignmentKeyPressed

        int keyValue = evt.getKeyCode();

        if (keyValue == KeyEvent.VK_SPACE
                || keyValue == KeyEvent.VK_INSERT
                || keyValue == KeyEvent.VK_BACK_SPACE
                || keyValue == KeyEvent.VK_DELETE
                || keyValue == KeyEvent.VK_TAB) {

            int firstSelectedColumn = jTableAlignment.getSelectedColumn();
            int firstSelectedRow = jTableAlignment.getSelectedRow();

            int[] selectedRows = jTableAlignment.getSelectedRows();
            int nSelectedRows = jTableAlignment.getSelectedRowCount();

            int[] selectedColumns = jTableAlignment.getSelectedColumns();
            int nSelectedColumns = jTableAlignment.getSelectedColumnCount();

            int maxPositions = alignmentTableModel.getColumnCount();

            //System.out.println("Selected rows: " + nSelectedRows + " " + Arrays.toString(selectedRows));
            //System.out.println("Selected cols: " + nSelectedColumns + " " + Arrays.toString(selectedColumns));

            boolean isGapInserted = false;
            boolean isGapDeleted = false;

            switch (keyValue) {

                case KeyEvent.VK_INSERT:
                case KeyEvent.VK_SPACE:

                    if (evt.isShiftDown()) {

                        boolean gapAfterExists = true;

                        if (selectedColumns[nSelectedColumns - 1] + 1 < maxPositions) {

                            for (int i = 0; i < nSelectedRows; i++) {
                                gapAfterExists = gapAfterExists && alignmentTableModel.sequenceHasGapIn(selectedRows[i], selectedColumns[nSelectedColumns - 1] + 1);
                            }

                            if (gapAfterExists) {
                                isGapDeleted = alignmentTableModelHelper.deleteGapMultipleRows(selectedRows, selectedColumns[nSelectedColumns - 1] + 1);
                            } else {
                                break;
                            }

                        }

                    }

                    isGapInserted = alignmentTableModelHelper.insertGapMultipleRows(selectedRows, firstSelectedColumn);

                    if (isGapInserted) {
                        firstSelectedColumn++;

                        for (int j = 0; j < nSelectedColumns; j++) {
                            selectedColumns[j]++;
                        }

                        glocserFrame.fireDynamicAlignmentChangedFromAlignmentPanel();
                    }


                    break;

                case KeyEvent.VK_BACK_SPACE:

                    isGapDeleted = alignmentTableModelHelper.deleteGapMultipleRows(selectedRows, firstSelectedColumn - 1);
                    if (isGapDeleted) {
                        firstSelectedColumn--;
                        for (int j = 0; j < nSelectedColumns; j++) {
                            selectedColumns[j]--;
                        }

                        if (evt.isShiftDown()) {
                            isGapInserted = alignmentTableModelHelper.insertGapMultipleRows(selectedRows, selectedColumns[nSelectedColumns - 1] + 1);
                        }

                        glocserFrame.fireDynamicAlignmentChangedFromAlignmentPanel();
                    }

                    break;

                case KeyEvent.VK_DELETE:

                    isGapDeleted = alignmentTableModelHelper.deleteGapMultipleRows(selectedRows, firstSelectedColumn);

                    if (isGapDeleted) {

                        firstSelectedColumn--;

                        if (nSelectedColumns < 2) {
                            //for (int j = 0; j < nSelectedColumns; j++) {
                            //    selectedColumns[j]--;
                            //}
                        } else {
                            int[] selectedColumnsOneLess = new int[nSelectedColumns - 1];
                            for (int i = 0; i < nSelectedColumns - 1; i++) {
                                selectedColumnsOneLess[i] = selectedColumns[i];
                            }
                            selectedColumns = selectedColumnsOneLess;
                        }

                        glocserFrame.fireDynamicAlignmentChangedFromAlignmentPanel();

                    }

                    break;

                case KeyEvent.VK_TAB:

                    boolean tabIsGapInserted = true;

                    for (int k = 0; k < TABSIZE; k++) {

                        if (evt.isShiftDown()) {

                            boolean gapAfterExists = true;

                            if (selectedColumns[nSelectedColumns - 1] + 1 < maxPositions) {

                                for (int i = 0; i < nSelectedRows; i++) {
                                    gapAfterExists = gapAfterExists && alignmentTableModel.sequenceHasGapIn(selectedRows[i], selectedColumns[nSelectedColumns - 1] + 1);
                                }

                                if (gapAfterExists) {
                                    isGapDeleted = alignmentTableModelHelper.deleteGapMultipleRows(selectedRows, selectedColumns[nSelectedColumns - 1] + 1);
                                } else {
                                    break;
                                }

                            }
                        }

                        isGapInserted = alignmentTableModelHelper.insertGapMultipleRows(selectedRows, firstSelectedColumn);

                        if (isGapInserted) {
                            firstSelectedColumn++;

                            for (int j = 0; j < nSelectedColumns; j++) {
                                selectedColumns[j]++;
                            }

                        }

                        tabIsGapInserted = tabIsGapInserted && isGapInserted;
                        if (!tabIsGapInserted) {
                            break;
                        }

                    }

                    if (tabIsGapInserted) {
                        glocserFrame.fireDynamicAlignmentChangedFromAlignmentPanel();
                    }

                    break;



            }

            int nColumns = jTableAlignment.getColumnCount();
            nSelectedColumns = selectedColumns.length;

            //System.out.println("Selected cols: [" + Math.min(selectedColumns[0], nColumns - 1) + " "
            //        + Math.min(selectedColumns[nSelectedColumns - 1], nColumns - 1) + "]");
            jTableAlignment.setColumnSelectionInterval(Math.min(selectedColumns[0], nColumns - 1),
                    Math.min(selectedColumns[nSelectedColumns - 1], nColumns - 1));
            jTableAlignment.setRowSelectionInterval(selectedRows[0], selectedRows[nSelectedRows - 1]);

            //System.out.println(openDynamicAlignment.toString());

            evt.consume();

        }
    }//GEN-LAST:event_jTableAlignmentKeyPressed


    private void jMenuItemMoveTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMoveTopActionPerformed

        TaxaNamesTableModel taxaNamesTM = (TaxaNamesTableModel) jTableTaxaNames.getModel();
        AlignmentTableModel alignmentTM = (AlignmentTableModel) jTableAlignment.getModel();
        //int rowCount = taxaNamesDTM.getRowCount();


        int[] rowIndexes = jTableTaxaNames.getSelectedRows();



        for (int i = 0; i < rowIndexes.length; i++) {
            //System.out.println(rowIndexes[i] + "-" + i);
            taxaOrderManager.moveTaxa(rowIndexes[i], i);
            taxaNamesTM.fireTableDataChanged();
            alignmentTM.fireTableDataChanged();


        }


    }//GEN-LAST:event_jMenuItemMoveTopActionPerformed

    private void jMenuItemMoveBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMoveBottomActionPerformed

        TaxaNamesTableModel taxaNamesTM = (TaxaNamesTableModel) jTableTaxaNames.getModel();
        AlignmentTableModel alignmentTM = (AlignmentTableModel) jTableAlignment.getModel();

        int[] rowIndexes = jTableTaxaNames.getSelectedRows();
        int nSequences = openDynamicAlignment.getNumberOfSequences();

        for (int i = 0; i < rowIndexes.length; i++) {
            //System.out.println(rowIndexes[i] - i + "-" + (nSequences - 1));
            taxaOrderManager.moveTaxa(rowIndexes[i] - i, nSequences - 1);
            taxaNamesTM.fireTableDataChanged();
            alignmentTM.fireTableDataChanged();
        }

    }//GEN-LAST:event_jMenuItemMoveBottomActionPerformed

    private void jMenuItemMoveHereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMoveHereActionPerformed

        TaxaNamesTableModel taxaNamesTM = (TaxaNamesTableModel) jTableTaxaNames.getModel();
        AlignmentTableModel alignmentTM = (AlignmentTableModel) jTableAlignment.getModel();

        int[] rowIndexes = jTableTaxaNames.getSelectedRows();
        int rowHeight = jTableTaxaNames.getRowHeight();
        int yPopUpMenuPosition = (int) lastTNPopUpPosition.getY();
        int nSequences = openDynamicAlignment.getNumberOfSequences();
        int toRowIndex = Math.min((yPopUpMenuPosition / rowHeight), nSequences - 1);

        for (int i = 0; i < rowIndexes.length; i++) {

            if (toRowIndex < rowIndexes[i]) {

                //System.out.println(rowIndexes[i] + "-" + toRowIndex + i);
                taxaOrderManager.moveTaxa(rowIndexes[i], toRowIndex + i);
                taxaNamesTM.fireTableDataChanged();
                alignmentTM.fireTableDataChanged();

            } else {

                //System.out.println(rowIndexes[i] - i + "-" + (toRowIndex + 1));
                taxaOrderManager.moveTaxa(rowIndexes[i] - i, toRowIndex);
                taxaNamesTM.fireTableDataChanged();
                alignmentTM.fireTableDataChanged();

            }

        }

    }//GEN-LAST:event_jMenuItemMoveHereActionPerformed

    private void jTableTaxaNamesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTaxaNamesMousePressed

        if (evt.isPopupTrigger()) {
            jPopupMenuTaxaNames.show(evt.getComponent(), evt.getX(), evt.getY());
            lastTNPopUpPosition.setLocation(evt.getX(), evt.getY());


        }

    }//GEN-LAST:event_jTableTaxaNamesMousePressed

    private void jTableTaxaNamesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTaxaNamesMouseReleased

        if (evt.isPopupTrigger()) {
            jPopupMenuTaxaNames.show(evt.getComponent(), evt.getX(), evt.getY());
            lastTNPopUpPosition.setLocation(evt.getX(), evt.getY());


        }

    }//GEN-LAST:event_jTableTaxaNamesMouseReleased

    private void jMenuItemResetOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemResetOrderActionPerformed

        TaxaNamesTableModel taxaNamesTM = (TaxaNamesTableModel) jTableTaxaNames.getModel();
        AlignmentTableModel alignmentTM = (AlignmentTableModel) jTableAlignment.getModel();

        taxaOrderManager.resetOriginalOrder();

        taxaNamesTM.fireTableDataChanged();
        alignmentTM.fireTableDataChanged();

    }//GEN-LAST:event_jMenuItemResetOrderActionPerformed

    private void jMenuItemSortAlphabeticallyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSortAlphabeticallyActionPerformed
        TaxaNamesTableModel taxaNamesTM = (TaxaNamesTableModel) jTableTaxaNames.getModel();
        AlignmentTableModel alignmentTM = (AlignmentTableModel) jTableAlignment.getModel();

        taxaOrderManager.sortAlphabetically();

        taxaNamesTM.fireTableDataChanged();
        alignmentTM.fireTableDataChanged();
    }//GEN-LAST:event_jMenuItemSortAlphabeticallyActionPerformed

    private void jTableAlignmentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAlignmentMousePressed
        if (evt.isPopupTrigger()) {
            jPopupMenuAlignment.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTableAlignmentMousePressed

    private void jMenuItemInvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInvertActionPerformed

        int selectedRows[] = jTableAlignment.getSelectedRows();
        int nSelectedRows = selectedRows.length;
        int selectedColumns[] = jTableAlignment.getSelectedColumns();
        int nSelectedColumns = selectedColumns.length;

        /*
         * assuming multiple seltections are not possible
         */

        for (int i = 0; i < nSelectedRows; i++) {

            alignmentTableModelHelper.invertRegion(
                    selectedRows[i],
                    openDynamicAlignment.getSymbolofPositionInAlignment(selectedRows[i], selectedColumns[0]),
                    openDynamicAlignment.getSymbolofPositionInAlignment(selectedRows[i], selectedColumns[nSelectedColumns-1])
                    );

        }

    }//GEN-LAST:event_jMenuItemInvertActionPerformed

    private void jTableAlignmentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAlignmentMouseReleased

        if (evt.isPopupTrigger()) {
            jPopupMenuAlignment.show(evt.getComponent(), evt.getX(), evt.getY());
        }

    }//GEN-LAST:event_jTableAlignmentMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItemInvert;
    private javax.swing.JMenuItem jMenuItemMoveBottom;
    private javax.swing.JMenuItem jMenuItemMoveHere;
    private javax.swing.JMenuItem jMenuItemMoveTop;
    private javax.swing.JMenuItem jMenuItemResetOrder;
    private javax.swing.JMenuItem jMenuItemSortAlphabetically;
    private javax.swing.JPopupMenu jPopupMenuAlignment;
    private javax.swing.JPopupMenu jPopupMenuTaxaNames;
    private javax.swing.JScrollPane jScrollPaneAlignment;
    private javax.swing.JScrollPane jScrollPaneTaxaNames;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTableAlignment;
    private javax.swing.JTable jTableTaxaNames;
    // End of variables declaration//GEN-END:variables

    public void loadAlignmentTable() {

        //System.out.println(openDynamicAlignment);

        highLightMatrix = new HighLightMatrix(openDynamicAlignment); //First load of the alignment, no highligths
        DefaultAlignmentColorScheme colorScheme = new DefaultAlignmentColorScheme();
        baseCellRenderer = new BaseCellRenderer(colorScheme, highLightMatrix);



        int maxPositions = openDynamicAlignment.getMaxPositions();
        ArrayList<ArrayList<Character>> sequencesData = openDynamicAlignment.getAlignedMatrix();

        ArrayList<Character> columnHeaders = ColumnHeaderHelper.computeColumnHeaders(maxPositions);

        alignmentTableModel = new AlignmentTableModel(sequencesData, columnHeaders);


        jTableAlignment.setModel(alignmentTableModel);
        alignmentTableModel.fireTableStructureChanged();

        alignmentTableModelHelper = new AlignmentTableModelHelper(jTableAlignment.getColumnModel(), alignmentTableModel, baseCellRenderer, headerRenderer, columnWidth, openDynamicAlignment);

        alignmentTableModelHelper.formatColumns();



    }

//    public void loadTaxaNamesTable() {
//
//        int numberOfSequences = openDynamicAlignment.getNumberOfSequences();
//        String[] names = new String[numberOfSequences];
//        names = openDynamicAlignment.getTaxaNames().toArray(names);
//        int largestName = 0;
//
//        //Object[][] objectModel = new Object[numberOfSequences + 1][2];
//        Object[][] objectModel = new Object[numberOfSequences][2];
//
//        for (int i = 0; i < numberOfSequences; i++) {
//            objectModel[i][0] = new Integer(i).toString();
//            objectModel[i][1] = names[i];
//            if (names[i].length() > largestName) {
//                largestName = names[i].length();
//            }
//        }
//        //objectModel[numberOfSequences][0] = "";
//        //objectModel[numberOfSequences][1] = "";
//
//        String[] columnNames = new String[2];
//        columnNames[0] = "#";
//        columnNames[1] = "Taxa";
//
//        DefaultTableModel tableModelTaxaNames = new DefaultTableModel(objectModel, columnNames);
//
//        jTableTaxaNames.setModel(tableModelTaxaNames);
//        tableModelTaxaNames.fireTableStructureChanged();
//
//        TableColumnModel tableColumnModel = jTableTaxaNames.getColumnModel();
//
//        TableColumn tableColumn = null;
//
//        int numberCWM = new Integer(numberOfSequences).toString().length();
//        tableColumn = tableColumnModel.getColumn(0);
//        tableColumn.setMinWidth(numberCWM * columnWidth);
//        tableColumn.setMaxWidth(numberCWM * columnWidth);
//        tableColumn.setPreferredWidth(numberCWM * columnWidth);
//        tableColumn.setResizable(false);
//
//        tableColumn = tableColumnModel.getColumn(1);
//        tableColumn.setMinWidth(largestName * columnWidth);
//        tableColumn.setMaxWidth(largestName * columnWidth);
//        tableColumn.setPreferredWidth(largestName * columnWidth);
//        tableColumn.setResizable(false);
//
//        jTableTaxaNames.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//        jTableTaxaNames.setRowSelectionInterval(0, 0);
//        jTableTaxaNames.setColumnSelectionInterval(0, 0);
//
//
//
//    }
    public void loadTaxaNamesTable() {

        int numberOfSequences = openDynamicAlignment.getNumberOfSequences();
        taxaOrderManager = new TaxaOrderManager(openDynamicAlignment, highLightMatrix);

        ArrayList<String> taxaNames = openDynamicAlignment.getSequenceNames();

        int largestNameLength = 0;
        int nameLength = 0;

        for (int i = 0; i < numberOfSequences; i++) {
            nameLength = taxaNames.get(i).length();

            if (nameLength > largestNameLength) {
                largestNameLength = nameLength;


            }
        }

        TaxaNamesTableModel tableModelTaxaNames = new TaxaNamesTableModel(taxaNames);

        jTableTaxaNames.setModel(tableModelTaxaNames);
        tableModelTaxaNames.fireTableStructureChanged();

        TableColumnModel tableColumnModel = jTableTaxaNames.getColumnModel();

        TableColumn tableColumn = null;



        int numberCWM = new Integer(numberOfSequences).toString().length();
        tableColumn = tableColumnModel.getColumn(0);
        //tableColumn.setMinWidth(numberCWM * columnWidth);
        //tableColumn.setMaxWidth(numberCWM * columnWidth);
        tableColumn.setPreferredWidth(numberCWM * columnWidth);
        //tableColumn.setResizable(false);

        tableColumn = tableColumnModel.getColumn(1);
        //tableColumn.setMinWidth(largestName * columnWidth);
        //tableColumn.setMaxWidth(largestName * columnWidth);
        tableColumn.setPreferredWidth(largestNameLength * columnWidth);
        //tableColumn.setResizable(false);

        jTableTaxaNames.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jTableTaxaNames.setRowSelectionInterval(0, 0);
        jTableTaxaNames.setColumnSelectionInterval(0, 0);





    }

    public void clearPanel() {
        openDynamicAlignment = null;

        jTableAlignment.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{}));

        jTableTaxaNames.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{}));



    }

//    public void regenerateAlignmentEvaluation() {
//
//        openDynamicAlignment = alignmentTableModelHelper.convertModelToAlignment();
//        highLightMatrix.setAlignmentGapsChanged(openDynamicAlignment);
//        glocserFrame.setOpenAlignment(openDynamicAlignment);
//        glocserFrame.reEvaluateAndRefresh();
//    }
    public BaseCellRenderer getBaseCellRenderer() {
        return baseCellRenderer;


    }

    public void setBaseCellRenderer(BaseCellRenderer baseCellRenderer) {
        this.baseCellRenderer = baseCellRenderer;


    }

    /**
     * @return the glocserFrame
     */
    public GlocserFrame getGlocserFrame() {
        return glocserFrame;


    }

    /**
     * @param glocserFrame the glocserFrame to set
     */
    public void setGlocserFrame(GlocserFrame glocserFrame) {
        this.glocserFrame = glocserFrame;


    }

//    /**
//     * @return the autorefresh
//     */
//    public boolean isAutorefresh() {
//        return autorefresh;
//    }
//
//    /**
//     * @param autorefresh the autorefresh to set
//     */
//    public void setAutorefresh(boolean autorefresh) {
//        this.autorefresh = autorefresh;
//    }
    /**
     * @return the highLightMatrix
     */
    public HighLightMatrix getHighLightMatrix() {
        return highLightMatrix;


    }

    /**
     * @param highLightMatrix the highLightMatrix to set
     */
    public void setHighLightMatrix(HighLightMatrix highLightMatrix) {
        this.highLightMatrix = highLightMatrix;


    }

    public void fireAlignmentTableRegionUpdated(int sequence, int unalignedStartPosition, int length) {

        //System.out.println("sequence: " + sequence + " unalignedStartPosition: " + unalignedStartPosition + " length: " + length);
        int position;


        for (int i = 0; i < length; i++) {
            position = openDynamicAlignment.getPositionOfSymbolInAlignment(sequence, unalignedStartPosition + i);
            alignmentTableModel.fireCellUpdated(sequence, position);
        }

    }

    public void highlightRegion(int sequence, int unalignedStartPosition, int length) {

        highLightMatrix.flagHighlightRegion(sequence, unalignedStartPosition, length);
        fireAlignmentTableRegionUpdated(sequence, unalignedStartPosition, length);

    }

    public void downlightRegion(int sequence, int unalignedStartPosition, int length) {

        highLightMatrix.flagDownlightRegion(sequence, unalignedStartPosition, length);
        fireAlignmentTableRegionUpdated(sequence, unalignedStartPosition, length);

    }

    public void clearHighLigths() {

        ArrayList<Integer[]> highlightList = highLightMatrix.getHighlightList();

        int nHLItems = highlightList.size();
        Integer[] highlightItem = null;

        for (int i = 0; i < nHLItems; i++) {
            highlightItem = highlightList.get(i);

            downlightRegion(highlightItem[0], highlightItem[1], highlightItem[2]);
        }

        highLightMatrix.setIsSomethingHighlighted(false);

    }

    /**
     * @param openDynamicAlignment the openDynamicAlignment to set
     */
    public void setOpenDynamicAlignment(DynamicAlignment openDynamicAlignment) {
        this.openDynamicAlignment = openDynamicAlignment;


    }

    public void selectSymbolsInSequence(int sequenceNumber, int startUnAlignedPosition, int length) {

        int startPosition = startUnAlignedPosition + openDynamicAlignment.getGapOffsetMatrix().get(sequenceNumber).get(startUnAlignedPosition);


        int stopPosition = startUnAlignedPosition + length - 1 + openDynamicAlignment.getGapOffsetMatrix().get(sequenceNumber).get(startUnAlignedPosition + length - 1);

        jTableAlignment.setColumnSelectionInterval(startPosition, stopPosition);
        jTableAlignment.setRowSelectionInterval(sequenceNumber, sequenceNumber);



    }

    public void selectPositionAlignment(int sequence, int position) {

        jTableAlignment.setRowSelectionInterval(sequence, sequence);
        jTableAlignment.setColumnSelectionInterval(position, position);


    }
}

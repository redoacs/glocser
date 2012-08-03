/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unam.iimas.glocsa.glocser.alignmentpanel;

import edu.unam.iimas.alignment.Alignment;
import edu.unam.iimas.alignment.DynamicAlignment;
import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author xaltonalli
 */
public class AlignmentTableModelHelper {

    private TableColumnModel tableColumnModel;
    private AlignmentTableModel tableModel;
    private BaseCellRenderer baseCellRenderer;
    private DefaultTableCellRenderer headerRenderer;
    private int columnWidth;
    private DynamicAlignment dynamicAlignment;
    private ArrayList<ArrayList<Character>> alignedMatrix;
    private ArrayList<ArrayList<Character>> unAlignedMatrix;
    private ArrayList<ArrayList<Integer>> gapOffsetMatrix; //symIndex -> position
    private ArrayList<ArrayList<Integer>> symIndexMatrix; //position -> symIndex
    private ArrayList<Integer> numberSymbolsPerTaxa; //numer of symbols per taxa

    public AlignmentTableModelHelper(
            TableColumnModel tableColumnModel,
            AlignmentTableModel tableModel,
            BaseCellRenderer baseCellRenderer,
            DefaultTableCellRenderer headerRenderer,
            int columnWidth,
            DynamicAlignment dynamicAlignment) {
        this.tableColumnModel = tableColumnModel;
        this.tableModel = tableModel;
        this.baseCellRenderer = baseCellRenderer;
        this.headerRenderer = headerRenderer;
        this.columnWidth = columnWidth;
        this.dynamicAlignment = dynamicAlignment;
        this.alignedMatrix = dynamicAlignment.getAlignedMatrix();
        this.unAlignedMatrix = dynamicAlignment.getUnAlignedMatrix();
        this.gapOffsetMatrix = dynamicAlignment.getGapOffsetMatrix();
        this.symIndexMatrix = dynamicAlignment.getSymIndexMatrix();
        this.numberSymbolsPerTaxa = dynamicAlignment.getNumberSymbolsPerSequence();

    }

    public boolean deleteGapSingleRow(int sequenceNumber, int columnNumber) {

        boolean sequenceHasGapIn = tableModel.sequenceHasGapIn(sequenceNumber, columnNumber);

        ArrayList<Character> sequenceData = tableModel.getSequencesData().get(sequenceNumber);
        int maxPosition = sequenceData.size();
        boolean isGapDeleted = false;

        if (sequenceHasGapIn) {

            sequenceData.remove(columnNumber);
            sequenceData.add(maxPosition - 1, Alignment.GAP);
            updateDynamicAlignmentDataDeleteGap(sequenceNumber, columnNumber);
            isGapDeleted = true;
            tableModel.fireTableDataChanged();

        }

        return isGapDeleted;

    }

    public boolean deleteGapMultipleRows(int[] selectedSequences, int firstSelectedColumn) {

        int nSelectedSequences = selectedSequences.length;

        boolean sequenceHasGapIn = false;
        boolean allSequencesHaveGapIn = true;
        for (int i = 0; i < nSelectedSequences; i++) {
            sequenceHasGapIn = tableModel.sequenceHasGapIn(selectedSequences[i], firstSelectedColumn);
            if (!sequenceHasGapIn) {
                allSequencesHaveGapIn = false;
                break;
            }
        }

        if (allSequencesHaveGapIn) {

            ArrayList<Character> sequenceData = null;
            int maxPosition = 0;
            for (int i = 0; i < nSelectedSequences; i++) {

                sequenceData = tableModel.getSequencesData().get(selectedSequences[i]);
                maxPosition = sequenceData.size();
                sequenceData.remove(firstSelectedColumn);
                sequenceData.add(maxPosition - 1, Alignment.GAP);
                updateDynamicAlignmentDataDeleteGap(selectedSequences[i], firstSelectedColumn);
                tableModel.fireTableDataChanged();

            }

        }

        return allSequencesHaveGapIn;

    }

    private void updateDynamicAlignmentDataDeleteGap(int sequenceNumber, int columnNumber) {

        ArrayList<Integer> symIndexMatrixLine = symIndexMatrix.get(sequenceNumber);
        ArrayList<Integer> gapOffsetMatrixLine = gapOffsetMatrix.get(sequenceNumber);

        int initSymIndex = symIndexMatrixLine.get(columnNumber);
        int gapOffset;
        int numberSymbols = numberSymbolsPerTaxa.get(sequenceNumber);

        for (int j = initSymIndex + 1; j < numberSymbols; j++) {
            gapOffset = gapOffsetMatrixLine.get(j);
            gapOffsetMatrixLine.set(j, gapOffset - 1);
        }

        int maxPositions = dynamicAlignment.getMaxPositions();

        symIndexMatrixLine.add(symIndexMatrixLine.get(maxPositions - 1));
        symIndexMatrixLine.remove(columnNumber);

    }

    public boolean insertGapMultipleRows(int[] selectedRows, int firstSelectedColumn) {

        int nSelectedRows = selectedRows.length;
        boolean isGapInserted = false;
        boolean singleGapInserted = false;

        for (int i = 0; i < nSelectedRows; i++) {
            singleGapInserted = this.insertGapSingleRow(selectedRows[i], firstSelectedColumn);
            isGapInserted = isGapInserted || singleGapInserted;
        }

        return isGapInserted;
    }

    public boolean insertGapSingleRow(int sequenceNumber, int columnNumber) {

        boolean sequenceEndsInGap = tableModel.sequenceEndsInGap(sequenceNumber);

        ArrayList<Character> sequenceData = tableModel.getSequencesData().get(sequenceNumber);
        int maxPosition = sequenceData.size();
        boolean isGapInserted = true;

        if (sequenceEndsInGap) {
            // Insert gap in selected position, and delete gap at end; columns are not modified
            sequenceData.add(columnNumber, Alignment.GAP);
            sequenceData.remove(maxPosition);
            updateDynamicAlignmentDataInsertGapSameColumns(sequenceNumber, columnNumber);
            tableModel.fireTableDataChanged();

            //if sequenceEndsInGap and the insertion point is in the last position, it's like it didn't do anything
            //TODO In general when the insert position is in trailing gap it is like it didn't do anything, any operation is redundant
            isGapInserted = columnNumber == maxPosition - 1 ? false : true;

        } else {
            // Add new column, insert gap in all columns ends, and then do as if the unAlignedSequence ends in gap
            appendGapColumn();
            sequenceData.add(columnNumber, Alignment.GAP);
            sequenceData.remove(maxPosition + 1);
            updateDynamicAlignmentDataInsertGapInsertColumn(sequenceNumber, columnNumber);
            tableModel.fireTableStructureChanged();
            //tableModel.fireTableDataChanged();
            //TODO Does it have to format all the columns ?
            formatColumns();

        }

        return isGapInserted;

    }

    private void updateDynamicAlignmentDataInsertGapSameColumns(int sequenceNumber, int columnNumber) {

        ArrayList<Integer> symIndexMatrixLine = symIndexMatrix.get(sequenceNumber);
        ArrayList<Integer> gapOffsetMatrixLine = gapOffsetMatrix.get(sequenceNumber);

        //int initSymIndex = symIndexMatrixLine.get(columnNumber);
        int initSymIndex = Math.max(symIndexMatrixLine.get(columnNumber),0);
        int gapOffset;
        int numberSymbols = numberSymbolsPerTaxa.get(sequenceNumber);

        for (int j = initSymIndex; j < numberSymbols; j++) {

//            if(j<0) {
//                gapOffset = gapOffsetMatrixLine.get(0);
//            } else {
//                gapOffset = gapOffsetMatrixLine.get(j);
//            }
            gapOffset = gapOffsetMatrixLine.get(j);

            gapOffsetMatrixLine.set(j, gapOffset + 1);
        }

        int maxPositions = dynamicAlignment.getMaxPositions();

        if (columnNumber > 0) {
            symIndexMatrixLine.add(columnNumber, symIndexMatrixLine.get(columnNumber - 1));
        } else {
            symIndexMatrixLine.add(columnNumber, -1);
        }

        //symIndexMatrixLine.add(columnNumber, symIndexMatrixLine.get(columnNumber - 1));

        symIndexMatrixLine.remove(maxPositions);

        //System.out.println(dynamicAlignment.toString());

    }

    private void updateDynamicAlignmentDataInsertGapInsertColumn(int sequenceNumber, int columnNumber) {

        //symIndexMatrix and gapOffsetMatrix are for the matrix before the insertion
        ArrayList<Integer> symIndexMatrixLine = symIndexMatrix.get(sequenceNumber);
        ArrayList<Integer> gapOffsetMatrixLine = gapOffsetMatrix.get(sequenceNumber);

        //int initSymIndex = symIndexMatrixLine.get(columnNumber);
        int initSymIndex = Math.max(symIndexMatrixLine.get(columnNumber),0);
        int gapOffset;
        int numberSymbols = numberSymbolsPerTaxa.get(sequenceNumber);

        for (int j = initSymIndex; j < numberSymbols; j++) {

//            if(j<0) {
//                gapOffset = gapOffsetMatrixLine.get(0);
//            } else {
//                gapOffset = gapOffsetMatrixLine.get(j);
//            }
            gapOffset = gapOffsetMatrixLine.get(j);
            

            gapOffsetMatrixLine.set(j, gapOffset + 1);
        }

        /**
         * Update symIndexMatrix , this one have to grow:
         *
         * In the lines where no gap was inserted: Duplicate the last value (to reflect the addition of trailing gap)
         *
         * In the line where the gap was inserted: Duplicate contiguosly the value at the insertion point
         *
         */
        int maxPositions = dynamicAlignment.getMaxPositions(); //maxPositions has not been updated yet
        int numberOfSequences = dynamicAlignment.getNumberOfSequences();
        int totalGaps = dynamicAlignment.getTotalGaps();

        for (int i = 0; i < numberOfSequences; i++) {
            symIndexMatrixLine = symIndexMatrix.get(i);
            if (i != sequenceNumber) {
                symIndexMatrixLine.add(symIndexMatrixLine.get(maxPositions - 1));
            } else {

                if (columnNumber > 0) {
                    symIndexMatrixLine.add(columnNumber, symIndexMatrixLine.get(columnNumber - 1));
                } else {
                    symIndexMatrixLine.add(columnNumber, -1);
                }

//                symIndexMatrixLine.add(columnNumber, symIndexMatrixLine.get(columnNumber - 1));

            }
        }

        dynamicAlignment.setMaxPositions(maxPositions + 1);
        dynamicAlignment.setTotalGaps(totalGaps + numberOfSequences - 1);


        //System.out.println(dynamicAlignment.toString());

    }

    private void appendGapColumn() {

        int nColumns = tableColumnModel.getColumnCount();
        TableColumn tableColumn = new TableColumn(nColumns, columnWidth, baseCellRenderer, null);
        tableColumn.setHeaderRenderer(headerRenderer);
        tableColumn.setMinWidth(columnWidth);
        tableColumn.setMaxWidth(columnWidth);
        tableColumn.setPreferredWidth(columnWidth);
        tableColumn.setResizable(false);
        tableColumnModel.addColumn(tableColumn);

        tableModel.appendGapColumn();

    }

    public void formatColumns() {

        TableColumn tableColumn = null;

        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            tableColumn = tableColumnModel.getColumn(i);
            tableColumn.setMinWidth(columnWidth);
            tableColumn.setMaxWidth(columnWidth);
            tableColumn.setPreferredWidth(columnWidth);
            tableColumn.setResizable(false);
            tableColumn.setHeaderRenderer(headerRenderer);
            tableColumn.setCellRenderer(baseCellRenderer);
        }
    }

    public void invertRegion(int sequenceIndex, int initialSymbol, int finalSymbol) {

        if (finalSymbol >= numberSymbolsPerTaxa.get(sequenceIndex)) {
            throw new RuntimeException("Final symbol index surpass sequence boundaries");
        }

        //System.out.println("To be inverted: s:" + sequenceIndex + " [" + initialSymbol + "," + finalSymbol + "]");

        ArrayList<Character> region = new ArrayList<Character>(finalSymbol - initialSymbol);

        for (int i = initialSymbol ; i <= finalSymbol ; i++) {
            region.add(unAlignedMatrix.get(sequenceIndex).get(i));
        }

        //System.out.println(region);

        ArrayList<Character> invertedRegion = invertCharacterAList(region);

        //System.out.println(invertedRegion);

        //replaceRegion(sequenceIndex, initialSymbol, finalSymbol, invertedRegion);

        ArrayList<Character> unAlignedSequence = unAlignedMatrix.get(sequenceIndex);
        ArrayList<Character> alignedSequence = alignedMatrix.get(sequenceIndex);

        Character newSymbol;
        int symbolPosition;
        for (int i = initialSymbol, j = 0 ; i <= finalSymbol ; i++, j++) {
            newSymbol = invertedRegion.get(j);
            unAlignedSequence.set(i, newSymbol);
            symbolPosition = dynamicAlignment.getPositionOfSymbolInAlignment(sequenceIndex, i);
            alignedSequence.set(symbolPosition,newSymbol);
            tableModel.fireCellUpdated(sequenceIndex, symbolPosition);
        }
        
    }

    public ArrayList<Character> invertCharacterAList(ArrayList<Character> region) {

        int regionSize = region.size();
        ArrayList<Character> invertedRegion = new ArrayList<Character>(regionSize);

        Character base;
        for (int i = regionSize-1 ; i > -1 ; i--) {
            base = region.get(i);
            switch(base) {
                case 'A':
                    base = 'T';
                    break;
                case 'T':
                    base = 'A';
                    break;
                case 'G':
                    base = 'C';
                    break;
                case 'C':
                    base = 'G';
                    break;
            }
            invertedRegion.add(base);
        }

        return invertedRegion;

    }

    public void replaceRegion(int sequenceIndex, int initialSymbol, int finalSymbol, ArrayList<Character> region) {

        if (finalSymbol-initialSymbol+1 != region.size()) {
            throw new RuntimeException("Region size does not match symbol boundaries");
        }

        if (finalSymbol >= numberSymbolsPerTaxa.get(sequenceIndex)) {
            throw new RuntimeException("Final symbol index surpass sequence boundaries");
        }

        ArrayList<Character> unAlignedSequence = unAlignedMatrix.get(sequenceIndex);
        ArrayList<Character> alignedSequence = alignedMatrix.get(sequenceIndex);

        Character newSymbol;
        for (int i = initialSymbol, j = 0 ; i <= finalSymbol ; i++, j++) {
            newSymbol = region.get(j);
            unAlignedSequence.set(i, newSymbol);
            alignedSequence.set(
                    dynamicAlignment.getPositionOfSymbolInAlignment(sequenceIndex, i),
                    newSymbol);
        }

    }

}

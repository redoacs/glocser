/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unam.iimas.glocsa.glocser.alignmentpanel;

import edu.unam.iimas.alignment.Alignment;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author xaltonalli
 */
public class AlignmentTableModel extends AbstractTableModel {

    //The Size of columnHeaders must be kept in sync with the size of al sequences, and viceversa.
    private ArrayList<ArrayList<Character>> sequencesData;
    private ArrayList<Character> columnHeaders;

    public AlignmentTableModel(ArrayList<ArrayList<Character>> sequencesData, ArrayList<Character> columnHeaders) {

        int columnHeadersSize = columnHeaders.size();
        int sequenceNumber = sequencesData.size();

        for (int i = 0; i < sequenceNumber; i++) {
            if (sequencesData.get(i).size() != columnHeadersSize) {
                throw new RuntimeException("Different size of sequence " + i + " and Column Header");
            }
        }

        this.sequencesData = sequencesData;
        this.columnHeaders = columnHeaders;


    }

    public boolean sequenceEndsInGap(int sequenceNumber) {

        ArrayList<Character> sequenceData = sequencesData.get(sequenceNumber);
        Character lastPosition = sequenceData.get(sequenceData.size()-1);

        return lastPosition == Alignment.GAP ? true : false;

    }



    public boolean sequenceHasGapIn(int sequenceNumber, int position) {

        ArrayList<Character> sequenceData = sequencesData.get(sequenceNumber);
        Character charPosition = sequenceData.get(position);

        return charPosition == Alignment.GAP ? true : false;

    }

    public void appendGapColumn(){
        for (Iterator<ArrayList<Character>> it = sequencesData.iterator(); it.hasNext();) {
            ArrayList<Character> sequence = it.next();
            sequence.add(Alignment.GAP);
        }
        columnHeaders.add(ColumnHeaderHelper.computeColumnHeaderChar(columnHeaders.size()));
    }

    public void moveRow(int fromRowIndex, int toRowIndex) {
        ArrayList<Character> aSequence = sequencesData.get(fromRowIndex);
        sequencesData.remove(fromRowIndex);
        sequencesData.add(toRowIndex, aSequence);

        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return sequencesData.size();
    }

    @Override
    public int getColumnCount() {
        return columnHeaders.size();
    }

    @Override
    public Character getValueAt(int rowIndex, int columnIndex) {
        return sequencesData.get(rowIndex).get(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnHeaders.get(column).toString();
    }

    /**
     * @return the sequencesData
     */
    public ArrayList<ArrayList<Character>> getSequencesData() {
        return sequencesData;
    }

    /**
     * @param sequencesData the sequencesData to set
     */
    public void setSequencesData(ArrayList<ArrayList<Character>> sequencesData) {
        this.sequencesData = sequencesData;
    }

    /**
     * @return the columnHeaders
     */
    public ArrayList<Character> getColumnHeaders() {
        return columnHeaders;
    }

    /**
     * @param columnHeaders the columnHeaders to set
     */
    public void setColumnHeaders(ArrayList<Character> columnHeaders) {
        this.columnHeaders = columnHeaders;
    }

    public void fireCellUpdated(int sequence, int position){
        fireTableCellUpdated(sequence, position);
    }
}

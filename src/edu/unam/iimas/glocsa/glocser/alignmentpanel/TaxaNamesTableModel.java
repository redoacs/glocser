/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unam.iimas.glocsa.glocser.alignmentpanel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author xaltonalli
 */
public class TaxaNamesTableModel extends AbstractTableModel {

    private ArrayList<String> taxaNames;
    private ArrayList<String> taxaNumber;

    public TaxaNamesTableModel(ArrayList<String> taxaNames) {
        this.taxaNames = taxaNames;
        int size = taxaNames.size();
        taxaNumber = new ArrayList<String>(size);
        for (int i = 0; i < size; i++) {
            taxaNumber.add(Integer.toString(i));
        }
    }

    @Override
    public int getRowCount() {
        return taxaNames.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex < 0 || columnIndex > 2) {
            throw new IndexOutOfBoundsException("This table has two columns");
        }
        Object value = null;

        if (columnIndex == 0) {
            value = taxaNumber.get(rowIndex);
        } else {
            value = taxaNames.get(rowIndex);
        }

        return value;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex < 0 || columnIndex > 1) {
            throw new IndexOutOfBoundsException("This table has two columns");
        }
        String name = null;

        if (columnIndex == 0) {
            name = "#";
        } else {
            name = "Taxa";
        }

        return name;
    }

    public void moveRow(int fromRowIndex, int toRowIndex) {

        String aTaxaName = taxaNames.get(fromRowIndex);
        taxaNames.remove(fromRowIndex);
        taxaNames.add(toRowIndex, aTaxaName);

        fireTableDataChanged();

    }

    @Override
    public boolean isCellEditable(int row, int col) {

        boolean isEditable = false;
        if(col == 1) isEditable = true;

        return isEditable;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        taxaNames.set(row, value.toString());
        fireTableCellUpdated(row, col);
    }

}

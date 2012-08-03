/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unam.iimas.glocsa.glocser.alignmentpanel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author xaltonalli
 */
public class BaseCellRenderer extends DefaultTableCellRenderer {

    private static final Border SAFE_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
    private AlignmentColorScheme colorScheme;
    boolean isSelected = false;
    private HighLightMatrix highLightMatrix;

    public BaseCellRenderer(AlignmentColorScheme colorScheme, HighLightMatrix aHighLightMatrix) {
        this.colorScheme = colorScheme;
        highLightMatrix = aHighLightMatrix;
    }

    private static Border getNoFocusBorder() {
        if (System.getSecurityManager() != null) {
            return SAFE_NO_FOCUS_BORDER;
        } else {
            return noFocusBorder;
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        Color fg = null;
        Color bg = null;

        JTable.DropLocation dropLocation = table.getDropLocation();
        if (dropLocation != null && !dropLocation.isInsertRow() && !dropLocation.isInsertColumn() && dropLocation.getRow() == row && dropLocation.getColumn() == column) {

            fg = UIManager.getColor("Table.dropCellForeground");
            bg = UIManager.getColor("Table.dropCellBackground");

            isSelected = true;
        }

        if (isSelected) {
            super.setForeground(fg == null ? table.getSelectionForeground()
                    : fg);
            super.setBackground(bg == null ? table.getSelectionBackground()
                    : bg);
        } else {

            Color[] colors = findColors(value.toString(), highLightMatrix.isCellHighLighted(row, column));
            
            super.setForeground(colors[1] != null
                    ? colors[1]
                    : table.getForeground());
            super.setBackground(colors[0] != null
                    ? colors[0]
                    : table.getBackground());
        }

        setFont(table.getFont());

        if (hasFocus) {
            Border border = null;
            if (isSelected) {
                border = UIManager.getBorder("Table.focusSelectedCellHighlightBorder");
            }
            if (border == null) {
                border = UIManager.getBorder("Table.focusCellHighlightBorder");
            }
            setBorder(border);

            if (!isSelected && table.isCellEditable(row, column)) {
                Color col;
                col = UIManager.getColor("Table.focusCellForeground");
                if (col != null) {
                    super.setForeground(col);
                }
                col = UIManager.getColor("Table.focusCellBackground");
                if (col != null) {
                    super.setBackground(col);
                }
            }
        } else {
            setBorder(getNoFocusBorder());
        }

        setValue(value);

        return this;
    }

    private Color[] findColors(String value, boolean isCellHighLighted) {

        //color[0] - Background Color
        //color[1] - Foreground Color

        Color[] colors = new Color[2];

        if (isCellHighLighted) {

            colors[0] = colorScheme.getHL_BACKGROUND_COLOR();
            colors[1] = colorScheme.getHL_FOREGROUND_COLOR();

        } else {

            if ("A".compareTo(value) == 0) {
                colors[0] = colorScheme.getA_BACKGROUND_COLOR();
                colors[1] = colorScheme.getA_FOREGROUND_COLOR();
            } else if ("C".compareTo(value) == 0) {
                colors[0] = colorScheme.getC_BACKGROUND_COLOR();
                colors[1] = colorScheme.getC_FOREGROUND_COLOR();
            } else if ("G".compareTo(value) == 0) {
                colors[0] = colorScheme.getG_BACKGROUND_COLOR();
                colors[1] = colorScheme.getG_FOREGROUND_COLOR();
            } else if ("T".compareTo(value) == 0) {
                colors[0] = colorScheme.getT_BACKGROUND_COLOR();
                colors[1] = colorScheme.getT_FOREGROUND_COLOR();
            } else if ("R".compareTo(value) == 0) {
                colors[0] = colorScheme.getR_BACKGROUND_COLOR();
                colors[1] = colorScheme.getR_FOREGROUND_COLOR();
            } else if ("Y".compareTo(value) == 0) {
                colors[0] = colorScheme.getY_BACKGROUND_COLOR();
                colors[1] = colorScheme.getY_FOREGROUND_COLOR();
            } else if ("K".compareTo(value) == 0) {
                colors[0] = colorScheme.getK_BACKGROUND_COLOR();
                colors[1] = colorScheme.getK_FOREGROUND_COLOR();
            } else if ("M".compareTo(value) == 0) {
                colors[0] = colorScheme.getM_BACKGROUND_COLOR();
                colors[1] = colorScheme.getM_FOREGROUND_COLOR();
            } else if ("S".compareTo(value) == 0) {
                colors[0] = colorScheme.getS_BACKGROUND_COLOR();
                colors[1] = colorScheme.getS_FOREGROUND_COLOR();
            } else if ("W".compareTo(value) == 0) {
                colors[0] = colorScheme.getW_BACKGROUND_COLOR();
                colors[1] = colorScheme.getW_FOREGROUND_COLOR();
            } else if ("B".compareTo(value) == 0) {
                colors[0] = colorScheme.getB_BACKGROUND_COLOR();
                colors[1] = colorScheme.getB_FOREGROUND_COLOR();
            } else if ("D".compareTo(value) == 0) {
                colors[0] = colorScheme.getD_BACKGROUND_COLOR();
                colors[1] = colorScheme.getD_FOREGROUND_COLOR();
            } else if ("H".compareTo(value) == 0) {
                colors[0] = colorScheme.getH_BACKGROUND_COLOR();
                colors[1] = colorScheme.getH_FOREGROUND_COLOR();
            } else if ("V".compareTo(value) == 0) {
                colors[0] = colorScheme.getV_BACKGROUND_COLOR();
                colors[1] = colorScheme.getV_FOREGROUND_COLOR();
            } else if ("N".compareTo(value) == 0) {
                colors[0] = colorScheme.getN_BACKGROUND_COLOR();
                colors[1] = colorScheme.getN_FOREGROUND_COLOR();
            } else if ("-".compareTo(value) == 0) {
                colors[0] = colorScheme.getGAP_BACKGROUND_COLOR();
                colors[1] = colorScheme.getGAP_FOREGROUND_COLOR();
            } else {
                colors[0] = Color.WHITE; //Background
                colors[1] = Color.BLACK; //Foreground
            }
        }

        return colors;

    }

    public AlignmentColorScheme getColorScheme() {
        return colorScheme;
    }

    public void setColorScheme(AlignmentColorScheme colorScheme) {
        this.colorScheme = colorScheme;
    }
}

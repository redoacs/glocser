/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unam.iimas.glocsa.glocser.alignmentpanel;

import java.util.ArrayList;

/**
 *
 * @author xaltonalli
 */
public class ColumnHeaderHelper {

    private static int columnNumberInterval = 10;

    public static char computeColumnHeaderChar(int column) {
        char columnHeader = '.';
        String numberString;
        int stringLength = 0;
        int module = column % columnNumberInterval;
        if (module == 0) {
            columnHeader = '|';
        } else {
            numberString = (new Integer(column - module)).toString();
            stringLength = numberString.length();
            if (module > stringLength) {
                columnHeader = '.';
            } else {
                columnHeader = numberString.charAt(module - 1);
            }
        }
        return columnHeader;
    }

    public static ArrayList<Character> computeColumnHeaders(int maxPositions) {
        ArrayList<Character> columnHeaders = new ArrayList<Character>(maxPositions);
        int charsLeft = 0;
        String numberString = "";
        int stringLength = 0;
        for (int j = 0; j < maxPositions; j++) {
            if ((j % columnNumberInterval) == 0) {
                columnHeaders.add('|');
                numberString = (new Integer(j)).toString();
                stringLength = charsLeft = numberString.length();
            } else if (charsLeft > 0) {
                columnHeaders.add(numberString.charAt(stringLength - charsLeft));
                charsLeft--;
            } else {
                columnHeaders.add('.');
            }
        }
        return columnHeaders;
    }
}

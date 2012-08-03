/*
 * AlignmentDataHelper.java
 *
 * Created on October 23, 2007, 12:33 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package edu.unam.iimas.glocsa.glocser.comparate;

import edu.unam.iimas.alignment.Alignment;
import edu.unam.iimas.alignment.AlignmentUM;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Helper for the creation of the Gap Representation of an alignment. The Gap Representation is an ArrayList of HashMaps. One HashMap per sequence in the alignment.
 * The HasMaps have as key a symbol(base) index in the sequence and as value the number of gap codifications '-' (the size of a gap) after the given symbol.
 *
 *
 * @author Edgar D. Arenas-Díaz
 */
public class AlignmentDataHelper {

    public static ArrayList<HashMap<Integer, Integer>> getAlignmentGapRepresentation(AlignmentUM alignment) {

        char alignedMatrix[][] = alignment.getAlignedMatrix();

        int lines = alignment.getNumberOfSequences();
        int columnsAligned = alignment.getMaxPositions();
        int[] numberSymbolsPerTaxa = alignment.getNumberSymbolsPerSequence();

        int[][] intArrayGapCount = new int[lines][];

        for (int i = 0; i < lines; i++) {
            intArrayGapCount[i] = new int[numberSymbolsPerTaxa[i]];
        }

        int position = 0;
        int gapsCurrentPosition = 0;

        for (int i = 0; i < lines; i++) {

            gapsCurrentPosition = 0;
            position = 0;

            for (int j = 0; j < columnsAligned; j++) {

                if (alignedMatrix[i][j] != Alignment.GAP) {

                    intArrayGapCount[i][position] = gapsCurrentPosition;
                    position++; //the gap is positioned before the following terminal (in the unaligned matrix)
                    gapsCurrentPosition = 0;


                } else {

                    gapsCurrentPosition++;

                }

            }

        }

        ArrayList<HashMap<Integer, Integer>> representationData = new ArrayList<HashMap<Integer, Integer>>(lines);
        HashMap<Integer, Integer> aTaxa;

        for (int i = 0; i < lines; i++) {

            aTaxa = new HashMap<Integer, Integer>();

            for (int j = 0; j < numberSymbolsPerTaxa[i]; j++) {

                if (intArrayGapCount[i][j] != 0) {
                    aTaxa.put(new Integer(j), new Integer(intArrayGapCount[i][j]));
                }

            }

            representationData.add(i, aTaxa);

        }

        return representationData;

    }

}
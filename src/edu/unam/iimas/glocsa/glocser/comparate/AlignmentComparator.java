/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unam.iimas.glocsa.glocser.comparate;

import edu.unam.iimas.alignment.Alignment;
import edu.unam.iimas.alignment.AlignmentUM;
import edu.unam.iimas.alignment.DynamicAlignment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Edgar D. Arenas-Díaz
 */
public class AlignmentComparator {

    public static ArrayList<ArrayList<AlignmentDifference>> compareAlignments(AlignmentUM alignmentA, AlignmentUM alignmentB) throws NotComparableAlignmentsException {

        int numberOfSequences = alignmentA.getNumberOfSequences();

        if (numberOfSequences != alignmentB.getNumberOfSequences()) {
            throw new NotComparableAlignmentsException("Different number of sequences between alignments");
        }

        int[] numberOfSymbolsPerTaxaA = alignmentA.getNumberSymbolsPerSequence();
        int[] numberOfSymbolsPerTaxaB = alignmentB.getNumberSymbolsPerSequence();

        char[][] matrixA = alignmentA.getAlignedMatrix();
        char[][] matrixB = alignmentB.getAlignedMatrix();

        for (int i = 0; i < numberOfSequences; i++) {
            if (numberOfSymbolsPerTaxaA[i] != numberOfSymbolsPerTaxaB[i]) {
                throw new NotComparableAlignmentsException("Length of sequence " + i + " is different between alignments (" + numberOfSymbolsPerTaxaA[i] + "," + numberOfSymbolsPerTaxaB[i] + ")");
            }

            for (int j = 0 ; j < numberOfSymbolsPerTaxaA[i] ; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    throw new NotComparableAlignmentsException("Sequences are different (at least sequence " + i + " at position " + j + ")");
                }
            }

        }

        ArrayList<HashMap<Integer, Integer>> alignmentGapRepresentationA = AlignmentDataHelper.getAlignmentGapRepresentation(alignmentA);
        ArrayList<HashMap<Integer, Integer>> alignmenGapRepresentationB = AlignmentDataHelper.getAlignmentGapRepresentation(alignmentB);

        Iterator<Map.Entry<Integer, Integer>> iteratorEntriesGapsSequenceA;
        Iterator<Map.Entry<Integer, Integer>> iteratorEntriesGapsSequenceB;

        HashMap<Integer, Integer> gapsSequenceA;
        HashMap<Integer, Integer> gapsSequenceB;

        Integer symbolIndex;

        Map.Entry<Integer, Integer> entryA;
        Integer positionA;
        Integer valueA;

        Map.Entry<Integer, Integer> entryB;
        Integer positionB;
        Integer valueB;

        ArrayList<ArrayList<AlignmentDifference>> differencesAllSequences = new ArrayList<ArrayList<AlignmentDifference>>();
        ArrayList<AlignmentDifference> differencesInSequence;

        for (int i = 0; i < numberOfSequences; i++) {

            differencesInSequence = new ArrayList<AlignmentDifference>();

            gapsSequenceA = alignmentGapRepresentationA.get(i);
            gapsSequenceB = alignmenGapRepresentationB.get(i);

            iteratorEntriesGapsSequenceA = gapsSequenceA.entrySet().iterator();

            while (iteratorEntriesGapsSequenceA.hasNext()) {
                entryA = iteratorEntriesGapsSequenceA.next();
                symbolIndex = entryA.getKey();
                valueA = entryA.getValue();

                valueB = gapsSequenceB.get(symbolIndex);

                if (valueB == null) {
                    differencesInSequence.add(new AlignmentDifference(i, symbolIndex, valueA, 0));
                } else if (valueA.intValue() != valueB.intValue()) {
                    differencesInSequence.add(new AlignmentDifference(i, symbolIndex, valueA, valueB));
                }

                gapsSequenceB.remove(symbolIndex);

            }

            iteratorEntriesGapsSequenceB = gapsSequenceB.entrySet().iterator();

            while (iteratorEntriesGapsSequenceB.hasNext()) {
                entryB = iteratorEntriesGapsSequenceB.next();
                symbolIndex = entryB.getKey();
                valueB = entryB.getValue();
                differencesInSequence.add(new AlignmentDifference(i, symbolIndex, 0, valueB));
            }

            differencesAllSequences.add(differencesInSequence);

        }


        return differencesAllSequences;

    }

    public static ArrayList<ArrayList<AlignmentDifference>> compareAlignments(DynamicAlignment alignmentA, DynamicAlignment alignmentB) throws NotComparableAlignmentsException {

        int numberOfSequences = alignmentA.getNumberOfSequences();

        if (numberOfSequences != alignmentB.getNumberOfSequences()) {
            throw new NotComparableAlignmentsException("Different number of sequences between alignments");
        }

        ArrayList<Integer> numberOfSymbolsPerTaxaA = alignmentA.getNumberSymbolsPerSequence();
        ArrayList<Integer> numberOfSymbolsPerTaxaB = alignmentB.getNumberSymbolsPerSequence();
        ArrayList<ArrayList<Character>> unAlignedMatrixA = alignmentA.getUnAlignedMatrix();
        ArrayList<ArrayList<Character>> unAlignedMatrixB = alignmentB.getUnAlignedMatrix();

        for (int i = 0; i < numberOfSequences; i++) {
            if (numberOfSymbolsPerTaxaA.get(i).intValue() != numberOfSymbolsPerTaxaB.get(i).intValue()) {
                throw new NotComparableAlignmentsException("Length of sequence " + i + " is different between alignments (" + numberOfSymbolsPerTaxaA.get(i) + "," + numberOfSymbolsPerTaxaB.get(i) + ")");
            }

            for (int j = 0 ; j < numberOfSymbolsPerTaxaA.get(i) ; j++) {
                if ( unAlignedMatrixA.get(i).get(j) != unAlignedMatrixB.get(i).get(j) ) {
                    throw new NotComparableAlignmentsException("Sequences are different (at least sequence " + i + " at position " + j +  ")");
                }
            }
        }



        ArrayList<HashMap<Integer, Integer>> alignmentGapRepresentationA = AlignmentDataHelper.getAlignmentGapRepresentation(alignmentA.getMinimalAlignmentUM());
        ArrayList<HashMap<Integer, Integer>> alignmenGapRepresentationB = AlignmentDataHelper.getAlignmentGapRepresentation(alignmentB.getMinimalAlignmentUM());

        Iterator<Map.Entry<Integer, Integer>> iteratorEntriesGapsSequenceA;
        Iterator<Map.Entry<Integer, Integer>> iteratorEntriesGapsSequenceB;

        HashMap<Integer, Integer> gapsSequenceA;
        HashMap<Integer, Integer> gapsSequenceB;

        Integer symbolIndex;

        Map.Entry<Integer, Integer> entryA;
        Integer positionA;
        Integer valueA;

        Map.Entry<Integer, Integer> entryB;
        Integer positionB;
        Integer valueB;

        ArrayList<ArrayList<AlignmentDifference>> differencesAllSequences = new ArrayList<ArrayList<AlignmentDifference>>();
        ArrayList<AlignmentDifference> differencesInSequence;

        for (int i = 0; i < numberOfSequences; i++) {

            differencesInSequence = new ArrayList<AlignmentDifference>();

            gapsSequenceA = alignmentGapRepresentationA.get(i);
            gapsSequenceB = alignmenGapRepresentationB.get(i);

            iteratorEntriesGapsSequenceA = gapsSequenceA.entrySet().iterator();

            while (iteratorEntriesGapsSequenceA.hasNext()) {
                entryA = iteratorEntriesGapsSequenceA.next();
                symbolIndex = entryA.getKey();
                valueA = entryA.getValue();

                valueB = gapsSequenceB.get(symbolIndex);


                if (valueB == null) {
                    positionA = alignmentA.getPositionOfSymbolInAlignment(i, symbolIndex);
                    positionB = alignmentB.getPositionOfSymbolInAlignment(i, symbolIndex);
                    differencesInSequence.add(new AlignmentDifference(i, symbolIndex, positionA, valueA, positionB, 0));
                } else if (valueA.intValue() != valueB.intValue()) {
                    positionA = alignmentA.getPositionOfSymbolInAlignment(i, symbolIndex);
                    positionB = alignmentB.getPositionOfSymbolInAlignment(i, symbolIndex);
                    differencesInSequence.add(new AlignmentDifference(i, symbolIndex, positionA, valueA, positionB, valueB));
                }

                gapsSequenceB.remove(symbolIndex);

            }

            iteratorEntriesGapsSequenceB = gapsSequenceB.entrySet().iterator();

            while (iteratorEntriesGapsSequenceB.hasNext()) {
                entryB = iteratorEntriesGapsSequenceB.next();
                symbolIndex = entryB.getKey();
                valueB = entryB.getValue();
                positionA = alignmentA.getPositionOfSymbolInAlignment(i, symbolIndex);
                positionB = alignmentB.getPositionOfSymbolInAlignment(i, symbolIndex);
                differencesInSequence.add(new AlignmentDifference(i, symbolIndex, positionA, 0, positionB, valueB));
            }

            differencesAllSequences.add(differencesInSequence);

        }


        return differencesAllSequences;

    }

    public static Alignment enforceSameOrder(AlignmentUM alignmentA, AlignmentUM alignmentB) throws NotComparableAlignmentsException {

        int numberOfSequences = alignmentA.getNumberOfSequences();

        if (numberOfSequences != alignmentB.getNumberOfSequences()) {
            throw new NotComparableAlignmentsException("Different number of sequences between alignments");
        }

        int[] numberSymbolsPerTaxaA = alignmentA.getNumberSymbolsPerSequence();
        int[] numberSymbolsPerTaxaB = alignmentB.getNumberSymbolsPerSequence();

        int[] newOrderB = new int[numberOfSequences];

        String[] namesA = alignmentA.getSequenceNames();
        String[] namesB = alignmentB.getSequenceNames();

        boolean found;
        boolean[] usedB = new boolean[numberOfSequences];

        for (int i = 0; i < numberOfSequences; i++) {

            found = false;

            for (int j = 0; j < numberOfSequences; j++) {

                if (namesA[i].compareTo(namesB[j]) == 0 && !usedB[j]) {
                    if (numberSymbolsPerTaxaA[i] == numberSymbolsPerTaxaB[j]) {
                        newOrderB[i] = j;
                        found = true;
                        usedB[j] = true;
                    } else {
                        throw new NotComparableAlignmentsException("Sequence " + namesA[i] + " has different lengths in the alignments (" + numberSymbolsPerTaxaA[i] + "," + numberSymbolsPerTaxaB[j] + ").");
                    }
                }

            }

            if (!found) {
                throw new NotComparableAlignmentsException("Sequence " + namesA[i] + " is not in both alignments");
            }

        }

        //int[] newNumberBasesPerTaxaB = new int[numberOfSequences];
        String[] newNamesB = new String[numberOfSequences];

        char[][] matrixB = alignmentB.getAlignedMatrix();
        char[][] newMatrixB = new char[numberOfSequences][alignmentB.getMaxPositions()];

        for (int i = 0; i < numberOfSequences; i++) {
            //newNumberBasesPerTaxaB[i] = numberBasesPerTaxaB[newOrderB[i]];
            newNamesB[i] = namesB[newOrderB[i]];
            newMatrixB[i] = matrixB[newOrderB[i]];
        }

        Alignment newAlignmentB = new Alignment(newMatrixB);
        newAlignmentB.setSequenceNames(newNamesB);

        return newAlignmentB;

    }
    
}

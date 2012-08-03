/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unam.iimas.glocsa.glocser.alignmentpanel;

import edu.unam.iimas.alignment.Alignment;
import edu.unam.iimas.alignment.DynamicAlignment;
import java.util.ArrayList;

/**
 *
 * @author xaltonalli
 */
public class HighLightMatrix {

    private DynamicAlignment openDynamicAlignment;
    private ArrayList<ArrayList<Boolean>> highlightMatrix = null;
    private ArrayList<Integer[]> highlightList = null;
    private int numberOfSequences;
    private ArrayList<Integer> numberSymbolsPerTaxa;
    private ArrayList<ArrayList<Integer>> symIndexMatrix;
    private ArrayList<ArrayList<Character>> alignedMatrix;
    private boolean isSomethingHighlighted = false;

    public HighLightMatrix(DynamicAlignment aDynamicAlignment) {

        openDynamicAlignment = aDynamicAlignment;

        numberOfSequences = openDynamicAlignment.getNumberOfSequences();
        numberSymbolsPerTaxa = openDynamicAlignment.getNumberSymbolsPerSequence();
        symIndexMatrix = openDynamicAlignment.getSymIndexMatrix();
        alignedMatrix = openDynamicAlignment.getAlignedMatrix();

        highlightMatrix = new ArrayList<ArrayList<Boolean>>(numberOfSequences);
        highlightList = new ArrayList<Integer[]>();

        ArrayList<Boolean> aSequenceMarkers;
        int numberSymbols = 0;

        for (int i = 0; i < numberOfSequences; i++) {

            numberSymbols = numberSymbolsPerTaxa.get(i);
            aSequenceMarkers = new ArrayList<Boolean>(numberSymbols);

            for (int j = 0; j < numberSymbols; j++) {
                aSequenceMarkers.add(new Boolean(false));
            }

            highlightMatrix.add(aSequenceMarkers);
        }

    }

//    public void setAlignmentGapsChanged(Alignment anAlignment) {
//        openDynamicAlignment = anAlignment;
//
//        symIndexMatrix = openDynamicAlignment.getBaseIndexMatrix();
//        gapMatrix = openDynamicAlignment.getGapMatrix();
//    }
    public void flagHighlightRegion(int sequence, int unalignedStartPosition, int length) {

        //System.out.println("highlight region: seq " + sequence + " pos " + unalignedStartPosition + " len " + length);
        isSomethingHighlighted = true;

        ArrayList<Boolean> aSequenceMarkers = highlightMatrix.get(sequence);

        for (int i = 0; i < length; i++) {
            aSequenceMarkers.set(unalignedStartPosition + i, Boolean.TRUE);
        }

        //TODO A class for HighLightItem's ?
        Integer[] highlightItem = new Integer[3];
        highlightItem[0] = sequence;
        highlightItem[1] = unalignedStartPosition;
        highlightItem[2] = length;

        highlightList.add(highlightItem);

    }

    public void flagDownlightRegion(int sequence, int unalignedStartPosition, int length) {

        ArrayList<Boolean> aSequenceMarkers = highlightMatrix.get(sequence);

        for (int i = 0; i < length; i++) {
            aSequenceMarkers.set(unalignedStartPosition + i, Boolean.FALSE);
        }

    }

    public void clearHighLigths() {

        highlightMatrix = new ArrayList<ArrayList<Boolean>>(numberOfSequences);
        highlightList = new ArrayList<Integer[]>();

        ArrayList<Boolean> aSequenceMarkers;
        int numberSymbols = 0;

        for (int i = 0; i < numberOfSequences; i++) {

            numberSymbols = numberSymbolsPerTaxa.get(i);
            aSequenceMarkers = new ArrayList<Boolean>(numberSymbols);

            for (int j = 0; j < numberSymbols; j++) {
                aSequenceMarkers.add(new Boolean(false));
            }

            highlightMatrix.add(aSequenceMarkers);
        }

        isSomethingHighlighted = false;

    }


    /*private Alignment obtainAlignment() {
    return alignmentOnlyPanel.getOpenAlignment();
    }*/
    public boolean isCellHighLighted(int sequence, int position) {

        boolean isCellHighlighted = false;
        int symIndex = symIndexMatrix.get(sequence).get(position);

        if (isSomethingHighlighted) {

            if (alignedMatrix.get(sequence).get(position) != Alignment.GAP) { //It is a base

                try {
                    isCellHighlighted = highlightMatrix.get(sequence).get(symIndex);
                } catch (RuntimeException rex) {
                    rex.printStackTrace();
                    System.out.println(openDynamicAlignment);
                }

            } else { // It is a gap

                //Previous and Next base need to be highlighted in order to a gap to be highlighted

                if (symIndex >= 0) {

                    if (highlightMatrix.get(sequence).get(symIndex)) { // previous base is highlighted

                        if (symIndex < numberSymbolsPerTaxa.get(sequence) - 1) { // there still are bases ahead

                            if (highlightMatrix.get(sequence).get(symIndex + 1)) { // next base is highlighted
                                isCellHighlighted = true;
                            }

                        }

                    }

                }

            }

        }

        return isCellHighlighted;

    }

    /**
     * @return the highlightList
     */
    public ArrayList<Integer[]> getHighlightList() {
        return highlightList;
    }

    /**
     * @param highlightList the highlightList to set
     */
    public void setHighlightList(ArrayList<Integer[]> highlightList) {
        this.highlightList = highlightList;
    }

    /**
     * @param isSomethingHighlighted the isSomethingHighlighted to set
     */
    public void setIsSomethingHighlighted(boolean isSomethingHighlighted) {
        this.isSomethingHighlighted = isSomethingHighlighted;
    }
}

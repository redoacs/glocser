/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unam.iimas.glocsa.glocser.alignmentpanel;

import edu.unam.iimas.alignment.DynamicAlignment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class IndexTaxaNameDuple implements Comparable<IndexTaxaNameDuple> {
    private int index;
    private int originalIndex;
    private String taxaName;

    public IndexTaxaNameDuple(int index, int originalIndex, String taxaName) {
        this.index = index;
        this.originalIndex = originalIndex;
        this.taxaName = taxaName;
    }

    @Override
    public int compareTo(IndexTaxaNameDuple o) {
        return getTaxaName().compareTo(o.getTaxaName());
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @return the taxaName
     */
    public String getTaxaName() {
        return taxaName;
    }

    /**
     * @return the originalIndex
     */
    public int getOriginalIndex() {
        return originalIndex;
    }

}

/**
 *
 * @author xaltonalli
 */
public class TaxaOrderManager {

    int numberSequences;
    private ArrayList<Integer> originalTaxaOrder;
    private ArrayList<String> taxaNames; //taxaNames
    private ArrayList<ArrayList<Character>> alignedMatrix; //All the taxas have the same length in this alignedMatrix
    private ArrayList<ArrayList<Character>> unAlignedMatrix; //Taxas may have differnt lenght (according to the number of symbols of each)
    private ArrayList<ArrayList<Integer>> gapOffsetMatrix; //symIndex -> position
    private ArrayList<ArrayList<Integer>> symIndexMatrix; //position -> symIndex
    private ArrayList<Integer> numberSymbolsPerTaxa; //numer of symbols per taxa
    HighLightMatrix highlightMatrix;

    public TaxaOrderManager(DynamicAlignment dynamicAlignment, HighLightMatrix highlightMatrix) {

        numberSequences = dynamicAlignment.getNumberOfSequences();

        taxaNames = dynamicAlignment.getSequenceNames();

        int size = taxaNames.size();
        originalTaxaOrder = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++) {
            originalTaxaOrder.add(i);
        }

        alignedMatrix = dynamicAlignment.getAlignedMatrix();
        unAlignedMatrix = dynamicAlignment.getUnAlignedMatrix();
        gapOffsetMatrix = dynamicAlignment.getGapOffsetMatrix();
        symIndexMatrix = dynamicAlignment.getSymIndexMatrix();
        numberSymbolsPerTaxa = dynamicAlignment.getNumberSymbolsPerSequence();

        this.highlightMatrix = highlightMatrix;

    }

    public void moveTaxa(int fromPosition, int toPosition) {

        Integer intElement = originalTaxaOrder.get(fromPosition);
        originalTaxaOrder.remove(fromPosition);
        originalTaxaOrder.add(toPosition, intElement);

        String taxaNameElement = taxaNames.get(fromPosition);
        taxaNames.remove(fromPosition);
        taxaNames.add(toPosition, taxaNameElement);

        ArrayList<Character> sequenceElement = alignedMatrix.get(fromPosition);
        alignedMatrix.remove(fromPosition);
        alignedMatrix.add(toPosition, sequenceElement);

        sequenceElement = unAlignedMatrix.get(fromPosition);
        unAlignedMatrix.remove(fromPosition);
        unAlignedMatrix.add(toPosition, sequenceElement);

        ArrayList<Integer> intSequenceElement = gapOffsetMatrix.get(fromPosition);
        gapOffsetMatrix.remove(fromPosition);
        gapOffsetMatrix.add(toPosition, intSequenceElement);

        intSequenceElement = symIndexMatrix.get(fromPosition);
        symIndexMatrix.remove(fromPosition);
        symIndexMatrix.add(toPosition, intSequenceElement);

        intElement = numberSymbolsPerTaxa.get(fromPosition);
        numberSymbolsPerTaxa.remove(fromPosition);
        numberSymbolsPerTaxa.add(toPosition, intElement);



        highlightMatrix.clearHighLigths();

    }

    /*
     * Order the taxas asuming that in taxaOrder, the value at i is the intended order for the i taxa
     */
    public void orderInverseAs(ArrayList<Integer> taxaOrder) {

        ArrayList<String> tmpTaxaNames = new ArrayList<String>(numberSequences);
        for (int i = 0; i < numberSequences; i++) {
            tmpTaxaNames.add(null);
        }
        for (int i = 0; i < numberSequences; i++) {
            tmpTaxaNames.set(taxaOrder.get(i), taxaNames.get(i));
        }
        taxaNames.clear();
        taxaNames.addAll(tmpTaxaNames);

        ArrayList<ArrayList<Character>> tmpAlignedMatrix = new ArrayList<ArrayList<Character>>(numberSequences);
        for (int i = 0; i < numberSequences; i++) {
            tmpAlignedMatrix.add(null);
        }
        for (int i = 0; i < numberSequences; i++) {
            tmpAlignedMatrix.set(taxaOrder.get(i), alignedMatrix.get(i));
        }
        alignedMatrix.clear();
        alignedMatrix.addAll(tmpAlignedMatrix);

        ArrayList<ArrayList<Character>> tmpUnAlignedMatrix = new ArrayList<ArrayList<Character>>(numberSequences);
        for (int i = 0; i < numberSequences; i++) {
            tmpUnAlignedMatrix.add(null);
        }
        for (int i = 0; i < numberSequences; i++) {
            tmpUnAlignedMatrix.set(taxaOrder.get(i), unAlignedMatrix.get(i));
        }
        unAlignedMatrix.clear();
        unAlignedMatrix.addAll(tmpUnAlignedMatrix);

        ArrayList<ArrayList<Integer>> tmpGapOffsetMatrix = new ArrayList<ArrayList<Integer>>(numberSequences);
        for (int i = 0; i < numberSequences; i++) {
            tmpGapOffsetMatrix.add(null);
        }
        for (int i = 0; i < numberSequences; i++) {
            tmpGapOffsetMatrix.set(taxaOrder.get(i), gapOffsetMatrix.get(i));
        }
        gapOffsetMatrix.clear();
        gapOffsetMatrix.addAll(tmpGapOffsetMatrix);

        ArrayList<ArrayList<Integer>> tmpSymIndexMatrix = new ArrayList<ArrayList<Integer>>(numberSequences);
        for (int i = 0; i < numberSequences; i++) {
            tmpSymIndexMatrix.add(null);
        }
        for (int i = 0; i < numberSequences; i++) {
            tmpSymIndexMatrix.set(taxaOrder.get(i), symIndexMatrix.get(i));
        }
        symIndexMatrix.clear();
        symIndexMatrix.addAll(tmpSymIndexMatrix);

        ArrayList<Integer> tmpNumberSymbolsPerTaxa = new ArrayList<Integer>(numberSequences);
        for (int i = 0; i < numberSequences; i++) {
            tmpNumberSymbolsPerTaxa.add(null);
        }
        for (int i = 0; i < numberSequences; i++) {
            tmpNumberSymbolsPerTaxa.set(taxaOrder.get(i), numberSymbolsPerTaxa.get(i));
        }
        numberSymbolsPerTaxa.clear();
        numberSymbolsPerTaxa.addAll(tmpNumberSymbolsPerTaxa);

    }

    public void resetOriginalOrder() {

        orderInverseAs(originalTaxaOrder);

        for (int i = 0; i < numberSequences; i++) {
            originalTaxaOrder.set(i, i);
        }

        highlightMatrix.clearHighLigths();

    }

    /*
     * Order the taxas asuming that in taxaOrder, the value at i is the taxa to be in position i
     */
    public void orderAs(ArrayList<Integer> taxaOrder) {

        ArrayList<String> tmpTaxaNames = new ArrayList<String>(numberSequences);
        for (int i = 0; i < numberSequences; i++) {
            tmpTaxaNames.add(null);
        }
        for (int i = 0; i < numberSequences; i++) {
            tmpTaxaNames.set(i, taxaNames.get(taxaOrder.get(i)));
        }
        taxaNames.clear();
        taxaNames.addAll(tmpTaxaNames);

        ArrayList<ArrayList<Character>> tmpAlignedMatrix = new ArrayList<ArrayList<Character>>(numberSequences);
        for (int i = 0; i < numberSequences; i++) {
            tmpAlignedMatrix.add(null);
        }
        for (int i = 0; i < numberSequences; i++) {
            tmpAlignedMatrix.set(i, alignedMatrix.get(taxaOrder.get(i)));
        }
        alignedMatrix.clear();
        alignedMatrix.addAll(tmpAlignedMatrix);

        ArrayList<ArrayList<Character>> tmpUnAlignedMatrix = new ArrayList<ArrayList<Character>>(numberSequences);
        for (int i = 0; i < numberSequences; i++) {
            tmpUnAlignedMatrix.add(null);
        }
        for (int i = 0; i < numberSequences; i++) {
            tmpUnAlignedMatrix.set(i, unAlignedMatrix.get(taxaOrder.get(i)));
        }
        unAlignedMatrix.clear();
        unAlignedMatrix.addAll(tmpUnAlignedMatrix);

        ArrayList<ArrayList<Integer>> tmpGapOffsetMatrix = new ArrayList<ArrayList<Integer>>(numberSequences);
        for (int i = 0; i < numberSequences; i++) {
            tmpGapOffsetMatrix.add(null);
        }
        for (int i = 0; i < numberSequences; i++) {
            tmpGapOffsetMatrix.set(i, gapOffsetMatrix.get(taxaOrder.get(i)));
        }
        gapOffsetMatrix.clear();
        gapOffsetMatrix.addAll(tmpGapOffsetMatrix);

        ArrayList<ArrayList<Integer>> tmpSymIndexMatrix = new ArrayList<ArrayList<Integer>>(numberSequences);
        for (int i = 0; i < numberSequences; i++) {
            tmpSymIndexMatrix.add(null);
        }
        for (int i = 0; i < numberSequences; i++) {
            tmpSymIndexMatrix.set(i, symIndexMatrix.get(taxaOrder.get(i)));
        }
        symIndexMatrix.clear();
        symIndexMatrix.addAll(tmpSymIndexMatrix);

        ArrayList<Integer> tmpNumberSymbolsPerTaxa = new ArrayList<Integer>(numberSequences);
        for (int i = 0; i < numberSequences; i++) {
            tmpNumberSymbolsPerTaxa.add(null);
        }
        for (int i = 0; i < numberSequences; i++) {
            tmpNumberSymbolsPerTaxa.set(i, numberSymbolsPerTaxa.get(taxaOrder.get(i)));
        }
        numberSymbolsPerTaxa.clear();
        numberSymbolsPerTaxa.addAll(tmpNumberSymbolsPerTaxa);

    }

    public void sortAlphabetically() {

        ArrayList<IndexTaxaNameDuple> indexTaxaNameDuples = new ArrayList<IndexTaxaNameDuple>(numberSequences);

        for (int i = 0; i < numberSequences; i++) {
            indexTaxaNameDuples.add(new IndexTaxaNameDuple(i, originalTaxaOrder.get(i), taxaNames.get(i)));
        }
        
        Collections.sort(indexTaxaNameDuples);
        
        ArrayList<Integer> taxaOrder = new ArrayList<Integer>(numberSequences);
        for (int i = 0; i < numberSequences; i++) {
            taxaOrder.add(indexTaxaNameDuples.get(i).getIndex());
        }
        
        orderAs(taxaOrder);

        for (int i = 0; i < numberSequences; i++) {
            originalTaxaOrder.set(i, indexTaxaNameDuples.get(i).getOriginalIndex());
        }

        highlightMatrix.clearHighLigths();

    }

    /**
     * @return the taxaOrder
     */
    public ArrayList<Integer> getTaxaOrder() {
        return originalTaxaOrder;
    }
}

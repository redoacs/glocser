/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unam.iimas.glocsa.glocser.comparate;

/**
 *
 * @author xaltonalli
 */
public class AlignmentDifference {

    private int sequenceNumber;
    private int symbolIndex;
    private int positionA;
    private int sizeA;
    private int positionB;
    private int sizeB;

    public AlignmentDifference(int p_sequenceNumber, int p_symbolIndex, int p_positionA, int p_sizeA, int p_positionB, int p_sizeB) {
        this.sequenceNumber = p_sequenceNumber;
        this.symbolIndex = p_symbolIndex;
        this.positionA = p_positionA;
        this.sizeA = p_sizeA;
        this.positionB = p_positionB;
        this.sizeB = p_sizeB;
    }

    public AlignmentDifference(int p_sequenceNumber, int p_symbolIndex, int p_sizeA, int p_sizeB) {
        this.sequenceNumber = p_sequenceNumber;
        this.symbolIndex = p_symbolIndex;
        this.sizeA = p_sizeA;
        this.sizeB = p_sizeB;
    }

    @Override
    public String toString() {
        return sequenceNumber + "|" + symbolIndex + "|" + positionA + "|" + sizeA + "|" + positionB + "|" + sizeB;
    }

    public int getSizeA() {
        return sizeA;
    }

    public void setSizeA(int sizeA) {
        this.sizeA = sizeA;
    }

    public int getSizeB() {
        return sizeB;
    }

    public void setSizeB(int sizeB) {
        this.sizeB = sizeB;
    }

    public int getSymbolIndex() {
        return symbolIndex;
    }

    public void setSymbolIndex(int position) {
        this.symbolIndex = position;
    }

    /**
     * @return the sequenceNumber
     */
    public int getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * @param sequenceNumber the sequenceNumber to set
     */
    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    /**
     * @return the positionA
     */
    public int getPositionA() {
        return positionA;
    }

    /**
     * @param positionA the positionA to set
     */
    public void setPositionA(int positionA) {
        this.positionA = positionA;
    }

    /**
     * @return the positionB
     */
    public int getPositionB() {
        return positionB;
    }

    /**
     * @param positionB the positionB to set
     */
    public void setPositionB(int positionB) {
        this.positionB = positionB;
    }
}

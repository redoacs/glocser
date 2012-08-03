/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unam.iimas.glocsa.glocser.alignmentpanel;

/**
 *
 * @author xaltonalli
 */
public class HighLightItem {

    private int sequence;
    private int unalignedStartPosition;
    private int length;

    public HighLightItem (int sequence, int unalignedStartPosition, int length) {
        this.sequence = sequence;
        this.unalignedStartPosition = unalignedStartPosition;
        this.length = length;
    }

    /**
     * @return the sequence
     */
    public int getSequence() {
        return sequence;
    }

    /**
     * @return the unalignedStartPosition
     */
    public int getUnalignedStartPosition() {
        return unalignedStartPosition;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

}

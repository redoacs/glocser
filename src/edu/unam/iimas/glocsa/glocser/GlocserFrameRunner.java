/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unam.iimas.glocsa.glocser;

/**
 *
 * @author redoacs
 */
public class GlocserFrameRunner implements Runnable{
    
    private GlocserFrame glocserFrame;
    boolean openFile = false;

    public GlocserFrameRunner(GlocserFrame glocserFrame, boolean openFile) {
        this.glocserFrame = glocserFrame;
        this.openFile = openFile;
    }

    @Override
    public void run() {
        glocserFrame.setVisible(true);
        if (openFile) {
            glocserFrame.openAlignmentAction();
        }
    }

}

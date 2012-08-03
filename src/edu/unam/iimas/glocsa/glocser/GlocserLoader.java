/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unam.iimas.glocsa.glocser;

import edu.unam.iimas.glocsa.glocser.comparate.frame.AlignmentComparatorFrame;
import edu.unam.iimas.glocsa.glocser.comparate.frame.AlignmentComparisonSelectorFrame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author redoacs
 */
public class GlocserLoader {

    private List<GlocserFrame> glocserFramesList;

    public GlocserLoader() {
        glocserFramesList = new ArrayList<GlocserFrame>();
    }

    public void loadNewGlocserFrame() {
        System.out.println("Loading new Glocser Frame...");
        GlocserFrame initialFrame = new GlocserFrame(this);
        glocserFramesList.add(initialFrame);
        java.awt.EventQueue.invokeLater(
                new GlocserFrameRunner(initialFrame, false));
    }

    public void loadNewGlocserFrameOpen() {
        System.out.println("Loading new Glocser Frame openning a file...");
        GlocserFrame initialFrame = new GlocserFrame(this);
        glocserFramesList.add(initialFrame);
        java.awt.EventQueue.invokeLater(
                new GlocserFrameRunner(initialFrame, true));
    }

    public void closeGlocserFrame(GlocserFrame glocserFrame) {
        glocserFramesList.remove(glocserFrame);
        System.out.println("Glocser Frames still open: " + glocserFramesList.size());
        if (glocserFramesList.isEmpty()) {
            System.exit(0);
        }
    }

    public List<GlocserFrame> getGlocserFramesList() {
        return glocserFramesList;
    }

    public void showCompareAlignmentsFrame(GlocserFrame sourceGlocserFrame) {

        System.out.println("Requesting alginment comparation");

        int numberOfOpenAlignments = glocserFramesList.size();
        if (numberOfOpenAlignments > 2) {
            AlignmentComparisonSelectorFrame selectorFrame = new AlignmentComparisonSelectorFrame(sourceGlocserFrame, glocserFramesList);
            selectorFrame.setVisible(true);
        } else if (numberOfOpenAlignments == 2) {
            for (GlocserFrame alignmentGlocserFrame : glocserFramesList) {
                if (alignmentGlocserFrame != sourceGlocserFrame) {
                    AlignmentComparatorFrame comparatorFrame = new AlignmentComparatorFrame(sourceGlocserFrame, alignmentGlocserFrame);
                    comparatorFrame.setVisible(true);
                }
            }
        } else {
            JOptionPane.showMessageDialog(sourceGlocserFrame, "Not enough alignments open for comparision");
        }

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(
                new Runnable() {

                    @Override
                    public void run() {
                        new GlocserLoader().loadNewGlocserFrame();
                    }
                });

    }
}

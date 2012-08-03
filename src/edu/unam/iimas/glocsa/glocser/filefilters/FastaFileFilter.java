/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unam.iimas.glocsa.glocser.filefilters;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author xaltonalli
 */
public class FastaFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {

        boolean accept = false;

        if (f.isDirectory()) {
            accept = true;
        } else if ( f.getName().endsWith(".fst") ) {
           accept = true;
        } else if ( f.getName().endsWith(".fasta") ) {
           accept = true;
        }
        return accept;

    }

    @Override
    public String getDescription() {
        return "Fasta Files - *.fst *.fasta";
    }

}

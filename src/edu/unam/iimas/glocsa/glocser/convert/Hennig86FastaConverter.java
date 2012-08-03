/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unam.iimas.glocsa.glocser.convert;

import edu.unam.iimas.alignment.Alignment;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author xaltonalli
 */
public class Hennig86FastaConverter {
    
    public static void convertHennig86FastaDNA(File hennig86File, File fastaFile) throws IOException {
        Alignment alignment = Hennig86Reader.readHennig86FileDNA(hennig86File);
        alignment.writeAlignment(fastaFile);
    }
    
    public static void convertHennig86FastaNumericDNA(File hennig86File, File fastaFile) throws IOException {
        Alignment alignment = Hennig86Reader.readHennig86FileNumericDNA(hennig86File);
        alignment.writeAlignment(fastaFile);
    }
}

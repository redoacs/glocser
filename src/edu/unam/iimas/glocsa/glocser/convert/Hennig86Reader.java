/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unam.iimas.glocsa.glocser.convert;

import edu.unam.iimas.alignment.Alignment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xaltonalli
 */
public class Hennig86Reader {
    
    public final static int XREAD = 0;
    public final static int DREAD = 1;
    public final static int UNKNOWN = 2;
    public final static int ERROR = 3;

    public static Alignment readHennig86FileDNA(File hennig86File) {

        BufferedReader inFile = null;

        String title = null;
        int nTaxas = 0;
        int nPositions = 0;
        String[] taxaNames = null;
        String[] data = null;

        try {
            inFile = new BufferedReader(new FileReader(hennig86File));

            int charInt = 0;
            char[] chars = null;
            StringBuffer stringBuffer = null;

            charInt = inFile.read();
            //chars = Character.toChars(charInt);

            while (charInt != -1 && charInt != 39) { //seek for the title start " ' "
                charInt = inFile.read();
            }
            stringBuffer = new StringBuffer(); //get ready to read the title
            charInt = inFile.read();
            while (charInt != -1 && charInt != 39) { //this is the title, save it and seek the title end " ' "
                chars = Character.toChars(charInt);
                stringBuffer.append(chars);
                charInt = inFile.read();
            }
            title = stringBuffer.toString();
            charInt = inFile.read();

            while (charInt != -1 && !Character.isDigit(charInt)) { //advance until you find a digit
                charInt = inFile.read();
            }
            stringBuffer = new StringBuffer(); //get ready to read a the number of positions
            while (charInt != -1 && Character.isDigit(charInt)) { //advance until you find a digit
                chars = Character.toChars(charInt);
                stringBuffer.append(chars);
                charInt = inFile.read();
            }
            nPositions = Integer.parseInt(stringBuffer.toString());

            while (charInt != -1 && !Character.isDigit(charInt)) { //advance until you find a digit
                charInt = inFile.read();
            }
            stringBuffer = new StringBuffer(); //get ready to read the number if taxas
            while (charInt != -1 && Character.isDigit(charInt)) { //advance until you read all digits
                chars = Character.toChars(charInt);
                stringBuffer.append(chars);
                charInt = inFile.read();
            }
            nTaxas = Integer.parseInt(stringBuffer.toString());

            //Here the data begins

            taxaNames = new String[nTaxas];
            data = new String[nTaxas];

            for (int i = 0; i < nTaxas; i++) {
                //taxa name
                while (charInt != -1 && Character.isWhitespace(charInt)) { //advance until you find a taxa name
                    charInt = inFile.read();
                }
                stringBuffer = new StringBuffer(); //get ready to read a taxa name
                while (charInt != -1 && !Character.isWhitespace(charInt)) { //read the taxaname
                    chars = Character.toChars(charInt);
                    stringBuffer.append(chars);
                    charInt = inFile.read();
                }
                taxaNames[i] = stringBuffer.toString();
                //System.out.println(">" + taxaNames[i]);
                //taxa data
                stringBuffer = new StringBuffer(); //get ready to read taxa data

                for (int j = 0; j < nPositions; j++) {
                    while (charInt != -1 && Character.isWhitespace(charInt)) { //advance until you find data
                        charInt = inFile.read();
                    }
                    if (charInt != -1) {
                        chars = Character.toChars(charInt);
                        stringBuffer.append(chars);
                        charInt = inFile.read();
                    }
                }
                data[i] = stringBuffer.toString();
            //System.out.println(data[i]);
            }



        } catch (FileNotFoundException ex) {
            Logger.getLogger(Hennig86FastaConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Hennig86FastaConverter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inFile.close();
            } catch (IOException ex) {
                Logger.getLogger(Hennig86FastaConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        char[][] charMatrix = new char[nTaxas][nPositions];

        for (int i = 0; i < nTaxas; i++) {
            for (int j = 0; j < nPositions; j++) {
                charMatrix[i][j] = data[i].charAt(j);
            }
        }

        Alignment alignment = new Alignment(charMatrix);
        alignment.setSequenceNames(taxaNames);

        return alignment;

    }

    public static Alignment readHennig86FileNumericDNA(File hennig86File) {

        BufferedReader inFile = null;

        String title = null;
        int nTaxas = 0;
        int nPositions = 0;
        String[] taxaNames = null;
        String[] data = null;

        try {
            inFile = new BufferedReader(new FileReader(hennig86File));

            int charInt = 0;
            char[] chars = null;
            StringBuffer stringBuffer = null;

            charInt = inFile.read();
            //chars = Character.toChars(charInt);

            while (charInt != -1 && charInt != 39) { //seek for the title start " ' "
                charInt = inFile.read();
            }
            stringBuffer = new StringBuffer(); //get ready to read the title
            charInt = inFile.read();
            while (charInt != -1 && charInt != 39) { //this is the title, save it and seek the title end " ' "
                chars = Character.toChars(charInt);
                stringBuffer.append(chars);
                charInt = inFile.read();
            }
            title = stringBuffer.toString();
            charInt = inFile.read();

            while (charInt != -1 && !Character.isDigit(charInt)) { //advance until you find a digit
                charInt = inFile.read();
            }
            stringBuffer = new StringBuffer(); //get ready to read a the number of positions
            while (charInt != -1 && Character.isDigit(charInt)) { //advance until you find a digit
                chars = Character.toChars(charInt);
                stringBuffer.append(chars);
                charInt = inFile.read();
            }
            nPositions = Integer.parseInt(stringBuffer.toString());

            while (charInt != -1 && !Character.isDigit(charInt)) { //advance until you find a digit
                charInt = inFile.read();
            }
            stringBuffer = new StringBuffer(); //get ready to read the number if taxas
            while (charInt != -1 && Character.isDigit(charInt)) { //advance until you read all digits
                chars = Character.toChars(charInt);
                stringBuffer.append(chars);
                charInt = inFile.read();
            }
            nTaxas = Integer.parseInt(stringBuffer.toString());

            //Here the data begins

            taxaNames = new String[nTaxas];
            data = new String[nTaxas];

            for (int i = 0; i < nTaxas; i++) {
                //taxa name
                while (charInt != -1 && Character.isWhitespace(charInt)) { //advance until you find a taxa name
                    charInt = inFile.read();
                }
                stringBuffer = new StringBuffer(); //get ready to read a taxa name
                while (charInt != -1 && !Character.isWhitespace(charInt)) { //read the taxaname
                    chars = Character.toChars(charInt);
                    stringBuffer.append(chars);
                    charInt = inFile.read();
                }
                taxaNames[i] = stringBuffer.toString();
                //System.out.println(">" + taxaNames[i]);
                //taxa data

                boolean canBeA = false;
                boolean canBeC = false;
                boolean canBeG = false;
                boolean canBeT = false;

                stringBuffer = new StringBuffer(); //get ready to read taxa data

                for (int j = 0; j < nPositions; j++) {
                    while (charInt != -1 && Character.isWhitespace(charInt)) { //advance until you find data
                        charInt = inFile.read();
                    }

                    if (charInt != -1) {
                        chars = Character.toChars(charInt);
                        if (chars[0] == '[') { //it is a poly

                            canBeA = false;
                            canBeC = false;
                            canBeG = false;
                            canBeT = false;

                            charInt = inFile.read();
                            chars = Character.toChars(charInt);

                            while (charInt != -1 && chars[0] != ']') { //advance until you find the end of poly
                                if (chars[0] == '0') {
                                    canBeA = true;
                                } else if (chars[0] == '1') {
                                    canBeC = true;
                                } else if (chars[0] == '2') {
                                    canBeG = true;
                                } else if (chars[0] == '3') {
                                    canBeT = true;
                                } else {
                                    throw new RuntimeException("File is not a valid numeric DNA one. Unknown codification at taxa " + i + ", position " + j);
                                }
                                charInt = inFile.read();

                                while (charInt != -1 && Character.isWhitespace(charInt)) { //advance until you find data
                                    charInt = inFile.read();
                                }

                                chars = Character.toChars(charInt);

                            }
                            charInt = inFile.read(); // "]" reached, poly ended, read next char

                            if (canBeA && !canBeC && canBeG && !canBeT) {
                                stringBuffer.append("R");
                            } else if (!canBeA && canBeC && !canBeG && canBeT) {
                                stringBuffer.append("Y");
                            } else if (!canBeA && !canBeC && canBeG && canBeT) {
                                stringBuffer.append("K");
                            } else if (canBeA && canBeC && !canBeG && !canBeT) {
                                stringBuffer.append("M");
                            } else if (!canBeA && canBeC && canBeG && !canBeT) {
                                stringBuffer.append("S");
                            } else if (canBeA && !canBeC && !canBeG && canBeT) {
                                stringBuffer.append("W");
                            } else if (!canBeA && canBeC && canBeG && canBeT) {
                                stringBuffer.append("B");
                            } else if (canBeA && !canBeC && canBeG && canBeT) {
                                stringBuffer.append("D");
                            } else if (canBeA && canBeC && !canBeG && canBeT) {
                                stringBuffer.append("H");
                            } else if (canBeA && canBeC && canBeG && !canBeT) {
                                stringBuffer.append("V");
                            } else if (canBeA && canBeC && canBeG && canBeT) {
                                stringBuffer.append("N");
                            }

                        } else {
                            if (chars[0] == '0') {
                                stringBuffer.append("A");
                            } else if (chars[0] == '1') {
                                stringBuffer.append("C");
                            } else if (chars[0] == '2') {
                                stringBuffer.append("G");
                            } else if (chars[0] == '3') {
                                stringBuffer.append("T");
                            } else if ((chars[0] == '-') || (chars[0] == '?')) {
                                stringBuffer.append(chars[0]);
                            } else {
                                throw new RuntimeException("File is not a valid numeric DNA one. Unknown codification at taxa " + i + ", position " + j);
                            }
                            charInt = inFile.read();
                        }
                    }
                }
                data[i] = stringBuffer.toString();
            //System.out.println(data[i]);
            }



        } catch (FileNotFoundException ex) {
            Logger.getLogger(Hennig86FastaConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Hennig86FastaConverter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inFile.close();
            } catch (IOException ex) {
                Logger.getLogger(Hennig86FastaConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        char[][] charMatrix = new char[nTaxas][nPositions];

        for (int i = 0; i < nTaxas; i++) {
            for (int j = 0; j < nPositions; j++) {
                //for (int j = 0; j < data[i].length(); j++) {
                charMatrix[i][j] = data[i].charAt(j);
            }
        }

        Alignment alignment = new Alignment(charMatrix);
        alignment.setSequenceNames(taxaNames);

        return alignment;

    }
    
    public static int readHennig86FileType(File hennig86File) {
        
        BufferedReader inFile = null;
        int typeCode = Hennig86Reader.UNKNOWN;
        
        try {

            inFile = null;

            String type = null;


            inFile = new BufferedReader(new FileReader(hennig86File));

            int charInt = 0;
            char[] chars = null;
            StringBuffer stringBuffer = null;

            charInt = inFile.read();
            //chars = Character.toChars(charInt);
            
            while (charInt != -1 && Character.isWhitespace(charInt)) { //seek for the first word 
                charInt = inFile.read();
            }
            
            stringBuffer = new StringBuffer();
            while ( (charInt != -1) && !Character.isWhitespace(charInt) && (charInt != 39) ) { //seek for the first word 
                chars = Character.toChars(charInt);
                stringBuffer.append(chars);
                charInt = inFile.read();
            }
            
            type = stringBuffer.toString();
            
            if(type.equalsIgnoreCase("xread")) {
                typeCode = Hennig86Reader.XREAD;
            } else if(type.equalsIgnoreCase("dread")) {
                typeCode = Hennig86Reader.DREAD;
            } else {
                typeCode = Hennig86Reader.UNKNOWN;
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Hennig86Reader.class.getName()).log(Level.SEVERE, null, ex);
            typeCode = Hennig86Reader.ERROR;
        } catch (IOException ex) {
            Logger.getLogger(Hennig86Reader.class.getName()).log(Level.SEVERE, null, ex);
            typeCode = Hennig86Reader.ERROR;
        } finally {
            try {
                inFile.close();
            } catch (IOException ex) {
                Logger.getLogger(Hennig86FastaConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return typeCode;
        
    }


    
}

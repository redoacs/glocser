/*
 * GlocserFrame.java
 *
 * Created on September 15, 2008, 2:52 PM
 */
package edu.unam.iimas.glocsa.glocser;

import edu.unam.iimas.alignment.Alignment;
import edu.unam.iimas.alignment.DynamicAlignment;
import edu.unam.iimas.alignment.glocsa.core.EventCount;
import edu.unam.iimas.alignment.glocsa.core.EventCounter;
import edu.unam.iimas.alignment.glocsa.core.GlocsaParameters;
import edu.unam.iimas.alignment.glocsa.core.GlocsaRater;
import edu.unam.iimas.alignment.glocsa.core.GlocsaRating;
import edu.unam.iimas.alignment.NonSupportedAlignmentException;
import edu.unam.iimas.glocsa.glocser.convert.Hennig86Reader;
import edu.unam.iimas.glocsa.glocser.exttool.ExternalToolAlignFrame;
import edu.unam.iimas.glocsa.glocser.filefilters.FastaFileFilter;
import edu.unam.iimas.glocsa.glocser.filefilters.Hennig86FileFilter;
import edu.unam.iimas.glocsa.glocser.glocsadetails.GlocsaDetailsFrame;
import edu.unam.iimas.glocsa.glocser.search.SearchFrame;
import edu.unam.iimas.alignment.glocsa.util.BaseGapReplacer;
import edu.unam.iimas.glocsa.glocser.alignmentpanel.AlignmentOnlyPanel;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author  xaltonalli
 */
public class GlocserFrame extends javax.swing.JFrame {

    private GlocserLoader glocserLoader;
    private GlocsaRater rater;
    private DynamicAlignment openDynamicAlignment;
    private File selectedFile;
    private File currentDirectory;
    private GlocsaRating lastGlocsaRating;
    private EventCount lastEventCount;
    private GlocsaDetailsFrame glocsaDetailsFrame;
    private FileFilter fastaFileFilter = new FastaFileFilter();
    private FileFilter hennig86FileFilter = new Hennig86FileFilter();
    String alignmentToolPathDefault = "ext-tools/muscle";
    String alignmentToolOptionsDefault = "";
    String alignmentToolPath = null;
    String alignmentToolOptions = null;
    String propertiesFileName = "configuration.properties";
    SearchFrame searchFrame;
    private boolean autorefreshRating = false;
    private Properties configuration = null;
    private boolean unSavedChangesExist;

    /** Creates new form GlocserFrame */
    public GlocserFrame(GlocserLoader glocserLoader) {
        this.glocserLoader = glocserLoader;
        configuration = new Properties();
        boolean incompleteProperties = false;

        try {
            configuration.load(new FileReader(propertiesFileName));
        } catch (IOException ex) {
            if ("java.io.FileNotFoundException".contentEquals(ex.getClass().getName())) {
                System.out.println("configuration.properties not found, creating one with default values");
                incompleteProperties = true;
            } else {
                Logger.getLogger(GlocserFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        alignmentToolPath = configuration.getProperty("alignmentToolPath");
        if (alignmentToolPath == null) {
            incompleteProperties = true;
            alignmentToolPath = alignmentToolPathDefault;
            configuration.setProperty("alignmentToolPath", alignmentToolPathDefault);
        }
        System.out.println(("alignmentToolPath: " + alignmentToolPath));

        alignmentToolOptions = configuration.getProperty("alignmentToolOptions");
        if (alignmentToolOptions == null) {
            incompleteProperties = true;
            alignmentToolOptions = alignmentToolOptionsDefault;
            configuration.setProperty("alignmentToolOptions", alignmentToolOptionsDefault);
        }
        System.out.println(("alignmentToolOptions: " + alignmentToolOptions));

        String currentDirectoryString = configuration.getProperty("currentDirectory");
        if (currentDirectoryString == null) {
            currentDirectory = null;
        } else {
            currentDirectory = new File(currentDirectoryString);
        }
        System.out.println(("currentDirectory: " + currentDirectory));

        try {
            if (incompleteProperties) {
                configuration.store(new FileWriter(propertiesFileName), "");
            }
        } catch (IOException ex) {
            Logger.getLogger(GlocserFrame.class.getName()).log(Level.SEVERE, null, ex);
        }


        initComponents();

        alignmentOnlyPanel.setGlocserFrame(this);
        deactivateCommandsAlignment();
        GlocsaParameters parameters = new GlocsaParameters();
        rater = new GlocsaRater(parameters);
        jFileChooserOpenAlignment.setFileFilter(fastaFileFilter);
        searchFrame = new SearchFrame(this);
        this.setIconImage(null);



    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooserOpenAlignment = new javax.swing.JFileChooser();
        jFileChooserOpenAlignment.addChoosableFileFilter(fastaFileFilter);
        jFileChooserOpenAlignment.addChoosableFileFilter(hennig86FileFilter);
        jFileChooserSaveAlignment = new javax.swing.JFileChooser();
        jFileChooserSaveAlignment.addChoosableFileFilter(fastaFileFilter);
        alignmentOnlyPanel = new edu.unam.iimas.glocsa.glocser.alignmentpanel.AlignmentOnlyPanel();
        glocsaRatingMiniPanel = new edu.unam.iimas.glocsa.glocser.GlocsaRatingMiniPanel();
        alignmentInfoMiniPanel = new edu.unam.iimas.glocsa.glocser.AlignmentInfoMiniPanel();
        jCheckBoxAutoRefresh = new javax.swing.JCheckBox();
        jButtonRefresh = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemOpenNewWindow = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemSaveAs = new javax.swing.JMenuItem();
        jMenuItemClose = new javax.swing.JMenuItem();
        jMenuData = new javax.swing.JMenu();
        jMenuItemDegap = new javax.swing.JMenuItem();
        jMenuItemPurgeDashColumns = new javax.swing.JMenuItem();
        jMenuItemReplaceNwithDash = new javax.swing.JMenuItem();
        jMenuItemReplaceDotWithDash = new javax.swing.JMenuItem();
        jMenuItemReplaceAllQmwithDash = new javax.swing.JMenuItem();
        jMenuItemReplaceQMwithDash = new javax.swing.JMenuItem();
        jMenuItemSearch = new javax.swing.JMenuItem();
        jMenuItemClearSearchMatches = new javax.swing.JMenuItem();
        jMenuTools = new javax.swing.JMenu();
        jMenuMuscle = new javax.swing.JMenuItem();
        jMenuItemCompare = new javax.swing.JMenuItem();
        jMenuView = new javax.swing.JMenu();
        jMenuItemViewGLOCSADetails = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Glocser");
        setIconImages(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jCheckBoxAutoRefresh.setFont(new java.awt.Font("DejaVu Sans", 0, 10));
        jCheckBoxAutoRefresh.setText("Autorefresh");
        jCheckBoxAutoRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAutoRefreshActionPerformed(evt);
            }
        });

        jButtonRefresh.setFont(new java.awt.Font("DejaVu Sans", 0, 10));
        jButtonRefresh.setText("Refresh");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        jMenuFile.setText("File");

        jMenuItemOpen.setText("Open alignment ...");
        jMenuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemOpen);

        jMenuItemOpenNewWindow.setText("Open alignment in new window ...");
        jMenuItemOpenNewWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenNewWindowActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemOpenNewWindow);

        jMenuItemSave.setText("Save alignment");
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSave);

        jMenuItemSaveAs.setText("Save alignment as ...");
        jMenuItemSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveAsActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSaveAs);

        jMenuItemClose.setText("Close alignment");
        jMenuItemClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCloseActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemClose);

        jMenuBar.add(jMenuFile);

        jMenuData.setText("Data");

        jMenuItemDegap.setText("Degap");
        jMenuItemDegap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDegapActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuItemDegap);

        jMenuItemPurgeDashColumns.setText("Purge '-' only columns");
        jMenuItemPurgeDashColumns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPurgeDashColumnsActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuItemPurgeDashColumns);

        jMenuItemReplaceNwithDash.setText("Replace 'N' with '-'");
        jMenuItemReplaceNwithDash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReplaceNwithDashActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuItemReplaceNwithDash);

        jMenuItemReplaceDotWithDash.setText("Replace '.' with '-'");
        jMenuItemReplaceDotWithDash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReplaceDotWithDashActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuItemReplaceDotWithDash);

        jMenuItemReplaceAllQmwithDash.setText("Replace '?' with '-'");
        jMenuItemReplaceAllQmwithDash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReplaceAllQmwithDashActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuItemReplaceAllQmwithDash);

        jMenuItemReplaceQMwithDash.setText("Replace initial & final '?' with '-'");
        jMenuItemReplaceQMwithDash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReplaceQMwithDashActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuItemReplaceQMwithDash);

        jMenuItemSearch.setText("Search...");
        jMenuItemSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSearchActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuItemSearch);

        jMenuItemClearSearchMatches.setText("Clear search matches");
        jMenuItemClearSearchMatches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClearSearchMatchesActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuItemClearSearchMatches);

        jMenuBar.add(jMenuData);

        jMenuTools.setText("Tools");

        jMenuMuscle.setText("Align with ext. tool...");
        jMenuMuscle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExtToolAlignActionPerformed(evt);
            }
        });
        jMenuTools.add(jMenuMuscle);

        jMenuItemCompare.setText("Compare alignments...");
        jMenuItemCompare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCompareActionPerformed(evt);
            }
        });
        jMenuTools.add(jMenuItemCompare);

        jMenuBar.add(jMenuTools);

        jMenuView.setText("View");

        jMenuItemViewGLOCSADetails.setText("GLOCSA Details");
        jMenuItemViewGLOCSADetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemViewGLOCSADetailsActionPerformed(evt);
            }
        });
        jMenuView.add(jMenuItemViewGLOCSADetails);

        jMenuBar.add(jMenuView);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alignmentOnlyPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(glocsaRatingMiniPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alignmentInfoMiniPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonRefresh)
                            .addComponent(jCheckBoxAutoRefresh))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(glocsaRatingMiniPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alignmentInfoMiniPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jCheckBoxAutoRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRefresh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alignmentOnlyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jMenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenActionPerformed
    openAlignmentAction();
}//GEN-LAST:event_jMenuItemOpenActionPerformed

public void openAlignmentAction(){
    
    jFileChooserOpenAlignment.setCurrentDirectory(currentDirectory);

    int result = jFileChooserOpenAlignment.showOpenDialog(this);

    selectedFile = jFileChooserOpenAlignment.getSelectedFile();

    currentDirectory = jFileChooserOpenAlignment.getCurrentDirectory();
    configuration.setProperty("currentDirectory", currentDirectory.getPath());
    try {
        configuration.store(new FileWriter(propertiesFileName), "");
    } catch (IOException ex) {
        Logger.getLogger(GlocserFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("currentDirectory: " + currentDirectory);

    FileFilter fileFilterSelected = jFileChooserOpenAlignment.getFileFilter();

    if (result == JFileChooser.APPROVE_OPTION) {
        try {

            //System.out.println("FileFilter selected: " + fileFilterSelected.getDescription());

            if (fileFilterSelected == fastaFileFilter) {

                openDynamicAlignment = new DynamicAlignment(new Alignment(new FileReader(selectedFile)));

            } else if (fileFilterSelected == hennig86FileFilter) {

                int hennig86FileType = Hennig86Reader.readHennig86FileType(selectedFile);
                System.out.println("Hennig86 FileType: " + hennig86FileType);
                switch (hennig86FileType) {
                    case Hennig86Reader.XREAD:
                        openDynamicAlignment = new DynamicAlignment(Hennig86Reader.readHennig86FileNumericDNA(selectedFile));
                        break;
                    case Hennig86Reader.DREAD:
                        openDynamicAlignment = new DynamicAlignment(Hennig86Reader.readHennig86FileDNA(selectedFile));
                        break;
                    case Hennig86Reader.UNKNOWN:
                        JOptionPane.showMessageDialog(rootPane, "Could not determine the type of the Hennig86 File; \"xread\" or \"dread\" were not found.", "Error: File could not be read", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException("Could not determine the type of the Hennig86 File; \"xread\" or \"dread\" were not found.");
                    case Hennig86Reader.ERROR:
                        JOptionPane.showMessageDialog(rootPane, "Error reading the file, while trying to identify the type of Hennig86 File.", "Error: File could not be read", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException("Error reading the file, while trying to identify the type of Hennig86 File.");
                    default:
                        JOptionPane.showMessageDialog(rootPane, "Could not determine the type of the Hennig86 File", "Error: File could not be read", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException("Could not determine the type of the Hennig86 File");
                }

            } else {
                System.out.println("Fasta format will be assumed");
                openDynamicAlignment = new DynamicAlignment(new Alignment(new FileReader(selectedFile)));
            }

            firstTimeEvaluateAndFill();
            activateCommandsAlignment();
            this.setTitle("Glocser - " + selectedFile.getName());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GlocserFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "File Not Found", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(GlocserFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (NonSupportedAlignmentException ex) {
            Logger.getLogger(GlocserFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Non Supported Alignment", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}

private void jMenuItemViewGLOCSADetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemViewGLOCSADetailsActionPerformed

    java.awt.EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            glocsaDetailsFrame = new GlocsaDetailsFrame();
            glocsaDetailsFrame.setOpenDynamicAlignment(openDynamicAlignment);
            glocsaDetailsFrame.setOpenAlignmentFile(getSelectedFile());
            evaluateAndFillGlocsaRatingPanel();
            glocsaDetailsFrame.setGlocsaRating(lastGlocsaRating);
            glocsaDetailsFrame.setEventCount(lastEventCount);
            glocsaDetailsFrame.createCharts();

            glocsaDetailsFrame.setVisible(true);
        }
    });

}//GEN-LAST:event_jMenuItemViewGLOCSADetailsActionPerformed

private void jMenuExtToolAlignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExtToolAlignActionPerformed

    ExternalToolAlignFrame extToolAlignFrame = new ExternalToolAlignFrame(configuration, propertiesFileName, openDynamicAlignment, this);

    java.awt.EventQueue.invokeLater(extToolAlignFrame);

    unSavedChangesExist = true;
    alignmentToolPath = configuration.getProperty("alignmentToolPath", alignmentToolPathDefault);
    alignmentToolOptions = configuration.getProperty("alignmentToolOptions", alignmentToolOptionsDefault);

}//GEN-LAST:event_jMenuExtToolAlignActionPerformed

private void jMenuItemReplaceNwithDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReplaceNwithDashActionPerformed

    openDynamicAlignment = new DynamicAlignment(BaseGapReplacer.replaceNwithGap(openDynamicAlignment.getMinimalAlignment()));
    evaluateAndFill();

}//GEN-LAST:event_jMenuItemReplaceNwithDashActionPerformed

private void jMenuItemPurgeDashColumnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPurgeDashColumnsActionPerformed

    Alignment minimalAlignment = openDynamicAlignment.getMinimalAlignment();
    minimalAlignment.purgeAlignment();
    openDynamicAlignment = new DynamicAlignment(minimalAlignment);
    evaluateAndFill();
    unSavedChangesExist = true;

}//GEN-LAST:event_jMenuItemPurgeDashColumnsActionPerformed

private void jMenuItemDegapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDegapActionPerformed

    openDynamicAlignment.degap();
    evaluateAndFill();
    unSavedChangesExist = true;

}//GEN-LAST:event_jMenuItemDegapActionPerformed

private void jMenuItemReplaceQMwithDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReplaceQMwithDashActionPerformed

    Alignment minimalAlignment = openDynamicAlignment.getMinimalAlignment();
    minimalAlignment.replaceIFQMWithDashes();
    openDynamicAlignment = new DynamicAlignment(minimalAlignment);
    evaluateAndFill();
    unSavedChangesExist = true;

}//GEN-LAST:event_jMenuItemReplaceQMwithDashActionPerformed

private void jMenuItemReplaceDotWithDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReplaceDotWithDashActionPerformed

    Alignment minimalAlignment = openDynamicAlignment.getMinimalAlignment();
    minimalAlignment.replaceDotsWithDashes();
    openDynamicAlignment = new DynamicAlignment(minimalAlignment);
    evaluateAndFill();
    unSavedChangesExist = true;

}//GEN-LAST:event_jMenuItemReplaceDotWithDashActionPerformed

private void jMenuItemReplaceAllQmwithDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReplaceAllQmwithDashActionPerformed

    Alignment minimalAlignment = openDynamicAlignment.getMinimalAlignment();
    minimalAlignment.replaceQMWithDashes();
    openDynamicAlignment = new DynamicAlignment(minimalAlignment);
    evaluateAndFill();
    unSavedChangesExist = true;

}//GEN-LAST:event_jMenuItemReplaceAllQmwithDashActionPerformed

private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed

    try {
        //alignmentOnlyPanel.regenerateAlignmentEvaluation();
        Alignment minimalAlignment = openDynamicAlignment.getMinimalAlignment();
        minimalAlignment.writeAlignment(selectedFile);
        unSavedChangesExist = false;

    } catch (IOException ex) {

        Logger.getLogger(GlocserFrame.class.getName()).log(Level.SEVERE, null, ex);

        JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error: File could not be saved.", JOptionPane.ERROR_MESSAGE);

    }

}//GEN-LAST:event_jMenuItemSaveActionPerformed

private void jMenuItemSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveAsActionPerformed

    jFileChooserSaveAlignment.setCurrentDirectory(currentDirectory);

    int result = jFileChooserSaveAlignment.showSaveDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        try {

            //alignmentOnlyPanel.regenerateAlignmentEvaluation();
            Alignment minimalAlignment = openDynamicAlignment.getMinimalAlignment();
            selectedFile = jFileChooserSaveAlignment.getSelectedFile();
            minimalAlignment.writeAlignment(selectedFile);
            unSavedChangesExist = false;

            this.setTitle("Glocser - " + selectedFile.getName());


            currentDirectory = jFileChooserSaveAlignment.getCurrentDirectory();
            configuration.setProperty("currentDirectory", currentDirectory.getPath());
            try {
                configuration.store(new FileWriter(propertiesFileName), "");
            } catch (IOException ex) {
                Logger.getLogger(GlocserFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("currentDirectory: " + currentDirectory);


        } catch (IOException ex) {

            Logger.getLogger(GlocserFrame.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error: File could not be saved.", JOptionPane.ERROR_MESSAGE);
        }

    }

}//GEN-LAST:event_jMenuItemSaveAsActionPerformed

private void jMenuItemCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCloseActionPerformed

    openDynamicAlignment = null;
    alignmentOnlyPanel.clearPanel();
    glocsaRatingMiniPanel.clearPanel();
    alignmentInfoMiniPanel.clearPanel();

    if (glocsaDetailsFrame != null) {
        glocsaDetailsFrame.dispose();
    }

    deactivateCommandsAlignment();

    this.setTitle("Glocser");

}//GEN-LAST:event_jMenuItemCloseActionPerformed

private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
    //alignmentOnlyPanel.regenerateAlignmentEvaluation();
    evaluateAndFillGlocsaRatingPanel();
}//GEN-LAST:event_jButtonRefreshActionPerformed

private void jCheckBoxAutoRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAutoRefreshActionPerformed
    //alignmentOnlyPanel.setAutorefresh(jCheckBoxAutoRefresh.isSelected());
    autorefreshRating = jCheckBoxAutoRefresh.isSelected();
}//GEN-LAST:event_jCheckBoxAutoRefreshActionPerformed

private void jMenuItemSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSearchActionPerformed

    searchFrame.setLocationRelativeTo(this);
    searchFrame.setVisible(true);
    searchFrame.setState(Frame.NORMAL);
    searchFrame.requestFocus();

}//GEN-LAST:event_jMenuItemSearchActionPerformed

private void jMenuItemClearSearchMatchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClearSearchMatchesActionPerformed
    // TODO add your handling code here:
    alignmentOnlyPanel.clearHighLigths();
}//GEN-LAST:event_jMenuItemClearSearchMatchesActionPerformed

private void jMenuItemOpenNewWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenNewWindowActionPerformed

    glocserLoader.loadNewGlocserFrameOpen();

}//GEN-LAST:event_jMenuItemOpenNewWindowActionPerformed

private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    glocserLoader.closeGlocserFrame(this);

}//GEN-LAST:event_formWindowClosed

private void jMenuItemCompareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCompareActionPerformed

    glocserLoader.showCompareAlignmentsFrame(this);

}//GEN-LAST:event_jMenuItemCompareActionPerformed

    private void deactivateCommandsAlignment() {

        jMenuTools.setEnabled(false);
        jMenuData.setEnabled(false);
        jMenuView.setEnabled(false);

        jMenuItemSave.setEnabled(false);
        jMenuItemSaveAs.setEnabled(false);
        jMenuItemClose.setEnabled(false);
        jMenuItemOpenNewWindow.setEnabled(false);

        jCheckBoxAutoRefresh.setEnabled(false);
        jButtonRefresh.setEnabled(false);


    }

    private void activateCommandsAlignment() {

        jMenuTools.setEnabled(true);
        jMenuData.setEnabled(true);
        jMenuView.setEnabled(true);

        jMenuItemSave.setEnabled(true);
        jMenuItemSaveAs.setEnabled(true);
        jMenuItemClose.setEnabled(true);
        jMenuItemOpenNewWindow.setEnabled(true);

        jCheckBoxAutoRefresh.setEnabled(true);
        jButtonRefresh.setEnabled(true);
    }

    public void evaluateAndFillGlocsaRatingPanel() {

        Alignment minimalAlignment = openDynamicAlignment.getMinimalAlignment();
        lastGlocsaRating = rater.rate(minimalAlignment);
        glocsaRatingMiniPanel.setRating(lastGlocsaRating);
        lastEventCount = EventCounter.countEvents(minimalAlignment);
        glocsaRatingMiniPanel.setEventCount(lastEventCount);
        glocsaRatingMiniPanel.refreshAllData();

    }

    private void evaluateAndFill() {

        alignmentOnlyPanel.setOpenDynamicAlignment(openDynamicAlignment);
        alignmentOnlyPanel.loadAlignmentTable();
        alignmentOnlyPanel.loadTaxaNamesTable();

        if (autorefreshRating) {
            evaluateAndFillGlocsaRatingPanel();
        }

        alignmentInfoMiniPanel.setOpenDynanicAlignment(openDynamicAlignment);
        alignmentInfoMiniPanel.refreshAllData();

    }

    private void firstTimeEvaluateAndFill() {

        alignmentOnlyPanel.setOpenDynamicAlignment(openDynamicAlignment);
        alignmentOnlyPanel.loadAlignmentTable();
        alignmentOnlyPanel.loadTaxaNamesTable();

        evaluateAndFillGlocsaRatingPanel();

        alignmentInfoMiniPanel.setOpenDynanicAlignment(openDynamicAlignment);
        alignmentInfoMiniPanel.refreshAllData();

    }

//    public void reEvaluateAndRefresh() {
//
//        //alignmentOnlyPanel.setOpenDynamicAlignment(openDynamicAlignment);
//        //alignmentOnlyPanel.loadAlignmentTable();
//        //alignmentOnlyPanel.loadTaxaNamesTable();
//
//        if (autorefreshRating) {
//            evaluateAndFillGlocsaRatingPanel();
//        }
//
//        alignmentInfoMiniPanel.setOpenDynanicAlignment(openDynamicAlignment);
//        alignmentInfoMiniPanel.refreshAllData();
//
//        unSavedChangesExist = true;
//
//    }
    public void selectPositionAlignment(int sequence, int position) {
        alignmentOnlyPanel.selectPositionAlignment(sequence, position);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private edu.unam.iimas.glocsa.glocser.AlignmentInfoMiniPanel alignmentInfoMiniPanel;
    private edu.unam.iimas.glocsa.glocser.alignmentpanel.AlignmentOnlyPanel alignmentOnlyPanel;
    private edu.unam.iimas.glocsa.glocser.GlocsaRatingMiniPanel glocsaRatingMiniPanel;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JCheckBox jCheckBoxAutoRefresh;
    private javax.swing.JFileChooser jFileChooserOpenAlignment;
    private javax.swing.JFileChooser jFileChooserSaveAlignment;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuData;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemClearSearchMatches;
    private javax.swing.JMenuItem jMenuItemClose;
    private javax.swing.JMenuItem jMenuItemCompare;
    private javax.swing.JMenuItem jMenuItemDegap;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemOpenNewWindow;
    private javax.swing.JMenuItem jMenuItemPurgeDashColumns;
    private javax.swing.JMenuItem jMenuItemReplaceAllQmwithDash;
    private javax.swing.JMenuItem jMenuItemReplaceDotWithDash;
    private javax.swing.JMenuItem jMenuItemReplaceNwithDash;
    private javax.swing.JMenuItem jMenuItemReplaceQMwithDash;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JMenuItem jMenuItemSaveAs;
    private javax.swing.JMenuItem jMenuItemSearch;
    private javax.swing.JMenuItem jMenuItemViewGLOCSADetails;
    private javax.swing.JMenuItem jMenuMuscle;
    private javax.swing.JMenu jMenuTools;
    private javax.swing.JMenu jMenuView;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the openDynamicAlignment
     */
    public DynamicAlignment getOpenDynamicAlignment() {
        return openDynamicAlignment;
    }

    /**
     * @param openDynamicAlignment the openDynamicAlignment to set
     */
//    public void setOpenDynamicAlignment(DynamicAlignment openDynamicAlignment) {
//        this.openDynamicAlignment = openDynamicAlignment;
//    }
//
//    public void setOpenDynamicAlignment(Alignment minimalAlignment) {
//        this.openDynamicAlignment = new DynamicAlignment(minimalAlignment);
//    }
    public void setNewOpenDynamicAlignment(DynamicAlignment openDynamicAlignment) {
        this.openDynamicAlignment = openDynamicAlignment;
        firstTimeEvaluateAndFill();
    }

    public void fireDynamicAlignmentChangedFromAlignmentPanel() {

        if (autorefreshRating) {
            evaluateAndFillGlocsaRatingPanel();
        }

        alignmentInfoMiniPanel.setOpenDynanicAlignment(openDynamicAlignment);
        alignmentInfoMiniPanel.refreshAllData();

    }

    /**
     * @return the alignmentOnlyPanel
     */
    public AlignmentOnlyPanel getAlignmentOnlyPanel() {
        return alignmentOnlyPanel;
    }

    /**
     * @param alignmentOnlyPanel the alignmentOnlyPanel to set
     */
    public void setAlignmentOnlyPanel(edu.unam.iimas.glocsa.glocser.alignmentpanel.AlignmentOnlyPanel alignmentOnlyPanel) {
        this.alignmentOnlyPanel = alignmentOnlyPanel;
    }

    /**
     * @return the selectedFile
     */
    public File getSelectedFile() {
        return selectedFile;
    }

    /**
     * @param selectedFile the selectedFile to set
     */
    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }
}

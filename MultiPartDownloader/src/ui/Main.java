package ui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import core.ManifestFile;

public class Main extends JFrame { 
   String filelist;
	
   public static void main(String args[])
   {
		 Main sfc = new Main();
		 sfc.setVisible(true);
   }
   
   public Main() {
    super("File Chooser Test Frame");
    setSize(350, 200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    
    JButton openButton = new JButton("Pick Manifest File");
    JButton startDownload = new JButton("Start Download");
    
    final JLabel statusbar = 
                 new JLabel("Output of your selection will go here");

    //Start Downloading, call manifest file
    startDownload.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
        ManifestFile manifest_file = new ManifestFile(filelist);
        manifest_file.fetchFileFromPath();
        	
        }
      });
    
    // Create a file chooser that opens up as an Open dialog
    openButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        int option = chooser.showOpenDialog(Main.this);
        if (option == JFileChooser.APPROVE_OPTION) {
          File[] sf = chooser.getSelectedFiles();
          filelist = "nothing";
          if (sf.length > 0) filelist = sf[0].getName();
          for (int i = 1; i < sf.length; i++) {
            filelist += ", " + sf[i].getName();
          }
          statusbar.setText("You chose " + filelist);
        }
        else {
          statusbar.setText("You canceled.");
        }
      }
    });

    c.add(openButton);
    c.add(statusbar);
    c.add(startDownload);
  }
}

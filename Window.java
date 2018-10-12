
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.awt.Color;


public class Window extends javax.swing.JFrame {

    static final Color COLOR_WINDOW_BACKGROUND = new java.awt.Color(153, 153, 153);
    static final Color COLOR_BUTTONS = new java.awt.Color(51, 204, 255);
    
    // All of our nodes
    ActivityTree tree;

    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonConnect;
    private javax.swing.JButton jButtonRestart;
    private javax.swing.JButton jButtonEnd;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JButton jButtonAbout;
    private javax.swing.JButton jButtonProcess;
    
    private javax.swing.JPanel  jPanel1;
    
    private static final int APPLET_WIDTH = 800, APPLET_HEIGHT = 600;
    

    public Window() {
        
        tree = new ActivityTree();

        initComponents();
    }

    private void initComponents() {
    	
    	//jPanel Creation
        jPanel1 = new Panel( tree );
        
        //jButton Creation
        jButtonAdd =        new javax.swing.JButton();
        jButtonConnect =    new javax.swing.JButton();
        jButtonRestart =    new javax.swing.JButton();
        jButtonEnd =        new javax.swing.JButton();
        jButtonHelp =       new javax.swing.JButton();
        jButtonAbout =      new javax.swing.JButton();
        jButtonProcess =    new javax.swing.JButton();
        
        //EXIT ON CLOSE as Default
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        //Title
        setTitle("Network Diagram");
        
        //Set background
        jPanel1.setBackground( COLOR_WINDOW_BACKGROUND );
        
        /**LAYOUT**/
        
        //Set group layout on jpanel1
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        
        //Set horizontal group
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE));
        
        //Set vertical group
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)); 
        
        /**END LAYOUT**/
        
        
        /**BUTTON SETUP**/
        
        /*All buttons setup with setBackground, setText, and configured ActionListener*/
        
        //End Application Button
        jButtonEnd.setBackground(COLOR_BUTTONS);
        jButtonEnd.setText("End Application");
        
        jButtonEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEndActionPerformed(evt);
            }
        });
        
        //Restart Button
        jButtonRestart.setBackground(COLOR_BUTTONS);
        jButtonRestart.setText("Restart");
        
        jButtonRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRestartActionPerformed(evt);
            }
        });
        
        //Add Activity Button
        jButtonAdd.setBackground(COLOR_BUTTONS);
        jButtonAdd.setText("Add Activity");
        
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed();
            }
        });
        
        //Connect Activities Button
            // jButtonConnect.setBackground(COLOR_BUTTONS);
            // jButtonConnect.setText("Connect Activities");
            
            // jButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            //     public void actionPerformed(java.awt.event.ActionEvent evt) {
            //         jButtonConnectActionPerformed(evt);
            //     }
            // });
        
      //About Button
        jButtonAbout.setBackground(COLOR_BUTTONS);
        jButtonAbout.setText("About");
        
        jButtonAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAboutActionPerformed(evt);
            }
        });
        
        //Help Button
        jButtonHelp.setBackground(COLOR_BUTTONS);
        jButtonHelp.setText("Help");
        
        jButtonHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHelpActionPerformed(evt);
            }
        });
        
      //Process Button
        jButtonProcess.setBackground(COLOR_BUTTONS);
        jButtonProcess.setText("Process");
        
        jButtonProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProcessActionPerformed(evt);
            }
        });
        
        
        /**END BUTTON SETUP**/
        
        /**ADDING COMPONENTS TO JPANEL**/
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                	.addComponent(jButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                	    // .addComponent(jButtonConnect, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                	.addComponent(jButtonProcess, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(jButtonRestart, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(jButtonAbout, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(jButtonHelp, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(jButtonEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    // .addComponent(jButtonConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    // .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()))))));
        //PACK
        pack();
        //SETSIZE
        setSize(APPLET_WIDTH, APPLET_HEIGHT);
        
        /**END ADDING COMPONENTS TO JPANEL**/
       
    }
    
    /**ACTIONS**/
    private void jButtonAddActionPerformed(){
        jButtonAddActionPerformed( "", "", "10" );
    } 
    private void jButtonAddActionPerformed( String nameS, String parentsS, String durationS ) {
       
        // We need name duration and parents field
         javax.swing.JTextField name =      new javax.swing.JTextField( nameS );
         javax.swing.JTextField duration =  new javax.swing.JTextField( durationS );
         javax.swing.JTextField parents =   new javax.swing.JTextField( parentsS );

        final javax.swing.JComponent[] inputs = new javax.swing.JComponent[] {
                new javax.swing.JLabel("Name"), name,
                new javax.swing.JLabel("Dependencies"), parents,
                new javax.swing.JLabel("Duration"), duration
        };
       

        int result = JOptionPane.showConfirmDialog(this, inputs, "Add Activity", JOptionPane.PLAIN_MESSAGE);
        nameS = name.getText();
        durationS = duration.getText();
        parentsS = parents.getText();
        
        if (result == JOptionPane.OK_OPTION) {
            // Add activity
            String err = "";
            switch( tree.AddActivity( nameS, durationS, parentsS ) ) {
                case ActivityTree.CREATE_OK: 
                    repaint();
                    return;

                case ActivityTree.CREATE_NONAME:
                    err = "PLEASE PROVIDE A NAME.";
                    break;
                
                case ActivityTree.CREATE_EXISTS:
                    err = "THIS ACTIVITY EXISTS.";
                    break;
                
                case ActivityTree.CREATE_DURATION:
                    err = "INVALID DURATION TYPE.";
                    break;
            }

            JOptionPane.showMessageDialog( this, err, "HEY!! We got a PROBLEM.", JOptionPane.ERROR_MESSAGE );
            jButtonAddActionPerformed( nameS, durationS, parentsS );

        } else {
            // nothing for now. exit.
        }

    }

    // private void jButtonConnectActionPerformed(java.awt.event.ActionEvent evt) {

    //     JOptionPane.showMessageDialog(this, "Right click the predecessor activity to link the activities.");
    // }
    
    private void jButtonRestartActionPerformed(java.awt.event.ActionEvent evt) {

        JOptionPane.showMessageDialog(this, "Network Diagram Cleared."); 
        tree.clear();

        repaint();
    }
    
    private void jButtonEndActionPerformed(java.awt.event.ActionEvent evt) {

        JOptionPane.showMessageDialog(this, "Application will close.");
        System.exit(0);
    }
    
    private void jButtonAboutActionPerformed(java.awt.event.ActionEvent evt) {

        JOptionPane.showMessageDialog(this, "Created by\n"
        		+ "Raquel Fierros    Andrew Resto    Aaron Gurrola\n"
        		+"\nThe program is designed to process activity diagrams from user inputs.");
    }
    
    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {

        JOptionPane.showMessageDialog(this, "Start by creating an activity node."
        		+"\nNodes which don't have dependencies are heads.\n"
                + "Clicking add activity allows you to create an activity.\n"
                + "Clicking process allows the program to finalyze and analyze the network.\n"
        		+"To exit the program, press the End Application button.");
    }
    
    private void jButtonProcessActionPerformed(java.awt.event.ActionEvent evt) {
        
        Processor p = new Processor( tree );

        if( !p.hasNoLoops() ){
            JOptionPane.showMessageDialog( this, "We found a loop in your network.\n You should fix that.", "HEY!! We got a PROBLEM.", JOptionPane.ERROR_MESSAGE );
        } else if( !p.hasAllConnections() ){
            JOptionPane.showMessageDialog( this, "Looks like you gave us a network with a point without a connection.\n That's not how networks work.\n Fix it.", "HEY!! We got a PROBLEM.", JOptionPane.ERROR_MESSAGE );
        } else if(!p.parentFinder()) {
        	JOptionPane.showMessageDialog( this, "Parent node is not found in network path. \n That's not how networks work.\n Fix it.", "HEY!! We got a PROBLEM.", JOptionPane.ERROR_MESSAGE );
        } else {
            p.buildPaths();   
            JOptionPane.showMessageDialog(this, p.outputString());
        }
    }
    
    /**END ACTIONS**/
    
    public static void main(String args[]) {

    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });

    }
}

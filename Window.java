
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.awt.Point;
import java.util.Scanner;


public class Window extends javax.swing.JFrame {
	
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonConnect;
    private javax.swing.JButton jButtonRestart;
    private javax.swing.JButton jButtonEnd;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JButton jButtonAbout;
    private javax.swing.JButton jButtonProcess;
    
    private javax.swing.JPanel  jPanel1;
    
    public List<Node> nodes;
    public List<Add> connect;
    
    private int APPLET_WIDTH = 800, APPLET_HEIGHT = 600;
    
    public Window() {
        
        initComponents();
    }

    private void initComponents() {
        // Node and connection data
        this.nodes = new ArrayList<>();
        this.connect = new ArrayList<>();
        
        //jPanel Creation
        jPanel1 = new Panel( this.nodes, this.connect, new Panel.NodeCreator(){
            public Node createNode( Point point ){
                return actionCreateNode( point );
            }
        } );
        
        //jButton Creation
        jButtonAdd = new javax.swing.JButton();
        jButtonConnect = new javax.swing.JButton();
        jButtonRestart = new javax.swing.JButton();
        jButtonEnd = new javax.swing.JButton();
        jButtonHelp = new javax.swing.JButton();
        jButtonAbout = new javax.swing.JButton();
        jButtonProcess = new javax.swing.JButton();
        
        //EXIT ON CLOSE as Default
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        //Title
        setTitle("Network Diagram");
        
        //Set background
        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        
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
        jButtonEnd.setBackground(new java.awt.Color(51, 204, 255));
        jButtonEnd.setText("End Application");
        
        jButtonEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEndActionPerformed(evt);
            }
        });
        
        //Restart Button
        jButtonRestart.setBackground(new java.awt.Color(51, 204, 255));
        jButtonRestart.setText("Restart");
        
        jButtonRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRestartActionPerformed(evt);
            }
        });
        
        //Add Activity Button
        jButtonAdd.setBackground(new java.awt.Color(51, 204, 255));
        jButtonAdd.setText("Add Activity");
        
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        
        //Connect Activities Button
        jButtonConnect.setBackground(new java.awt.Color(51, 204, 255));
        jButtonConnect.setText("Connect Activities");
        
        jButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectActionPerformed(evt);
            }
        });
        
      //About Button
        jButtonAbout.setBackground(new java.awt.Color(51, 204, 255));
        jButtonAbout.setText("About");
        
        jButtonAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAboutActionPerformed(evt);
            }
        });
        
        //About Button
        jButtonHelp.setBackground(new java.awt.Color(51, 204, 255));
        jButtonHelp.setText("Help");
        
        jButtonHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHelpActionPerformed(evt);
            }
        });
        
      //About Button
        jButtonProcess.setBackground(new java.awt.Color(51, 204, 255));
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
                	.addComponent(jButtonConnect, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
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
                                .addComponent(jButtonConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {
       
       JOptionPane.showMessageDialog( this, "Click where you want the activity located.");
    }

    private void jButtonConnectActionPerformed(java.awt.event.ActionEvent evt) {

        JOptionPane.showMessageDialog( this, "Right click the predecessor activity to link the activities.");
    }
    
    private void jButtonRestartActionPerformed(java.awt.event.ActionEvent evt) {

        JOptionPane.showMessageDialog( this, "Network Diagram Cleared."); 
        
        // We clear our data here.
        connect.clear(); 
        nodes.clear();

        repaint();
    }
    
    private void jButtonEndActionPerformed(java.awt.event.ActionEvent evt) {

        JOptionPane.showMessageDialog( this, "Application will close.");
        System.exit(0);
    }
    
    private void jButtonAboutActionPerformed(java.awt.event.ActionEvent evt) {

        JOptionPane.showMessageDialog( this, "Created by\n"
        		+ "Raquel Fierros    Andrew Resto    Aaron Gurrola\n"
        		+"\nThe program is designed to process activity diagrams from user inputs.");
    }
    
    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {

        JOptionPane.showMessageDialog( this, "Start by creating an activity node."
        		+"\nThe first node created is the head.\n"
        		+ "Pressing any button, and it will create a dialogue box with information on the button.\n"
        		+"To exit the program, press the End Application button.");
    }
    
    private void jButtonProcessActionPerformed(java.awt.event.ActionEvent evt) {
        
        Processor p = new Processor( this.nodes );
        p.buildPaths();

        if( p.failed() ){
            JOptionPane.showMessageDialog( this, p.failureMessage(), "HEY!! We got a PROBLEM.", JOptionPane.ERROR_MESSAGE );
        } else {
            JOptionPane.showMessageDialog( this, p.outputString());
        }
    }

    private Node actionCreateNode( Point point ){
        return actionCreateNode( "N" + String.valueOf( nodes.size() ), "10", point );
    } 

    private Node actionCreateNode( String nameS, String durationS, Point point ) {
       
        // We need name duration and parents field
         javax.swing.JTextField name =      new javax.swing.JTextField( nameS );
         javax.swing.JTextField duration =  new javax.swing.JTextField( durationS );

        final javax.swing.JComponent[] inputs = new javax.swing.JComponent[] {
                new javax.swing.JLabel("Name"), name,
                new javax.swing.JLabel("Duration"), duration
        };
       
        // get results from input
        int result = JOptionPane.showConfirmDialog(this, inputs, "Add Activity", JOptionPane.PLAIN_MESSAGE);
        nameS = name.getText();
        durationS = duration.getText();

        if( result == JOptionPane.OK_OPTION ){
            // check if input valid, else retry
            String err = "ERROR";
            
            boolean invalidName = ( nameS.equals(null) || nameS.replace(" ", "").equals("") );
            boolean invalidDuration = true;

            // Get integer
            int foundDuration = 0;
            Scanner scanner = new Scanner(durationS);
            if( scanner.hasNextInt() ){
                foundDuration = scanner.nextInt();
                // don't want more than 1 integer in box
                invalidDuration = scanner.hasNext();
            }

            if( invalidName ){
                err = "An invalid name has been entered";
            }
            else if( invalidDuration ){
                err = "Please enter an integer value.";
            } else {
                
                Node n = new Node();
                n.setActivityName( nameS );
                n.setActivityDuration( foundDuration );
                n.setPoint( point );

                this.nodes.add( n );
                return n;
            }

            JOptionPane.showMessageDialog( this, err, "HEY!! We got a PROBLEM.", JOptionPane.ERROR_MESSAGE );
            return actionCreateNode( nameS, durationS, point );
        } else {
            // cancled? 
            return null;
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

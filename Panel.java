import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Panel extends javax.swing.JPanel {
    
    boolean flag = false;
    Node predecessor;
    Node destination;
    
    public static List <Node> nodes;
    public static List <Add> connect;
    
    
    Processor pro = new Processor(nodes);
    Font nodeFont;
    
    
    public List<Node> getNodes() {
        return nodes;
    }

    public List<Add> getAdd() {
        return connect;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }    
    
    /**PANEL**/
    public Panel() {
        
        // nodeFont is reusable once instantiated since it is an object.
        nodeFont = new Font( "Verdana", Font.BOLD, 16 );
    	predecessor = null;
        destination = null;
        this.nodes = new ArrayList<>();
        this.connect = new ArrayList<>();
        
        addMouseListener(new MouseAdapter()
        { 
            public void mousePressed(MouseEvent e)
            { 
                if (e.getButton() == MouseEvent.BUTTON1)
                {
                    Node n = new Node();
                    
                    try {
                    	
                        String activityName = JOptionPane.showInputDialog("Enter the name of the activity: ");
                        
                        if (!activityName.equals(null) && !activityName.replace(" ", "").equals("")) {

                            n.setActivityName(activityName);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Write a valid activity name.");
                    }
                    
                    try{
                		String activityDuration = JOptionPane.showInputDialog("Enter the duration of the activity:");
                		int aDuration = Integer.parseInt(activityDuration);
                		n.setActivityDuration(aDuration);
                		n.setPoint(e.getPoint());
                		/*if (nodes.isEmpty())
                			n.setHead(true);*/
                        nodes.add(n); // add new node to the list
                        System.out.println("Size of nodes: " + nodes.size());
                	}catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Enter an integer for the duration.");
                        
                    }
                }
                repaint(); 
        } 
            
          public void mouseClicked(MouseEvent e) { 

            if (e.getButton() == MouseEvent.BUTTON3) {
            	
                // Create an arrow connection
                // Shows destination and duration
            	
                try {
                    if (!flag) {
                        try {
                        	predecessor = getNodeXY(e.getX(), e.getY());
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Select a correct Activity.");
                        }
                        
                        if (predecessor != null) {
                        flag = true;
                        JOptionPane.showMessageDialog(null, "Right click the destination.");
                        }
                    }
                    else if (flag) {
                        try {
                            destination = getNodeXY(e.getX(), e.getY());
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Select a correct Activity.");
                        }
                        
                        if (destination != null) {
                        	
                            Add a = new Add();
                            a.setPredecessor(predecessor);
                            a.setDestination(destination);
                            
                            predecessor.add(destination);
                            destination.incPredecessors();
                            destination.doesHasPredecessor();
                            
                            flag = false;
                            String duration = "";
                            int d = -1;
                            /**while (d == -1) {                                
                                try {
                                     duration = JOptionPane.showInputDialog("Enter the duration to get to next activity, if there is no duration enter 0.");
                                     d = Integer.parseInt(duration);
                                     
                                } catch (Exception ex) {
                                	JOptionPane.showMessageDialog(null, "Enter an integer for the duration.");
                                }
                               }**/
                            a.setDuration(d);
                            connect.add(a);
                            //predecessor.add(destination);
                            predecessor = null;
                            destination = null;
                        }
                    }
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error.");
                }
                //test
                repaint(); 
                }
          } 

        }); 
    }
   
    public void paint( Graphics g )
    {
        super.paint(g);

        // Drawing Nodes
        g.setFont( nodeFont ); // only need to set the graphics font once, it's cached
        for (Node node : nodes ) {
            drawNode( node, g );
        }
        
        // Drawing Arrows        
        for( Add adder : connect ){ 
            drawConnection( adder, g );
        }
    }
   
    public Node getNodeXY(int x, int y) {
        Point point = new Point( x, y );
        
        // find node
        for ( Node node : nodes ) {
            if( pointInCircle( point, node.getPoint(), 50 ) ) return node;
        }

        // did not find a node
        return null;
    }

    private boolean pointInCircle( Point point, Point pos, int rad ){
        return (( point.x >= pos.x )  && 
                ( point.x <= pos.x + rad ) && 
                ( point.y >= pos.y ) &&  
                ( point.y <= pos.y + rad ) );
    }

    // Draws a node, provided a node
    private void drawNode( Node node, Graphics g ){
        Point point = node.getPoint();
        
        // Fill
        g.setColor(Color.WHITE);
        g.fillOval( point.x, point.y, 50, 50 );
        g.setColor(Color.BLACK);

        // Inner text
        g.drawString( node.getActivityName(), point.x + 20, point.y + 25 );
        g.drawString( String.valueOf( node.getActivityDuration() ), point.x + 20, point.y + 43 );
        
        // Outline
        g.setColor(Color.BLUE);
        g.drawOval( point.x, point.y, 50, 50 );
    }

    // Draws the arrows between connected elements
    private void drawConnection( Add adder, Graphics g ){
        Point p1 = new Point( adder.getDestination().getPoint() );
        Point p2 = new Point( adder.getPredecessor().getPoint() );

        // 15 is the angle seperation, so 30 from head to head
        double angleSeparation = Math.toRadians( 180 - 15 );
        int size = 15;

        Point point1 = new Point( p2.x + 25, p2.y + 25);
        Point point2 = new Point( p1.x + 25, p1.y + 25);

        // angle from origin to destination
        double angle = Math.atan2( point2.y-point1.y, point2.x-point1.x );
        
        // shift the line to the edges of the circles
        point1.x += Math.cos( angle ) * 27.45;
        point1.y += Math.sin( angle ) * 27.45;
        point2.x -= Math.cos( angle ) * 27.45;
        point2.y -= Math.sin( angle ) * 27.45;
    
        // Defining the arrow tips on destination
        p1.x = (int)(point2.x + size*Math.cos( -angle - angleSeparation ) );
        p1.y = (int)(point2.y - size*Math.sin( -angle - angleSeparation ) );
        p2.x = (int)(point2.x + size*Math.cos( -angle + angleSeparation ) );
        p2.y = (int)(point2.y - size*Math.sin( -angle + angleSeparation ) );

        // color of arrow line
        g.setColor(Color.RED);
        
        ((Graphics2D)g).setStroke(new BasicStroke(2.5f));
        
        // Draw line and arrow-tip
        g.drawLine( point1.x, point1.y, point2.x, point2.y );
        g.drawLine( p1.x, p1.y, point2.x, point2.y );
        g.drawLine( p2.x, p2.y, point2.x, point2.y );
    }
    
	public static void restart() {
	    connect.clear(); 
    	nodes.clear();
	}
}

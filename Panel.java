import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


/**
 * 
 * This panel will draw all the nodes.
 * 
 */
public class Panel extends javax.swing.JPanel {    
    
    public ActivityTree tree;
    
    
    boolean flag = false;
    Node predecessor;
    Node destination;
    public static List <Node> nodes;
    public static List <Add> connect;

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Add> getAdd() {
        return connect;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void setAdd(List<Add> connect) {
        this.connect = connect;
    }
    
    /**PANEL**/
    public Panel( ActivityTree tree ) {
        
        this.tree = tree;
        
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
                        
                        if (activityName.equals(null) || activityName.replace(" ", "").equals("")) {
                           
                            JOptionPane.showMessageDialog(null, "Write a valid activity name.");
                       }
                        else
                        {
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
                        nodes.add(n); // add new node to the list
                        
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
                            
                            flag = false; 
                            connect.add(a);
                            predecessor = null;
                            destination = null;
                        }
                    }
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error.");
                }
                repaint(); 
                }
          } 
        }); 
    }
   
    public void paint (Graphics g)
    {
        super.paint(g);

        // Drawing Nodes
        for (int i = 0; i < nodes.size(); i++) {
            
            g.setColor(Color.WHITE);
            g.fillOval(nodes.get(i).getPoint().x, nodes.get(i).getPoint().y, 50, 50);
            g.setColor(Color.BLACK);
            g.setFont( new Font( "Verdana", Font.BOLD, 16 ) );
            g.drawString(nodes.get(i).getActivityName(), nodes.get(i).getPoint().x + 20, nodes.get(i).getPoint().y + 25);
            g.drawString("" + nodes.get(i).getActivityDuration(), nodes.get(i).getPoint().x + 20, nodes.get(i).getPoint().y + 43);
            g.setColor(Color.BLUE);
            g.drawOval(nodes.get(i).getPoint().x, nodes.get(i).getPoint().y, 50, 50);    
        }
        
        // Drawing Arrows
        Point p1 = new Point();
        Point p2 = new Point();
        
        for (int i = 0; i < connect.size(); i++) {
            System.out.println("" + connect.get(i).getDestination().getActivityName());
            p1.x = connect.get(i).getDestination().getPoint().x;
            p1.y = connect.get(i).getDestination().getPoint().y;
            p2.x = connect.get(i).getPredecessor().getPoint().x;
            p2.y = connect.get(i).getPredecessor().getPoint().y;
                          
            g.setColor(Color.DARK_GRAY);
           
            g.setColor(Color.black);
            
            double angle = 0.0;
            double angleSeparation = 0.0;
            double tx;
            double ty;
            int size = 0;
            Point point1 = null;
            Point point2 = null;
            
            point1 = new Point(p2.x+25,p2.y+25);
            point2 = new Point(p1.x+15,p1.y+15);

            // arrow size 
            size = 10;

            ty =-(point1.y-point2.y)*1.0;
            tx = (point1.x-point2.x)*1.0;
            
            angle = Math.atan(ty/tx);

            if(tx < 0)
            { 
            	// if negative add 180 degrees   
               angle += Math.PI;
            }

            Point point = point2;

            angleSeparation = 25.0;

            p1.x = (int)(point.x + size*Math.cos (angle-Math.toRadians (angleSeparation)));
            p1.y = (int)(point.y - size*Math.sin (angle-Math.toRadians (angleSeparation)));
            p2.x = (int)(point.x + size*Math.cos (angle+Math.toRadians (angleSeparation)));
            p2.y = (int)(point.y - size*Math.sin (angle+Math.toRadians (angleSeparation)));

            Graphics2D g2D = (Graphics2D)g;

            // color of arrow line
            g.setColor (Color.RED);
           
            g2D.setStroke (new BasicStroke(1.2f));
           
            g.drawLine (point1.x, point1.y, point.x, point.y);
            
            g.drawLine (p1.x, p1.y, point.x, point.y);
            g.drawLine (p2.x, p2.y, point.x, point.y);  
        }
    }
    public Node getNodeXY(int x, int y) {
        for (int i = 0; i < nodes.size(); i++) {
            System.out.println(x + "x  nod"+ nodes.get(i).getPoint().x);
           
            System.out.println(y + "y nod" + nodes.get(i).getPoint().y);
        if ((x >= nodes.get(i).getPoint().x  && x  <= nodes.get(i).getPoint().x + 50) && (y >= nodes.get(i).getPoint().y &&  y  <= nodes.get(i).getPoint().y + 50))
            return nodes.get(i); 
        }
        return null;
    }


/*
    We got a grid here.
    It basically allows us to generate a list of drawable nodes.
    The positions of these drawable nodes will not be screen coordinates,
        the positions will be the points on a grid.
        Their screen positions depend on the dimensions calculated in NodeGrid.cellWidth/Height
        Look at draw node.
    Or you can get the screen coordinates using the NodeGrid get DrawableNode Screen Pos.
*/
class NodeGrid {

    protected class DrawableNode {
        public Node node;
        final public Point point;

        public DrawableNode( Node node, Point point ){
            this.node = node;
            this.point = point;
        }
    }

    // in the future, spots may be better referencing the drawable node.
    private boolean[][] spots;
    public List<DrawableNode> nodes = new ArrayList<>();
    public int padding = 0;
    public int cellWidth = 0;
    public int cellHeight = 0;
    public int sepWidth = 0;
    public int sepHeight = 0;

    public NodeGrid( int size, int padding, int sep ){
        spots = new boolean[size][size];
        this.padding = padding;
        this.sepHeight = sep;
        this.sepWidth = sep;
    }

    protected NodeGrid build( ActivityTree tree, Graphics g, Font font ){
        List<Node> nodes = tree.getNodes();
        buildPositions( tree, nodes );
        String longString = longestString(  nodes ) + "@!#$";

        Rectangle2D rec = font.createGlyphVector(
                g.getFontMetrics().getFontRenderContext(), 
                longString).getVisualBounds();
        
        cellHeight =(int)rec.getHeight()*(2) + padding;
        cellWidth = (int)rec.getWidth() + padding;
        return this;
    }

    private String longestString( List<Node> nodes ){
        String longest = "";
        for( Node node : nodes ){
            if( node.getActivityName().length() > longest.length() ){
                longest = node.getActivityName();
            }
        }

        return longest;
    }    

    private void buildPositions( ActivityTree tree, List<Node> nodes ){
        for( Node node : tree.getNodes() ){
            int column = Math.min( tree.size()-1, tree.parentCountToRoots( node ));
            int row = 0;
            System.out.println("tree size:" + tree.size());
            for( int j = 0; j < tree.size(); j ++ ){
                if( !(spots[column][j]) ){
                    spots[column][j] = true;
                    row = j;
                    break;
                }
            }
            
            this.nodes.add( new DrawableNode( node, new Point( column, row ) ) );
        }
    }

    public Rectangle2D  screenBounds( DrawableNode node ){
        int x = node.point.x * cellWidth  + node.point.x * sepWidth;
        int y = node.point.y * cellHeight + node.point.y * sepHeight;

        return new Rectangle( x, y, cellWidth, cellHeight );
    }

	}
}

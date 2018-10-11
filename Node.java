package netgraph;
import java.awt.Point;
import java.util.List;
import java.util.ArrayList;
public class Node {
    
    public Node() {
        point = new Point();
    }
    private String activityName; // name of the activity
    private Point point; // location of the node 
    private int activityDuration; 
    public List <Node> children = new ArrayList<>();
    private boolean isHead = false;
    private short processed = 0;
    private boolean hasPredecessor = false;
    
    
    
    //getters setters
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityName() {
        return activityName;
    }
    
    // .
    public void setActivityDuration(int activityDuration) {
        this.activityDuration = activityDuration;
    }

    public int getActivityDuration() {
        return activityDuration;
    }
    

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
    
    public void setHead(boolean isHead) {
    	this.isHead = isHead; 
    }
    
    public boolean isTail() {
    	return (children.isEmpty());
    }
    
    public void add(Node n) {
    	children.add(n);
    }
    
    public void reset() {
    	processed = 0;
    }
    
    public void process() {
    	processed++;
    }
    
    public int getProcessed() {
    	return processed;
    }
    
    public void doesHasPredecessor() {
    	hasPredecessor = true;
    }
    
    public boolean hasPredecessor() {
    	return hasPredecessor;
    }
    
}

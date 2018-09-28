
import java.awt.Point;


public class Node {
    
    public Node() {
        point = new Point();
    }
    
    /*NODE VARIABLES*/
    
    private String activityName; 
    // name of the activity
    
    private Point point; 
    // location of the node 
    
    private int activityDuration; 
    //duration of the activity
    
    private int numPredecessors = 0;
    //number of predecessors
    
    private boolean isHead; 
    //boolean to see if node is head  
    //only one node may be head
    
    private boolean isTail = true; 
    //boolean to see if node is tail
    //processing of paths must be used with tails
    //if node has no successors, it must be a tail
    //node is indicated as true until made into a predecessor
    
    /*END NODE VARIABLES*/
    
    
    /*GETTERS & SETTERS*/
    
    //HEADS & TAILS
    public void setHead (boolean isHead){
        this.isHead = isHead;
    }
    
    public boolean isHead() {
        return isHead;
    }
    
    public void setTail (boolean isTail) {
        this.isTail = isTail;
    }
    
    public boolean isTail() {
        return isTail;
    }
    //END HEADS & TAILS
    
    
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityName() {
        return activityName;
    }
    
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
    
    public int getNumPredecessors() {
        return numPredecessors;
    }
    /*END GETTERS & SETTERS*/
    
    /*OTHER METHODS*/
    
    public void iteratePredecessors() {
        numPredecessors++;
    }
    
}

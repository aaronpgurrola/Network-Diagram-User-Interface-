
import java.awt.Point;

public class Node {
    
    public Node() {
        point = new Point();
    }
    private String activityName; // name of the activity
    private Point point; // location of the node 
    private int activityDuration; 

    // Getter and Setter methods 
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
    
}

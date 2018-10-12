import java.awt.Point;
import java.util.List;
import java.util.ArrayList;


public class Node {
    
    public Node( String name, int duration, ArrayList<String> parents ) { 
        
        if( name.isEmpty() ){
            throw new java.lang.RuntimeException("Name shouldn't be empty.");
        }
        point = new Point();
        this.name =     name;
        this.duration = duration;
        this.parents =  parents;
        parents.remove("");
    }
    
    public Node() {
        
    }

    private Point point; // location of the node 
    private int duration;
    private String name;
    private List<String> parents;
    private List<String> children = new ArrayList<>();
    
    //getters setters

    // NAME
    public void setActivityName(String activityName) {
        if(  !activityName.isEmpty() ) name = activityName;
    }
    public String getActivityName() {
        return name;
    }

    // DURATION
    public void setActivityDuration(int activityDuration) {
        duration = activityDuration;
    }
    public int getActivityDuration() {
        return duration;
    }
    
    public boolean isTail() {
        return children.isEmpty();
    }

    public boolean isHead() {
    	return parents.isEmpty();
    }
    
    public boolean addParent(String name) {
    	if( !parents.contains(name) ){
            parents.add(name);
            return true;
        }
        return false;
    }

    public boolean addChild(String name){
    	if( !children.contains(name) ){
            children.add(name);
            return true;
        }
        return false;
    }
   
    public boolean hasParents() {
    	return !parents.isEmpty();
    }

    public boolean hasChildren() {
    	return !children.isEmpty();
    }

    public List<String> getParents(){
        List<String> list = new ArrayList<>();
        list.addAll( parents );
        return list;
    }

    public int parentCount(){ return parents.size(); }

    public List<String> getChildren(){
        List<String> list = new ArrayList<>();
        list.addAll( children );
        return list;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int childrenCount(){ return children.size(); }

    public String toString(){
        return "name:" + name + ", duration:" + duration + " children:" + children + " parents:" + parents; 
    }

	public Point getPoint() {
		
		return point;
	}
    
}

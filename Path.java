import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Path {
	
	public List<Node> path;
	private int duration;
	private String toString;
	
	public Path() {
		path = new ArrayList<>();
	}
	
	public void add(Node n) {
		path.add(n);
	}
	
	public boolean hasLoop() {
		if( path.isEmpty() || path.size() == 1 ){
			return true;
		}

		for (int i = 0 ; i < path.size(); i++) {
			for (int j = i+1; j < path.size();j++) {
				if ( path.get(i) == path.get(j) )
					return false;
			}
		}

		return true;
	}
	
	public int getDuration() {
		int duration = 0;
		for ( Node n : path ) duration += n.getActivityDuration();
		return duration;
	}
	
	private String pathString() {
		String pathString = "";
		for (int i = 0; i < path.size(); i++) {
			if (i!=path.size()-1)
				pathString+=(path.get(i).getActivityName()+"-->");
			else
				pathString+=(path.get(i).getActivityName());
		}
		return pathString;
	}
	
	public String toString() {
		return ( "Path: "+pathString()+ "\n Duration: "+getDuration() );
	}
}


class PathSorter implements Comparator<Path> 
{ 
    public int compare(Path a, Path b) 
    { 
        return a.getDuration() - b.getDuration(); 
    } 
} 
import java.util.List;
import java.util.ArrayList;

public class Processor {
	private List<Path> paths;
	private ActivityTree tree;
	
	Processor( ActivityTree tree ){
		paths = new ArrayList<>();
		this.tree = tree;
	}
	
	// Returns trOO if all nodes have a connection.
	public boolean hasAllConnections() {
		for( Node node : tree.getNodes() ){
			if( node.isHead() && node.isTail() ) return false;
		}
		return true;
	}

	public boolean hasNoLoops(){
		for( Node node : tree.getNodes() ){ 
			if( !hasNoLoops( new ArrayList<Node>(), node ) )
				return false;
		}
		return true;
	}

	private boolean hasNoLoops( List<Node> path, Node current ){
		// this shouldn't be in the path yet.
		if( path.contains( current ) ) return false; 
		// this is the tail, we're good to pass.
		if( current.isTail() ) return true;
		// else continue down path.
		path.add( current );
		for( Node child : tree.getChildrenOf( current ) ){
			if( !hasNoLoops( path, child ) ){ return false; }
		}
		path.remove( current );
		// no child had loops, pass this element.
		return true;
	} 
	
	public boolean parentFinder()
	{
		boolean flag = true;
		
		for(Node node: tree.getNodes())
		{
			for(String parent: node.getParents())
			{
				if(!tree.activityExists(parent))
				{
					flag = false;
				}
				else
				{
					flag = true; 
				}
			}
		}
		return flag;
	}
	
	public String outputString() {
		StringBuilder sb=new StringBuilder();		
		for( Path path : paths ){ 
			sb.append( System.getProperty("line.separator") );
			sb.append( path );
		}
		return sb.toString();
	}

	public void buildPaths() {
		if( tree.isEmpty() ) return;
		this.paths.clear();

		System.out.println("we're about to build.");
		for( Node node : tree.getNodes() ){
			// Only generate full paths. Paths which start with a head.
			if( node.isHead() ){ buildPaths( node, new ArrayList<Node>() ); }
		}

		// Order these paths.
		java.util.Collections.sort(paths, new PathSorter()); 
	}
	
	private void buildPaths( Node current, ArrayList<Node> builtPath ) {
		
		if( current.isTail() ) {
			
			// add the full path to the list of paths
			Path p = new Path();
			
			builtPath.add( current );

			for( int i = 0; i < builtPath.size(); i ++  ) {
				p.add( builtPath.get(i) );
			}
			
			System.out.println("We have a path");
			System.out.println(p.path.size());
			System.out.println(p.toString());
			
			paths.add( p );
			
			builtPath.remove( current );

			return; 
		} else {
			
			builtPath.add( current );
			
			for( Node child : tree.getChildrenOf( current ) ) {
				buildPaths( child, builtPath  );
			}
			
			builtPath.remove( current );
			
		}
		
	}
	
}

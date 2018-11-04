import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class Processor {
	public List<Node> nodes;
	public List<Path> paths;
	public List<Node> heads;
	
	Processor( List<Node> nodes ){
		this.nodes = nodes;
		paths = new ArrayList<>();
		heads = new ArrayList<>();
	}
	
	private void buildHeads() {
		System.out.println("size of nodes = "+nodes.size());
		for (int i = 0; i < nodes.size(); i++) {
			//System.out.println((!nodes.get(i).hasPredecessor())+" + "+i+"Activity name: "+nodes.get(i).getActivityName());
			if(!nodes.get(i).hasPredecessor()) {
				System.out.println(i);
				heads.add((nodes.get(i)));
			}
		}
	}
	
	public boolean isConnected() {
		for (int i = 0; i < nodes.size();i++) {
			if (!nodes.get(i).hasPredecessor()) {
				if (nodes.get(i).isTail())
					return false;
			} 
		}
		return true;
	}
	
	public boolean validHead() {
		return !heads.isEmpty();
		// return (!nodes.get(0).hasPredecessor());
	}
	
	public String outputString() {
		String outputString = "";
		for(int i = 0; i < paths.size(); i++) {
			outputString+=paths.get(i).toString();
		}
		return outputString;
	}
	
	
	
	
	
	
	public void buildPaths() {
		if(!isConnected()) {
			JOptionPane.showMessageDialog(null, "Not connected.");
		}
		else if (!nodes.get(0).hasChildren()) {
			Path p = new Path();
			p.add(nodes.get(0));
			return;
		} else {
			buildHeads();
			if( !validHead() ){
				JOptionPane.showMessageDialog(null, "Invalid head.");
				return;
			} else {
				for (int i = 0; i < heads.size(); i++){ 
					buildPathsAlg(heads.get(i));
				}
			}
		}
	}
	
	
	public void buildPathsAlg(Node head) {
		Path p = new Path();
		p.add(head);
		if (head.hasChildren()) {
			for(int i = 0; i < head.children.size(); i++) {
				buildPathsAlgHelper(head.children.get(i), p);
			}
		}
		else {
			paths.add(p);
		}
		
	}
	
	public void buildPathsAlgHelper(Node child, Path p) {
		Path pa = new Path();
		pa.copyFrom(p);
		pa.add(child);

		if (!pa.loopCheck()) {
			JOptionPane.showMessageDialog(null, "There is a loop.");
			// I don't believe this is a requirement.
			// Panel.restart();
			return;
		}
			
		if (child.isTail())
			paths.add(pa);
		else {
			for (int i = 0; i < child.children.size(); i++) {
				buildPathsAlgHelper(child.children.get(i), pa);
			}
		}
		pathsSort();
		
	}
	
	public void pathsSort() {
		Path key = new Path();
		for (int i = 0; i < (paths.size()-1); i++) {
			int max = i;
			for (int j = i; j < paths.size();j++) {
				if (paths.get(j).getDuration()>paths.get(max).getDuration())
					max = j; 
			}
			key.swapPath(paths.get(max));
			paths.get(max).swapPath(paths.get(i));
			paths.get(i).swapPath(key);
		}
	}
	
	
}

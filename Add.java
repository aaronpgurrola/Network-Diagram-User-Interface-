

public class Add {
    
    // public Add() {
        
    // }  
    private Node predecessor; // Node predecessor
    private Node destination;// Node destination
    private int duration;// Node duration
    //getters setters

    public Node getPredecessor() {
        return predecessor;
    }

    public Node getDestination() {
        return destination;
    }

    public int getDuration() {
        return duration;
    }

    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
}

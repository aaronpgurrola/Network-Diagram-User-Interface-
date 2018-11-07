
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

import java.lang.StringBuilder;
import java.time.LocalDateTime;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;




// Report class 
//
// A class which allows you to write a network diagram report.
// @author: Team 4
public class Report{

    public Report( List<Node> nodes, Processor processor ){
        
        this.nodes = new ArrayList<>( nodes );
        this.processor = processor;

    }

    // Writes a report file.
    // 
    // Given a location & title to write a file, this function will write the content file.
    // This object must have been provided current data to write out accurate results.
    //
    // returns successful write true/false
    public boolean writeReport( String filePath, String title ){
        File file = new File( filePath + "/" + title );
        try( BufferedWriter writer = new BufferedWriter( new FileWriter(file) ) ){
            
            StringBuilder sb = new StringBuilder();
            
            // Header 
            sb.append( title )
                .append( SEP )
                .append( LocalDateTime.now() )
                .append( SEP ).append( SEP );
            
            // Display activities in alphabetical order 
            sb.append( "Activitys:" )
                .append( SEP );

            Collections.sort( nodes, sorter );
            
            for( Node node : nodes ){
                sb.append( node.getActivityName() )
                    .append( " : " )
                    .append( node.getActivityDuration() );
            }

            // Display paths
            sb.append( SEP ).append( SEP ).append( "Paths:" )
                    .append( SEP );
                
            

            writer.append( sb );

            return true;
        } 
        catch( IOException _E ) {
            return false;
        }

    }

    private List<Node> nodes;
    private Processor processor;
    final static private String SEP = System.getProperty( "line.separator" ); 

    static final private Comparator sorter = new Comparator<Node>() {
        public int compare( Node L, Node R ) {
            return L.getActivityName().compareTo( R.getActivityName() );
        }
    };
}
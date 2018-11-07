
// import java.util.List;
// import java.util.Arrays;
// import java.util.ArrayList;
// import java.util.Map;
// import java.util.HashMap;

// class ActivityTree {

//     private Map< String, Node> activities; 
//     private int elements = 0;

//     public static final int CREATE_OK =         0;
//     public static final int CREATE_NONAME =     1;
//     public static final int CREATE_EXISTS =     2;
//     public static final int CREATE_DURATION =   3;      

//     public ActivityTree() {
//         activities = new HashMap<>();
//     }

//     public int AddActivity( String nameS, String durationS, String parentsS  ){
//         int duration;

//         // Name conflicts
//         if( nameS == null || nameS.isEmpty() ) return CREATE_NONAME;
//         if( activities.containsKey(nameS) ) return CREATE_EXISTS;
        
//         // Duration conflicts
//         if( durationS == null ) return CREATE_DURATION;
//         try{
//             duration = Integer.parseInt( durationS );
//         } catch( Exception e ){
//             return CREATE_DURATION;
//         }

//         if( parentsS.replaceAll(" ", "").isEmpty() ){
//             parentsS = "";
//         }
//         System.out.println(parentsS.length());

//         // Create.
//         Node activity = new Node();
        
//         // update before inserting the new activity.
//         updateRelationships( activity ); 
//         activities.put( nameS, activity );

//         activities.forEach( (k, v) -> System.out.println( v ) );

//         // Increase our count.
//         elements ++;

//         return CREATE_OK;
//     }
 
//     public List<Node> getChildrenOf( Node node ){
//         List<Node> children = new ArrayList<>();
//         for( String name : node.getChildren() ){
//             if( activityExists(name) ){
//                 children.add( getActivity(name) );
//             }
//         }
//         return children;
//     }

//     public List<Node> getChildrenOf( String name ){
//         return getChildrenOf( getActivity(name) );
//     }

//     public List<Node> getParentsOf( Node node ){
//         List<Node> parents = new ArrayList<>();
//         for( String name : node.getParents() ){
//             if( activityExists(name) ){
//                 parents.add( getActivity(name) );
//             }
//         }
//         return parents;
//     }

//     public List<Node> getParentsOf( String name ){
//         return getParentsOf( getActivity(name) );
//     }    

//     public Node getActivity( String name ){
//         return activities.get( name );
//     }

//     public boolean activityExists( String name ){
//         return activities.containsKey( name );
//     }

//     private void updateRelationships( Node added ){
//         activities.forEach( (k, v) ->{
//             // Update the children since we've been provided parents.
//             if( added.getParents().contains( v.getActivityName() ) ){
//                 v.addChild( added.getActivityName() ); 
//             }

//             if( v.getParents().contains( added.getActivityName() ) ){
//                 if( !added.getChildren().contains( v.getActivityName() ) ){
//                     added.addChild( v.getActivityName() );
//                 }
//             }
            
//         });
//     }

//     // All of the children to the root
//     public int parentCountToRoots( Node from ){
//         return parentCountToRoots( from, 0 );
//     }

//     private int parentCountToRoots( Node from, int count ){
//         // Quick escape on node-loop.
//         if( count >= size() ){ return size()-1; }
        
//         count += from.parentCount();
//         for( Node parent : getParentsOf( from ) ){

//             count = parentCountToRoots( parent, count );
//         }
//         return count;
//     }

//     public List<Node> getNodes(){
//         ArrayList<Node> nodes = new ArrayList<>();
//         activities.forEach( (k, v) -> nodes.add( v ) );
//         return nodes;
//     }

//     public int size(){ return elements; }

//     public boolean isEmpty(){ return size()==0; }
    
//     public void clear(){ 
//         elements = 0;
//         activities.clear();
//      }
// }

/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WalmartTestClass {
	int startJn, endJn, pathWt;
	static int noOfJns;
	static int noOfQs;
	
	WalmartTestClass(int startJn, int endJn, int pathWt){
		this.startJn = startJn;
		this.endJn = endJn;
		this.pathWt = pathWt;
	}
	
    @SuppressWarnings("resource")
	public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         */
        int count = 0;
        ArrayList<WalmartTestClass> arrL = new ArrayList<WalmartTestClass>();
		Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
        	String line = scanner.nextLine();
        	if (line.isEmpty()) break;
        	if (count < 2){
        		if (count == 0){
        			noOfJns = Integer.valueOf(line);
        		} else {
        			noOfQs = Integer.valueOf(line);
        		}
        		count++;
        	}
        	else if((arrL.isEmpty() || (arrL.size() < noOfQs))) {
        		String[] tokens = line.split("\\s+");
        		if (tokens != null){
        			WalmartTestClass wtc = new WalmartTestClass(Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1])
        					                , Integer.valueOf(tokens[2]));
        			arrL.add(wtc);
        		}
        	}
        }
        findShortestPath(arrL);
    }

	public static void findShortestPath(ArrayList<WalmartTestClass> arrL) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> startJns = new TreeMap<Integer, Integer>();
		Map<Integer, Integer> endJns = new TreeMap<Integer, Integer>();
		Map<Integer, Integer> nodeMatrix = new TreeMap<Integer, Integer>();
		
		for (int i = 0; i < arrL.size(); i++){
			WalmartTestClass wl = (WalmartTestClass)arrL.get(i);
			
			nodeMatrix.put(wl.startJn, wl.endJn);
			
			if (!endJns.containsKey(wl.startJn)){
				startJns.put(wl.startJn, wl.pathWt);
			} 
		}
		
		int minStartWeight = 0;
		int minStartNode = 0;
		int shortestPathWeight = 1;
		for (Map.Entry<Integer, Integer> entry : startJns.entrySet())
		{
		    if (minStartWeight == 0){
		    	minStartWeight = entry.getValue();
		    	minStartNode = entry.getKey();
		    } else {
		    	if (minStartWeight > entry.getValue()){
		    		minStartWeight = entry.getValue();
			    	minStartNode = entry.getKey();
		    	}
		    } 
		}
		shortestPathWeight += minStartWeight;
		ArrayList<Integer> shortestPath = new ArrayList<Integer>();
		shortestPath.add(minStartNode);
		int midMinPath = minStartNode;
		int secNode = nodeMatrix.get(midMinPath);
		while (nodeMatrix.containsKey(midMinPath)){
		      shortestPath.add(nodeMatrix.get(midMinPath));
		      midMinPath = nodeMatrix.get(midMinPath); 
		}
		
		String str = shortestPath.toString();
		System.out.println("Shortest Path is: " + str);
		
		shortestPathWeight = findShortestPathWtFromMidJns(shortestPathWeight, minStartNode, 
				             minStartWeight, secNode, startJns, nodeMatrix);
		
		System.out.println("Optimum time is: " + shortestPathWeight);
		
	}

	public static int findShortestPathWtFromMidJns(int shortestPathWeight,
			int minStartNode, int minStartWeight, int secNode, Map<Integer, Integer> startJns, 
			Map<Integer, Integer> nodeMatrix) {
		
		/* Identify the start nodes and its relevant path */
		for (Object o : startJns.keySet()) {
		      if ((nodeMatrix.get(o).equals(secNode) && !(o.equals(Integer.valueOf(minStartNode))))) {
		    	  shortestPathWeight += startJns.get(o) - minStartWeight;
		        
		      }
		 }
		
		minStartNode = secNode;
		/* Identify the Mid-Junctions and calculate the shortest path from the same */
		while (startJns.containsKey(secNode)){
			secNode = nodeMatrix.get(secNode);
			for (Object o : startJns.keySet()) {
				if ((nodeMatrix.get(o).equals(secNode))){
					shortestPathWeight += startJns.get(o);
				}
			}
		}
		return shortestPathWeight;
	}
    
    
}

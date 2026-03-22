import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solver {

	private String[][] map;
    private int rows;
    private int cols;
    private int rooms;
    private int[][] path;
    private int pathLength;
 
    
    public Solver(String[][] paramMap, int paramRows, int paramCols, int paramRooms) {
    	map = paramMap;
    	cols = paramCols;
    	rows = paramRows;
    	rooms = paramRooms;
    }
    
    public int[] findStart() {
    	for(int r = 0; r<map.length; r++) {
    		for(int c = 0; c<map[r].length; c++) {
                if (map[r][c] != null && map[r][c].equals("W")) {
                    return new int[]{r, c};
                }
    		}
    	}
		return null;
    }
    
    public void queue()  {
    	int[] start = findStart();
    	if(start == null) {
    		System.out.println("No start");
    		return;
    	}
    	
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        
        boolean found = false;
  
        

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int r = curr[0];
            int c = curr[1];
        //north
            if (r-1 >= 0 && map[r-1][c] != null) {
                if (map[r-1][c].equals("$")) {
                	found = true; 
                	break; 
                }
                if (map[r-1][c].equals(".")|| map[r-1][c].equals("|")) {
                    map[r-1][c] = "+";
                    queue.add(new int[]{r-1, c});
                }
            }
       //south
            if (r+1 < map.length && map[r+1][c] != null) {
                if (map[r+1][c].equals("$")) { 
                	found = true; 
                	break; 
                }
                if (map[r+1][c].equals(".")|| map[r+1][c].equals("|")) {
                    map[r+1][c] = "+";
                    queue.add(new int[]{r+1, c});
                }
            }
            // east
            if (c+1 < map[r].length && map[r][c+1] != null) {
                if (map[r][c+1].equals("$")) {
                	found = true; 
                	break; 
                }
                if (map[r][c+1].equals(".")|| map[r][c+1].equals("|")) {
                    map[r][c+1] = "+";
                    queue.add(new int[]{r, c+1});
                }
            }
            // west
            if (c-1 >= 0 && map[r][c-1] != null) {
                if (map[r][c-1].equals("$")) { 
                	found = true; 
                	break; 
                }
                if (map[r][c-1].equals(".")|| map[r][c-1].equals("|")) {
                    map[r][c-1] = "+";
                    queue.add(new int[]{r, c-1});
                }
            }
            
            
        }
        
        if(found == false) {
        	System.out.println("No path found");
        }
    
    }
    
    
    
    
    
    
    public void stack() {
        int[] start = findStart();
      	if(start == null) {
    		System.out.println("No start");
    		return;
    	}
      	
      	
      	
        Stack<int[]> stack = new Stack<>();
        stack.push(start);
    
        
        
        boolean found = false;

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int r = curr[0];
            int c = curr[1];
            
            
            
     // north
    
        
        if (r-1 >= 0 && map[r-1][c] != null) {
            if (map[r-1][c].equals("$")) { 
            	found = true; 
            	break; 
            }
            if (map[r-1][c].equals(".")|| map[r-1][c].equals("|")) {
                map[r-1][c] = "+";
                stack.push(new int[]{r-1, c});
            }
        }
        // south
        if (r+1 < map.length && map[r+1][c] != null) {
            if (map[r+1][c].equals("$")) { 
            	found = true; 
            	break; 
            }
            if (map[r+1][c].equals(".")|| map[r+1][c].equals("|")) {
                map[r+1][c] = "+";
                stack.push(new int[]{r+1, c});
            }
        }
        // east
        if (c+1 < map[r].length && map[r][c+1] != null) {
            if (map[r][c+1].equals("$")) { 
            	found = true; 
            	break; 
            }
            if (map[r][c+1].equals(".")|| map[r][c+1].equals("|")) {
                map[r][c+1] = "+";
                stack.push(new int[]{r, c+1});
            }
        }
        // west
        if (c-1 >= 0 && map[r][c-1] != null) {
            if (map[r][c-1].equals("$")) { 
            	found = true; 
            	break; 
            }
            if (map[r][c-1].equals(".")|| map[r][c-1].equals("|")) {
                map[r][c-1] = "+";
                stack.push(new int[]{r, c-1});
            }
        }
        

        
        
        
        }
        if(found == false) {
        	System.out.println("No path found");
        }
    }
    
    
    public void opt() {
        int[] start = findStart();
        if (start == null) {
            System.out.println("No start");
            return;
        }
 
        int totalRows = map.length;
        int totalCols = map[0].length;
 
        int[][] previous = new int[totalRows][totalCols];
        
        
        for (int r = 0; r < totalRows; r++) {
            for (int c = 0; c < totalCols; c++) {
                previous[r][c] = -1;
            }
        }
 
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);       
        previous[start[0]][start[1]] = start[0] * totalCols + start[1];
 
        boolean found = false;

    }
    
    

    public void printMap() {
    	for(int r = 0 ; r<map.length; r++) {
    		for(int c=0; c<map[r].length; c++) {
    			if(map[r][c] == null) {
    				System.out.print(".");
    			}
    			else {
    				System.out.print(map[r][c]);
    			}
    			
    		}
    		System.out.println();
    	}
    }
    
 
    public void printCoordinateMap() {
        System.out.println(rows + " " + cols + " " + rooms);
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                if (map[r][c] != null && !map[r][c].equals(".")) {
                    int room = r / rows;
                    int row  = r % rows;
                    System.out.println(map[r][c] + " " + row + " " + c + " " + room);
                }
            }
        }
    }
    
    
    
    
}

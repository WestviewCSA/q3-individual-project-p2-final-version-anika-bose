import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Runner {
	private String[][] map;
    private int rows;
    private int cols;
    private int rooms;
    
    public Runner(String[][] paramMap, int paramRows, int paramCols, int paramRooms) {
    	map = paramMap;
    	cols = paramCols;
    	rows = paramRows;
    	rooms = paramRooms;
    }
    
    public int[] findStart() {
    	for(int r = 0; r<map.length; r++) {
    		for(int c = 0; c<map[r].length; c++) {
    			if(map[r][c].equals("W")) {
    				int[] coordinate;
    				coordinate = new int[] {r,c};
    				return coordinate;
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
    	
    	boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        
        
        boolean found = false;
        int steps = 0;
        
        
    	
    
    }
    
    public void stack() {
        int[] start = findStart();
      	if(start == null) {
    		System.out.println("No start");
    		return;
    	}
      	
      	boolean[][] visited = new boolean[map.length][map[0].length];
      	
        Stack<int[]> stack = new Stack<>();
        stack.push(start);
        visited[start[0]][start[1]] = true;
        
        
        boolean found = false;
        int steps = 0;
    	
    }
    
    
    private boolean isValid(int r, int c, boolean[][] visited) {
        if (r < 0 || r >= map.length || c < 0 || c >= map[0].length) {
        	return false;
        }
        if (visited[r][c]) {
        	return false;
        }
        String cell = map[r][c];
        if (cell == null) {
        	return false;
        }
        return !cell.equals("#");
    }
 
    
    
    
    
    

}

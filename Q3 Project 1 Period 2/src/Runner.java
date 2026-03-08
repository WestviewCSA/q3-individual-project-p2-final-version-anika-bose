
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
    
    
    
    
    

}

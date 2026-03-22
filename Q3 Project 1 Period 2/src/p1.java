
public class p1 {
	
	public p1() {
		
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		/*
		ReadMap map;
		try {
			map = new ReadMap("easyMap1");
			Solver solver = new Solver( map.getMap(), map.getRows(), map.getCols(), map.getRooms());
			
			
			solver.queue();
			
		} catch (MazeException.IllegalFirstLineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MazeException.IllegalMapCharacterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MazeException.IncompleteMapException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/       
        
        boolean useStack = false;
        boolean useQueue = false;
        boolean useOpt = false;
        boolean useTime = false;
        boolean inCoordinate = false;
        boolean outCoordinate = false;
        String  mapFile = null;
        
        for (int i=0; i<args.length-1; i++) {
            switch (args[i]) {
                case "--Stack":
                    useStack = true;
     
                    break;
                case "--Queue":
                    useQueue = true;
 
                    break;
                case "--Opt":
                    useOpt = true;
                    break;
                case "--Time":
                    useTime = true;
                    break;
                case "--Incoordinate":
                    inCoordinate = true;
                    break;
                  
                case "--Outcoordinate":
                    outCoordinate = true;
                    break;
                case "--Help":
                    System.out.println("Maze Solver");
                    System.out.println("Usage: java p1 [switches] <mapfile>");
                    System.out.println("  --Stack: Use stack-based approach");
                    System.out.println("  --Queue: Use queue-based approach");
                    System.out.println("  --Opt: Find the shortest path");
                    System.out.println("  --Time: Print the runtime of the search algorithm");
                    System.out.println("  --Incoordinate: Input file is in coordinate-based format");
                    System.out.println("  --Outcoordinate: Output in coordinate-based format");
                    System.out.println("  --Help: Print this help message");
                    System.out.println("Exactly one of --Stack, --Queue, or --Opt must be specified.");
                    System.exit(0);
                default:
                    if (i == args.length - 1) {
                        mapFile = args[i];
                    } else {
                        System.err.println("Error: Unknown argument: " + args[i]);
                        System.exit(-1);
                    }
            }
        }
 
 
        if (args.length > 0 && mapFile == null) {
        	mapFile = args[args.length - 1];
        }
        
        
        int modeCount = 0;
        if (useStack){
        	modeCount++;
        }
        if (useQueue) {
        	modeCount++;
        }
        if (useOpt) {
        	modeCount++;
        }
 
        
        if (modeCount != 1) {
            System.err.println("Exactly one of --Stack, --Queue, or --Opt must be specified.");
            System.exit(-1);
        }
        
        if (mapFile == null) {
            System.err.println("No map file specified.");
            System.exit(-1);
        }
        
        
        try {
            ReadMap readMap;
            if (inCoordinate) {
                readMap = new ReadMap(mapFile, true);
            } else {
                readMap = new ReadMap(mapFile, false);
            }
 
            Solver solver = new Solver(
                readMap.getMap(),
                readMap.getRows(),
                readMap.getCols(),
                readMap.getRooms()
            );
 
            long startTime = System.nanoTime();
            
            boolean found = false;

 
            if (useQueue) {
               found= solver.queue();
            } else if (useStack) {
               found= solver.stack();
            } else if (useOpt) {
            
                found=solver.opt();
            }
            long endTime = System.nanoTime();
 
            if(found) {
            if (outCoordinate) {
                solver.printCoordinateMap();
            } else {
                solver.printMap();
            }
            }
            
            if (useTime) {
                double seconds = (endTime - startTime) / 1_000_000_000.0;
                System.out.println("Total Runtime: " + seconds + " seconds");
            }
 
 
        } catch (MazeException.IllegalFirstLineException e) {
            System.err.println("Map format error: " + e.getMessage());
        } catch (MazeException.IllegalMapCharacterException e) {
            System.err.println("Illegal character in map: " + e.getMessage());
        } catch (MazeException.IncompleteMapException e) {
            System.err.println("Incomplete map: " + e.getMessage());
        }
    
	
	
	
	}

}

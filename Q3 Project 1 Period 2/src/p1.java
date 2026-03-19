
public class p1 {

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
		
        if (args.length < 2) {
            throw new MazeException.IllegalCommandLineException(
                "illegal command line");
        }
        
        
        boolean useStack = false;
        boolean useQueue = false;
        boolean useOpt   = false;
        int switchCount  = 0;
        
        for (int i=0; i<args.length-1; i++) {
            switch (args[i]) {
                case "--stack":
                    useStack = true;
                    switchCount++;
                    break;
                case "--queue":
                    useQueue = true;
                    switchCount++;
                    break;
                case "--opt":
                    useOpt = true;
                    switchCount++;
                    break;
                default:
                    throw new MazeException.IllegalCommandLineException(
                        "Unknown argument: " + args[i]);
            }
        }
 
 
        if (switchCount != 1) {
            throw new MazeException.IllegalCommandLineException(
                "Exactly one switch must be specified.");
        }
 
        String mapFile = args[args.length - 1];
 
        try {
            ReadMap readMap = new ReadMap(mapFile);
            Solver solver = new Solver(
                readMap.getMap(),
                readMap.getRows(),
                readMap.getCols(),
                readMap.getRooms()
            );
 
            if (useQueue) {
                solver.queue();
            } else if (useStack) {
                solver.stack();
            } else if (useOpt) {
            
                solver.queue();
            }
 
            solver.printMap();
 
        } catch (MazeException.IllegalFirstLineException e) {
            System.err.println("Map format error: " + e.getMessage());
        } catch (MazeException.IllegalMapCharacterException e) {
            System.err.println("Illegal character in map: " + e.getMessage());
        } catch (MazeException.IncompleteMapException e) {
            System.err.println("Incomplete map: " + e.getMessage());
        }
    
	
	
	
	}

}

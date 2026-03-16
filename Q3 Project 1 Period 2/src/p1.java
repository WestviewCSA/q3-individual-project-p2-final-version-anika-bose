import java.io.File;

public class p1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  if (args.length != 2) {
	            throw new MazeException.IllegalCommandLineException(
	                "command line exception"
	            		// one switch and one file
	            );
	      }
		  
	      String mode = args[0];
	      String filename = args[args.length - 1];
	      
	      if (!mode.equals("--Stack") && !mode.equals("--Queue") && !mode.equals("--Opt")) {
	            throw new MazeException.IllegalCommandLineException(
	                "invalid switch"
	            );
	      }
	      
	      
	        if (!new File(filename).exists()) {
	            System.err.println("file not found.");
	            return;
	        }

	        try {
	            ReadMap map = new ReadMap(filename);
	            Solver solver = new Solver(map.getMap(), map.getRows(), map.getCols(), map.getRooms());
	 
	            if (mode.equals("--Stack")) {
	                solver.stack();
	            } else if (mode.equals("--Queue")) {
	                solver.queue();
	            } else { // --Opt
	                solver.opt();
	            }
	 
	        } catch (MazeException.IllegalFirstLineException |
	                 MazeException.IllegalMapCharacterException |
	                 MazeException.IncompleteMapException e) {
	            System.err.println("Map error: " + e.getMessage());
	        }

}

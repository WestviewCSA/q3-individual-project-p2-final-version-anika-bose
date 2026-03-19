import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
			
public class ReadMap {
	private String[][] map;
	private int rows;
	private int cols;
	private int rooms;

    private static final String LEGAL_CHARS = "W$#.|@";


    public ReadMap(String filename) throws MazeException.IllegalFirstLineException,
                   MazeException.IllegalMapCharacterException,
                   MazeException.IncompleteMapException {
        if (filename.endsWith("c")) {
            readCoordinate(filename);
        } else {
            readFile(filename);
        }
   
	}

	public void readFile(String name)  throws MazeException.IllegalFirstLineException,
			MazeException.IllegalMapCharacterException,
			MazeException.IncompleteMapException {
		try {
			File file = new File(name);
			Scanner scanner = new Scanner(file);
			
			int rows =0;
			int cols= 0;
			int rooms= 0; 
			for(int i = 0; i<3; i++) {
				if(!scanner.hasNextInt()) {
				  throw new MazeException.IllegalFirstLineException("Invalid first line");
				
				}
				
	            int val = scanner.nextInt();
	            if (val <= 0) {
	            throw new MazeException.IllegalFirstLineException(
	                        "invalid first line");
	                }
	                if (i == 0) {
	                	rows  = val;
	                }
	                else if (i == 1) {
	                	cols  = val;
	                }
	                else {
	                	rooms = val;
	                }
	            }
				map = new String[rows * rooms][cols];

				for(int r = 0; r<map.length; r++) {
	                if (!scanner.hasNext()) {
	                    throw new MazeException.IncompleteMapException(
	                        "Map is incomplete");
	                }
	                String line = scanner.next();
	 
	                if (line.length() < cols) {
	                    throw new MazeException.IncompleteMapException(
	                        "Row is too short");
	                }
	 
	                for (int c = 0; c < cols; c++) {
	                    String ch = String.valueOf(line.charAt(c));
	                    if (LEGAL_CHARS.indexOf(ch) == -1) {
	                        throw new MazeException.IllegalMapCharacterException(
	                            "Illegal character");
	                    }
	                    map[r][c] = ch;
	                }
				}
	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readCoordinate(String name) throws MazeException.IllegalFirstLineException {
		try {
			File file = new File(name);
			Scanner scanner = new Scanner(file);
			
			

			int rows =0;
			int cols= 0;
			int rooms= 0; 
			for(int i = 0; i<3; i++) {
				if(!scanner.hasNextInt()) {
					throw new MazeException.IllegalFirstLineException("Invalid Map");
				}
	            int val = scanner.nextInt();
	            if (val <= 0) {
	                    throw new MazeException.IllegalFirstLineException(
	                        "rows, cols, and rooms must all be positive integers.");
	            }
	            if (i == 0) {
	            	rows  = val;
	            }
	            else if (i == 1) {
	            	cols  = val;
	            }
	            else {
	            	rooms = val;
	            }
	            
			}

	           map = new String[rows * rooms][cols];
	           
	            while (scanner.hasNext()) {
	                String ch = scanner.next();
	 
	                if (LEGAL_CHARS.indexOf(ch) == -1) {
	                    throw new MazeException.IllegalMapCharacterException(
	                        "Illegal character");
	                }
	 
	                if (!scanner.hasNextInt()) break;
	                int r = scanner.nextInt();
	                if (!scanner.hasNextInt()) break;
	                int c = scanner.nextInt();
	                if (!scanner.hasNextInt()) break;
	                int l = scanner.nextInt(); 
	 
	                int mappedRow = r + (rows * l);
	 
	                if (mappedRow < map.length && c < map[0].length && mappedRow >= 0 && c >= 0) {
	                    map[mappedRow][c] = ch;
	                }
	            }
	 
	            for (int r = 0; r < map.length; r++) {
	                for (int c = 0; c < map[r].length; c++) {
	                    if (map[r][c] == null) {
	                        map[r][c] = ".";
	                    }
	                }
	            }
	 
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MazeException.IllegalMapCharacterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	
	
	
	
	
	
	
	
	public String[][] getMap(){
		return map;
	}
	
	public int getRows() {
		return rows;
	}
	public int getCols() {
		return cols;
	}
	public int getRooms() {
		return rooms;
	}


}

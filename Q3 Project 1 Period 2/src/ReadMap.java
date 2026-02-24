import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
			
public class ReadMap {

	public static void main(String[] args) {		
			ReadMap m = new ReadMap("medMap2");
	}

	public ReadMap(String name) {
		readFile("easyMap1");
		readFile("medMap2");
		
		readCoordinate("easyMap1c");

	}

	public void readFile(String name) {
		try {
			File file = new File(name);
			Scanner scanner = new Scanner(file);
		/*	for(int i = 0; i<3; i++) {
				if(!scanner.hasNextInt()) {
					System.out.println("Invalid Map");
					return;
				}
				scanner.nextInt();
			}
			*/
			int rows = scanner.nextInt();
			int cols = scanner.nextInt();
			int rooms = scanner.nextInt(); 
			
				String[][] map = new String[rows*rooms][cols];
				for(int r = 0; r<map.length; r++) {
					String str = scanner.next();
					for(int c = 0; c<map[r].length; c++) {
						map[r][c] = String.valueOf(str.charAt(c));
					}
				}
				
				for(int r = 0; r<map.length; r++) {
					for(int c = 0; c<map[r].length; c++) {
						System.out.print(map[r][c]);
					}
					System.out.println();
				}
	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readCoordinate(String name) {
		try {
			File file = new File(name);
			Scanner scanner = new Scanner(file);
		/*	for(int i = 0; i<3; i++) {
				if(!scanner.hasNextInt()) {
					System.out.println("Invalid Map");
					return;
				}
				scanner.nextInt();
			}
			*/
			int rows = scanner.nextInt();
			int cols = scanner.nextInt();
			int rooms = scanner.nextInt(); 
			System.out.println(rows + " " + cols + " " + rooms);
			String[][] map = new String[rows*rooms][cols];
			while(scanner.hasNext()) {
				String str = scanner.next();
				int r = scanner.nextInt();
				int c = scanner.nextInt();
				int l = scanner.nextInt();
				map[r+ (r*l)][c] = str;
				
			}
			
			for(int r = 0; r<map.length; r++) {
				for(int c = 0; c<map[r].length; c++) {
					if(map[r][c] == null) {
						map[r][c] = ".";
					}
					System.out.print(map[r][c]);
				}
				System.out.println();
			}
			
	 
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


public class p1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ReadMap map;
		try {
			map = new ReadMap("easyMap1");
			Solver solver = new Solver( map.getMap(), map.getRows(), map.getCols(), map.getRooms());
			
			
			
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
	
		
	
	
	
	}

}

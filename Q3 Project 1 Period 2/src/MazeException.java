 
public class MazeException {
	public static class IllegalFirstLineException extends Exception {
        public IllegalFirstLineException(String message) {
            super(message);
        }
    }
 
 
    public static class IllegalMapCharacterException extends Exception {
        public IllegalMapCharacterException(String message) {
            super(message);
        }
    }
 
    public static class IncompleteMapException extends Exception {
        public IncompleteMapException(String message) {
            super(message);
        }
    }
 
 
    public static class IllegalCommandLineException extends RuntimeException {
        public IllegalCommandLineException(String message) {
            super(message);
        }
    }
}
 
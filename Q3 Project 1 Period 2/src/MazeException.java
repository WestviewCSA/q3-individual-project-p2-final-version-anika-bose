
public class MazeException {
	public static class IllegalFirstLineException extends MazeException {
        public IllegalFirstLineException(String message) {
            super(message);
        }
    }
 
    /**
     * Thrown when a character in the map is not one of: . # W $ +
     */
    public static class IllegalMapCharacterException extends MazeException {
        public IllegalMapCharacterException(String message) {
            super(message);
        }
    }
 
    /**
     * Thrown when the map doesn't have enough rows or a row is too short.
     */
    public static class IncompleteMapException extends MazeException {
        public IncompleteMapException(String message) {
            super(message);
        }
    }
 
    /**
     * Thrown when command line arguments are missing, extra, or invalid.
     * (wrong number of args, or switch is not --Stack / --Queue / --Opt)
     */
    public static class IllegalCommandLineException extends RuntimeException {
        public IllegalCommandLineException(String message) {
            super(message);
        }
    }
}

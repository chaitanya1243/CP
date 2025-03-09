import java.util.*;

 class KeypadConundrum {
    // Numeric Keypad layout (Level 0)
    static final char[][] NUMERIC_KEYPAD = {
        {' ', ' ', ' '}, // Empty row for alignment
        {'7', '8', '9'},
        {'4', '5', '6'},
        {'1', '2', '3'},
        {' ', '0', 'A'}
    };
    static final int NUMERIC_START_X = 2, NUMERIC_START_Y = 0; // Start at 'A'

    // Directional Keypad layout (Levels 1, 2, 3)
    static final char[][] DIRECTIONAL_KEYPAD = {
        {' ', '^', 'A'},
        {'<', 'v', '>'}
    };
    static final int DIR_START_X = 2, DIR_START_Y = 1; // Start at 'A'

    // Movement directions: left, up, down, right
    static final int[][] MOVES = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static final char[] MOVE_CHARS = {'<', '^', 'v', '>'};

    static class State {
        int x, y; // Current position
        String sequence; // Sequence typed so far
        String moves; // Moves made to reach this state

        State(int x, int y, String sequence, String moves) {
            this.x = x;
            this.y = y;
            this.sequence = sequence;
            this.moves = moves;
        }
    }

    // BFS to find shortest sequence to type a target on a keypad
    static String findShortestSequence(char[][] keypad, int startX, int startY, String target) {
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(); // (x,y,sequence) to avoid cycles
        queue.add(new State(startX, startY, "", ""));
        visited.add(startX + "," + startY + ",");

        while (!queue.isEmpty()) {
            State current = queue.poll();
            if (current.sequence.equals(target)) {
                return current.moves;
            }

            // Try pressing the current button
            if (keypad[current.y][current.x] != ' ') {
                String newSeq = current.sequence + keypad[current.y][current.x];
                if (target.startsWith(newSeq)) {
                    String newMoves = current.moves + 'A';
                    String key = current.x + "," + current.y + "," + newSeq;
                    if (!visited.contains(key)) {
                        visited.add(key);
                        queue.add(new State(current.x, current.y, newSeq, newMoves));
                    }
                }
            }

            // Try moving in all directions
            for (int i = 0; i < 4; i++) {
                int newX = current.x + MOVES[i][0];
                int newY = current.y + MOVES[i][1];
                if (isValid(keypad, newX, newY)) {
                    String key = newX + "," + newY + "," + current.sequence;
                    if (!visited.contains(key)) {
                        visited.add(key);
                        queue.add(new State(newX, newY, current.sequence, current.moves + MOVE_CHARS[i]));
                    }
                }
            }
        }
        return null; // No solution found
    }

    // Check if a position is valid on the keypad
    static boolean isValid(char[][] keypad, int x, int y) {
        return x >= 0 && x < keypad[0].length && y >= 0 && y < keypad.length && keypad[y][x] != ' ';
    }

    // Compute complexity and solve for all codes
    static long solve(String[] codes) {
        long totalComplexity = 0;
        for (String code : codes) {
            // Level 1: Robot 1 types the code on numeric keypad
            String level1Seq = findShortestSequence(NUMERIC_KEYPAD, NUMERIC_START_X, NUMERIC_START_Y, code);
            if (level1Seq == null) {
                System.out.println("No solution for " + code + " at level 1");
                return -1;
            }

            // Level 2: Robot 2 types Level 1 sequence on directional keypad
            String level2Seq = findShortestSequence(DIRECTIONAL_KEYPAD, DIR_START_X, DIR_START_Y, level1Seq);
            if (level2Seq == null) {
                System.out.println("No solution for " + code + " at level 2");
                return -1;
            }

            // Level 3: You type Level 2 sequence on your directional keypad
            String level3Seq = findShortestSequence(DIRECTIONAL_KEYPAD, DIR_START_X, DIR_START_Y, level2Seq);
            if (level3Seq == null) {
                System.out.println("No solution for " + code + " at level 3");
                return -1;
            }

            // Calculate complexity
            int numericValue = Integer.parseInt(code.substring(0, code.length() - 1)); // Ignore 'A'
            int sequenceLength = level3Seq.length();
            long complexity = (long) sequenceLength * numericValue;
            totalComplexity += complexity;

            // Debugging output
            System.out.printf("Code: %s, Your Seq Length: %d, Numeric: %d, Complexity: %d\n",
                    code, sequenceLength, numericValue, complexity);
        }
        return totalComplexity;
    }

    public static void main(String[] args) {
        // Input codes from the problem
        String[] codes = {"029A", "980A", "179A", "456A", "379A"};
        long result = solve(codes);
        System.out.println("Sum of complexities: " + result);
    }
}
package github.bkp5190;

import java.util.Arrays;
import java.util.LinkedList;

public class UserIOTest implements UserIO {
    private final LinkedList<String> inputLines;
    private int currentLineIndex = 0;

    public UserIOTest(String... inputLines) {
        this.inputLines = new LinkedList<>(Arrays.asList(inputLines));
    }

    @Override
    public String readLine() {
        return inputLines.poll();
    }

    @Override
    public int readInt() {
        return Integer.parseInt(inputLines.poll());
    }
}
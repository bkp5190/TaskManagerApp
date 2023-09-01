package github.bkp5190;

import java.util.Scanner;

public class ConsoleUserIO implements UserIO {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public int readInt() {
        return scanner.nextInt();
    }
}

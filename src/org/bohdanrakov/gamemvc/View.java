package org.bohdanrakov.gamemvc;

public class View {

    public void printIsSmaller(boolean isSmaller) {
        if (isSmaller) {
            System.out.println("Your guess is smaller");
        } else {
            System.out.println("Your guess is bigger");
        }
    }

    public void printTries(int[] tries, int toIndex) {
        System.out.print("Your tries: ");
        for (int i = 0; i < toIndex; i++) {
            System.out.print(tries[i] + " ");
        }
        System.out.println();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}

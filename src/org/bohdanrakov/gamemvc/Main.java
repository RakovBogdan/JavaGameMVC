package org.bohdanrakov.gamemvc;

import org.bohdanrakov.gamemvc.model.*;

public class Main {

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);

        controller.processUser();
    }
}

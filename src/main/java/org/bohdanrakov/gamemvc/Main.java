package org.bohdanrakov.gamemvc;

import org.bohdanrakov.gamemvc.model.*;

public class Main {

    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);

        controller.processUser();
    }
}

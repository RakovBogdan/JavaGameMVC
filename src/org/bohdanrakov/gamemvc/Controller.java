package org.bohdanrakov.gamemvc;

import org.bohdanrakov.gamemvc.model.*;

public class Controller {

    private MoreOrLessGame game;
    private View view;

    public Controller(View view) {
        this.view = view;
        this.game = new MoreOrLessGame(0, 100);
    }

    public void processUser() {
        view.printMessage("Working");
    }
}

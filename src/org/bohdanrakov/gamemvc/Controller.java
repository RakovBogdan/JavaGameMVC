package org.bohdanrakov.gamemvc;

import org.bohdanrakov.gamemvc.model.*;

public class Controller {

    private MoreOrLess moreOrLess;
    private View view;

    public Controller(View view) {
        this.view = view;
        this.moreOrLess = new MoreOrLess(0, 100);
    }

    public void processUser() {
        view.printMessage("Working");
    }
}

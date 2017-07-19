package org.bohdanrakov.gamemvc;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        view.printMessage("Working");
    }
}

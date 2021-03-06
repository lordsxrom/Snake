import enums.GameState;

import java.awt.image.BufferedImage;

public class Presenter implements ViewListener, ModelListener {

    private final View view;
    private final Model model;

    public Presenter(View view, Model model) {
        this.model = model;
        model.addListener(this);

        this.view = view;
        view.addListener(this);

        model.start();
    }

    @Override
    public void onButtonClicked(int dir) {
        model.setDirection(dir);
    }

    @Override
    public void onButtonStartClicked() {
        model.start();
    }

    @Override
    public void updateMap(BufferedImage map) {
        view.updateMap(map);
    }

    @Override
    public void updateScore(int score) {
        view.updateScore(score);
    }

    @Override
    public void updateGameState(GameState state) {
        view.updateGameState(state);
    }
}

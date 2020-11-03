package com.mygdx.game.screen;

import com.badlogic.gdx.Screen;

public enum ScreenType {
    MAINMENU(MainMenu.class);

    private final Class<? extends AbstractScreen> screenClass;

    ScreenType(Class<? extends AbstractScreen> screenClass) {
        this.screenClass = screenClass;
    }

    public Class<? extends Screen> getScreenClass() {
        return screenClass;
    }
}
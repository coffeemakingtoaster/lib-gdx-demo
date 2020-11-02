package com.mygdx.game.Screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.MyGdxGame;

public abstract class AbstractScreen implements Screen {
    protected final MyGdxGame context;
    protected final FitViewport viewport;
    protected final World world;
    protected final Box2DDebugRenderer box2DDebugRenderer;

    protected AbstractScreen(final MyGdxGame context) {
        this.context = context;
        this.viewport = context.getScreenViewport();
        this.world = context.getWorld();
        this.box2DDebugRenderer = context.getBox2DDebugRenderer();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}

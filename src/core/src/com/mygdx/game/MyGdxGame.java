package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.screen.MainMenu;
import com.mygdx.game.screen.ScreenType;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import java.util.EnumMap;


public class MyGdxGame extends Game {
	private static final String TAG = MyGdxGame.class.getSimpleName();
	OrthographicCamera gameCamera;
	FitViewport screenViewport;
	Box2DDebugRenderer box2DDebugRenderer;
	AssetManager assetManager;
	private EnumMap<ScreenType, Screen> screenCache;
	SpriteBatch spriteBatch;
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		gameCamera = new OrthographicCamera();
		screenViewport = new FitViewport(1920, 1080, gameCamera);
		assetManager = new AssetManager();
		box2DDebugRenderer = new Box2DDebugRenderer();
		screenCache = new EnumMap<ScreenType, Screen>(ScreenType.class);
		setScreen(ScreenType.MAINMENU);
	}

	public void setScreen(final ScreenType screenType) {
		final Screen screen = screenCache.get(screenType);

		if(screen == null) {
			try {
				Gdx.app.debug(TAG, "Creating new screen: " + screenType);
				final Screen newScreen = (Screen) ClassReflection.getConstructor(screenType.getScreenClass(), MyGdxGame.class).newInstance(this);
				screenCache.put(screenType, newScreen);
				setScreen(newScreen);
			} catch (ReflectionException e) {
				throw new GdxRuntimeException("Screen " + screenType + " could not be created!", e);
			}

		} else {
			Gdx.app.debug(TAG, "Switching to screen: " + screenType);
			setScreen(screen);
		}
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
	}

	public FitViewport getScreenViewport() {
		return screenViewport;
	}

	public Box2DDebugRenderer getBox2DDebugRenderer() {
		return box2DDebugRenderer;
	}

	public World getWorld() {
		return null;
	}
	public OrthographicCamera getGameCamera() {
		return gameCamera;
	}

	public SpriteBatch getSpriteBatch() {
		return spriteBatch;
	}

}

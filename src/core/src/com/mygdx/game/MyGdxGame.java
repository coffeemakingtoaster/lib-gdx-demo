package com.mygdx.game;

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
import com.mygdx.game.Screen.MainMenu;
import com.mygdx.game.Screen.ScreenType;

import java.util.EnumMap;

import com.mygdx.game.Screen.MainMenu;

public class MyGdxGame extends Game {
	OrthographicCamera gameCamera;
	FitViewport screenViewport;
	Box2DDebugRenderer box2DDebugRenderer;
	AssetManager assetManager;
	
	@Override
	public void create () {
		gameCamera = new OrthographicCamera();
		screenViewport = new FitViewport(1,1, gameCamera);
		this.setScreen(new MainMenu());
		assetManager = new AssetManager();
		box2DDebugRenderer = new Box2DDebugRenderer();
		screenCache = new EnumMap<ScreenType, Screen>(ScreenType.class);
		setScreen(ScreenType.LOADING);
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

}

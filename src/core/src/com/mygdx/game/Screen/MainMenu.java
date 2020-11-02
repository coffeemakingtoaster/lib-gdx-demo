package com.mygdx.game.Screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;





public class MainMenu implements Screen {
    private SpriteBatch batch;
    protected Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    private TextureAtlas atlas;
    private Skin skin;

    public MainMenu(){
        //atlas = new TextureAtlas("skin.atlas"); 
        skin = new Skin(Gdx.files.internal("skins/glassy-ui.json"));

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new FitViewport(1920, 1080, camera);
        viewport.apply();

        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2,0);
        camera.update();

        stage = new Stage(viewport,batch);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        Table mainTable  = new Table();
        mainTable.setFillParent(true);
        mainTable.top();

        TextButton playButton = new TextButton("Play",skin);
        TextButton SettingsButton = new TextButton("Settings",skin);
        TextButton exitButton = new TextButton("Exit",skin);
        
        playButton.addListener(new InputListener(){
            @Override
            public boolean  touchDown(InputEvent event,float x, float y,int pointer, int button){
                System.out.println("Stating game...");
                return true;
            }
        });
        SettingsButton.addListener( new InputListener(){
            @Override
            public boolean touchDown(InputEvent event,float x, float y,int pointer, int button){
                System.out.println("Opening Settings");
                return true;
            }
        });
        exitButton.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event,float x, float y,int pointer, int button){
                System.out.println("Exiting game");
                return true;
            }
        });
        mainTable.add(playButton);
        mainTable.row();
        mainTable.add(SettingsButton);
        mainTable.row();
        mainTable.add(exitButton);
        stage.addActor(mainTable);  
    }

    @Override
    public void pause(){

    }
    @Override
    public void render(float f){
        Gdx.gl.glClearColor(.1f, .12f, .16f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        stage.act();
        stage.draw();
    }
    @Override
    public void hide(){

    }
    @Override
    public void dispose(){
        skin.dispose();
        //atlas.dispose();
    }
    @Override
    public void resume(){

    }
    @Override
    public void resize(int width, int height){
        //should not be possible with settings
        viewport.update(width, height);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
    }

}
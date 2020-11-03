package com.mygdx.game.screen;

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
import com.mygdx.game.MyGdxGame;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.screen.ScreenType;


public class SettingsMenu extends AbstractScreen{
    private SpriteBatch batch;
    protected Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    private TextureAtlas atlas;
    private Skin skin;



    public SettingsMenu(final MyGdxGame context){
        super(context);
        System.out.println("In Settngs");
        //atlas = new TextureAtlas("skin.atlas"); 
        skin = new Skin(Gdx.files.internal("skins/glassy-ui.json"));

        batch = context.getSpriteBatch();
        camera = context.getGameCamera();
        viewport = context.getScreenViewport();
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

        TextButton return2MM = new TextButton("return to Main Menu!",skin);
        
        return2MM.addListener(new InputListener(){
            @Override
            public boolean  touchDown(InputEvent event,float x, float y,int pointer, int button){
                context.setScreen(ScreenType.MAINMENU);
                return true;
            }
        });
        mainTable.add(return2MM);
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
       
    }
    @Override
    public void resume(){

    }
    @Override
    public void resize(int width, int height){
        
    }

}
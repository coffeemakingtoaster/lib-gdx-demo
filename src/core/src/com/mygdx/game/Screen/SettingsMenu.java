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
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Event;


public class SettingsMenu extends AbstractScreen{
    private SpriteBatch batch;
    protected Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    private TextureAtlas atlas;
    private Skin skin;

    public SettingsMenu(final MyGdxGame context){
        super(context);
        System.out.println("In Settings");
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

        TextButton return2MM = new TextButton("Save and exit",skin);      
        return2MM.addListener(new InputListener(){
            @Override
            public boolean  touchDown(InputEvent event,float x, float y,int pointer, int button){
                context.getSettings().writeSettings();
                context.setScreen(ScreenType.MAINMENU);
                return true;
            }
        });
        final Slider volumeMusicSlider = new Slider( 0f, 1f, 0.1f,false, skin );
        volumeMusicSlider.setValue( 0f );
        volumeMusicSlider.addListener( new EventListener() {
  		    @Override
		    public boolean handle(Event event) {
                context.getSettings().setMusicVolume(volumeMusicSlider.getValue());
                return false;
	        }
        });
        mainTable.add(volumeMusicSlider);
        mainTable.row();
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
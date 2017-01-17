package com.stasio.tools;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Created by Stasio on 02.01.2017.
 */
public class NewWindow extends Stage {

    private String path;

    public NewWindow (String path){
        this.path=path;
        start();
    }

    public void start(){
        try {
            setScene(new Scene(FXMLLoader.load(getClass().getResource(path))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        show();
    }

}

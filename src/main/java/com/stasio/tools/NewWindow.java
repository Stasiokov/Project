package com.stasio.tools;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Created by Stasio on 02.01.2017.
 */
public class NewWindow extends Stage {

    private String resources;
    private String title;
    private ActionEvent event;

    public NewWindow (ActionEvent event,String resources,String title){
        this.resources =resources;
        this.title = title;
        this.event=event;
        start();
    }

    public void start(){
        try {
            Parent root=FXMLLoader.load(getClass().getResource(resources));
            setTitle(title);
            setResizable(false);
            setScene(new Scene(root));
            initModality(Modality.WINDOW_MODAL);
            initOwner(((Node) event.getSource()).getScene().getWindow());
            show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        show();
    }

}

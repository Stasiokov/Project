package com.stasio.controller;

import com.stasio.beans.Credit;
import com.stasio.beans.Person;
import com.stasio.tools.MDData;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hibernate.LazyInitializationException;

import java.util.Set;

/**
 * Created by Stasio on 17.01.2017.
 */
public class InfoController {
    @FXML
    TableView<Credit> tableCredits;
    @FXML
    TableColumn<Credit,Integer>idCredit;

    @FXML
    private Button btnClose;

    @FXML
    private Text name;

    private MDData mdData = MDData.getMdData();
    private Person person = mdData.getTempPerson();
    private ObservableList<Credit> list = FXCollections.observableArrayList();

    public void initialize(){
        name.setText(person.getFullName());
        try {
            list.addAll(person.getCredit());
        }catch (LazyInitializationException e){
        }

//        idCredit.setCellValueFactory(data->new SimpleObjectProperty<Integer>(0));
        tableCredits.setItems(list);
    }
    public void close(){
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

}

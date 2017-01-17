package com.stasio.controller;

import com.stasio.beans.Person;
import com.stasio.dao.PersonDao;
import com.stasio.tools.MDData;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;

import static com.stasio.tools.MDData.getMdData;

/**
 * Created by Stasio on 24.12.2016.
 */
public class TableController {


    private MDData mdData = getMdData();
    private ObservableList<Person> list = mdData.getList();

    public TableController() {
    }

    @FXML
    TableView<Person> tableView;
    @FXML
    TableColumn<Person, String> firstName;
    @FXML
    TableColumn<Person, String> midleName;
    @FXML
    TableColumn<Person, String> lastName;
    @FXML
    TableColumn<Person, String> passport;
    @FXML
    TableColumn<Person, String> idNumber;
    @FXML
    TableColumn<Person, LocalDate> birthday;
    @FXML
    TableColumn<Person, String> credits;

    @FXML
    public void initialize() {
        load();
        firstName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFirstName()));
        midleName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMidleName()));
        lastName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLastName()));
        passport.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPassport()));
        idNumber.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getIdNumber()));
        birthday.setCellValueFactory(data -> new SimpleObjectProperty<LocalDate>(LocalDate.of(data.getValue().getBirthday().getYear(), data.getValue().getBirthday().getMonth(), data.getValue().getBirthday().getDayOfMonth())));
//        credits.setCellValueFactory(tools -> new SimpleObjectProperty<String>(Integer.toString(tools.getValue().getCredit().size())));
        tableView.setItems(list);
    }

    @FXML
    public void refresh() {
        tableView.getItems().removeAll(list);
        load();
    }

    @FXML
    public void loadDate() {
        mdData.startEM();
        PersonDao dao = new PersonDao(mdData.getManager());
        dao.insert(new Person("проба", "проба", "проба", LocalDate.of(1986, 10, 10), "ен454545", "5465465465",null));
        mdData.stopEM();
    }

    @FXML
    public void newPerson(ActionEvent event) {
        try {
            Stage window = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/view/newPerson.fxml"));
            window.setTitle("Новый клиент");
            window.setResizable(false);
            window.setScene(new Scene(root));
            window.initModality(Modality.WINDOW_MODAL);
            window.initOwner(((Node) event.getSource()).getScene().getWindow());
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void load() {
        mdData.startEM();
        PersonDao dao = new PersonDao(mdData.getManager());
        list.addAll(dao.getAll());
        mdData.stopEM();
    }

    public Person getPerson(int i) {
        mdData.startEM();
        PersonDao dao = new PersonDao(mdData.getManager());
        Person person = dao.get(i);
        mdData.stopEM();
        return person;
    }

}


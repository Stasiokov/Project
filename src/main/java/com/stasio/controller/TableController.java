package com.stasio.controller;

import com.stasio.beans.Credit;
import com.stasio.beans.Person;
import com.stasio.dao.CreditDao;
import com.stasio.dao.PersonDao;
import com.stasio.tools.MDData;
import com.stasio.tools.NewWindow;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    TableView<Person> tablePerson;
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
    TableColumn<Person, Integer> credits;

    @FXML
    public void initialize() {
        load();
        firstName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFirstName()));
        midleName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMidleName()));
        lastName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLastName()));
        passport.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPassport()));
        idNumber.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getIdNumber()));
        birthday.setCellValueFactory(data -> new SimpleObjectProperty<LocalDate>(LocalDate.of(data.getValue().getBirthday().getYear(), data.getValue().getBirthday().getMonth(), data.getValue().getBirthday().getDayOfMonth())));
        credits.setCellValueFactory(data -> new SimpleObjectProperty<Integer>(data.getValue().quantityCredit())); // ДОРАБОТАТЬ
        tablePerson.setItems(list);
    }

    @FXML
    public void refresh() {
//        System.out.println(list.get(2).getCredit().size()+"  "+list.get(2).getFirstName());
        tablePerson.getItems().removeAll(list);
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
        new NewWindow(event,"/view/newPerson.fxml","Новый клиент");
    }

    public void load() {
        mdData.startEM();
        PersonDao dao = new PersonDao(mdData.getManager());
        list.addAll(dao.getAll());
        mdData.stopEM();
    }

    public void btnInfo(ActionEvent event){
        Person selectedPerson = tablePerson.getSelectionModel().getSelectedItem();
        if(selectedPerson!=null){
            mdData.setTempPerson(selectedPerson);
            new NewWindow(event,"/view/infoPerson.fxml","Информация о клиенте");
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING,"Выберете клиента");
            alert.show();
        }

    }

    public void testCredit(){
        Person selectedPerson = tablePerson.getSelectionModel().getSelectedItem();
        if(selectedPerson!=null){
            mdData.setTempPerson(selectedPerson);
            mdData.startEM();
            CreditDao dao = new CreditDao(mdData.getManager());
            dao.insert(new Credit(selectedPerson,100,9999,999,LocalDate.of(1986, 10, 10),LocalDate.of(1986, 10, 10),"валюта"));
            mdData.stopEM();
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING,"Выберете клиента");
            alert.show();
        }
    }

//    public Person getPerson(int i) {
//        mdData.startEM();
//        PersonDao dao = new PersonDao(mdData.getManager());
//        Person person = dao.get(i);
//        mdData.stopEM();
//        return person;
//    }

}


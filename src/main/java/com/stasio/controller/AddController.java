package com.stasio.controller;

import com.stasio.beans.Person;
import com.stasio.dao.PersonDao;
import com.stasio.tools.MDData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;


public class AddController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField midleName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField idNumber;
    @FXML
    private TextField passport;
    @FXML
    private DatePicker birthday;

    @FXML
    private Button ok;
    @FXML
    private Button btnClose;

    private MDData mdData = MDData.getMdData();

    public void clickOk(ActionEvent event){
         if(firstName.getLength()>0)
         if(midleName.getLength()>0)
         if(lastName.getLength()>0)
         if(idNumber.getLength()>0)
         if(passport.getLength()>0){
             Person person = new Person();
             person.setFirstName(firstName.getText());
             person.setMidleName(midleName.getText());
             person.setLastName(lastName.getText());
             person.setIdNumber(idNumber.getText());
             person.setPassport(passport.getText());
             person.setBirthday(LocalDate.of(birthday.getValue().getYear(),birthday.getValue().getMonth(),birthday.getValue().getDayOfMonth()));
             mdData.startEM();
             PersonDao dao = new PersonDao(mdData.getManager());
             dao.insert(person);
             mdData.stopEM();
             close();
        }
    }

    public void close(){
        Stage stage = (Stage) btnClose.getScene().getWindow(); //при нажатии на кнопку
        stage.close();
    }

    public void initialize() {
    }
    }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import model.Main;

/**
 * FXML Controller class
 *
 * @author Lukas
 */
public class MenuController implements Initializable {

    @FXML private Button displayOne;
    @FXML private Button displayTwo;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML private void switchToOne(ActionEvent event) {
        try {
            URL smallUrl = getClass().getResource("/resources/view/Small.fxml");
            AnchorPane smallScreen = FXMLLoader.load(smallUrl);
            
            BorderPane border = Main.getRoot();
            border.setCenter(smallScreen);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
            
    }

    @FXML private void switchToTwo(ActionEvent event) {
        try {
            URL largeUrl = getClass().getResource("/resources/view/Large.fxml");
            AnchorPane largeScreen = FXMLLoader.load(largeUrl);
            
            BorderPane border = Main.getRoot();
            border.setCenter(largeScreen);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

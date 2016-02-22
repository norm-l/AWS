package model;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Lukas
 */
public class Main extends Application {
    
    private static BorderPane root = new BorderPane();
    
    public static BorderPane getRoot() {
        return root;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        URL menuBarUrl = getClass().getResource("/resources/view/MenuBar.fxml");
        MenuBar bar = FXMLLoader.load(menuBarUrl);
        
        URL smallUrl = getClass().getResource("/resources/view/Small.fxml");
        AnchorPane smallScreen = FXMLLoader.load(smallUrl);
        
        root.setTop(bar);
        root.setCenter(smallScreen);
        
        Scene scene = new Scene(root, 320, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

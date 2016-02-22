package model;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
    
    private static Stage stage;
    private static Scene scene;
    private static final BorderPane ROOT = new BorderPane();
    
    public static BorderPane getRoot() {
        return ROOT;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        URL toolBarUrl = getClass()
                .getResource("/resources/view/Menu.fxml");
        ToolBar bar = FXMLLoader.load(toolBarUrl);
        
        URL smallUrl = getClass()
                .getResource("/resources/view/small/Main.fxml");
        AnchorPane smallScreen = FXMLLoader.load(smallUrl);
        
        ROOT.setTop(bar);
        ROOT.setCenter(smallScreen);
        
        Main.stage = stage;
        
        scene = new Scene(ROOT, 320, 480+35);
        scene.getStylesheets().add(getClass()
                .getResource("/resources/css/main.css").toExternalForm());
        stage.setScene(scene);
        //stage.setResizable(false); re-set after comfortable with sizing
        stage.show();
    }
    
    public static Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

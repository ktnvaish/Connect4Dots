package sample;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));

        GridPane rootGridPane = loader.load();
        controller = loader.getController();
        controller.createPlayground();

        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane = (Pane)rootGridPane.getChildren().get(0);

        menuPane.getChildren().add(menuBar);


        Scene scene = new Scene(rootGridPane);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");

        primaryStage.show();
    }

    private MenuBar createMenu() {
        //File menu
        Menu fileMenu = new Menu("File");

        MenuItem newGame = new MenuItem("New game");

        newGame.setOnAction(event -> controller.resetGame());  //Action on new Game

        MenuItem resetGame = new MenuItem("Reset game");

        resetGame.setOnAction(event -> controller.resetGame());//Action on reset button

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem exitGame = new MenuItem("Exit game");

        exitGame.setOnAction(event -> exitGame());

        fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, exitGame);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);
        return menuBar;

    }



    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
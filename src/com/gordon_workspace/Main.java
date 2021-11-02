package com.gordon_workspace;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main extends Application implements EventHandler<ActionEvent> {

    public static void main(String[] args) throws FileNotFoundException {

        launch(args);
        }

    @Override
    public void start(Stage stage) throws Exception {

        Text text = new Text("Top 20 Words");

        text.setFont(Font.font("Edwardian Script ITC", 50));
        text.setX(155);
        text.setY(50);
        text.setFill(Color.BLUE);
        text.setStrokeWidth(2);
        text.setStroke(Color.DARKSLATEBLUE);
        text.getLineSpacing();

        String imagePath = "/Users/gordonm/Documents/Gordon B.A.S Journey/CEN3024C(softwareDevelopment1) FALL2021/module2 intelij/image1.jpg";
        Image image = new Image(new FileInputStream(imagePath));
        ImageView imageView = new ImageView(image);
        imageView.setX(150);
        imageView.setY(100);
        imageView.setFitHeight(455);
        imageView.setFitWidth(500);

        Button button = new Button("Count Words");
        button.setTextFill(Color.DARKSLATEBLUE);
        button.setLayoutX(30);
        button.setLayoutY(480);
        button.setOnAction(this);

        Group root = new Group(text, button, imageView);
        Scene scene = new Scene(root, 600, 600);

        stage.setScene(scene);
        stage.setTitle("Word Occurrences");
        stage.setWidth(600);
        stage.setHeight(550);
        stage.show();

    }

    @Override
    public void handle(ActionEvent actionEvent) {
            String testFile = "/Users/gordonm/Documents/Gordon B.A.S Journey/CEN3024C(softwareDevelopment1) FALL2021/module2 intelij/src/input.txt";
            ProcessFile processFile = new ProcessFile(testFile);
            Map<String, Integer> wordHolder = processFile.getFileResults();
            LinkedHashMap<String, Integer> sortedHolder = new LinkedHashMap<>();
            wordHolder.entrySet().stream().sorted(Map.Entry.comparingByValue(
                    Comparator.reverseOrder())).limit(20).forEachOrdered(
                    x -> sortedHolder.put(x.getKey(), x.getValue()));
            System.out.println("------Top 20 Words---------");
            for (Map.Entry<String, Integer> entry : sortedHolder.entrySet()) {
                System.out.println(entry.getKey() + " ----> " + entry.getValue());
            }

    }
}


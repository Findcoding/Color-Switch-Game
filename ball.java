package com.example.ColorSwitchGame;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.EventHandler;



public class ball extends Application {

    private Group root;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start (Stage stage) {

        stage.setTitle ("ball");
        root = new Group();
        Scene scene = new Scene(root, 800, 800, Color.BLACK);
        stage.setScene(scene);
        stage.show();

        Circle circle = new Circle();
        Circle circle1 = new Circle();
        Circle circle2 = new Circle();
        Circle circle3 = new Circle();
        Circle circle4 = new Circle();
        Circle circle5 = new Circle();

        MakeBall(circle, Color.PURPLE, 700, 400, 350);
        MakeBall(circle5, Color.WHITE, 560, 400, 350);
        MakeBall(circle1, Color.BLUE, 420, 400, 340);
        MakeBall(circle2, Color.GREEN, 280, 400, 310);
        MakeBall(circle3, Color.YELLOW, 140, 400, 280);
        MakeBall(circle4, Color.RED, 0, 400, 250);

    }

    private void MakeBall(Circle circle, Color c, int x, int y, int dist) {

        circle = new Circle(50, c);
        circle.relocate(x, y);
        root.getChildren().add(circle);
    }


}
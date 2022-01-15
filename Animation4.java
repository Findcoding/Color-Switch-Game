package com.example.demo;

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
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


import java.util.List;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;

import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation4 extends Application{

    private Pane canvas;

    @Override
    public void start(Stage stage) {

        canvas = new Pane();
        Scene scene = new Scene(canvas, 800, 800);
        scene.setFill(Color.BLACK);

//        Circle ball = new Circle(20, Color.WHITE);
//        ball.relocate(0, 400);
//        canvas.getChildren().add(ball);


//        Button b = new Button();
//        b.setText("EXIT");
//        b.relocate(500, 700);
//
//        Button b1 = new Button();
//        b1.setText("PAUSE");
//        b1.relocate(370, 700);
//        canvas.getChildren().add(b1);
//
//        Button b2 = new Button();
//        b2.setText("NEW GAME");
//        b2.relocate(200, 700);
//        canvas.getChildren().add(b2);




//
////        StackPane root = new StackPane();
//        canvas.getChildren().add(b);
//        b.setOnAction(e -> Platform.exit());



        stage.setTitle("Moving Ball");
        stage.setScene(scene);
        stage.show();

        GetBall(Color.GREEN, 1, 0);
        GetBall(Color.RED, 2, 100);
        GetBall(Color.YELLOW, 3, 200);
        GetBall(Color.WHITE, 4, 300);
        GetBall(Color.BLUE, 5, 400);


//        Bounds bounds = canvas.getBoundsInLocal();
//        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2),
//                new KeyValue(ball.layoutXProperty(), bounds.getMaxX()-ball.getRadius())));

//        b2.setOnAction(e-> {
//            timeline.play();
//        });
//
//        b1.setOnAction(e->{
//            timeline.pause();
//        });

//        timeline.setCycleCount(20);
//        timeline.play();
    }

    private void GetBall(Color x, int time, int dist) {

        Circle ball = new Circle(20, x);
        ball.relocate(dist, 400);
        canvas.getChildren().add(ball);

        Bounds bounds = canvas.getBoundsInLocal();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(time),
                new KeyValue(ball.layoutXProperty(), bounds.getMaxX()-ball.getRadius())));

        timeline.setCycleCount(100);
        timeline.play();

    }

    public static void main(String[] args) {
        launch();
    }
}
package com.example.ColorSwitchGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.ScaleTransition;
import javafx.animation.RotateTransition;
import javafx.animation.PathTransition;
import javafx.scene.shape.Circle;

public class Animation1 extends Application {

    private Scene scene;
    private Group group;

    @Override
    public void start(Stage primaryStage) {

        Circle ball = new Circle(20);
        primaryStage.setTitle("Animation");


        group = new Group();
        scene = new Scene(group, 800, 800, Color.BLACK);


        ball.setFill(Color.WHITE);
        ball.setCenterX(scene.getHeight()/2);
        ball.setCenterY(scene.getWidth()/2);
        group.getChildren().add(ball);

        Circle ball1 = new Circle(20);
        ball1.setFill(Color.RED);
        ball1.setCenterX(scene.getHeight()/2);
        ball1.setCenterY(scene.getWidth()/2);
        group.getChildren().addAll(ball1);

        RotateBall(ball, 2050, 400, 400);
        RotateBall(ball1, 2100, 400, 400);
        Circle ball2 = new Circle(20);
        MakeCircle(ball2, Color.BLUE);
        RotateBall(ball2, 2150, 400, 400);

        Circle ball3 = new Circle(20);
        MakeCircle(ball3, Color.YELLOW);
        RotateBall(ball3, 2250, 400, 400);

        Circle ball4 = new Circle(20);
        MakeCircle(ball4, Color.GREEN);
        RotateBall(ball4, 2200, 400, 400);


        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private void RotateBall(Circle ball, int time, int x, int y){
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(time));
        //Set node to be animated
        pathTransition.setNode(ball);

        pathTransition.setCycleCount(100);
        pathTransition.setAutoReverse(true);
        pathTransition.setRate(1);
//	    pathTransition.isAutoReverse();
        //Rotate button through a circular path locate at (400,400) with radius 150
        pathTransition.setPath(new Circle(x, y, 200));

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1));
        rotateTransition.setByAngle(180f);
        rotateTransition.setNode(ball);

        pathTransition.play();
    }


    private void MakeCircle(Circle ball, Color x) {

        ball.setFill(x);
        ball.setCenterX(scene.getHeight()/2);
        ball.setCenterY(scene.getWidth()/2);
        group.getChildren().addAll(ball);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}





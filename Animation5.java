package com.example.demo;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Point3D;
//import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;


public class Animation5 extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub

        //Creating Rectangle
        Rectangle rect = new Rectangle(300,300,200,200);
//        rect.setFill();
        rect.setStroke(Color.WHITE);
        rect.setStrokeWidth(5);

        Rectangle rect1 = new Rectangle(300,400,100,100);
//      rect.setFill();
        rect1.setStroke(Color.YELLOW);
        rect1.setStrokeWidth(5);

        Play(rect, Rotate.Z_AXIS);
//      Play(rect1, Rotate.Z_AXIS);/

        //Configuring Group and Scene
        Group root = new Group();
        root.getChildren().addAll(rect);
//        root.getChildren().addAll(rect1);
        Scene scene = new Scene(root,800,800, Color.BLACK);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Animation");
        primaryStage.show();

    }

    private void Play(Rectangle rect, Point3D x) {

        RotateTransition rotate = new RotateTransition();

        //Setting Axis of rotation
        rotate.setAxis(x);

        // setting the angle of rotation
        rotate.setByAngle(360);

        //setting cycle count of the rotation
        rotate.setCycleCount(100);

        //Setting duration of the transition
        rotate.setDuration(Duration.millis(10000));

        //the transition will be auto reversed by setting this to true
        rotate.setAutoReverse(true);

        //setting Rectangle as the node onto which the
// transition will be applied
        rotate.setNode(rect);

        //playing the transition
        rotate.play();

    }


    public static void main(String[] args) {
        launch(args);
    }

}

package com.example.demo;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Animation3 extends Application {

    private static final ArrayList<Group> obs = new ArrayList<>();

    public Animation3() {
        obs.add(InsideLine());
        obs.add(OuterLine());
    }






    @Override
    public void start(Stage primaryStage) throws Exception{

        Group root  = new Group();
        root.getChildren().addAll(obs);

//        InsideLine();
//        OuterLine();




        Thread animationThread = new Thread(() -> {
            int updateInTime = 20;                 // Millisecond
            double rotateSpeed = 0.05;             // Degree Per Mili Sec

            while (true) {

                try {
//                    root.setRotate(root.getRotate() + rotateSpeed*updateInTime);
                    obs.get(0).setRotate(obs.get(0).getRotate() + rotateSpeed*updateInTime);
                    obs.get(1).setRotate(obs.get(1).getRotate() - rotateSpeed*updateInTime);
                    Thread.sleep(updateInTime);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        animationThread.start();



        primaryStage.setTitle("Animation");
        Scene firstScene = new Scene(root, 800, 800);
        firstScene.setFill(Color.rgb(23,17,17));
        primaryStage.setScene(firstScene);
        primaryStage.show();


    }


    public Group OuterLine() {

        Group root  = new Group();

        Line line2 = new Line(600, 200, 600, 600);
        line2.setStroke(Color.WHITE);
        line2.setStrokeWidth(15);
        line2.setFill(Color.TRANSPARENT);
        root.getChildren().addAll(line2);

        Line line1 = new Line(200, 600, 600, 600);
        line1.setStroke(Color.BLUE);
        line1.setStrokeWidth(15);
        line1.setFill(Color.TRANSPARENT);
        root.getChildren().addAll(line1);

        Line line3 = new Line(200, 200, 200, 600);
        line3.setStroke(Color.RED);
        line3.setStrokeWidth(15);
        line3.setFill(Color.TRANSPARENT);
        root.getChildren().addAll(line3);

        Line line4 = new Line(200, 200, 600, 200);
        line4.setStroke(Color.YELLOW);
        line4.setStrokeWidth(15);
        line4.setFill(Color.TRANSPARENT);
        root.getChildren().addAll(line4);

        return root;

    }



    public Group InsideLine() {

        Group root  = new Group();

        Line line5 = new Line(220, 220, 580, 220);
        line5.setStroke(Color.RED);
        line5.setStrokeWidth(15);
        line5.setFill(Color.TRANSPARENT);
        root.getChildren().addAll(line5);

        Line line6 = new Line(220, 220, 220, 580);
        line6.setStroke(Color.BLUE);
        line6.setStrokeWidth(15);
        line6.setFill(Color.TRANSPARENT);
        root.getChildren().addAll(line6);


        Line line7 = new Line(580, 220, 580, 580);
        line7.setStroke(Color.YELLOW);
        line7.setStrokeWidth(15);
        line7.setFill(Color.TRANSPARENT);
        root.getChildren().addAll(line7);


        Line line8 = new Line(220, 580, 580, 580);
        line8.setStroke(Color.WHITE);
        line8.setStrokeWidth(15);
        line8.setFill(Color.TRANSPARENT);
        root.getChildren().addAll(line8);

        return root;


    }





    public static void main(String[] args) {
        launch(args);
    }
}


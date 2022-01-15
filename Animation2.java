
package com.example.ColorSwitchGame;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.application.Platform;
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


public class Animation2 extends Application {

    private static final ArrayList<Group> obj = new ArrayList<>();

    public Animation2() {
        obj.add(InnerCircle());
        obj.add(OuterCircle());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

//        Arc arc = new Arc(400,400,200,200,0,72);
//        Arc arc1 = new Arc(400,400,200,200,72,72);
//        Arc arc2 = new Arc(400,400,200,200,144,72);
//        Arc arc3 = new Arc(400,400,200,200,216,72);
//        Arc arc4 = new Arc(400,400,200,200,288,72);


//        arc.setStroke(Color.BLUE);
//        arc.setFill(Color.TRANSPARENT);
//        arc.setStrokeWidth(10);
////        arc.setType(ArcType.ROUND);
//
//
//
//        arc1.setStroke(Color.WHITE);
//        arc1.setStrokeWidth(10);
//        arc1.setFill(Color.TRANSPARENT);
//
//
//        arc2.setStroke(Color.YELLOW);
//        arc2.setStrokeWidth(10);
//        arc2.setFill(Color.TRANSPARENT);
//
//        arc3.setStroke(Color.RED);
//        arc3.setFill(Color.TRANSPARENT);
//        arc3.setStrokeWidth(10);
//
//
//
//        arc4.setStroke(Color.GREEN);
//        arc4.setFill(Color.TRANSPARENT);
//        arc4.setStrokeWidth(10);

//        Arc arc5 = new Arc(400,400,180,180, 0, 72);
//        Arc arc6 = new Arc(400,400,180,180, 72, 72);
//        Arc arc7 = new Arc(400,400,180,180, 144, 72);
//        Arc arc8 = new Arc(400,400,180,180, 216, 72);
//        Arc arc9 = new Arc(400,400,180,180, 288, 72);
//
//
//        addArc(arc, Color.BLUE);
//        addArc(arc1, Color.WHITE);
//        addArc(arc2, Color.YELLOW);
//        addArc(arc3, Color.RED);
//        addArc(arc4, Color.GREEN);
//
//        addArc(arc5, Color.GREEN);
//        addArc(arc6, Color.BLUE);
//        addArc(arc7, Color.RED);
//        addArc(arc8, Color.WHITE);
//        addArc(arc9, Color.YELLOW);


//        Group root  = new Group(arc);
//        root.getChildren().add(arc);
//        root.getChildren().add(arc1);
//        root.getChildren().add(arc2);
//        root.getChildren().add(arc3);
//        root.getChildren().add(arc4);
//
//        root.getChildren().add(arc5);
//        root.getChildren().add(arc6);
//        root.getChildren().add(arc7);
//        root.getChildren().add(arc8);
//        root.getChildren().add(arc9);



        Group root  = new Group();
        root.getChildren().addAll(obj);


        primaryStage.setTitle("Animation1");
        Scene firstScene = new Scene(root, 800, 800);
        //firstScene.setFill(Color.GREENYELLOW);
//        arc.setCenterX(firstScene.getHeight()/2);
//        arc.setCenterY(firstScene.getWidth()/2);

        firstScene.setFill(Color.rgb(23,17,17));
        primaryStage.setScene(firstScene);
        primaryStage.show();





        Thread animationThread = new Thread(() -> {

            int updateInTime = 10; // Millisecond
            double rotateSpeed = 0.05; // Degree Per Mili Sec

            while (true) {
                try {

//                    root.setRotate(root.getRotate() + rotateSpeed*updateInTime);
                    obj.get(0).setRotate(obj.get(0).getRotate() + rotateSpeed*updateInTime);
                    obj.get(1).setRotate(obj.get(1).getRotate() - rotateSpeed*updateInTime);
                    Thread.sleep(updateInTime);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        animationThread.start();





//

    }

    public void addArc(Arc arc, Color c) {

        arc.setStroke(c);
        arc.setFill(Color.TRANSPARENT);
        arc.setStrokeWidth(15);

    }


    public Group OuterCircle() {

        Group root  = new Group();
        Arc arc1 = new Arc(400,400,200,200,0,72);
        Arc arc2 = new Arc(400,400,200,200,72,72);
        Arc arc3 = new Arc(400,400,200,200,144,72);
        Arc arc4 = new Arc(400,400,200,200,216,72);
        Arc arc5 = new Arc(400,400,200,200,288,72);

        addArc(arc1, Color.BLUE);
        addArc(arc2, Color.WHITE);
        addArc(arc3, Color.YELLOW);
        addArc(arc4, Color.RED);
        addArc(arc5, Color.GREEN);

        root.getChildren().addAll(arc1, arc2, arc3, arc4, arc5);

        return root;

    }


    public Group InnerCircle() {

        Group root  = new Group();
        Arc arc6 = new Arc(400,400,180,180, 0, 72);
        Arc arc7 = new Arc(400,400,180,180, 72, 72);
        Arc arc8 = new Arc(400,400,180,180, 144, 72);
        Arc arc9 = new Arc(400,400,180,180, 216, 72);
        Arc arc10 = new Arc(400,400,180,180, 288, 72);

        addArc(arc6, Color.WHITE);
        addArc(arc7, Color.YELLOW);
        addArc(arc8, Color.RED);
        addArc(arc9, Color.GREEN);
        addArc(arc10, Color.BLUE);

        root.getChildren().add(arc6);
        root.getChildren().add(arc7);
        root.getChildren().add(arc8);
        root.getChildren().add(arc9);
        root.getChildren().add(arc10);

        return root;

    }


    private void Rotated(Arc arc, float f) {

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(2));
        //Set node to be animated
        pathTransition.setNode(arc);

        pathTransition.setCycleCount(2);
        pathTransition.setAutoReverse(false);
        pathTransition.setRate(1);
//	    pathTransition.isAutoReverse();
        //Rotate button through a circular path locate at (400,400) with radius 150
        pathTransition.setPath(new Circle(400, 400, 200));

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1));
        rotateTransition.setByAngle(f);
        rotateTransition.setNode(arc);

        pathTransition.play();

    }


    public static void main(String[] args) {
        launch(args);
    }
}


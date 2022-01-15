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




public class demo1 extends Application {

    private Timeline t;
    private int xSpeed = 2;
    Scene scene2;
    public boolean collision = false;




    public void start(Stage first) throws FileNotFoundException {


        Image image = new Image(new FileInputStream("C:\\Users\\Prasa\\Desktop\\download.png"));

        //Setting the image view
        ImageView imageView = new ImageView(image);

        //Setting the position of the image
        imageView.setX(200);
        imageView.setY(400);

        //setting the fit height and width of the image view
        imageView.setFitHeight(700);
        imageView.setFitWidth(400);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);


        Group root = new Group(imageView);
        Scene field = new Scene(root, 800, 800);
        field.setFill(Color.BLACK);

        Circle ball = new Circle(20);
        ball.setFill(Color.WHITE);
//        ball.setScaleX(300);
//        ball.setScaleY(500);
        ball.setCenterX(field.getHeight()/2);
        ball.setCenterY(field.getWidth()/2);
        root.getChildren().add(ball);

        int position = 100;


        field.setOnKeyReleased(e ->{    //event handler for space
            switch (e.getCode()) {

                case SPACE:
                    ball.setTranslateY(ball.getCenterY() + position);
                    break;

            }
        });



        Button b = new Button();
        b.setText("EXIT");
        b.relocate(650, 700);

        Button b1 = new Button();
        b1.setText("PAUSE");
        b1.relocate(500, 700);
        root.getChildren().add(b1);

        Button b2 = new Button();
        b2.setText("PLAY");
        b2.relocate(150, 700);
        root.getChildren().add(b2);

        Button b3 = new Button();
        b3.setText("SAVED GAME");
        b3.relocate(300, 700);
        root.getChildren().add(b3);


        //Creating Rectangle
        Rectangle rect = new Rectangle(200, 100, 200, 200);
        rect.relocate(300, 100);
//        rect.setFill();
        rect.setStroke(Color.WHITE);
        rect.setFill(Color.TRANSPARENT);
        rect.setStrokeWidth(5);
//        rect.setVisible(false);
//        root.getChildren().add(rect);

        //Instantiating RotateTransition class
        RotateTransition rotate = new RotateTransition();

        //Setting Axis of rotation
        rotate.setAxis(Rotate.Z_AXIS);

        // setting the angle of rotation
        rotate.setByAngle(360);

        //setting cycle count of the rotation
        rotate.setCycleCount(100);

        //Setting duration of the transition
        rotate.setDuration(Duration.seconds(10));

        //the transition will be auto reversed by setting this to true
        rotate.setAutoReverse(true);
//        rotate.setNode(rect);
//        rotate.play();


        root.getChildren().add(rect);
        first.setScene(field);
        first.show();


        b2.setOnAction(e-> {
//            t.play();

            if(e.getSource() == b2) {
//            	rect.setVisible(true);
                rotate.setNode(rect);
                rotate.play();
                t.play();
                imageView.setVisible(false);

            }

        });

        b1.setOnAction(e->{
//            t.pause();

            if(e.getSource() == b1) {
                rotate.pause();
                t.pause();
            }

        });

        Label label= new Label("Here All data will be store....");
        VBox layout= new VBox(20);
        layout.getChildren().add(label);
        Group root1 = new Group();
        b3.setOnAction(e -> first.setScene(scene2));
//        scene2= new Scene(root1, 800, 800, Color.BLACK);
        scene2= new Scene(layout, 800, 800, Color.BLACK);

        root.getChildren().add(b);
        b.setOnAction(e -> Platform.exit());

        first.setTitle("Color Switch Game...");

        //

        field.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override

            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SPACE) {
                    xSpeed=-xSpeed;
                }
            }


        });

//        pauseGame(btnPause,ball);
//        startGame(btnStart,ball);
        KeyFrame k = new KeyFrame(Duration.millis(8), e ->{       // speed..
            moveBall(ball);
        });

        t = new Timeline(k);
        t.setCycleCount(Animation.INDEFINITE);
    }

    private void moveBall(Circle ball){
        ball.setCenterY(ball.getCenterY() - xSpeed);
        if(ball.getCenterY()>=700 || ball.getCenterY()<=100){
            xSpeed=-xSpeed;
        }
    }



//    private void startGame(Button start, Circle ball){
//        start.setOnAction(e->{
//            t.play();
//        });
//    }
//
//    private void pauseGame(Button pause, Circle ball){
//        pause.setOnAction(e->{
//           t.pause();
//        });
//    }

    /*
       public void Collision(Rectangle rectangle, Circle ball) {

           Rectangle rect = bounds();
           ball = new Circle(20);
           if(ball.intersects(rect)) {

               collision = true;

           }

           else {

               collision = false;
           }
       }

       public Rectangle bounds() {
           return (new Rectangle(200, 100, 200, 200));
       }



       public class Ball extends Circle	{
           private String color;

           public Ball(String color){
               this.color = color;
           }

           public String getColor() {
               return color;
           }
       }


   */
    public static void main(String[] args){
        Application.launch(args);
    }

}

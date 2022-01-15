package com.example.ColorSwitchGame;


import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.animation.*;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;






public class Main extends Application {

    private Timeline t;
    private Thread t1;
    private int xSpeed = 2;
    Scene scene2, scene3;



    private int Score = 0;
    private int End = 0;
    private int n = 1;
    private static final int      KEYBOARD_MOVEMENT_DELTA = 10;
    private static final Duration TRANSLATE_DURATION      = Duration.seconds(0.25);

    private static final ArrayList<Group> obj = new ArrayList<>();
    private static int current;
    private static int next;

    public Main() {

//    	obj.add(Black());
//    	obj.add(Line());
        obj.add(InnerCircle());
//    	obj.add(OuterCircle());
        obj.add(Line());
        obj.add(drawDifferentArcCircle1());
        obj.add(LineBall());
        obj.add(OuterLine());
        obj.add(drawDifferentArcCircle());


        current = 0;
        next = 1;
    }



    public static int getCurrent() {
        return current;
    }

    public static void setCurrent(int i) {
        current = i;
    }

    public int getScore() {
        return Score;
    }

    public int getEnd() {
        return End;
    }



    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();
        root.getChildren().addAll(obj);

        while (current <= obj.size()-1) {
            obj.get(current).setVisible(false);
            current++;
        }

        current = 0;

        obj.get(current).setVisible(true);
        obj.get(next).setTranslateY(obj.get(current).getTranslateY() + 700);
        obj.get(next).setVisible(true);


        Button b = new Button();
        b.setText("EXIT");
        b.setStyle("-fx-background-color: red");
        b.relocate(650, 700);
        root.getChildren().add(b);

        Button b1 = new Button();
        b1.setText("PAUSE");
        b1.setStyle("-fx-background-color: blue");
        b1.relocate(500, 700);
        root.getChildren().add(b1);

        Button b2 = new Button();
        b2.setText("PLAY");
        b2.setStyle("-fx-background-color: green");
        b2.relocate(150, 700);
        root.getChildren().add(b2);

        Button b3 = new Button();
        b3.setText("SAVED GAME");
        b3.setStyle("-fx-background-color: yellow");
        b3.relocate(300, 700);
        root.getChildren().add(b3);

        Circle circle = new Circle(200, 150, 20, Color.WHITE);

        final TranslateTransition transition = createTranslateTransition(circle);
        Scene scene = new Scene(root, 800, 800, Color.BLACK);

        circle.setFill(Color.WHITE);
        circle.setCenterX(scene.getHeight()/2);
        circle.setCenterY(scene.getWidth()/2);
        root.getChildren().add(circle);


        b.setOnAction(e -> Platform.exit());

        // Image....
        Image image = new Image("file:Media/download.png"));

        ImageView imageView = new ImageView(image);

        imageView.setX(200);
        imageView.setY(410);

        imageView.setFitHeight(700);
        imageView.setFitWidth(400);

        imageView.setPreserveRatio(true);
        root.getChildren().add(imageView);



        //MUSIC.....
        String path = "Media/Intro.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);



        Text text = new Text();
        text.setText("SCORE: ");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        text.setFill(Color.WHITE);
        text.setStrokeWidth(1);
        text.setStroke(Color.RED);
        text.setX(20);
        text.setY(30);
        root.getChildren().add(text);



        Text text2 = new Text();
        text2.setText("PLAYER: THALA ");
        text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        text2.setFill(Color.WHITE);
        text2.setStrokeWidth(1);
        text2.setStroke(Color.RED);
        text2.setX(600);
        text2.setY(30);
        root.getChildren().add(text2);




        Label label= new Label("LIST OF GAMER...");
        Label label1 = new Label();
        label1.setText("PLAYER:      THALA   --->" + " SCORE: " + Integer.toString(Score));
        label.setLayoutX(100);
        label.setLayoutY(200);

        VBox layout= new VBox(30);


        scene2 = new Scene(layout, 800, 800, Color.BLACK);
        Button button2= new Button("BACK");
        layout.getChildren().addAll(label, button2, label1);
        button2.setOnAction(e -> stage.setScene(scene));
        b3.setOnAction(e -> stage.setScene(scene2));




        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                xSpeed=-xSpeed;
            }
        });

        KeyFrame k = new KeyFrame(Duration.millis(8), e -> {       // speed..
//            moveBall(ball);
        });




        t = new Timeline(k);
        t.setCycleCount(Animation.INDEFINITE);

        stage.setScene(scene);
        stage.setTitle("Color Switch");
        stage.show();


        Text text1 = new Text();
        text1.setText(Integer.toString(getScore()));
        text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        text1.setFill(Color.WHITE);
        text1.setStrokeWidth(1);
        text1.setStroke(Color.RED);
        text1.setX(110);
        text1.setY(30);
        root.getChildren().add(text1);


        final Popup popup = new Popup();
        popup.setX(520);
        popup.setY(400);
        Text text0 = new Text();
        text0.setText("GAME OVER!!");
        text0.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 60));
        text0.setFill(Color.WHITE);
        text0.setStrokeWidth(1);
        text0.setStroke(Color.RED);
        text0.setX(20);
        text0.setY(30);
        popup.getContent().addAll(text0);


        t1 = new Thread(()-> {

            while(true) {
                try {

                    obj.get(current).setTranslateY(obj.get(current).getTranslateY() + 130*(0.05));
                    obj.get(current).setRotate(obj.get(current).getRotate() - 10*0.1);

                    obj.get(next).setTranslateY(obj.get(current).getTranslateY() - 900);
                    obj.get(next).setRotate(obj.get(1).getRotate() - 10*0.1);

                    if (obj.get(current).getTranslateY() >= 400) {
                        obj.get(current).setVisible(false);
                        current = next;
                        next++;

                        if (next == obj.size()) {
                            next = 0;
                        }

                        obj.get(next).setTranslateY(obj.get(current).getTranslateY() - 900);
                        obj.get(next).setVisible(true);
                    }


                    for(int i=0; i<4; i++) {

                        if (obj.get(current).getChildren().size() >= 1 && ((Path) Shape.intersect((Shape)obj.get(current).getChildren().get(i), circle)).getElements().size()>0) {
                            if (((Shape)obj.get(current).getChildren().get(i)).getStroke() == circle.getFill() || ((Shape)obj.get(current).getChildren().get(i)).getFill() == circle.getFill()) {
//                        		System.out.println("No Collison");
                                Score++;
                                text1.setText(Integer.toString(getScore()));
                                label1.setText("PLAYER:      THALA   --->" + " SCORE: " + Integer.toString(Score));

                            } else {

//                        		System.out.println("Collison Detected");
                                label1.setText("PLAYER:      THALA   --->" + " SCORE: " + Integer.toString(Score) + "  (OUT)...");
                                End = 1;

                                mediaPlayer.pause();
                                Platform.runLater(()-> popup.show(stage));
                                t1.stop();


                            }

                        }

                    }


                    Thread.sleep(100);


                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });



        popup.setHideOnEscape(false);



        b1.setOnAction(e-> {

            if(e.getSource() == b1) {
                t.pause();
                mediaPlayer.pause();
                t1.suspend();

            }

        });



        b2.setOnAction(e-> {

            if(e.getSource() == b2) {

                if(n==1) {
                    t1.start();
                    n=0;

                } else {
                    t1.resume();
                }

                mediaPlayer.play();
                moveCircleOnKeyPress(scene, circle);
                imageView.setVisible(false);

            }

        });




    }

    private void moveBall(Circle ball) {
        ball.setCenterY(ball.getCenterY() - xSpeed);
        if(ball.getCenterY()>=700 || ball.getCenterY()<=100){
            xSpeed=-xSpeed;
        }
    }




    public void pause() throws InterruptedException {
        t1.wait();
    }




    private TranslateTransition createTranslateTransition(final Circle circle) {
        final TranslateTransition transition = new TranslateTransition(TRANSLATE_DURATION, circle);
        transition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent t) {
                circle.setCenterX(circle.getTranslateX() + circle.getCenterX());
                circle.setCenterY(circle.getTranslateY() + circle.getCenterY());
                circle.setTranslateX(0);
                circle.setTranslateY(0);
            }
        });

        return transition;
    }




    private void moveCircleOnKeyPress(Scene scene, final Circle circle) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    circle.setCenterY(circle.getCenterY() - KEYBOARD_MOVEMENT_DELTA); break;
//              case RIGHT: circle.setCenterX(circle.getCenterX() + KEYBOARD_MOVEMENT_DELTA); break;
                    case DOWN:  circle.setCenterY(circle.getCenterY() + KEYBOARD_MOVEMENT_DELTA); break;
//              case LEFT:  circle.setCenterX(circle.getCenterX() - KEYBOARD_MOVEMENT_DELTA); break;
                    default:
                        break;
                }
            }
        });
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
        Arc arc6 = new Arc(400,400,180,180, 0, 90);
        Arc arc7 = new Arc(400,400,180,180, 90, 90);
        Arc arc8 = new Arc(400,400,180,180, 180, 90);
        Arc arc10 = new Arc(400,400,180,180, 270, 90);

        addArc(arc6, Color.WHITE);
        addArc(arc7, Color.YELLOW);
        addArc(arc8, Color.RED);
        addArc(arc10, Color.BLUE);

        root.getChildren().add(arc6);
        root.getChildren().add(arc7);
        root.getChildren().add(arc8);
        root.getChildren().add(arc10);


        return root;

    }



    public Group OuterLine() {

        Group root  = new Group();

        Line line2 = new Line(500, 220, 500, 500);
        line2.setStroke(Color.YELLOW);
        line2.setStrokeWidth(15);
        line2.setFill(Color.TRANSPARENT);
        root.getChildren().addAll(line2);

        Line line1 = new Line(220, 500, 500, 500);
        line1.setStroke(Color.BLUE);
        line1.setStrokeWidth(15);
        line1.setFill(Color.TRANSPARENT);
        root.getChildren().addAll(line1);

        Line line3 = new Line(220, 220, 220, 500);
        line3.setStroke(Color.WHITE);
        line3.setStrokeWidth(15);
        line3.setFill(Color.TRANSPARENT);
        root.getChildren().addAll(line3);

        Line line4 = new Line(220, 220, 500, 220);
        line4.setStroke(Color.RED);
        line4.setStrokeWidth(15);
        line4.setFill(Color.TRANSPARENT);
        root.getChildren().addAll(line4);

        return root;

    }


    public Group drawDifferentArcCircle() {

        Group root = new Group();
        Arc arc = new Arc(400,400,180,180,0,90);
        Arc arc1 = new Arc(400,400,180,180,90,90);
        Arc arc2 = new Arc(400,400,180,180,180,90);
        Arc arc3 = new Arc(400,400,180,180,270,90);

        arc.setFill(Color.BLUE);
        arc1.setFill(Color.YELLOW);
        arc2.setFill(Color.RED);
        arc3.setFill(Color.WHITE);

        root.getChildren().addAll(arc,arc1,arc2,arc3);


        return root;
    }


    public Group drawDifferentArcCircle1() {

        Group root = new Group();
        Arc arc = new Arc(400,400,180,180,0,90);
        Arc arc1 = new Arc(400,400,180,180,90,90);
        Arc arc2 = new Arc(400,400,180,180,180,90);
        Arc arc3 = new Arc(400,400,180,180,270,90);

        arc.setFill(Color.BLUE);
        arc1.setFill(Color.WHITE);
        arc2.setFill(Color.YELLOW);
        arc3.setFill(Color.WHITE);

        root.getChildren().addAll(arc,arc1,arc2,arc3);


        return root;
    }






    public Group LineBall() {

        Group root = new Group();

        Circle circle = new Circle(100, Color.RED);
        circle.relocate(0, 400);
        root.getChildren().add(circle);


        Circle circle1 = new Circle(100, Color.WHITE);
        circle1.relocate(200, 400);
        root.getChildren().add(circle1);

        Circle circle2 = new Circle(100, Color.WHITE);
        circle2.relocate(400, 400);
        root.getChildren().add(circle2);


        Circle circle3 = new Circle(100, Color.GREEN);
        circle3.relocate(600, 400);
        root.getChildren().add(circle3);


        return root;

    }


    public Group Line() {

        Group root  = new Group();

        Line line2 = new Line(500, 220, 500, 500);
        line2.setStroke(Color.YELLOW);
        line2.setStrokeWidth(15);
        line2.setFill(Color.TRANSPARENT);
        root.getChildren().addAll(line2);

        Line line1 = new Line(220, 500, 500, 500);
        line1.setStroke(Color.WHITE);
        line1.setStrokeWidth(15);
        line1.setFill(Color.TRANSPARENT);
        root.getChildren().addAll(line1);

        Line line3 = new Line(220, 220, 220, 500);
        line3.setStroke(Color.WHITE);
        line3.setStrokeWidth(15);
        line3.setFill(Color.TRANSPARENT);
        root.getChildren().addAll(line3);

        Line line4 = new Line(220, 220, 500, 220);
        line4.setStroke(Color.RED);
        line4.setStrokeWidth(15);
        line4.setFill(Color.TRANSPARENT);
        root.getChildren().addAll(line4);

        return root;

    }


    public Group Black() {

        Group root = new Group();
        Circle circle = new Circle(400, Color.BLACK);
        circle.relocate(400, 400);
        circle.setVisible(false);
        root.getChildren().add(circle);

        return root;

    }




    public static void main(String[] args) {
        launch(args);
    }

}


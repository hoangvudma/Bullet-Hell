package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;




public class Main extends Application {
Pane root;
Rectangle player,screen;
final int WIDTH = 800;
final int HEIGHT = 600;
ArrayList<Enemy> Enes = new ArrayList<>();
AnimationTimer timer;



    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Bullet Hell");
        primaryStage.setScene(new Scene(content()));
        primaryStage.show();

        primaryStage.getScene().setOnKeyPressed(event -> {
            System.out.println("KeyPress");
            if (event.getCode() == KeyCode.UP) player.setLayoutY(player.getLayoutY()-16);
            if (event.getCode()== KeyCode.DOWN) player.setLayoutY(player.getLayoutY()+16);
            if (event.getCode()== KeyCode.LEFT) player.setLayoutX(player.getLayoutX()-16);
            if (event.getCode()== KeyCode.RIGHT) player.setLayoutX(player.getLayoutX()+16);

        });
    }
    private Parent content() {
        root = new Pane();
        root.setPrefSize(WIDTH,HEIGHT);
        screen = new Rectangle(WIDTH,HEIGHT,Color.BLACK);
        screen.setLayoutX(0);
        screen.setLayoutY(0);
        player = new Rectangle(20,20,Color.WHITE);
        player.setLayoutX(WIDTH/2);
        player.setLayoutY(HEIGHT/2);
        root.getChildren().addAll(screen,player);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };

        timer.start();
        return root;
    }

    private void onUpdate() {
        if ((Enes.size()==0 || (int) (Math.random()*1000)>960)&& Enes.size()<20)
            addnewEne();

        for (Enemy Ene:Enes){
            Ene.move();

            if (Ene.getLayoutX() >= player.getLayoutX()-15 &&
            Ene.getLayoutX() <= player.getLayoutX()+15 &&
            Ene.getLayoutY() >= player.getLayoutY()-15 &&
            Ene.getLayoutY() <= player.getLayoutY()+15){
                Text text = new Text();
                text.setText("Game Over");
                text.setFont(Font.font("Arial",20));
                text.setFill(Color.WHITE);
                text.setLayoutX(WIDTH/2);
                text.setLayoutY(HEIGHT/2);
                root.getChildren().addAll(text);
                timer.stop();
            }
        }
    }

    private void addnewEne() {
        Enemy Ene = new Enemy(-5,setY(),10);
        Enes.add(Ene);
        root.getChildren().addAll(Ene);

    }
    private int setY(){
       int rand = (int)(Math.random()*1000);
       if (rand >0 && rand <800);
           return rand;
    }
    public static void main(String[] args) {
        launch(args);
    }
}

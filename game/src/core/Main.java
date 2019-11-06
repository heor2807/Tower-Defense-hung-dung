package core;import Entity.Moveable.Enemy.Enemy;import Entity.Moveable.Enemy.NormalEnemy;import Graphic.Render;import javafx.animation.AnimationTimer;import javafx.application.Application;import javafx.scene.Group;import javafx.scene.Scene;import javafx.stage.Stage;public class Main extends Application {    @Override    public void start(Stage primaryStage) {        //load game information (load in a Object name gameField)        GameField gameField = new GameField();        //Create new Window        Render renderGame = new Render();        Group root = new Group();        Scene theScene = new Scene(root);        Render.generateWindow(primaryStage, root, theScene);        /*        | Menu game (play (then choice level), credit or tutorial, choice level, load map, load game config, ...)         */        /*        |=======================================|        |   1. Player controller's input        |        |=======================================|        /*        |=======================================|        |   2. Render Everything                |        |=======================================|        /*        |=======================================|        |   3. Update world                     |        |=======================================|        /*        |=======================================|        |   4. Update Physics                   |        |=======================================|         */        /*        | Game loop         */        AnimationTimer timer = new AnimationTimer() {            int timerCount = 0;            int timerCheck = 0;            @Override            public void handle(long now) {                //render 4 layers: background -> road -> treeRock -> spawn                Render.renderMap(root, gameField);                if (timerCount == timerCheck + 10) {                    System.out.println("New enemy");                    timerCheck = timerCount;                    Enemy enemy = new NormalEnemy();                    gameField.addEnemy(enemy);                }//                GameField.enemyManage();                GameField.draw(root);                timerCount++;                //if(player don't play more, click exit button to exit the game) GameStage.closeWindow(primaryStage);            }        };        timer.start();        primaryStage.show();    }    public static void main (String[] args){        launch(args);    }}
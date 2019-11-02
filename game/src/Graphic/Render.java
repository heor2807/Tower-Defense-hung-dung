package Graphic;import core.Config;import core.GameField;import javafx.scene.Group;import javafx.scene.Scene;import javafx.scene.canvas.Canvas;import javafx.scene.image.Image;import javafx.scene.image.ImageView;import javafx.stage.Stage;public class Render {    public static void generateWindow(Stage primaryStage, Group root, Scene theScene) {        Canvas canvas = new Canvas(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);        root.getChildren().add(canvas);        primaryStage.setScene(theScene);        primaryStage.setTitle(Config.TITLE);        primaryStage.setResizable(false);        primaryStage.setMaxHeight(Config.SCREEN_HEIGHT + 35); // += 35 to remove the white bar        primaryStage.setMaxWidth(Config.SCREEN_WIDTH + 5);    // += 5  to remove the white bar//      need to be inside class Render, manually add latter//        primaryStage.show();    }    public static void renderMap(Group root, TileMap tileMap, ImageSheet imageSheet) {        for (int i = 0; i < Config.MAP_HEIGHT; i++) {            for (int j = 0; j < Config.MAP_WIDTH; j++) {                /*load index in tileMap, then find the right image -> add to imageView*/                if(tileMap.getTileMap(i, j) == 0) continue;                Image img = imageSheet.getImage(tileMap.getTileMap(i, j) - 1);                tileMap.setImageView(i, j, new ImageView(img));                tileMap.setXY(i, j, j * Config.TILE_HORIZONTAL, i * Config.TILE_VERTICAL);                root.getChildren().add(tileMap.getImageView(i, j));            }        }    }    public static void testRender(Group root, ImageSheet imageSheet) {        for (int i = 0; i < Config.MAP_HEIGHT; i++) {            for (int j = 0; j < Config.MAP_WIDTH; j++) {                Image img = imageSheet.getImage(i * 23 + j);                ImageView imageView = new ImageView(img);                imageView.setLayoutX(j * 64);                imageView.setLayoutY(i * 64);                root.getChildren().add(imageView);            }        }    }    public static void renderMap(Group root, GameField gameField) {        renderMap(root, gameField.getBackground(), gameField.getImageSheet());        renderMap(root, gameField.getRoad(), gameField.getImageSheet());        renderMap(root, gameField.getRockTree(), gameField.getImageSheet());        renderMap(root, gameField.getSpawn(), gameField.getImageSheet());    }}
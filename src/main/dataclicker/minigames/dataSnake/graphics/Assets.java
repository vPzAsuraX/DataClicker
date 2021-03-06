package main.dataclicker.minigames.dataSnake.graphics;

import java.awt.image.BufferedImage;

public class Assets {


    private static final int width = 32, height = 32;

    public static BufferedImage data, tail, grassTile, grassTileBorder, menu_background, menu_background1, startButton, logo, keys, border;
    public static BufferedImage head_W, head_A, head_S, head_D;


    public static void init() {

        SpriteSheet dataSheet = new SpriteSheet(ImageLoader.loadImage("/main/dataclicker/res/textures/dataDataSnake.png"));
        SpriteSheet headSheet = new SpriteSheet(ImageLoader.loadImage("/main/dataclicker/res/textures/headSheet.png"));
        SpriteSheet tailSheet = new SpriteSheet(ImageLoader.loadImage("/main/dataclicker/res/textures/tail.png"));
        SpriteSheet grassWithBorder = new SpriteSheet(ImageLoader.loadImage("/main/dataclicker/res/textures/tile_border.png"));
        SpriteSheet grassSheet = new SpriteSheet(ImageLoader.loadImage("/main/dataclicker/res/textures/tile.png"));
        SpriteSheet menuBack = new SpriteSheet(ImageLoader.loadImage("/main/dataclicker/res/textures/menu_background.png"));
        SpriteSheet menuBack1 = new SpriteSheet(ImageLoader.loadImage("/main/dataclicker/res/textures/menu_background1.png"));
        SpriteSheet start = new SpriteSheet(ImageLoader.loadImage("/main/dataclicker/res/textures/start.png"));
        SpriteSheet dataSnakeLogo = new SpriteSheet(ImageLoader.loadImage("/main/dataclicker/res/textures/logo1.png"));
        SpriteSheet tasten = new SpriteSheet(ImageLoader.loadImage("/main/dataclicker/res/textures/tasten.png"));
        SpriteSheet tileBorder = new SpriteSheet(ImageLoader.loadImage("/main/dataclicker/res/textures/border.png"));

        //Logo
        logo = dataSnakeLogo.crop(0, 0, 700, 300);

        //Start Button
        startButton = start.crop(0, 0, 250, 75);

        //Tasten
        keys = tasten.crop(0, 0, 87, 57);

        //Data
        data = dataSheet.crop(0, 0, width, height);

        //Hintergrund
        grassTile = grassSheet.crop(0, 0, width, height);
        grassTileBorder = grassWithBorder.crop(0, 0, width, height);
        border = tileBorder.crop(0,0, width, height);

        //Menü
        menu_background = menuBack.crop(0, 0, 800, 800);
        menu_background1 = menuBack1.crop(0, 0, 800, 800);

        //Schlange
        head_W = headSheet.crop(0, 0, width, height);
        head_A = headSheet.crop(width, 0, width, height);
        head_S = headSheet.crop(width * 2, 0, width, height);
        head_D = headSheet.crop(width * 3, 0, width, height);
        tail = tailSheet.crop(0, 0, width, height);


    }

}

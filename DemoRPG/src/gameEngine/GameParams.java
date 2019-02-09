package gameEngine;

import java.util.concurrent.Semaphore;

public class GameParams {

    public static Semaphore semaphore = new Semaphore(1);

    public static final double
        TILE_SIZE = 40;
    public static final double
        PLAYER_SPEED = 2.0;
    public static final int
        TICKS_PER_SECOND = 60;

    public static final String
        WORLD_MAP_FILE_PATH = "res/worldGeneration/world.map",
        MONSTERS_MATRIX_FILE_PATH = "res/worldGeneration/monsters.matrix";
}

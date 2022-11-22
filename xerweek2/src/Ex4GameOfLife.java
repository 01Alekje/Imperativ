import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.lang.System.exit;
import static java.lang.System.out;

/*
 * Program for Conway's game of life.
 * See https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 *
 * This is a graphical program using JavaFX to draw on the screen.
 * There's a bit of "drawing" code to make this happen (far below).
 * You don't need to implement (or understand) any of it.
 * NOTE: To run tests must uncomment in init() method, see comment
 *
 * Use functional decomposition!
 *
 * See:
 * - ex5matrix
 */
public class Ex4GameOfLife extends Application {

    final Random rand = new Random();

    // Enum type for state of Cells
    enum Cell {
        DEAD, ALIVE;
    }

    // This is the *only* accepted modifiable instance variable in program except ...
    Cell[][] world;

    @Override
    public void init() {
        // test();        // <--------------- Uncomment to test!
        int nLocations = 100000;
        double distribution = 0.05;   // % of locations holding a Cell

        int sideLength = (int) round(sqrt(nLocations));
        world = new Cell[sideLength][sideLength];

        this.world = seedWorld(world, distribution);

        //  a) Implement the init() method. The method should create and initialize the world with Cells
        //       (a square matrix with Cells). See code.
    }


    // Implement this method (using functional decomposition)
    // Every involved method should be tested, see below, method test()
    // This method is automatically called by a JavaFX timer (don't need to call it)

    // b) Now implement the update() method. The method should calculate the next state for all
    //       Cells in the world (using the rules).
    //       Method called automatically by a timer, don't need to call it. Rendering will be done automatically

    void update() {
        scanWorld();
    }

    // -------- Write methods below this --------------

    Cell[][] seedWorld (Cell[][] w, double dist) {
        int wSideLength = w.length;
        for (int i = 0; i < wSideLength; i++) {
            for (int j = 0; j < wSideLength; j++) {
                if (rand.nextDouble() < dist) {
                    w[i][j] = Cell.ALIVE;
                } else {
                    w[i][j] = Cell.DEAD;
                }
            }
        }
        return w;
    }

    Cell[][] scanWorld () {
        for (int r = 0; r < world.length; r++) {
            for (int c = 0; c < world[r].length; c++) {
                if (willLive(world[r][c], countNeighbors(r, c))) {
                    world[r][c] = Cell.ALIVE;
                } else {
                    world[r][c] = Cell.DEAD;
                }
            }
        }
        return world;
    }

    int countNeighbors (int i, int j) {
        int nAlive = 0;
        for (int m = -1; m < 2; m++) {
            for (int n = -1; n < 2; n++) {
                if (isValidLocation(world.length, i+m, j+n)) {
                    if (world[i+m][j+n] == Cell.ALIVE) {
                        nAlive++;
                    }
                }
            }
        }
        return nAlive;
    }

    boolean willLive (Cell cell, int nAlive) {
        if (cell == Cell.DEAD) {
            if (nAlive == 3) {
                return true;
            }
        } else {
            if (3 == nAlive || nAlive == 4) {
                return true;
            }
        }
        return false;
    }


    boolean isValidLocation(int size, int row, int col) {
        return 0 <= row && row < size && 0 <= col && col < size;
    }

    // ---- Utilities ------------
    Cell[][] toMatrix(Cell[] arr) {
        int size = (int) round(sqrt(arr.length));
        Cell[][] matrix = new Cell[size][size];
        for (int i = 0; i < arr.length; i++) {
            matrix[i / size][i % size] = arr[i];
        }
        return matrix;
    }

    void shuffle(Cell[] arr) {
        for (int i = arr.length; i > 1; i--) {
            int j = rand.nextInt(i);
            Cell tmp = arr[j];
            arr[j] = arr[i - 1];
            arr[i - 1] = tmp;
        }
    }

    // ---------- Testing -----------------
    // Here you run your tests i.e. call your logic methods
    // to see that they really work
    void test() {
        // Hard coded test world
        Cell[][] testWorld = {
                {Cell.ALIVE, Cell.ALIVE, Cell.DEAD},
                {Cell.ALIVE, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.ALIVE},

        };
        int size = testWorld.length;

        out.println(isValidLocation(size, 0, 0));  // All should be true
        out.println(!isValidLocation(size, 0, 3));


        exit(0);
    }

    // -------- Below is JavaFX stuff, nothing to do --------------

    void render() {
        gc.clearRect(0, 0, width, height);
        int size = world.length;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int x = 3 * col + 50;
                int y = 3 * row + 50;
                renderCell(x, y, world[row][col]);
            }
        }
    }

    void renderCell(int x, int y, Cell cell) {
        if (cell == Cell.ALIVE) {
            gc.setFill(Color.RED);
        } else {
            gc.setFill(Color.WHITE);
        }
        gc.fillOval(x, y, 3, 3);
    }

    final int width = 800;   // Size of window
    final int height = 800;

    GraphicsContext gc;

    // Must have public before more later.
    @Override
    public void start(Stage primaryStage) throws Exception {

        // JavaFX stuff
        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        root.getChildren().addAll(canvas);
        gc = canvas.getGraphicsContext2D();

        // Create a timer
        AnimationTimer timer = new AnimationTimer() {

            long timeLastUpdate;

            // This method called by FX at a certain rate, parameter is the current time
            public void handle(long now) {
                if (now - timeLastUpdate > 300) {
                    update();
                    render();
                    timeLastUpdate = now;
                }
            }
        };
        // Create a scene and connect to the stage
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game of Life");
        primaryStage.show();
        timer.start();  // Start simulation
    }

    public static void main(String[] args) {
        launch(args);   // Launch JavaFX
    }
}
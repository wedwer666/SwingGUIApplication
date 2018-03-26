import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 840, HEIGHT = (WIDTH / 12) * 9;

    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private Random r;
    private Life_design life_design;
    private Menu menu;
    public enum STATE {
        Menu,
        Game,
        Game2,
        Game3,
        Info_class
    };
    public STATE gameState = STATE.Menu;

    public Game() {
        handler = new Handler();
        menu = new Menu(this, handler);
        this.addMouseListener(menu);
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "Primul joc in java!", this);
        life_design = new Life_design();
        r = new Random();
        // ADAUG FUNCTIONALITATEA DE MENU
        if (gameState == STATE.Game) {
            handler.addObject(new Player(WIDTH / 2 - 32, (HEIGHT / 2) - 32, All_players.Player, handler));
            for (int i = 0; i < 5; i++) {
                handler.addObject(new Enemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), All_players.Enemy, handler));
                handler.addObject(new Second_enemy(r .nextInt(WIDTH), r.nextInt(HEIGHT), All_players.Second_enemy, handler));
                handler.addObject(new Static_Enemy(100, 100, All_players.Static_enemy, handler));
            }
        }
    }
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();

        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();

            running = false;
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();

        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        double time = 0;

        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();

            delta += (now - lastTime) / ns;
            time += (now - lastTime);
            lastTime = now;

            while (delta >= 1) {
                tick();
                delta--;
            }

            if (running) {
                render();
            }

            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("Elaspsed time: " + time);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
        if (gameState == STATE.Game) {
            handler.tick();
            life_design.tick();
        }
        else if (gameState == STATE.Menu ){
         menu.tick();
        }

    }

    private void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();

        if (bufferStrategy == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.orange);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        handler.render(graphics);
        if (gameState == STATE.Game) {
            life_design.render(graphics);
        }
        else if (gameState == STATE.Menu || gameState == STATE.Game2 ){
            menu.render(graphics);
        }
        else if (gameState == STATE.Info_class)
        {
            menu.render(graphics);
        }
        graphics.dispose();
        bufferStrategy.show();

    }

    public static int border_game(int tmp, int min, int max)
    {
        if(tmp >= max)
            return tmp = max;
        else if(tmp <= min)
            return tmp = min;
        else
            return tmp;
    }
    public static void main(String args[]) {
        Game game = new Game();
        Obiect ob = new Obiect() {
            @Override
            public void tick() {
            }
            @Override
            public void render(Graphics g) {

            }
            public Rectangle coliziune()
            {
                return new Rectangle(x,y,32,32);
            }
        };
        ob.setCorY(32);
    }
}
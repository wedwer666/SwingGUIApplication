import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {
    private Game game;
    private Handler handler;
    private Random r;
    public static final int WIDTH = 840, HEIGHT = (WIDTH / 12) * 9;

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        r = new Random();
        //actiunea cind utilizatorul apasa pe butonul de Nivel Easy
        if (mouse_over(mx, my, 250, 100, 300, 64))
        {
            game.gameState = Game.STATE.Game;
            handler.addObject(new Player(WIDTH / 2 - 32, (HEIGHT / 2) - 32, All_players.Player, handler));
            for (int i = 0; i < 5; i++) {
                handler.addObject(new Enemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), All_players.Enemy, handler));
                handler.addObject(new Second_enemy(r .nextInt(WIDTH), r.nextInt(HEIGHT), All_players.Second_enemy, handler));
            }
        }
        //actiunea cind se apasa pe nivel Mediu
        if ( mouse_over(mx, my, 250, 170, 300, 64))
        {
            game.gameState = Game.STATE.Game;
            handler.addObject(new Player_middle_level(WIDTH  - 32, HEIGHT  - 32, All_players.Player, handler));
            for (int i = 0; i < 5; i++) {
                handler.addObject(new Enemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), All_players.Enemy, handler));
                handler.addObject(new Second_enemy(r .nextInt(WIDTH), r.nextInt(HEIGHT), All_players.Second_enemy, handler));
            }
        }
        //actiunea cind se apasa pe nivel Difficult
        if ( mouse_over(mx, my, 250, 240, 300, 64))
        {
            game.gameState = Game.STATE.Game;
            handler.addObject(new Player_advanced_level(WIDTH  - 32, HEIGHT  - 32, All_players.Player, handler));
//            for (int i = 0; i < 0; i++) {
                handler.addObject(new Enemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), All_players.Enemy, handler));
//            }
        }
        //actiunea cind jucatorul apasa pe nivelul master
        if ( mouse_over(mx, my,250, 310, 340, 64)) {
            game.gameState = Game.STATE.Game;
            for (int i = 0; i < 3; i++) {
                handler.addObject(new Player(WIDTH - 32, HEIGHT - 32, All_players.Player, handler));
                handler.addObject(new Static_Enemy(100, 100, All_players.Static_enemy, handler));
                handler.addObject(new Static_Enemy(150, 100, All_players.Static_enemy, handler));
                handler.addObject(new Static_Enemy(200, 100, All_players.Static_enemy, handler));
                handler.addObject(new Static_Enemy(250, 100, All_players.Static_enemy, handler));
                handler.addObject(new Static_Enemy(300, 100, All_players.Static_enemy, handler));
                handler.addObject(new Static_Enemy(300, 150, All_players.Static_enemy, handler));
                handler.addObject(new Static_Enemy(300, 200, All_players.Static_enemy, handler));
            }
        }
        //actiunea cind jucatorul apasa pe nivelul informatie despre joc
        if ( mouse_over(mx, my, 250, 380, 340, 64))
        {
            game.gameState = Game.STATE.Info_class;
        }
        if (mouse_over(mx, my, 300, 450, 250, 54))
        {
            game.gameState = Game.STATE.Menu;
        }
        //actiunea cind utilizatorul apasa pe butonul return
        if (mouse_over(mx, my, 720, 10, 100, 30))
        {
            game.gameState = Game.STATE.Menu;
        }

    }
    //constructor pentru joc
    public Menu(Game game, Handler handler)
    {
        this.game = game;
        this.handler =  handler;
    }
    public void mouse_eliberat(MouseEvent e)
    {

    }
    //functie care verifica daca in general mouse-ul este apasat
    private boolean mouse_over(int mx, int my, int x, int y, int width, int height)
    {
        if ( mx > x && mx < x + width) {
            if (my > y && my < y + height){
                return true;
            } else return false;
        }else return false;
    }
    public void tick(){

    }
    public void render(Graphics g) {
        if (game.gameState == Game.STATE.Menu) {
            Font tmp = new Font("Times New Roman", 3, 36);
            Font tmp2 = new Font("Times New Roman", 1, 30);
            g.setFont(tmp);
            g.setColor(Color.white);
            g.drawString("Meniu", 370, 50);

            g.drawRect(250, 100, 340, 64);
            g.setColor(Color.red);
            g.fillRect(250, 100, 340, 64);
            g.setColor(Color.white);
            g.drawString("Nivel Easy", 340, 140);

            g.drawRect(250, 170, 340, 64);
            g.setColor(Color.red);
            g.fillRect(250, 170, 340, 64);
            g.setColor(Color.white);
            g.drawString("Nivel Mediu", 330, 210);

            g.drawRect(250, 240, 340, 64);
            g.setColor(Color.red);
            g.fillRect(250, 240, 340, 64);
            g.setColor(Color.white);
            g.drawString("Nivel Avansat", 320, 280);

            g.drawRect(250, 310, 340, 64);
            g.setColor(Color.red);
            g.fillRect(250, 310, 340, 64);
            g.setColor(Color.white);
            g.drawString("Nivel MASTER", 310, 350);

            g.drawRect(250, 380, 340, 64);
            g.setColor(Color.red);
            g.fillRect(250, 380, 340, 64);
            g.setColor(Color.white);
            g.drawString("Informatie JOC", 310, 420);

            //chenar pentru toate
            g.setColor(Color.white);
            g.drawRect(240, 90, 360, 365);

        }
        else if (game.gameState == Game.STATE.Game2)
        {
            Font tmp = new Font("Times New Roman", 1, 30);
            Font tmp2 = new Font("Times New Roman", 1, 30);
            g.setFont(tmp);
            g.setColor(Color.white);
            g.drawString("Nivel Mediu", 340, 20);


        }
        else if (game.gameState == Game.STATE.Game3)
        {
            Font tmp = new Font("Times New Roman", 1, 30);
            Font tmp2 = new Font("Times New Roman", 1, 30);
            g.setFont(tmp);
            g.setColor(Color.white);
            g.drawString("Nivel Avansat", 340, 20);

        }
        else if (game.gameState == Game.STATE.Info_class)
        {
            Font tmp = new Font("Times New Roman", 3, 36);
            g.setFont(tmp);
            g.setColor(Color.white);
            g.drawString("Informatie despre joc:", 250, 50);
            Font tmp2 = new Font("Times New Roman", 3, 30);
            g.setFont(tmp2);
            g.drawString("Scopul jocului: De a cistiga numarul maxim de baluri", 100, 80);
            g.drawString("fara a pierde viata jucatorului", 100, 110);
            g.drawString("Nivel Easy - in acest nivel jucatorul este de nivel", 100, 140);
            g.drawString("standart cu un singur inamic.", 100, 170 );
            g.drawString("Nivel Mediu - in acest nivel jucatorul este de 2 ori ", 100, 200);
            g.drawString("mai mare decit inamicul.",100,230);
            g.drawString("Nivel Avansat - in acest nivel jucatorul este de 2 ori ", 100, 260);
            g.drawString("mai mare decit inamicul si odata la coliziunea lor", 100, 290 );
            g.drawString("numarul inamicilor devine de 4 ori mai mare", 100,320);
            g.drawString("Nivel MASTER - in acest nivel jucatorul are n numar ", 100, 350);
            g.drawString(" de inamici dinamici in forma de masiv", 100, 380);
            g.drawString("Informatie JOC - in aceasta sectiune se explica", 100, 410);
            g.drawString("caracaterisitca fiecarui nivel", 100, 440);

            g.drawRect(320, 450, 220, 54);
            g.setColor(Color.gray);
            g.fillRect(320, 450, 220, 54);
            g.setColor(Color.white);
            g.drawString("Return", 380, 480);
        }
    }
}

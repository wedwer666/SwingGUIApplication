import java.util.Random;

/**
 * Created by Maria on 26.03.2018.
 */
public class Nivele {
    private Handler handler;
    private Life_design life_design;
    private Random r;
    private int scor = 0;

    public Nivele(Handler handler,Life_design life_design)
    {
        this.handler = handler;
        this.life_design = life_design;
        r = new Random();
    }
    public void tick()
    {
        scor++;

        // nivel nou setat
        if(scor >= 400){
            scor = 0;
            life_design.set_nivel(life_design.get_nivel() + 1);
            handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), All_players.Enemy, handler));
        }

        if(life_design.get_nivel() == 2){
            handler.clearEnemys();
            handler.addObject(new Enemy((Game.WIDTH / 2) - 48, -99, All_players.Enemy, handler));
        }
    }
}

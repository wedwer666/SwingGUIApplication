import java.awt.*;

/**
 * Created by Maria on 17.03.2018.
 */
public class Static_Enemy extends Obiect {
    public Static_Enemy(int x, int y, All_players all_players, Handler handler) {
        super(x,y,all_players);
        corX = 5;
        corY = 5;
    }

    @Override
    public Rectangle coliziune() {
        return new Rectangle(x,y,50,50);

    }

    @Override
    public void tick() {
        x += corX;
        y += corY;

        if(y <= 0 || y >= Game.HEIGHT - 50)
            corY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 50)
            corX *= -1;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x,y, 50, 50);
    }
}

import java.awt.*;

public class Second_enemy extends Obiect {

    public Second_enemy(int x, int y, All_players all_players, Handler handler)
    {
        super(x,y,all_players);
        corX = 5;
        corY = 5;
    }

    public Rectangle coliziune()
    {
        return new Rectangle(x,y,16,16);
    }
    @Override
    public void tick() {
        x += corX;
        y += corY;

        if(y <= 0 || y >= Game.HEIGHT - 32)
            corY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 16)
            corX *= -1;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x,y, 16, 16);
        g.drawRect(x - 5, y - 5,26,26);
        g.drawRect(x - 10, y - 10,36,36);
    }
}

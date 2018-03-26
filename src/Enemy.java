import java.awt.*;

public class Enemy extends Obiect {
    public Enemy(int x, int y, All_players all_players, Handler handler)
    {
        super(x,y,all_players);
        corX = 2;
        corY = 2;
    }
    public Rectangle coliziune()
    {
        return new Rectangle(x,y,16,16);
    }
    //polimorfism
    @Override
    public void tick()
    {
        x += corX;
        y += corY;

        if(y <= 0 || y >= Game.HEIGHT - 32)
            corY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 16)
            corX *= -1;
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(x,y, 16, 16);
        g.drawRect(x - 5, y - 5,26,26);
        g.drawRect(x - 10, y - 10,36,36);
    }
}

import java.awt.*;

public abstract class Obiect {
    protected int x, y;
    protected All_players all_players;
    protected int corX, corY;

    public Obiect(int x, int y, All_players all_players)
    {
        this.x = x;
        this.y = y;
        this.all_players = all_players;
    }

    public Obiect() {
    }

    //metoda creata pentru a asigura ca sa nu fie coliziune intre obiecte
    public abstract Rectangle coliziune();
    public abstract void tick();
    public abstract void render(Graphics g);

    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public int getX()
    {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setId(){
        this.all_players = all_players;
    }
    public All_players getId()
    { return all_players;}
    public void setCorX(int corX){
        this.corX = corX;
    }
    public void setCorY(int corY){
        this.corY = corY;
    }
    public void getCorX(int corX){
        this.corX = corX;
    }
    public void getCorY(int corY){
        this.corY = corY;
    }

}

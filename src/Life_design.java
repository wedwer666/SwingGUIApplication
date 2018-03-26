import java.awt.*;

public class Life_design {
    public static int LIFE = 100;
    private int valoarea_blue = 255;
    private int timpul = 0;
    private int nivel = 1;
    //        public static int CUR_COL = 100;
    public static int MAX_COL = 55;
    private int score = 0;

    public void set_score(int newValue)
    {
        score = newValue;
    }
    //    public void set_cur_col(int newValuecur)
//    {
//        CUR_COL = newValuecur;
//    }
    public void set_nivel(int newValue)
    {
        nivel = newValue;
    }
    public int get_score() {
        return timpul;
    }
    public int get_nivel() {
        return nivel;
    }
//    public int get_cur_col() { return CUR_COL;}

    public void tick() {
        LIFE = Game.border_game(LIFE, 0, 100);
//        score++;
//        CUR_COL++;
    }
    public void render(Graphics graphics) {
        graphics.setColor(Color.gray);
        graphics.fillRect(10, 470, 200, 32);
        graphics.setColor(new Color(75, valoarea_blue, 0));
        graphics.fillRect(10, 470, LIFE * 2, 32);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(10, 470, 200, 32);
//        graphics.drawString("Nivelul = " + nivel, 10, 520);
        graphics.drawString("Scorul = " + score, 10, 520);
//        graphics.drawString("Nr de coliziuni curente =" + CUR_COL , 10, 540);
        graphics.drawString("Nr de coliziuni maxime = " + MAX_COL, 10, 560);

        graphics.drawRect(720, 10, 100, 30);
        graphics.setColor(Color.gray);
        graphics.fillRect(720, 10, 100, 30);
        graphics.setColor(Color.white);
        graphics.drawString("Return", 750, 30);

    }
}



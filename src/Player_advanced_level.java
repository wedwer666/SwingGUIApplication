import java.awt.*;
import java.util.Random;

public class Player_advanced_level extends Obiect{
    Random r = new Random();
    Handler handler;
    public static final int WIDTH = 840, HEIGHT = (WIDTH / 12) * 9;
    public static int CUR_COL3 = 0;
    public static int MAX_COL = 55;

    public Player_advanced_level(int x, int y, All_players all_players,Handler handler)
    {
        super(x,y,all_players);
        this.handler = handler;
//        corX = 1;
//        corX = r.nextInt(5) * 1;
//        corY = r.nextInt(5);
    }
    public Rectangle coliziune()
    {
        return new Rectangle(x,y,32,32);
    }
    //polimorfism de mostenire
    @Override
    public void tick()
    {
        x += corX;
        y += corY;
        x = Game.border_game(x,0, WIDTH - 37);
        y = Game.border_game(y,0, HEIGHT - 60);
        col();
    }

    public Enemy col()
    {
        //INAMIC PRINCIPAL ACUM ESTE tmpObiect
        for(int i = 0; i< handler.object.size(); i++)
        {
            Obiect tmpObiect = handler.object.get(i);
            if (tmpObiect.getId() == All_players.Enemy)
            {
                if(coliziune().intersects(tmpObiect.coliziune()))
                {
                    //codul pentru a multiplica un obiect in 4 mai multe de aceasi marime
                     handler.addObject(new Enemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), All_players.Enemy, handler));
                    Life_design.LIFE -=2;
                    CUR_COL3++;
                    if ( CUR_COL3 == MAX_COL) {
//                        // pop up ca jocul a fost finisat
//                        Object[] options = {"Continue","Exit"};
//                        int response = JOptionPane.showOptionDialog(
//                                null,
//                                "You lost the game with score 55 points!", "You lost!",
//                                JOptionPane.YES_NO_CANCEL_OPTION,
//                                JOptionPane.DEFAULT_OPTION,
//                                null,
//                                options, options[1]);
//                        if(response == 0){
//                            System.exit(1);
//                        }else if(response == 1){
//                            System.exit(1);
//                        }else{
//                            System.out.println("Nu a fost aleasa optiunea");
//                        }
                    }
                }
            }
        }
        return null;
    }
    @Override
    public void render(Graphics g)
    {

        g.setColor(Color.black);
        g.fillRect(x, y, 32, 32);
        g.drawRect(x - 5, y - 5,42,42);
        g.drawRect(x - 10, y - 10,52,52);
        g.drawString("Nr de coliziuni curente =" + CUR_COL3 , 10, 540);


    }
}

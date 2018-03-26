import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    public KeyInput(Handler handler)
    {
        this.handler = handler;
    }
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
//        System.out.println(key);
        // loop pentru a parcurge prin toate obiectele din joc
        for (int i = 0; i < handler.object.size(); i++)
        {
            Obiect tmpObiect = handler.object.get(i);

            if(tmpObiect.getId() == All_players.Player)
            {
                //specificam actiunile pentru fiecare jucator in parte - jucatorul numarul 1
                if(key == KeyEvent.VK_W)
                    tmpObiect.setCorY(-5);
                if(key == KeyEvent.VK_S)
                    tmpObiect.setCorY(5);
                if(key == KeyEvent.VK_D)
                    tmpObiect.setCorX(5);
                if(key == KeyEvent.VK_A)
                    tmpObiect.setCorX(-5);
            }
        }
    }
    //specificam actiunile atunci cind cheia a fost eliberata
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++)
        {
            Obiect tmpObiect = handler.object.get(i);

            if(tmpObiect.getId() == All_players.Player)
            {
                //specificam actiunile pentru fiecare jucator in parte - jucatorul numarul 1
                if(key == KeyEvent.VK_W)
                    tmpObiect.setCorY(0);
                if(key == KeyEvent.VK_S)
                    tmpObiect.setCorY(0);
                if(key == KeyEvent.VK_D)
                    tmpObiect.setCorX(0);
                if(key == KeyEvent.VK_A)
                    tmpObiect.setCorX(0);
            }
        }
    }

}

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<Obiect> object = new LinkedList<Obiect>();
    //polimorfism de mostenire
    public void tick(){
        for(int i=0; i<object.size(); i++){
            Obiect tempObject = object.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for(int i=0; i<object.size(); i++){
            Obiect tempObject = object.get(i);
            tempObject.render(g);
        }
    }
    public void addObject(Obiect object){
        this.object.add(object);
    }

    public void removeObject(Obiect object){
        this.object.remove(object);
    }

    public void clearEnemys() {
        for(int i=0; i<object.size(); i++){
            Obiect tempObject = object.get(i);
            if(tempObject.getId() == All_players.Player)
            {
                object.clear();
                if (Game.gameState != Game.STATE.END ) {
                    // in cazul in care am nevoie de un nou jucator
                    addObject( new Player((int)tempObject.getX(), (int)tempObject.getY(), All_players.Player, this));
                    addObject( new Enemy((int)tempObject.getX(), (int)tempObject.getY(), All_players.Enemy, this));

                }
            }
        }
    }
}

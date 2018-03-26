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
//            if(tempObject.getId() != All_players.Player && tempObject.getId() != All_players.EnemyBoss){
//                removeObject(tempObject);
//            }
        }
    }
}

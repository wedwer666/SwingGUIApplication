/**
 * Created by Maria on 19.03.2018.
 */
public class WorstPlayer implements New_player, player_good, bad_player {
    String name;
    String surname;

    @Override
    public void setname(String name) {
        this.name = name;
    }
    @Override
    public void setsurname(String surname) {
        this.surname = surname;
    }
    @Override
    public void move() {
        System.out.println("Worst player started to move ");
    }
    @Override
    public void stopped() {
        System.out.println("Worst player stopped");
    }
    @Override
    public String toString(){
        return "Worst Player: Good and bad players - Name: " + name + " Surname: " + surname;
    }
}

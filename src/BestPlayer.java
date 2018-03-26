/**
 * Created by Maria on 19.03.2018.
 */
public class BestPlayer implements New_player, player_good {
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
        System.out.println("Best player started to move");
    }
    @Override
    public String toString()
    {
        return "Best_players: Best_players that moves - Name: " + name + " Surname: " + surname;
    }
}

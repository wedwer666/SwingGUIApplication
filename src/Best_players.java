/**
 * Created by Maria on 19.03.2018.
 */
public class Best_players implements New_player {
    String name;
    String surname;

    @Override
    public void setname(String name){
        this.name = name;
    }
    @Override
    public void setsurname(String surname)
    {
        this.surname = surname;
    }
    @Override
    public String toString()
    {
        return "Best_players: Best_players - Name: " + name + " Surname: " + surname;
    }
}

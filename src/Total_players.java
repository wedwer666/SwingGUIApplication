/**
 * https://springframework.guru/principles-of-object-oriented-design/interface-segregation-principle/
 * http://www.aut.upt.ro/staff/diercan/data/PSSC/curs-03.pdf
 * Created by Maria on 19.03.2018.
 * Interface segregation principle
 */
public class Total_players {
    public static Best_players createBest_Player()
    {
        Best_players best_players = new Best_players();
        best_players.setname("Maria");
        best_players.setsurname("Mitriuc");
        return best_players;
    }
    public static WorstPlayer createWorstPlayer()
    {
        WorstPlayer worstPlayer = new WorstPlayer();
        worstPlayer.setname("Mirzin");
        worstPlayer.setsurname("Ivan");
        return worstPlayer;
    }
    public static BestPlayer createBestPlayer()
    {
        BestPlayer bestPlayer = new BestPlayer();
        bestPlayer.setname("Ernest");
        bestPlayer.setsurname("Clinet");
        return bestPlayer;
    }
    public static void main(String[] args)
    {
        System.out.println(createBest_Player());
        System.out.println(createWorstPlayer());
        System.out.println(createBestPlayer());
    }
}

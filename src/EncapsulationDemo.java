public class EncapsulationDemo {
    public static void main(String[] args) {
        Life_design tmp = new Life_design();
        tmp.set_score(1000);
        tmp.set_nivel(1);
        System.out.println("Scorul este:" +  tmp.get_score());
        System.out.println("Nivelul este:" + tmp.get_nivel());
    }
}

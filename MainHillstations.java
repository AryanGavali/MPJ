public class MainHillstations 
{

    public static void main(String[] args) 
    {
        Hillstations station;

        System.out.println("---- Manali ----");
        station = new Manali();
        station.famousfor();
        station.famousfood();

        System.out.println();

        System.out.println("---- Ooty ----");
        station = new Ooty();
        station.famousfor();
        station.famousfood();

        System.out.println();

        System.out.println("---- Munnar ----");
        station = new Munnar();
        station.famousfor();
        station.famousfood();
    }
}
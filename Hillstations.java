class Hillstations 
{

    void famousfor() 
    {
        System.out.println("Hill stations are known for natural beauty and cool climate.");
    }

    void famousfood() 
    {
        System.out.println("Hill stations offer traditional regional food.");
    }
}


class Manali extends Hillstations 
{

    @Override
    void famousfor() 
    {
        System.out.println("Manali is famous for snowfall and adventure sports.");
    }

    @Override
    void famousfood() 
    {
        System.out.println("Manali is popular for Siddu and Trout fish.");
    }
}


class Ooty extends Hillstations 
{

    @Override
    void famousfor() 
    {
        System.out.println("Ooty is famous for tea plantations and scenic views.");
    }

    @Override
    void famousfood() 
    {
        System.out.println("Ooty is famous for homemade chocolates.");
    }
}


class Munnar extends Hillstations 
{

    @Override
    void famousfor() 
    {
        System.out.println("Munnar is famous for green hills and tea gardens.");
    }

    @Override
    void famousfood() 
    {
        System.out.println("Munnar is known for authentic Kerala cuisine.");
    }
}
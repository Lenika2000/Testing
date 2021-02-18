package domainModel;

import java.util.ArrayList;

public class Environment {
    private Ford ford = new Ford();
    private Artur artur = new Artur();
    private ArrayList<Thing> things = new ArrayList<Thing>();
    private boolean hasSimpleThing = false;

    public Environment() {
        setThings();
        ford.hasBottleHold();
        artur.getWatchAction();
        if (!hasSimpleThing) {
            artur.getWish();
            getThings();
            ford.getBirthPlace();
            ford.getOffer();
            getSimpleThing();
        }
    }

    public void setThings() {
        Thing underWears = new Thing("нижним бельем ", "дентрасси");
        Thing mattresses = new Thing("матрацами ", " скворншельскими ");
        things.add(underWears);
        things.add(mattresses);
    }

    public void getThings() {
        System.out.println(things.get(0).getName() + things.get(0).getOwner() +
                "," + things.get(1).getOwner() + things.get(1).getName());
    }

    public void getSimpleThing() {
        System.out.print(" он увидел, к примеру, пакет кукурузных хлопьев");
    }
}

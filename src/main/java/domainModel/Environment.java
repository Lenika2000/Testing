package domainModel;

import java.util.ArrayList;

public class Environment {
    private Ford ford;
    private Artur artur;
    private ArrayList<Thing> things = new ArrayList<Thing>();
    private boolean isEmpty = true;
    private boolean hasSimpleThing = false;

    public Environment() {
        initEnvironment();
    }

    public Ford getFord() {
        return ford;
    }

    public Artur getArtur() {
        return artur;
    }

    public boolean isHasSimpleThing() {
        return hasSimpleThing;
    }

    public void initEnvironment() {
        if (isEmpty) {
            ford = new Ford();
            artur = new Artur();
            setThings();
            isEmpty = false;
        }
        ford.hasBottleHold();
        artur.getWatchAction();
        hasSimpleThing();
    }

    private void hasSimpleThing() {
        if (!hasSimpleThing) {
            artur.setConfident(false);
            getThings();
            ford.getBirthPlace();
            ford.getOffer();
            getSimpleThing();
        }
    }

    private void setThings() {
        Thing underWears = new Thing("нижним бельем ", "дентрасси");
        Thing mattresses = new Thing("матрацами ", " скворншельскими ");
        things.add(underWears);
        things.add(mattresses);
    }

    private void getThings() {
        System.out.println(things.get(0).getName() + things.get(0).getOwner() +
                "," + things.get(1).getOwner() + things.get(1).getName());
    }

    private void getSimpleThing() {
        System.out.print(" он увидел, к примеру, пакет кукурузных хлопьев");
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public int getThingsQuantity() {
        return things.size();
    }
}

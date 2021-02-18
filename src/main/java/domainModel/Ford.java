package domainModel;

public class Ford {
    private Birthplace birthplace = Birthplace.BETELGEUSE;
    private Fish fish;
    // держит ли флакон с рыбкой
    private boolean hasHold = false;

    public void hasBottleHold() throws IllegalStateException {
        if (!hasHold) {
            takeBottle();
        } else {
            throw new IllegalStateException();
        }
    }

    private void takeBottle() {
        System.out.println("У Форда в руке был стеклянный флакончик, в котором ");
        hasHold = true;
        fish = new Fish("маленькая желтая");
        fish.swim();
    }

    public void getBirthPlace() {
        System.out.print("и человеком с " + Birthplace.getRussianVersionBirthplaces(birthplace) + "," );
    }

    public void getOffer() throws IllegalStateException{
        if (hasHold) {
            System.out.print(", держащим маленькую рыбку и предлагающим засунуть ее в ухо");
        } else {
            throw new IllegalStateException();
        }
    }

    public boolean hasHold() {
        return hasHold;
    }
}

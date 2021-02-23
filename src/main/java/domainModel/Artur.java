package domainModel;

public class Artur {

    private Birthplace birthplace = Birthplace.EARTH;
    // чувствует ли Артур себя уверенно
    private boolean isConfident = true;

    public boolean isConfident() {
        return isConfident;
    }

    public void setConfident(boolean confident) {
        isConfident = confident;
        if (!isConfident) {
            getWish();
        }
    }

    public void doWatchAction(){
        System.out.println(" Артур смотрел на него, моргая глазами.");
    }

    private void getWish(){
        System.out.println("Ему хотелось, чтобы здесь было что-нибудь простое и знакомое," +
                "\nза что можно было бы мысленно зацепиться. Он чувствовал бы себя увереннее, если бы рядом с");
    }

    public Birthplace getBirthplace() {
        return birthplace;
    }
}

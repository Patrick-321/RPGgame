package RPG;

public interface Gear {

    Gear combine(Gear gear);

    Type getType();

    int getAttack();

    int getDefense();

    String getName();

    String getAdjective();

    String getNoun();

}

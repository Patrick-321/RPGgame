package RPG;

public abstract class GearParent implements Gear, Comparable<GearParent> {
    final private String Adjective;
    final private String Noun;
    final private String Name;
    private final Type type;
    private final int attack;
    private final int defense;

    public GearParent(String adjective, String noun, Type type, int attack, int defense) {
        this.Adjective = adjective;
        this.Noun = noun;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
        this.Name = this.Adjective + ", " + this.Noun;
    }



    @Override
    public int compareTo(GearParent c) {
        if (attack != c.getAttack()) {
            return attack - c.getAttack();
        } else {
            return defense - c.getDefense();
        }
    }


    public String getAdjective() {
        return Adjective;
    }

    public String getNoun() {
        return Noun;
    }

//    public void setAttack(int attack) {
//        this.attack = attack;
//    }
//
//    public void setDefense(int defense) {
//        this.defense = defense;
//    }

    public String getName() {
        return this.Name;
    }

    public Type getType() {
        return type;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }


    @Override
    public Gear combine(Gear other) {
        if(this.getType() != other.getType()){
            throw new IllegalArgumentException("Can not combine different type of gears");
        }
        String Noun = this.getNoun();
        String Adj = other.getAdjective() + ", " + this.getAdjective();
        int Attack = this.getAttack() + other.getAttack();
        int Defense = this.getDefense() + other.getDefense();
        return null;
    } // will be overridden in chile classes

    @Override
    public String toString() {
        return getName() + ": attack " + attack + ", defense " + defense;
    }
}

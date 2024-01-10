package RPG;

public class HeadGear extends GearParent {
    public HeadGear(String adjective, String noun, int defense) {
        super(adjective, noun, Type.HeadGear, 0, defense);
    }

    @Override
    public HeadGear combine(Gear gear) {
        if (! this.getType().equals(gear.getType())) {
            throw new IllegalArgumentException("Wrong type to combine HeadGear");
        }
        int NewDefense;
        // value changes
        //NewAttack = super.getAttack() + gear.getAttack();
        NewDefense = super.getDefense() + gear.getDefense();
        // name changes
        // String adjective = gear.getName().split(" ")[0];
        String NewAdj = gear.getAdjective();
        String NewNoun = this.getAdjective() + " " + this.getNoun();
        return new HeadGear(NewAdj, NewNoun, NewDefense); // error yet
    }
}

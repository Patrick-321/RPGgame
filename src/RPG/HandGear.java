package RPG;

public class HandGear extends GearParent {
    public HandGear(String adjective, String noun, int attack) {
        super(adjective, noun, Type.HandGear, attack, 0);
    }

    @Override
    public HandGear combine(Gear gear) {
        if (! this.getType().equals(gear.getType())) {
            throw new IllegalArgumentException("Wrong type to combine HandGear");
        }
        int NewAttack;
        // value changes
        NewAttack = super.getAttack() + gear.getAttack();
        //NewDefense = super.getDefense() + gear.getDefense();
        // name changes
        // String adjective = gear.getName().split(" ")[0];
        String NewAdj = gear.getAdjective();
        String NewNoun = this.getAdjective() + " " + this.getNoun();
        return new HandGear(NewAdj, NewNoun, NewAttack); // error yet
    }
}

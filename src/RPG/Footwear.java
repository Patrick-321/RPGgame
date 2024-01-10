package RPG;

public class Footwear extends GearParent {

    public Footwear(String adjective, String noun, int attack, int defense) {
        super(adjective, noun, Type.FootWear, attack, defense);
    }

    @Override
    public Footwear combine(Gear gear) {
        if (! this.getType().equals(gear.getType())) {
            throw new IllegalArgumentException("Wrong type to combine FootWear");
        }
        int NewAttack, NewDefense;
        // value changes
        NewAttack = super.getAttack() + gear.getAttack();
        NewDefense = super.getDefense() + gear.getDefense();
        // name changes
        // String adjective = gear.getName().split(" ")[0];
        String NewAdj = gear.getAdjective();
        String NewNoun = this.getAdjective() + " " + this.getNoun();
        return new Footwear(NewAdj, NewNoun, NewAttack, NewDefense); // error yet
    }
}

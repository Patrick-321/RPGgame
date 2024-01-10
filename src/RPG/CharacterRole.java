package RPG;

public interface CharacterRole  {

    public int getFinalAttack(); // calculated attack

    public int getFinalDefense(); // calculated defense

    public boolean hasSlot(Type type); // if still has slot

    public void putGear(GearParent gearParent); // wear the gear

    public void wearHead(GearParent gearParent); // wear HeadGear
    //private method in interface should have a body

    public void wearHand(GearParent gearParent); // wear HandGear

    public void wearFoot(GearParent gearParent); // wear Footwear

    public String showGears(); // show the gears worn on body

}

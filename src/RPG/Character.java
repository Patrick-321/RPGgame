package RPG;

import java.util.List;
import java.util.ArrayList;

public class Character implements CharacterRole{

    static final int FullFootWear = 2;
    static final int FullHandGear = 2;
    static final int FullHeadGear = 1;
    private final int baseAttack;
    private final int baseDefense;

    private final String PlayerName;

    private final List<GearParent> headGears = new ArrayList<>();
    private final List<GearParent> handGears = new ArrayList<>();
    private final List<GearParent> footwears = new ArrayList<>();

    public Character(int attack, int defense, String playerName) {
        this.baseAttack = attack;
        this.baseDefense = defense;
        PlayerName = playerName;
    }

    public int getFinalAttack() {
        int finalAT = baseAttack;
        for (GearParent gearParent : handGears) {
            finalAT += gearParent.getAttack();
        }
        for (GearParent gearParent : footwears) {
            finalAT += gearParent.getAttack();
        }
        for (GearParent gearParent : headGears) {
            finalAT += gearParent.getAttack();
        }
        return finalAT;
    }

    public int getFinalDefense() {
        int finalDF = baseDefense;
        for (GearParent gearParent : handGears) {
            finalDF += gearParent.getDefense();
        }
        for (GearParent gearParent : footwears) {
            finalDF += gearParent.getDefense();
        }
        for (GearParent gearParent : headGears) {
            finalDF += gearParent.getDefense();
        }
        return finalDF;
    }

    public boolean hasSlot(Type type) {
        switch (type) {
            case HeadGear:
                return headGears.size() < FullHeadGear;
            case HandGear:
                return handGears.size() < FullHandGear;
            default :
                return footwears.size() < FullFootWear;
        }
    }

    public void putGear(GearParent gearParent) {
        switch (gearParent.getType()) {
            case HeadGear:
                wearHead(gearParent);
                break;
            case HandGear:
                wearHand(gearParent);
                break;
            case FootWear:
                wearFoot(gearParent);
                break;
            default:
                throw new IllegalArgumentException("No such type exists");
        }
    }


    public void wearHead(GearParent gearParent) {
        if (headGears.size() < FullHeadGear) {
            headGears.add(gearParent);
        } else {
//            throw new IndexOutOfBoundsException("Gear is Full");
            //headGears.get(0).combine(gearParent);
            HeadGear newOne = (HeadGear) headGears.get(0).combine(gearParent);
            headGears.remove(0);
            headGears.add(0, newOne);
        }
    }

    public void wearHand(GearParent gearParent) {
        if (handGears.size() < FullHandGear) {
            handGears.add(gearParent);
        } else {
//            throw new IndexOutOfBoundsException("Gear is Full");
            //handGears.get(0).combine(gearParent);
            HandGear newOne = (HandGear) handGears.get(0).combine(gearParent);
            handGears.remove(0);
            handGears.add(0, newOne);
        }
    }

    public void wearFoot(GearParent gearParent) {
        if (footwears.size() < FullFootWear) {
            footwears.add(gearParent);
        } else {
//            throw new IndexOutOfBoundsException("Gear is Full");
            Footwear newOne = (Footwear) footwears.get(0).combine(gearParent); //why return Gear type by default?
            footwears.remove(0);
            footwears.add(0, newOne);
        }
    }

    public String showGears() {
        String head = "";
        for (GearParent gearParent : headGears) {
            head = head.concat(gearParent.getName());
        }
        String hand = "";
        for (GearParent gearParent : handGears) {
            hand = hand.concat(gearParent.getName() + "; ");
        }
        String foot = "";
        for (GearParent gearParent : footwears) {
            foot = foot.concat(gearParent.getName() + "; ");
        }

        String str = "head: " + head + "\nhand: " + hand + "\nfoot: " + foot;
        String strength = "\nattack: " + getFinalAttack() + ", defense: " + getFinalDefense();
        return str + strength;
    }

    public String showHead() {
        return headGears.get(0).getName();
    }

    public String showFoot() {
        return footwears.get(0).getName();
    }

    public String showHand() {
        return handGears.get(0).getName();
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public int getFoot(){
        return footwears.size();
    }

    public Type gettype() {
        return footwears.get(0).getType();
    }



}

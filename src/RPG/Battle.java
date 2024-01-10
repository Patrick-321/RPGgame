package RPG;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Battle {
    private final static int FIRST_PLAYER = 0;
    private final static int SECOND_PLAYER = 1;
    private final static int PLAYER_NUMBER = 2;

    static final int MAXItem = 10;

    private final Character[] characters = new Character[PLAYER_NUMBER];
    private List<GearParent> gearParentList = new ArrayList<>(MAXItem);

    private Character currentCha;

    public Battle(Character character1, Character character2, List<GearParent> list) {
        characters[FIRST_PLAYER] = character1;
        characters[SECOND_PLAYER] = character2;
        gearParentList.addAll(list); //add all items in the gear list
        gearParentList.sort((o1, o2) -> o2.compareTo(o1));

        battleStarts();
    }


    public String battleStarts() { // not void character
        int turns = gearParentList.size();

        for (int i = 0; i < turns; i++) {
            currentCha = characters[i % 2];
            currentCha.putGear(pickItem()); // distribute


            System.out.println("Turn " + (i + 1));
            System.out.println("Player " + (i % 2 + 1));
            System.out.println(currentCha.showGears() + "\n");
        }
        System.out.println("#################################################################");

        int attack1 = characters[FIRST_PLAYER].getFinalAttack();
        int attack2 = characters[SECOND_PLAYER].getFinalAttack();
        int defense1 = characters[FIRST_PLAYER].getFinalDefense();
        int defense2 = characters[SECOND_PLAYER].getFinalDefense();
        int damage1 = attack2 - defense1;
        int damage2 = attack1 - defense2;

        System.out.println("Player 1 has " + attack1 + " attack points and "
                + defense1 + " defense strength");
        System.out.println("Player 2 has " + attack2 + " attack points and "
                + defense2 + " defense strength");
        System.out.println("The battle ends with Player 1 having " + damage1
                + " units of damage and Player 2 having " + damage2 + " unit of damage.");

        if (damage1 == damage2 || (damage1 <= 0 && damage2 <= 0)) {
            return null;
        } else if (damage1 < damage2) {
            System.out.println(String.valueOf(FIRST_PLAYER));
            return String.valueOf(FIRST_PLAYER);

        } else {
            return String.valueOf(SECOND_PLAYER);
        }
    }

    private GearParent pickItem() { // distribute item
        int len = gearParentList.size();
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (currentCha.hasSlot(gearParentList.get(i).getType())) {
                idx = i;
                break;
            }
        }

        return gearParentList.remove(idx);
    }


    public String getWinner(String battleStarts) {
        if (Objects.equals(battleStarts, String.valueOf(FIRST_PLAYER))) {
            System.out.println("Player " + String.valueOf(FIRST_PLAYER)+1 + " wins");
            return ("Player " + String.valueOf(FIRST_PLAYER+1) + " wins");

        } else if (Objects.equals(battleStarts, String.valueOf(SECOND_PLAYER))) {
            System.out.println("Player " + String.valueOf(SECOND_PLAYER+1) + " wins");
            return ("Player " + String.valueOf(SECOND_PLAYER+1) + " wins");

        } else {
            System.out.println("There is a tie");
            return ("There is a tie");
        }
    }

}
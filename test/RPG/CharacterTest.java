package RPG;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class CharacterTest {
    static final int MAXItem = 10;

    @Test
    public void getFinalAttack() {
        List<GearParent> list = new ArrayList<>(MAXItem);
        GearParent head1 = new HeadGear("Happy", "Helmets", 1);
        GearParent head2 = new HeadGear("Scurrying", "Visors", 2);
        GearParent hand1 = new HandGear("Scurrying", "Sandals", 1);
        GearParent hand2 = new HandGear("Happy", "HoverBoard", 2);
        GearParent foot1 = new Footwear("Happy", "Sneakers", 3, 2);
        GearParent foot2 = new Footwear("Scurrying", "Hoverboard", 0, 3);
        list.add(head1);
        list.add(head2);
        list.add(hand1);
        list.add(hand2);
        list.add(foot1);
        list.add(foot2);
        list.add(new HeadGear("Silly", "Hats", 1));
        list.add(new HandGear("Lucky", "Gloves", 5));
        list.add(new Footwear("Lucky", "Sandals", 3, 0));
        list.add(new Footwear("Silly", "Boots", 0, 0));

        Character c1 = new Character(0, 0, "Klaus");
        Character c2 = new Character(0, 0, "Tylor");

        Battle d = new Battle(c1, c2, list);

        assertEquals(9, c1.getFinalAttack());
        assertEquals(5, c2.getFinalAttack());
    }

    @Test
    public void getFinalDefense() {

        List<GearParent> list = new ArrayList<>(MAXItem);
        GearParent head1 = new HeadGear("Happy", "Helmets", 1);
        GearParent head2 = new HeadGear("Scurrying", "Visors", 2);
        GearParent hand1 = new HandGear("Scurrying", "Sandals", 1);
        GearParent hand2 = new HandGear("Happy", "HoverBoard", 2);
        GearParent foot1 = new Footwear("Happy", "Sneakers", 3, 2);
        GearParent foot2 = new Footwear("Scurrying", "Hoverboard", 0, 3);
        list.add(head1);
        list.add(head2);
        list.add(hand1);
        list.add(hand2);
        list.add(foot1);
        list.add(foot2);
        list.add(new HeadGear("Silly", "Hats", 1));
        list.add(new HandGear("Lucky", "Gloves", 5));
        list.add(new Footwear("Lucky", "Sandals", 3, 0));
        list.add(new Footwear("Silly", "Boots", 0, 0));

        Character c1 = new Character(0, 0, "Klaus");
        Character c2 = new Character(0, 0, "Tylor");

        Battle d = new Battle(c1, c2, list);

        assertEquals(2, c1.getFinalDefense());
        assertEquals(7, c2.getFinalDefense());
    }

    @Test
    public void hasSlot() {
        List<GearParent> list = new ArrayList<>(MAXItem);
        GearParent head1 = new HeadGear("Happy", "Helmets", 1);
        GearParent head2 = new HeadGear("Scurrying", "Visors", 2);
        GearParent hand1 = new HandGear("Scurrying", "Sandals", 1);
        GearParent hand2 = new HandGear("Happy", "HoverBoard", 2);
        GearParent foot1 = new Footwear("Happy", "Sneakers", 3, 2);
        GearParent foot2 = new Footwear("Scurrying", "Hoverboard", 0, 3);
        list.add(head1);
        list.add(head2);
        list.add(hand1);
        list.add(hand2);
        list.add(foot1);
        list.add(foot2);
        list.add(new HeadGear("Silly", "Hats", 1));
        list.add(new HandGear("Lucky", "Gloves", 5));
        list.add(new Footwear("Lucky", "Sandals", 3, 0));
        list.add(new Footwear("Silly", "Boots", 0, 0));

        Character c1 = new Character(0, 0, "Klaus");
        Character c2 = new Character(0, 0, "Tylor");

        assertTrue(c1.hasSlot(Type.FootWear));
        assertTrue(c2.hasSlot(Type.HandGear));

        new Battle(c1, c2, list);

        System.out.println(c2.getFoot());
        System.out.println(c2.gettype());
        System.out.println(c2.hasSlot(Type.FootWear));
        assertFalse(c2.hasSlot(Type.FootWear));


    }


    @Test
    public void getPlayerNameTest() {
        Character c1 = new Character(0, 0, "Klaus");
        Character c2 = new Character(0, 0, "Tylor");

        assertEquals("Klaus", c1.getPlayerName());
        assertEquals("Tylor", c2.getPlayerName());
    }

    @Test
    public void putGearTest() {
        String[] strs = new String[2];

        GearParent c1 = new HandGear("Scurrying", "Sandals", 1);
        GearParent c2 = new HandGear("Happy", "HoverBoard", 2);

        Character player1 = new Character(0, 0, "Peter");
        player1.putGear(c1);
        player1.putGear(c2);

        System.out.println(player1.showGears());
        assertEquals("Scurrying, Sandals",player1.showHand());
    }

    @Test
    public void testCompareClothing()
    {
        List<GearParent> list = new ArrayList<>(MAXItem);
        GearParent head1 = new HeadGear("Happy", "Helmets", 1);
        GearParent head2 = new HeadGear("Scurrying", "Visors", 2);
        GearParent hand1 = new HandGear("Scurrying", "Sandals", 1);
        GearParent hand2 = new HandGear("Happy", "HoverBoard", 2);
        GearParent foot1 = new Footwear("Happy", "Sneakers", 3, 2);
        GearParent foot2 = new Footwear("Scurrying", "Hoverboard", 0, 3);
        list.add(head1);
        list.add(head2);
        list.add(hand1);
        list.add(hand2);
        list.add(foot1);
        list.add(foot2);
        list.add(new HeadGear("Silly", "Hats", 1));
        list.add(new HandGear("Lucky", "Gloves", 5));
        list.add(new Footwear("Lucky", "Sandals", 3, 0));
        list.add(new Footwear("Silly", "Boots", 0, 0));

        list.sort(Comparator.reverseOrder());
        for (GearParent c : list) {
            System.out.println(c);
        }
        System.out.println("\t");

    }


}
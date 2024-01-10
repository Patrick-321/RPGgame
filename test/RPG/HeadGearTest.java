package RPG;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HeadGearTest {
    static final int MAXItem = 10;

    @Test
    public void combine() {

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

        assertEquals("Scurrying, Visors", c1.showHead());
        assertEquals("Lucky, Gloves", c1.showHand());

        assertEquals("Silly, Happy Helmets", c2.showHead());
    }
}
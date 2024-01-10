package RPG;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class GearParentTest {
    static final int MAXItem = 10;

    @Test
    public void compareTo() {
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
    }


}
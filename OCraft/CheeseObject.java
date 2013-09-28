package OCraft; /**
 * Created with IntelliJ IDEA.
 * User: mlc
 * Date: 9/20/13
 * Time: 6:10 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.Random;
import net.minecraft.item.Item;

public class CheeseObject extends Item
{
    public CheeseObject(int i)
    {
        super(i);
        maxStackSize = 64;
    }

    public String Version()
    {
        return "1.5/1.5.1";
    }
}
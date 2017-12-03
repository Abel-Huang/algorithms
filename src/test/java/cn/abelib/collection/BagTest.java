package cn.abelib.collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * create by abel-huang on 2017/10/30
 */
<<<<<<< HEAD
// The unit test for Bag
=======
>>>>>>> 245eb44931ba0001767e05c615c1e630842b2ec3
public class BagTest {
    Bag bag = null;

    @Before
    public void init(){
        bag = new Bag();
        Assert.assertTrue(bag.isEmpty());
    }

    @Test
    public void add(){
        bag.add(1);
        Assert.assertFalse(bag.isEmpty());
    }
}

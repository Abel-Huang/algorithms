package cn.abelib.datastructure.linear.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * create by abel-huang on 2017/10/30
 */
public class BagTest {
    private LinkedBag bag;

    @Before
    public void init() {
        bag = new LinkedBag();
        Assert.assertTrue(bag.isEmpty());
    }

    @Test
    public void add() {
        bag.add(1);
        Assert.assertFalse(bag.isEmpty());
    }
}

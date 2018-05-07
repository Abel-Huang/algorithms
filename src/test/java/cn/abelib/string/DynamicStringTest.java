package cn.abelib.string;

import org.junit.Test;

/**
 * Created by ${abel-huang} on 18/2/28.
 */
public class DynamicStringTest {
    // success
    @Test
    public void testNew(){
        DynamicString string = new DynamicString("Hello 4121241212345678900876543345678987654456789765434567876543456787654345678654345676543" +
                "fbnmnbvcvbnmmmmnbvccccvbnmhgfdvbnu654edfghy5rfbnjytrfdvbnjuytrdfcvbuytrfbhytrfdvbnytrfhytrfgbnyrdewertyukmnfd23456yhgfdwyhgfr" +
                "gtredfhytredfbyrfghjuytrfr3456iolkmgrtyujkngfrthbvftghbgrld123456");
        System.err.println(string.len());
        System.err.println(string.available());
        System.err.println(string.value());
    }

    // success
    @Test
    public void tesEmpty(){
        DynamicString string = new DynamicString();
        System.err.println(string.len());
        System.err.println(string.available());
        System.err.println(string.value());
    }

    @Test
    public void tesFixed(){
        DynamicString string = new DynamicString(2);
        System.err.println(string.len());
        System.err.println(string.available());
        System.err.println(string.value());
    }


    @Test
    public void testUpdate(){
        DynamicString string = new DynamicString("1234567890");
        System.err.println(string.len());
        System.err.println(string.available());
        System.err.println(string.value());
        string.update("world");
        System.err.println(string.len());
        System.err.println(string.available());
        System.err.println(string.value());
        string.update("123");
        System.err.println(string.len());
        System.err.println(string.available());
        System.err.println(string.value());
        string.update("12323rfekrnvkklermerkbekverkgmrevb");
        System.err.println(string.len());
        System.err.println(string.available());
        System.err.println(string.value());
    }

    // success
    @Test
    public void testBitCac(){

        System.err.println(1>>1);
        System.err.println(2>>1);
        System.err.println(2<<1);
        System.err.println(-2<<1);
        System.err.println(-1>>1);
        System.err.println(-2>>1);
    }

    @Test
    public void testAppend() {
        DynamicString string = new DynamicString("a");
        string.append("a");
        System.err.println(string.len());
        System.err.println(string.available());
        System.err.println(string.value());
    }

    // success
    @Test
    public void testClear() {
        DynamicString string = new DynamicString("ab");
        System.err.println(string.len());
        System.err.println(string.available());
        System.err.println(string.value());
        string.clear();
        System.err.println(string.len());
        System.err.println(string.available());
        System.err.println(string.value());
        string.append("a");
        System.err.println(string.len());
        System.err.println(string.available());
        System.err.println(string.value());
    }
}

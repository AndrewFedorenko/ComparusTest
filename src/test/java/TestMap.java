import org.example.LongMapImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMap {
    @Test
    public void test(){
        LongMapImpl<Integer> lmi = new LongMapImpl<>();
        assertEquals(lmi.isEmpty(), true);

        // test of put
        for (int i = 0; i < 5; i++) {
            assertEquals(lmi.put(i,i) == i, true);
            assertEquals(lmi.containsKey(i), true);
            assertEquals(lmi.containsValue(i), true);
        }
        assertEquals(lmi.isEmpty(), false);
        assertEquals(lmi.size(), 5);
        // test of remove
        long[] keys = {3,1,9};
        for (int i = 0; i < keys.length; i++) {
            if (lmi.containsKey(keys[i])){
                assertEquals(lmi.remove(keys[i]) == keys[i], true);
            }
            assertEquals(lmi.containsKey(keys[i]), false);
            assertEquals(lmi.containsValue((int) keys[i]), false);
        }
        assertEquals(lmi.size(), 3);
        // test of put
        assertEquals(lmi.put(2, 12)==12, true);

        LongMapImpl<String> slmi = new LongMapImpl<>();
        for (int i = 0; i < 5; i++) {
            slmi.put(i,"Value"+i);
        }

    }
}

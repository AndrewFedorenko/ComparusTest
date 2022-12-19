package org.example;

public class Main {
    public static void main(String[] args) {

        LongMapImpl<Integer> lmi = new LongMapImpl<>();
        System.out.println("Working of isEmpty "+lmi.isEmpty());
        // test of put
        for (int i = 0; i < 5; i++) {
            lmi.put(i,i);
        }
        System.out.println("Working of isEmpty after add elements "+lmi.isEmpty());
        System.out.println("First state "+lmi);
        // test of remove
        long[] keys = {3,1,9};
        for (int i = 0; i < keys.length; i++) {
            if (lmi.containsKey(keys[i])){
                lmi.remove(3);
                System.out.println("after removal of " + keys[i] + " is: ");
                System.out.println(lmi);
            } else {
                System.out.println("No key "+keys[i]);
            }
        }
        // test of put
        lmi.put(2, Integer.valueOf(12));
        System.out.println("after putting of 12 to key 2 "+lmi);

        LongMapImpl<String> slmi = new LongMapImpl<>();
        for (int i = 0; i < 5; i++) {
            slmi.put(i,"Value"+i);
        }
        System.out.println("First state of string map "+slmi);
    }
}
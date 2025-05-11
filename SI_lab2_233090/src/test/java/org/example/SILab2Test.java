package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void checkCart() {

        RuntimeException e1 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(null, "1234567812345678")
        );
        assertEquals("allItems list can't be null!", e1.getMessage());


        Item itemWithNullName = new Item(null, 1, 100, 0.0);
        RuntimeException e2 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(itemWithNullName), "1234567812345678")
        );
        assertEquals("Invalid item!", e2.getMessage());

        Item validItem = new Item("Milk", 1, 100, 0.0);
        RuntimeException e3 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(validItem), "1234abcd1234abcd")
        );
        assertEquals("Invalid character in card number!", e3.getMessage());

        RuntimeException e4 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(validItem), "1234")
        );
        assertEquals("Invalid card number!", e4.getMessage());

        Item bread = new Item("Bread", 2, 350, 0.2); 
        double result = SILab2.checkCart(List.of(bread), "1111222233334444");
        assertEquals(530.0, result, 0.01);
    }

    @Test
    void checkCart_MultipleCondition() {

        Item item1 = new Item("Item1", 1, 100, 0.0);
        double result1 = SILab2.checkCart(List.of(item1), "1234567812345678");
        assertEquals(100.0, result1, 0.01);


        Item item2 = new Item("Item2", 1, 350, 0.0);
        double result2 = SILab2.checkCart(List.of(item2), "1234567812345678");
        assertEquals(320.0, result2, 0.01);


        Item item3 = new Item("Item3", 1, 100, 0.5);
        double result3 = SILab2.checkCart(List.of(item3), "1234567812345678");
        assertEquals(20.0, result3, 0.01);


        Item item4 = new Item("Item4", 11, 10, 0.0);
        double result4 = SILab2.checkCart(List.of(item4), "1234567812345678");
        assertEquals(80.0, result4, 0.01);
    }

}

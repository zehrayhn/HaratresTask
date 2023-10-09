package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {
    ShoppingCart shoppingCart;


    @Before
    public void setUp() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void giveDiscountTest() {

        String expected = ("Toplam tutar: " + "15" + ", İndirim yapılmayan kalemler, C= { " + "3, 4, 5" + "}");
        String output = shoppingCart.showDiscount();
        Assert.assertEquals(expected, output);
        System.out.println(output);

    }


}

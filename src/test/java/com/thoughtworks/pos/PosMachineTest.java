package com.thoughtworks.pos;

import com.thoughtworks.pos.domain.AllImformationItem;
import com.thoughtworks.pos.domain.CartItem;
import com.thoughtworks.pos.domain.DiscountItem;
import com.thoughtworks.pos.domain.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PosMachineTest {
    private PosMachine posMachine;

    @Before
    public void setUp() {
        List<Item> allItems = Arrays.asList(new Item("ITEM000001", 40),
                new Item("ITEM000003", 50), new Item("ITEM000005", 60));
        List<DiscountItem> discountItems=Arrays.asList(new DiscountItem("ITEM000001",75),new DiscountItem("ITEM000005",90));
        posMachine = new PosMachine(allItems,discountItems);
        List<CartItem> cartItems=Arrays.asList(new CartItem("ITEM000001",3),new CartItem("ITEM000003",2),new CartItem("ITEM000005",2));

    }

    @Test
    public void should_return_0_when_shopping_cart_empty() {
        List<AllImformationItem> all = Arrays.asList();
        double total = posMachine.calculate(all);

        assertThat(total, is(0d));
    }

    @Test
    public void should_calculate_total_when_given_1_item() {
        List<CartItem> emptyCart = Arrays.asList(new CartItem("ITEM000003", 1));
        List<Item> allItems = Arrays.asList(new Item("ITEM000001", 40),
                new Item("ITEM000003", 50), new Item("ITEM000005", 60));
        List<DiscountItem> discountItems=Arrays.asList(new DiscountItem("ITEM000001",75),new DiscountItem("ITEM000005",90));
        double total = posMachine.calculate(posMachine.getAllList(emptyCart,allItems,discountItems));

        assertThat(total, is(50d));
    }

    @Test
    public void should_calculate_total_when_given_multiple_items() {
        List<CartItem> emptyCart = Arrays.asList(new CartItem("ITEM000001", 2));
        List<Item> allItems = Arrays.asList(new Item("ITEM000001", 40),
                new Item("ITEM000003", 50), new Item("ITEM000005", 60));
        List<DiscountItem> discountItems=Arrays.asList(new DiscountItem("ITEM000001",0),new DiscountItem("ITEM000005",0));
        double total = posMachine.calculate(posMachine.getAllList(emptyCart,allItems,discountItems));

        assertThat(total, is(60d));
    }

    @Test
    public void should_calculate_total_when_given_dicount() {
        List<CartItem> emptyCart = Arrays.asList(new CartItem("ITEM000001", 2));
        List<Item> allItems = Arrays.asList(new Item("ITEM000001", 40),
                new Item("ITEM000003", 50), new Item("ITEM000005", 60));
        List<DiscountItem> discountItems=Arrays.asList(new DiscountItem("ITEM000001",90),new DiscountItem("ITEM000005",0));
        double total = posMachine.calculate(posMachine.getAllList(emptyCart,allItems,discountItems));

        assertThat(total, is(56d));
    }


    }



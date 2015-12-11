package com.thoughtworks.pos;

import com.thoughtworks.pos.domain.*;
import com.thoughtworks.pos.parser.DiscountParser;
import com.thoughtworks.pos.parser.ItemParser;
import com.thoughtworks.pos.parser.ShoppingCartParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ItemParser itemParser = new ItemParser();
        List<Item> allItems = itemParser.parse(ShopData.ITEMS_DATA);

        ShoppingCartParser shoppingCartParser = new ShoppingCartParser();
        List<CartItem> cartItems = shoppingCartParser.parse(ShopData.SHOPPING_CART_DATA);

        DiscountParser discountParser=new DiscountParser();
        List<DiscountItem> discountItems= discountParser.parse(ShopData.DISCOUNT_ITEMS);



        PosMachine posMachine = new PosMachine(allItems,discountItems);
        List<AllImformationItem> allImformationItems=posMachine.getAllList(cartItems,allItems,discountItems);

        double total = posMachine.calculate(allImformationItems);

        System.out.println("总价:" + total);
    }




}

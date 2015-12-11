package com.thoughtworks.pos;

import com.thoughtworks.pos.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PosMachine {
    private final List<Item> allItems;
    private final List<DiscountItem> discountItems;



    public PosMachine(List<Item> allItems,List<DiscountItem> discountItems) {

        this.allItems = allItems;
        this.discountItems=discountItems;


    }

    public double calculate(List<AllImformationItem> allImformationItems) {
        double total = 0;
        for (AllImformationItem all : allImformationItems) {

            total += all.getallprice(all);
        }

        return total;
    }

    private double calculateSubtotal(final CartItem cartItem) {
        String barcode = cartItem.getBarcode();
        double originPrice = queryItemPrice(barcode);

        return cartItem.getQuantity() * originPrice;
    }

    public double queryItemPrice(final String barcode) {
        for (Item item : allItems) {
            if (item.getBarcode().equals(barcode)) {
                return item.getPrice();
            }
        }

        throw new IllegalArgumentException("unknown item");
    }

    public boolean queryHalfprice(final String barcode){
        for (String s:ShopData.HALF_PRICE_DATA){
            if (s.equals(barcode)){
                return true;
            }
        }
        return false;
    }

    public Integer queryDiscount(final String barcode){
        for (DiscountItem item:discountItems){
            if (item.getBarcode().equals(barcode)){
                return item.getDiscount();
            }
        }
        return 0;
    }



    public List<AllImformationItem> getAllList(List<CartItem> cartItems, List<Item> items, List<DiscountItem> discountItems){
        PosMachine posMachine=new PosMachine(items,discountItems);
        List<AllImformationItem> allImformationItems=new ArrayList<>();
        AllImformationItem allImformationItem=new AllImformationItem();

        for (CartItem cc:cartItems){
            allImformationItem.barcode=cc.getBarcode();
            allImformationItem.count=cc.getQuantity();
            allImformationItem.price=posMachine.queryItemPrice(allImformationItem.barcode);
            allImformationItem.halfornot=posMachine.queryHalfprice(allImformationItem.barcode);
            allImformationItem.discount=posMachine.queryDiscount(allImformationItem.barcode);
            allImformationItems.add(allImformationItem);

        }

        return allImformationItems;
    }


}

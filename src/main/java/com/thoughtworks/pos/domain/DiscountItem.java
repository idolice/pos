package com.thoughtworks.pos.domain;

/**
 * Created by idolice on 15-12-5.
 */
public class DiscountItem {

    private final String barcode;
    private final Integer discount;


    public DiscountItem(final String barcode, final Integer dicount) {

        this.barcode = barcode;
        this.discount = dicount;
    }

    public String getBarcode() {
        return barcode;
    }

    public Integer getDiscount() {
        return discount;
    }
}

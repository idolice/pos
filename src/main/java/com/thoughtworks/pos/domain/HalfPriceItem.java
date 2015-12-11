package com.thoughtworks.pos.domain;

/**
 * Created by idolice on 15-12-8.
 */
public class HalfPriceItem {
    private final String barcode;
    private final boolean halfornot;

    public HalfPriceItem(final String barcode, final boolean halfornot) {
        this.barcode = barcode;
        this.halfornot=halfornot;
    }

    public String getBarcode() {
        return barcode;
    }

    public boolean gethalfornot() {
        return halfornot;
    }
}

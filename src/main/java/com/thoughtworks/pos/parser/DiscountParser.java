package com.thoughtworks.pos.parser;

import com.thoughtworks.pos.domain.DiscountItem;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class DiscountParser extends Parser<DiscountItem> {
    private static final Pattern PATTERN = compile("^(\\w+):(\\d+)$");

    @Override
    protected DiscountItem parseLine(String line) {
        String barcode = line.split(":")[0];
        Integer dicount = Integer.parseInt(line.split(":")[1]);
        return new DiscountItem(barcode, dicount);
    }

    @Override
    protected Pattern getPattern() {
        return PATTERN;
    }
}

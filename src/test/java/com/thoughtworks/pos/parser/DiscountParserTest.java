package com.thoughtworks.pos.parser;

import com.thoughtworks.pos.domain.DiscountItem;
import com.thoughtworks.pos.domain.Item;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by idolice on 15-12-5.
 */
public class DiscountParserTest {
    @Test
    public void should_return_discount()
    {
        //given
        List<DiscountItem> items = new DiscountParser().parse(asList("I1:40"));

        assertThat(items.get(0).getBarcode(), is("I1"));
        assertEquals(items.get(0).getDiscount(), 40, 1e-6);
    }

}
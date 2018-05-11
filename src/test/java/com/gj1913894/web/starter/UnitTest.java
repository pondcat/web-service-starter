package com.gj1913894.web.starter;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @author gejian
 */
public class UnitTest {

    @Test
    public void tt() {
        NumberFormat format = NumberFormat.getPercentInstance();
        format.setMaximumIntegerDigits(3);
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);
        String format1 = format.format(BigDecimal.valueOf(1.035));
        System.out.println(format1);

    }
}

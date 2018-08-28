package com.tencent.mm.plugin.h.a.a;

import java.math.BigDecimal;

public final class i {
    public static BigDecimal j(double d, double d2) {
        return new BigDecimal(d).multiply(new BigDecimal(d2));
    }

    public static double i(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new NullPointerException("null == dataGroup || 0 == dataGroup.length");
        }
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i++;
            i2 = iArr[i] + i2;
        }
        return new BigDecimal((double) i2).divide(new BigDecimal((double) iArr.length), 5, 4).doubleValue();
    }

    public static double j(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new NullPointerException("null == dataGroup || 0 == dataGroup.length");
        }
        double i = i(iArr);
        BigDecimal bigDecimal = new BigDecimal(0.0d);
        for (int i2 : iArr) {
            bigDecimal = bigDecimal.add(new BigDecimal((double) i2).subtract(new BigDecimal(i)).pow(2));
        }
        return Math.pow(bigDecimal.divide(new BigDecimal(iArr.length - 1), 5, 4).doubleValue(), 0.5d);
    }
}

package com.tencent.tencentmap.mapsdk.a;

import java.util.Arrays;

public class h {
    public static final double a = Double.longBitsToDouble(4368491638549381120L);
    public static final double b = Double.longBitsToDouble(4503599627370496L);
    private static final long c = Double.doubleToRawLongBits(0.0d);
    private static final long d = Double.doubleToRawLongBits(-0.0d);
    private static final int e = Float.floatToRawIntBits(0.0f);
    private static final int f = Float.floatToRawIntBits(-0.0f);

    public static String a(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }

    public static String a(String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            stringBuilder.append(strArr[i]);
            if (i2 != strArr.length - 1) {
                stringBuilder.append(",");
            }
            i++;
            i2++;
        }
        return stringBuilder.toString();
    }

    public static int a(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }
}

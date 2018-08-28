package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.loader.stub.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class c {
    public static final int[] jqc = new int[]{65536};
    public static final int[] jqd = new int[]{196608};
    public static final int[] jqe = new int[]{262144};
    public static final int[] jqf = new int[]{327680};
    public static final int[] jqg = new int[]{393216};
    public static final int[] jqh = new int[]{458752};
    public static final int[] jqi = new int[]{131073, 131074};
    public static final int[] jqj = new int[]{131072, 131075, 131076, 131081};
    public static final int[] jqk = new int[]{131072, 131075, 131076, 131081};
    public static final int[] jql = new int[]{131072};
    public static final int[] jqm = new int[]{131073, 131074};
    public static final int[] jqn = new int[]{131077, 131078};
    public static final int[] jqo = new int[]{131079, 131080};
    public static final int[] jqp = new int[]{5, 6, 7, 1, 2, 3};
    public static final Map<Integer, Integer> jqq;
    public static final int[] jqr = new int[]{2, 3, 6, 7};
    public static final int[] jqs = new int[]{29, 30, 31, 34, 35, 36, 33, 32, 37};
    public static final int[] jqt;
    public static final int[] jqu;
    public static final int[] jqv = new int[43];
    public static final int[] jqw = new int[27];
    public static final String jqx = (b.bnE + "fts/");

    static {
        int i;
        int i2 = 0;
        int[] iArr = new int[]{8, 9, 10};
        jqt = iArr;
        jqu = iArr;
        int[] iArr2 = new int[]{131072, 131073, 131074, 131075, 131076, 131077, 131078, 131079, 131080};
        int[] iArr3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 17, 18, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 0};
        int[] iArr4 = new int[]{1, 2, 3, 4, 5, 6, 8, 19, 20, 21, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 7, 0};
        Map hashMap = new HashMap();
        for (i = 0; i < 9; i++) {
            hashMap.put(Integer.valueOf(iArr2[i]), Integer.valueOf(i));
        }
        jqq = Collections.unmodifiableMap(hashMap);
        for (i = 0; i < 43; i++) {
            jqv[iArr3[i]] = i;
        }
        while (i2 < 27) {
            jqw[iArr4[i2]] = i2;
            i2++;
        }
    }
}

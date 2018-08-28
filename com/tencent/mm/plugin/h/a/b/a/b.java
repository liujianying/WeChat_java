package com.tencent.mm.plugin.h.a.b.a;

import com.tencent.mm.plugin.h.a.b.h;
import com.tencent.mm.sdk.platformtools.x;

public class b extends a {
    static final String TAG = b.class.getName();
    public static String hhk = h.hhe;
    public static String hhl = h.hhf;
    public static String hhm = h.hhg;
    private final int hhn;
    private final int hho;
    private final int hhp;
    private final int hhq;
    private final int hhr;
    b hhs;
    a hht;
    int hhu;

    public b() {
        this.hhn = 1;
        this.hho = 2;
        this.hhp = 4;
        this.hhq = 8;
        this.hhr = 16;
        this.hhi = null;
        this.hhj = 2;
        this.hgC = 8;
        this.hhs = null;
    }

    static double K(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] << 8) & 65280;
        int i3 = (i2 >> 12) - 16;
        int i4 = i2 & 3840;
        int i5 = (bArr[i] & 255) + (65280 & i4);
        double pow = ((double) i5) * Math.pow(10.0d, (double) i3);
        x.d(TAG, "hbyte=" + i2 + " hvalue=" + i4 + " value=" + i5 + " exp=" + i3);
        return pow;
    }

    public final byte[] atV() {
        return null;
    }
}

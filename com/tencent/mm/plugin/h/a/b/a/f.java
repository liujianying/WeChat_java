package com.tencent.mm.plugin.h.a.b.a;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.h.a.b.h;
import com.tencent.mm.sdk.platformtools.x;

@TargetApi(18)
public class f extends a {
    static final String TAG = f.class.getName();
    public static String hin = h.hgQ;
    public static String hio = h.hgR;
    public int hip;
    public int hiq;
    public int hir;
    public long his;
    public long hit;

    public f() {
        this.hhi = null;
        this.hhj = 8;
        this.hgC = 1;
        this.hip = -1;
        this.hiq = -1;
        this.hir = -1;
        this.his = 0;
        this.hit = 0;
    }

    public final byte[] atV() {
        if (this.hip < 0) {
            x.e(TAG, "stepCount is invalid");
            return null;
        }
        int i;
        int i2;
        if (this.hiq >= 0) {
            i = 7;
        } else {
            i = 4;
        }
        if (this.hir >= 0) {
            i += 3;
        }
        byte[] bArr = new byte[i];
        bArr[0] = (byte) 1;
        i = 1;
        for (i2 = 0; i2 < 3; i2++) {
            bArr[i] = (byte) ((this.hip >> (i2 * 8)) & 255);
            i++;
        }
        if (this.hiq >= 0) {
            bArr[0] = (byte) (bArr[0] | 2);
            for (i2 = 0; i2 < 3; i2++) {
                bArr[i] = (byte) ((this.hiq >> (i2 * 8)) & 255);
                i++;
            }
        }
        if (this.hir >= 0) {
            bArr[0] = (byte) 4;
            int i3 = 0;
            i2 = i;
            while (i3 < 3) {
                bArr[i2] = (byte) ((this.hir >> (i3 * 8)) & 255);
                i3++;
                i2++;
            }
        }
        return bArr;
    }
}

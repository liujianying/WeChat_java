package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.plugin.report.service.h;

public final class i {
    int aIs;
    boolean fdA;
    long[] fdv;
    int fdw;
    int fdx;
    private int fdy = 0;
    boolean fdz;
    int mType;

    public final void o(int i, long j) {
        if (i == 0) {
            this.fdv = new long[13];
            this.fdy = d.ana() ? 1 : 0;
        }
        if (i < this.fdv.length && this.fdv[i] == 0) {
            this.fdv[i] = j;
        }
    }

    final void d(String str, int i, int i2, int i3) {
        int i4;
        int i5 = 1;
        h hVar = h.mEJ;
        Object[] objArr = new Object[13];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(this.aIs);
        objArr[2] = Integer.valueOf(this.mType);
        objArr[3] = Integer.valueOf(i);
        objArr[4] = "";
        objArr[5] = "";
        objArr[6] = Long.valueOf(this.fdv[i2]);
        objArr[7] = Integer.valueOf(this.fdw);
        objArr[8] = Integer.valueOf(this.fdy);
        objArr[9] = Integer.valueOf(this.fdx);
        if (this.fdz) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        objArr[10] = Integer.valueOf(i4);
        if (!this.fdA) {
            i5 = 0;
        }
        objArr[11] = Integer.valueOf(i5);
        objArr[12] = Integer.valueOf(i3);
        hVar.h(13886, objArr);
    }
}

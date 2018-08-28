package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.sdk.platformtools.bi;

public final class b {
    int bYE;
    int kGn;
    int kGo;
    byte[] lho;
    byte[] lhp;
    int lhq = 0;
    int lhr = 0;
    long lhs = bi.VG();
    int lht;
    int lhu;
    int lhv;
    int lhw;
    boolean lhx;
    boolean lhy;

    public interface a {
        void a(b bVar);
    }

    public b(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, int i6, byte[] bArr) {
        this.lhv = i3;
        this.kGn = i4;
        this.kGo = i5;
        this.lht = i;
        this.lhu = i2;
        this.lhy = z2;
        this.lhx = z;
        this.bYE = i6;
        this.lho = bArr;
        this.lhq = bArr.length;
        this.lhp = j.lin.c(Integer.valueOf(((i4 * i5) * 3) / 2));
    }
}

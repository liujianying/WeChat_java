package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.b.a.a.as;
import com.tencent.pb.common.b.a.a.av;

class f$4 implements Runnable {
    final /* synthetic */ int hbj;
    final /* synthetic */ int ovC;
    final /* synthetic */ long ovD;
    final /* synthetic */ f vyi;
    final /* synthetic */ av[] vyl;
    final /* synthetic */ as vym;
    final /* synthetic */ byte[] vyn;
    final /* synthetic */ boolean vyo;
    final /* synthetic */ String vyp;
    final /* synthetic */ int vyq;
    final /* synthetic */ int vyr;
    final /* synthetic */ byte[] vys;

    f$4(f fVar, int i, av[] avVarArr, as asVar, byte[] bArr, boolean z, String str, int i2, long j, int i3, int i4, byte[] bArr2) {
        this.vyi = fVar;
        this.hbj = i;
        this.vyl = avVarArr;
        this.vym = asVar;
        this.vyn = bArr;
        this.vyo = z;
        this.vyp = str;
        this.ovC = i2;
        this.ovD = j;
        this.vyq = i3;
        this.vyr = i4;
        this.vys = bArr2;
    }

    public final void run() {
        f.a(this.vyi, this.hbj - 1, this.vyl, this.vym, this.vyn, this.vyo, this.vyp, this.ovC, this.ovD, this.vyq, this.vyr, this.vys);
    }
}

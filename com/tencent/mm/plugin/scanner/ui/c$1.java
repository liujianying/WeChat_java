package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.protocal.c.io;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ String mGV;
    final /* synthetic */ c mGW;

    c$1(c cVar, String str) {
        this.mGW = cVar;
        this.mGV = str;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        x.i("MicroMsg.BaseScanModeLicence", "errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        c cVar = this.mGW;
        cVar.mGQ++;
        c.a(this.mGW, i2, this.mGV, ((io) bVar.dIE.dIL).rjK);
        return 0;
    }
}

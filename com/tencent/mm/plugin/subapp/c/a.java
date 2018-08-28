package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.axh;
import com.tencent.mm.protocal.c.axi;
import com.tencent.mm.protocal.c.byq;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.LinkedList;

public final class a extends l implements k {
    private b diG;
    private e diJ;

    public a(LinkedList<byq> linkedList, int i) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new axh();
        aVar.dIH = new axi();
        aVar.uri = "/cgi-bin/micromsg-bin/opvoicereminder";
        aVar.dIF = TbsListener$ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE;
        aVar.dII = 150;
        aVar.dIJ = 1000000150;
        this.diG = aVar.KT();
        axh axh = (axh) this.diG.dID.dIL;
        axh.qZc = 1;
        axh.sar = linkedList;
        axh.saq = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return TbsListener$ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }
}

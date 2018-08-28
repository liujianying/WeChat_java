package com.tencent.mm.modelvoiceaddr.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bgz;
import com.tencent.mm.protocal.c.bha;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class a extends l implements k {
    private b diG;
    private e diJ;

    public a(int i, LinkedList<bhz> linkedList, bhz bhz, bhz bhz2) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bgz();
        aVar.dIH = new bha();
        aVar.uri = "/cgi-bin/micromsg-bin/reportvoiceresult";
        aVar.dIF = 228;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bgz bgz = (bgz) this.diG.dID.dIL;
        bgz.shR = i;
        bgz.shS = linkedList;
        bgz.shT = bhz;
        bgz.shU = bhz2;
    }

    public final int getType() {
        return 228;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneNewVoiceInputReport", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.diJ.a(i2, i3, str, this);
    }
}

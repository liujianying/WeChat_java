package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bbh;
import com.tencent.mm.protocal.c.bbi;
import com.tencent.mm.sdk.platformtools.x;

public final class ag extends l implements k {
    public String bYo;
    public String content;
    private final b diG;
    private e diJ;
    public String fpc;
    public String hxm;
    public String hxn;
    public boolean hxo;
    public String hxp;
    public String hxq;
    public String hxr;
    public String hxs;
    public int status;

    public ag(int i, String str, String str2) {
        a aVar = new a();
        aVar.dIG = new bbh();
        aVar.dIH = new bbi();
        aVar.uri = "/cgi-bin/micromsg-bin/preacceptgiftcard";
        aVar.dIF = 1171;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bbh bbh = (bbh) this.diG.dID.dIL;
        bbh.qZT = i;
        bbh.qZU = str;
        bbh.qZV = str2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetScenePreAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            bbi bbi = (bbi) this.diG.dIE.dIL;
            this.bYo = bbi.qZY;
            this.hxm = bbi.qZZ;
            this.status = bbi.status;
            this.content = bbi.content;
            this.hxn = bbi.hwH;
            this.fpc = bbi.sdu;
            this.hxo = bbi.hxo;
            this.hxp = bbi.sdv;
            this.hxq = bbi.sdw;
            this.hxr = bbi.sdx;
            this.hxs = bbi.sdy;
            x.d("MicroMsg.NetScenePreAcceptGiftCard", "fromUserName:%s, fromUserHeadImgUrl:%s, status:%d, content:%s,buttonWording:%s, backgroundColor:%s, ignore:%b", new Object[]{this.bYo, this.hxm, Integer.valueOf(this.status), this.content, this.hxn, this.fpc, Boolean.valueOf(this.hxo)});
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1171;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}

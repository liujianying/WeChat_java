package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bsj;
import com.tencent.mm.protocal.c.bsk;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends f {
    private final b diG;
    private com.tencent.mm.ab.e diJ;
    private final String kGu;
    private int sceneType = 0;

    public e(String str, int i, long j, int i2) {
        this.sceneType = i2;
        a aVar = new a();
        aVar.dIG = new bsj();
        aVar.dIH = new bsk();
        aVar.uri = "/cgi-bin/micromsg-bin/talknoop";
        aVar.dIF = 335;
        aVar.dII = 149;
        aVar.dIJ = 1000000149;
        this.diG = aVar.KT();
        bsj bsj = (bsj) this.diG.dID.dIL;
        bsj.rxG = i;
        bsj.rxH = j;
        bsj.rca = (int) bi.VE();
        this.kGu = str;
        bsj.otY = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        x.d("MicroMsg.NetSceneTalkNoop", "doScene");
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 335;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneTalkNoop", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.diJ.a(i2, i3, str, this);
        } else {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final String bHj() {
        return this.kGu;
    }

    public final int bHk() {
        return this.sceneType;
    }
}

package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bsh;
import com.tencent.mm.protocal.c.bsi;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends f {
    public int actionType;
    private final b diG;
    private e diJ;
    private final String kGu;
    public int owV;
    private int sceneType = 0;

    public d(int i, long j, int i2, String str, int i3) {
        this.sceneType = i3;
        a aVar = new a();
        aVar.dIG = new bsh();
        aVar.dIH = new bsi();
        aVar.uri = "/cgi-bin/micromsg-bin/talkmicaction";
        aVar.dIF = 334;
        aVar.dII = 146;
        aVar.dIJ = 1000000146;
        this.diG = aVar.KT();
        bsh bsh = (bsh) this.diG.dID.dIL;
        bsh.rxG = i;
        bsh.rxH = j;
        bsh.rDF = i2;
        bsh.rca = (int) bi.VE();
        this.actionType = i2;
        this.kGu = str;
        bsh.otY = i3;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneTalkMicAction", "doScene");
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 334;
    }

    public final String bHj() {
        return this.kGu;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneTalkMicAction", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.owV = ((bsi) this.diG.dIE.dIL).rxI;
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int bHk() {
        return this.sceneType;
    }
}

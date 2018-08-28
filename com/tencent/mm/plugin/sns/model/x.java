package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.protocal.c.bps;
import com.tencent.mm.protocal.c.bpx;
import com.tencent.mm.protocal.c.bpy;
import com.tencent.mm.sdk.platformtools.bi;

public final class x extends l implements k {
    private int bNI;
    private b diG;
    public e diJ;
    private long noJ = 0;

    public x(long j, String str) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSnsTagOption", "opcode 3 snsTagId " + j + " tagName " + str);
        this.noJ = j;
        this.bNI = 3;
        a aVar = new a();
        aVar.dIG = new bpx();
        aVar.dIH = new bpy();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstagoption";
        aVar.dIF = 290;
        aVar.dII = 114;
        aVar.dIJ = 1000000114;
        this.diG = aVar.KT();
        bpx bpx = (bpx) this.diG.dID.dIL;
        bpx.qZc = 3;
        bpx.snO = j;
        bpx.jSt = str;
    }

    public final int getType() {
        return 290;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSnsTagOption", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            bps bps = ((bpy) ((b) qVar).dIE.dIL).snQ;
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSnsTagOption", bps.toString());
            switch (this.bNI) {
                case 1:
                case 2:
                    t fk = af.byu().fk(bps.snO);
                    fk.field_tagId = bps.snO;
                    fk.field_tagName = bi.aG(bps.jSt, "");
                    fk.field_count = bps.hbF;
                    fk.co(bps.hbG);
                    af.byu().a(fk);
                    break;
                case 3:
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSnsTagOption", "MM_SNS_TAG_DEL " + af.byu().fl(this.noJ));
                    break;
            }
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }
}

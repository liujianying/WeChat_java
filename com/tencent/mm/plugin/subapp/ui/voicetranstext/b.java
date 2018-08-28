package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajp;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.protocal.c.byt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class b extends l implements k {
    private final String TAG = "MicroMsg.NetSceneGetVoiceTransRes";
    private com.tencent.mm.ab.b dIy;
    private e lCQ;
    private String otU;
    public byt oud;
    public int ouh = -1;

    public b(String str) {
        Assert.assertTrue(!bi.oW(str));
        this.otU = str;
        a aVar = new a();
        aVar.dIG = new ajp();
        aVar.dIH = new ajq();
        aVar.uri = "/cgi-bin/micromsg-bin/getvoicetransres";
        aVar.dIF = 548;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.dIy = aVar.KT();
    }

    public final int getType() {
        return 548;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.lCQ = eVar2;
        ((ajp) this.dIy.dID.dIL).rsZ = this.otU;
        return a(eVar, this.dIy, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            ajq ajq = (ajq) this.dIy.dIE.dIL;
            if (ajq.rtd != null) {
                this.ouh = ajq.rtd.sga;
            }
            this.oud = ajq.rtb;
        } else {
            x.i("MicroMsg.NetSceneGetVoiceTransRes", "error get: errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        this.lCQ.a(i2, i3, str, this);
    }

    public final boolean isComplete() {
        return this.oud != null && this.oud.rgC == 1;
    }

    public final boolean bGC() {
        return (this.oud == null || bi.oW(this.oud.suF)) ? false : true;
    }
}

package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.btz;
import com.tencent.mm.protocal.c.bua;
import com.tencent.mm.protocal.c.cp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLivePushConfig;
import java.util.LinkedList;

public final class aa extends l implements k {
    private final b diG;
    private e diJ;

    public aa(String str, int i, LinkedList<cp> linkedList) {
        x.i("MicroMsg.NetSceneTranslateLink", "ticket link = " + str + "; scene = " + i);
        a aVar = new a();
        aVar.dIG = new btz();
        aVar.dIH = new bua();
        aVar.uri = "/cgi-bin/mmbiz-bin/translatelink";
        aVar.dIF = TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        btz btz = (btz) this.diG.dID.dIL;
        btz.egr = str;
        btz.scene = i;
        btz.srr = linkedList;
    }

    public final int getType() {
        return TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneTranslateLink", "swap deep link with ticket onGYNetEnd:[%d,%d,%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }

    public final String Rv() {
        bua bua = (bua) this.diG.dIE.dIL;
        if (bua == null) {
            return null;
        }
        return bua.srs;
    }

    public final bua Rw() {
        if (this.diG == null || this.diG.dIE.dIL == null) {
            return null;
        }
        return (bua) this.diG.dIE.dIL;
    }
}

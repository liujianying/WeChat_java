package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bmp;
import com.tencent.mm.protocal.c.bmq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    byte[] cdy;
    private final com.tencent.mm.ab.b diG;
    private e diJ;
    int ret;

    public b(float f, float f2, int i, int i2, String str, String str2) {
        a aVar = new a();
        aVar.dIG = new bmp();
        aVar.dIH = new bmq();
        aVar.uri = "/cgi-bin/micromsg-bin/shakereport";
        aVar.dIF = JsApiOperateBackgroundAudio.CTRL_INDEX;
        aVar.dII = 56;
        aVar.dIJ = 1000000056;
        this.diG = aVar.KT();
        bmp bmp = (bmp) this.diG.dID.dIL;
        x.i("MicroMsg.NetSceneShakeReport", "share reprot %f %f", new Object[]{Float.valueOf(f2), Float.valueOf(f)});
        bmp.qZc = 0;
        bmp.rmr = f;
        bmp.rms = f2;
        bmp.ryV = i;
        bmp.ryW = str;
        bmp.ryX = str2;
        bmp.ryY = i2;
        au.HU();
        bmp.skU = bi.a((Integer) c.DT().get(4107, null), 0);
        au.HU();
        int f3 = bi.f((Integer) c.DT().get(4106, null));
        bmp.skV = f3;
        f3++;
        au.HU();
        c.DT().set(4106, Integer.valueOf(f3));
        bmp.rTr = new bhy().bq(com.tencent.mm.plugin.normsg.a.b.lFJ.bjE());
        o.a(2002, f, f2, i);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneShakeReport", "doScene");
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return JsApiOperateBackgroundAudio.CTRL_INDEX;
    }

    public final int bun() {
        return ((bmp) this.diG.dID.dIL).ryY;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneShakeReport", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        bmq bmq = (bmq) this.diG.dIE.dIL;
        this.ret = qVar.Id().qWB;
        if (i2 == 0 && i3 == 0) {
            this.cdy = ab.a(bmq.rfy);
        }
        this.diJ.a(i2, i3, str, this);
    }
}

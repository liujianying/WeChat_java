package com.tencent.mm.modelsimple;

import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements Runnable {
    final /* synthetic */ String efo;
    final /* synthetic */ boolean efp;
    final /* synthetic */ k efq;

    k$1(k kVar, String str, boolean z) {
        this.efq = kVar;
        this.efo = str;
        this.efp = z;
    }

    public final void run() {
        int i;
        String str = "MicroMsg.NetSceneGetDisasterInfo";
        String str2 = "summerdiz NetSceneGetDisasterInfo broadcastEvent content len[%d], cache[%b]";
        Object[] objArr = new Object[2];
        if (this.efo == null) {
            i = -1;
        } else {
            i = this.efo.length();
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(this.efp);
        x.i(str, str2, objArr);
        ah ahVar = new ah();
        ahVar.bHy.type = 5;
        ahVar.bHy.bHA = this.efo;
        a.sFg.m(ahVar);
        str = ahVar.bHz.bHF;
        int i2 = ahVar.bHz.position;
        int i3 = ahVar.bHz.bHC;
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd event.result.Actionp[%d] noticeId[%s], position[%d], manualauthSucc[%b], noticeidTickMap[%s]", new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i2), Boolean.valueOf(k.a(this.efq)), k.QV()});
        if (i2 == 1 && i3 == 6) {
            if (this.efp) {
                k.ax(str, this.efo);
            }
            if (k.a(this.efq)) {
                str2 = ahVar.bHz.desc;
                String str3 = ahVar.bHz.url;
                x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after init[%b]", new Object[]{Boolean.valueOf(ad.chV())});
                if (k.b(this.efq) == null) {
                    k.a(this.efq, new 1(this, str2, str3));
                }
                a.sFg.b(k.b(this.efq));
            } else {
                iz izVar = new iz();
                izVar.bSF.content = ahVar.bHz.desc;
                izVar.bSF.url = ahVar.bHz.url;
                a.sFg.m(izVar);
            }
            k.QV().put(str, Long.valueOf(bi.VG()));
        } else if (i3 == 2) {
            if (this.efp) {
                k.ax(str, this.efo);
            }
            k.QV().put(str, Long.valueOf(bi.VG()));
        }
    }
}

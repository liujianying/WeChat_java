package com.tencent.mm.plugin.voip_cs.a;

import com.tencent.mm.g.a.ss;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.plugin.voip_cs.b.d;
import com.tencent.mm.protocal.c.bzj;
import com.tencent.mm.protocal.c.bzq;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class a extends c<ss> {
    public a() {
        this.sFo = ss.class.getName().hashCode();
    }

    private static boolean a(ss ssVar) {
        if ((ssVar instanceof ss) && au.HX()) {
            d bMw = b.bMw();
            Object obj = ssVar.cdx.cdy;
            if (!(obj == null || obj.length == 0)) {
                Object obj2 = new byte[(obj.length - 1)];
                System.arraycopy(obj, 1, obj2, 0, obj2.length);
                bzj bzj = new bzj();
                try {
                    bzj.aG(obj2);
                    x.i("MicroMsg.voipcs.VoipCSService", "notify status = " + bzj.svE + ",notifySeq = " + bMw.oXm);
                    bzq bzq = new bzq();
                    bzq.svs = bzj.svs;
                    bzq.rxH = bzj.rxH;
                    bzq.svC = bzj.svC;
                    bzq.svE = bzj.svE;
                    bzq.svF = bzj.svF;
                    bzq.svG = bzj.svG;
                    bzq.svD = bzj.svD;
                    bMw.a(bzq);
                } catch (IOException e) {
                    x.e("MicroMsg.voipcs.VoipCSService", "csNotify.parseFrom content error!", new Object[]{e});
                }
            }
        }
        return false;
    }
}

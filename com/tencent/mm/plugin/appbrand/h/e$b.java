package com.tencent.mm.plugin.appbrand.h;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.v;
import com.tencent.mm.plugin.appbrand.h.e.a;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.protocal.c.ait;
import com.tencent.mm.protocal.c.bni;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum e$b {
    ;
    
    Map<Integer, a> gke;
    private Runnable gkf;

    private e$b(String str) {
        this.gke = new ConcurrentHashMap();
        this.gkf = new 1(this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: alo */
    final void b() {
        /*
        r9 = this;
        r4 = 1;
        r5 = 0;
        com.tencent.mm.kernel.g.Em();
        r0 = r9.gkf;
        com.tencent.mm.sdk.platformtools.ah.M(r0);
        r0 = r9.gke;
        r0 = r0.size();
        if (r0 >= 0) goto L_0x001c;
    L_0x0012:
        r0 = "MicroMsg.WxaUpdateableMsgService";
        r1 = "not sendUpdatableMsgRequest";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
    L_0x001b:
        return;
    L_0x001c:
        r0 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r2 = r9.gke;
        r2 = r2.values();
        r6 = r2.iterator();
        r2 = r0;
    L_0x002c:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x007d;
    L_0x0032:
        r0 = r6.next();
        r0 = (com.tencent.mm.plugin.appbrand.h.e.a) r0;
        r1 = r0.alm();
        if (r1 == 0) goto L_0x0063;
    L_0x003e:
        r0 = r4;
    L_0x003f:
        r1 = "MicroMsg.WxaUpdateableMsgService";
        r6 = "needUpdateFirst:%b minDelayTime:%d";
        r7 = 2;
        r7 = new java.lang.Object[r7];
        r8 = java.lang.Boolean.valueOf(r0);
        r7[r5] = r8;
        r5 = java.lang.Long.valueOf(r2);
        r7[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.d(r1, r6, r7);
        if (r0 == 0) goto L_0x0070;
    L_0x0059:
        r0 = com.tencent.mm.kernel.g.Em();
        r1 = r9.gkf;
        r0.H(r1);
        goto L_0x001b;
    L_0x0063:
        r1 = r0.gkb;
        if (r1 < 0) goto L_0x007d;
    L_0x0067:
        r0 = r0.gkb;
        r0 = (long) r0;
        r0 = java.lang.Math.min(r0, r2);
        r2 = r0;
        goto L_0x002c;
    L_0x0070:
        r0 = com.tencent.mm.kernel.g.Em();
        r1 = r9.gkf;
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 * r4;
        r0.h(r1, r2);
        goto L_0x001b;
    L_0x007d:
        r0 = r5;
        goto L_0x003f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.h.e$b.alo():void");
    }

    public final void v(LinkedList<bni> linkedList) {
        if (linkedList.size() <= 0) {
            x.e("MicroMsg.WxaUpdateableMsgService", "shareKeyInfoList is null, return");
            b();
            return;
        }
        x.d("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg shareKeyInfoList.size:%d", new Object[]{Integer.valueOf(linkedList.size())});
        b.a aVar = new b.a();
        aVar.dIF = 2954;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getupdatablemsginfo";
        ais ais = new ais();
        ais.rLt = linkedList;
        aVar.dIG = ais;
        aVar.dIH = new ait();
        v.a(aVar.KT(), new 2(this));
    }
}

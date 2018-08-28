package com.tencent.mm.ac;

import com.tencent.mm.aa.j;
import com.tencent.mm.aa.k;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.cgc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h implements e {
    Object dMd = new Object();
    Set<String> dMe = new HashSet();
    public LinkedList<a> dMf = new LinkedList();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.ac.h.a r7) {
        /*
        r6 = this;
        r1 = r6.dMd;
        monitor-enter(r1);
        r0 = r6.dMf;	 Catch:{ all -> 0x0053 }
        r0 = r0.contains(r7);	 Catch:{ all -> 0x0053 }
        if (r0 != 0) goto L_0x0051;
    L_0x000b:
        r0 = r6.dMf;	 Catch:{ all -> 0x0053 }
        r2 = r0.iterator();	 Catch:{ all -> 0x0053 }
    L_0x0011:
        r0 = r2.hasNext();	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x004c;
    L_0x0017:
        r0 = r2.next();	 Catch:{ all -> 0x0053 }
        r0 = (com.tencent.mm.ac.h.a) r0;	 Catch:{ all -> 0x0053 }
        if (r7 == 0) goto L_0x0011;
    L_0x001f:
        if (r0 == 0) goto L_0x0011;
    L_0x0021:
        r3 = r7.MQ();	 Catch:{ all -> 0x0053 }
        r3 = com.tencent.mm.sdk.platformtools.bi.oV(r3);	 Catch:{ all -> 0x0053 }
        r0 = r0.MQ();	 Catch:{ all -> 0x0053 }
        r0 = com.tencent.mm.sdk.platformtools.bi.oV(r0);	 Catch:{ all -> 0x0053 }
        r0 = r3.equals(r0);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0011;
    L_0x0037:
        r0 = "MicroMsg.BizKFService";
        r2 = "the same callbacker %s, return";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0053 }
        r4 = 0;
        r5 = r7.MQ();	 Catch:{ all -> 0x0053 }
        r3[r4] = r5;	 Catch:{ all -> 0x0053 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);	 Catch:{ all -> 0x0053 }
        monitor-exit(r1);	 Catch:{ all -> 0x0053 }
    L_0x004b:
        return;
    L_0x004c:
        r0 = r6.dMf;	 Catch:{ all -> 0x0053 }
        r0.add(r7);	 Catch:{ all -> 0x0053 }
    L_0x0051:
        monitor-exit(r1);	 Catch:{ all -> 0x0053 }
        goto L_0x004b;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0053 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ac.h.a(com.tencent.mm.ac.h$a):void");
    }

    public final void b(a aVar) {
        synchronized (this.dMd) {
            if (this.dMf.contains(aVar)) {
                this.dMf.remove(aVar);
            }
        }
    }

    public final void ag(String str, String str2) {
        if (bi.oW(str)) {
            x.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
            return;
        }
        g.Eh().dpP.a(new u(str, str2), 0);
        x.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[]{str, Integer.valueOf(this.dMf.size())});
    }

    public final void ah(String str, String str2) {
        if (bi.oW(str) || bi.oW(str2)) {
            x.e("MicroMsg.BizKFService", "doKFGetDefaultList error args, %s, %s", new Object[]{str, str2});
        } else if (this.dMe.contains(str2)) {
            x.i("MicroMsg.BizKFService", "doKFGetInfoList: same is running, %s", new Object[]{str2});
        } else {
            this.dMe.add(str2);
            LinkedList linkedList = new LinkedList();
            linkedList.add(str2);
            w wVar = new w(str, linkedList);
            wVar.tag = str2;
            g.Eh().dpP.a(wVar, 0);
            x.i("MicroMsg.BizKFService", "doKFGetInfoList %s, %s, %d", new Object[]{str, str2, Integer.valueOf(this.dMf.size())});
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.BizKFService", "onSceneEnd errType = %s, errCode = %s, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (lVar == null) {
            x.e("MicroMsg.BizKFService", "scene == null");
            c(null);
        } else if (i == 0 && i2 == 0) {
            x.i("MicroMsg.BizKFService", "scene.getType() = %s", new Object[]{Integer.valueOf(lVar.getType())});
            k KH = q.KH();
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = null;
            long currentTimeMillis = System.currentTimeMillis();
            LinkedList linkedList3;
            Iterator it;
            cgc cgc;
            j jVar;
            if (lVar.getType() == 672) {
                if (((v) lVar).MU() == null) {
                    x.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[]{Integer.valueOf(lVar.getType())});
                    c(null);
                    return;
                }
                linkedList3 = ((v) lVar).MU().rSr;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    x.e("MicroMsg.BizKFService", "empty workers");
                    c(null);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    cgc = (cgc) it.next();
                    linkedList.add(new g(cgc.sAB, ((v) lVar).dMD, cgc.jPM, cgc.rTW, 1, currentTimeMillis));
                    if (KH != null) {
                        jVar = new j();
                        jVar.username = cgc.sAB;
                        jVar.dHQ = cgc.jPM;
                        jVar.by(false);
                        jVar.csA = 3;
                        KH.a(jVar);
                        q.KJ().jP(cgc.sAB);
                    }
                }
                linkedList2 = linkedList3;
            } else if (lVar.getType() == 675) {
                this.dMe.remove(((w) lVar).tag);
                if (((w) lVar).MV() == null) {
                    x.e("MicroMsg.BizKFService", "KFGetInfoList resp is null, type = %s", new Object[]{Integer.valueOf(lVar.getType())});
                    c(null);
                    return;
                }
                linkedList3 = ((w) lVar).MV().rSr;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    x.e("MicroMsg.BizKFService", "empty workers");
                    c(null);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    cgc = (cgc) it.next();
                    x.i("MicroMsg.BizKFService", "onScenEnd: workers=%s, tag=%s", new Object[]{cgc.sAB, ((w) lVar).tag});
                    linkedList.add(new g(cgc.sAB, ((w) lVar).dMD, cgc.jPM, cgc.rTW, ((w) lVar).dME, currentTimeMillis));
                    if (KH != null) {
                        jVar = new j();
                        jVar.username = cgc.sAB;
                        jVar.dHQ = cgc.jPM;
                        jVar.by(false);
                        jVar.csA = 3;
                        KH.a(jVar);
                        q.KJ().jP(cgc.sAB);
                    }
                }
                linkedList2 = linkedList3;
            } else if (lVar.getType() == 674) {
                if (((u) lVar).MT() == null) {
                    x.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[]{Integer.valueOf(lVar.getType())});
                    c(null);
                    return;
                }
                linkedList3 = ((u) lVar).MT().rSr;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    x.e("MicroMsg.BizKFService", "empty workers");
                    c(null);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    cgc = (cgc) it.next();
                    linkedList.add(new g(cgc.sAB, ((u) lVar).dMD, cgc.jPM, cgc.rTW, 2, currentTimeMillis));
                    if (KH != null) {
                        jVar = new j();
                        jVar.username = cgc.sAB;
                        jVar.dHQ = cgc.jPM;
                        jVar.by(false);
                        jVar.csA = 3;
                        KH.a(jVar);
                        q.KJ().jP(cgc.sAB);
                    }
                }
                linkedList2 = linkedList3;
            }
            x.i("MicroMsg.BizKFService", "insertOrUpdateBizKFs %d", new Object[]{Integer.valueOf(z.MX().e(linkedList))});
            c(linkedList2);
        } else {
            x.e("MicroMsg.BizKFService", "scene.getType() = %s", new Object[]{Integer.valueOf(lVar.getType())});
            c(null);
            if (lVar.getType() == 675) {
                this.dMe.remove(((w) lVar).tag);
            }
        }
    }

    private void c(LinkedList<cgc> linkedList) {
        synchronized (this.dMd) {
            ArrayList arrayList = new ArrayList(this.dMf);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    a aVar = (a) arrayList.get(i2);
                    if (aVar != null) {
                        aVar.d(linkedList);
                    }
                    i = i2 + 1;
                }
            }
        }
    }
}

package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.g.d;
import com.tencent.mm.plugin.sns.g.e;
import com.tencent.mm.plugin.sns.g.f;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.protocal.c.boi;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class ad {
    String cXR = "";
    private d npq;
    private List<Integer> npr = new Vector();
    private Map<String, Integer> nps = new HashMap();
    private List<Integer> npt = new Vector();
    private Map<Integer, Integer> npu = new HashMap();
    private String path;

    public static boolean Mg(String str) {
        if (str != null && str.startsWith("_AD_TAG_")) {
            return true;
        }
        return false;
    }

    public ad(String str) {
        this.path = str;
        if (!bxR()) {
            this.npq = new d();
        }
        this.npr.clear();
        this.nps.clear();
    }

    public final synchronized void bxP() {
        if (!af(this.npq.nuS)) {
            if (!af(this.npq.nuT) && !af(this.npq.nuU) && !af(this.npq.nuV)) {
                f fVar;
                long j;
                while (!this.npq.nuW.isEmpty()) {
                    fVar = (f) this.npq.nuW.getFirst();
                    if (bi.bG((long) fVar.nuZ) <= 21600) {
                        j = fVar.nvb;
                        g.Ek();
                        g.Eh().dpP.a(new r(j, 1), 0);
                        break;
                    }
                    this.npq.nuW.removeFirst();
                }
                while (!this.npq.nuX.isEmpty()) {
                    fVar = (f) this.npq.nuX.getFirst();
                    if (bi.bG((long) fVar.nuZ) <= 21600) {
                        j = fVar.nvb;
                        g.Ek();
                        g.Eh().dpP.a(new r(j, 5), 0);
                        break;
                    }
                    this.npq.nuX.removeFirst();
                }
            }
        }
    }

    private static boolean af(LinkedList<e> linkedList) {
        while (!linkedList.isEmpty()) {
            e eVar = (e) linkedList.getFirst();
            if (bi.bG((long) eVar.nuZ) > 21600) {
                linkedList.removeFirst();
            } else {
                if (Mg(eVar.nuY)) {
                    g.Ek();
                    g.Eh().dpP.a(new k(eVar.nnO, eVar.nuY, eVar.nva), 0);
                } else {
                    g.Ek();
                    g.Eh().dpP.a(new o(eVar.nnO, eVar.nuY), 0);
                }
                return true;
            }
        }
        return false;
    }

    public final synchronized boolean eR(long j) {
        boolean z;
        Iterator it = this.npq.nuW.iterator();
        while (it.hasNext()) {
            if (((f) it.next()).nvb == j) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    public final synchronized void eS(long j) {
        f fVar = new f();
        fVar.nvb = j;
        fVar.nuZ = (int) bi.VE();
        this.npq.nuW.add(fVar);
        bxQ();
    }

    final synchronized void eT(long j) {
        Object obj;
        Iterator it = this.npq.nuW.iterator();
        while (it.hasNext()) {
            obj = (f) it.next();
            if (obj.nvb == j) {
                break;
            }
        }
        obj = null;
        if (obj != null) {
            this.npq.nuW.remove(obj);
        }
        bxQ();
    }

    private static boolean a(LinkedList<bon> linkedList, String str, int i) {
        if (bi.oW(str)) {
            return true;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bon bon = (bon) it.next();
            if (str.equals(bon.jSA) && i == bon.lOH) {
                return true;
            }
        }
        return false;
    }

    public final synchronized boy c(boy boy) {
        if (bi.oW(this.cXR)) {
            this.cXR = q.GF();
        }
        if (!(this.npq.nuS.size() == 0 && this.npq.nuT.size() == 0)) {
            e eVar;
            bon bon;
            long j = boy.rlK;
            Iterator it = this.npq.nuS.iterator();
            while (it.hasNext()) {
                eVar = (e) it.next();
                bon a = a(eVar.nnO);
                if (eVar.nnO.rlK == j && !a(boy.smL, a.jSA, a.lOH)) {
                    boy.smL.add(a);
                    boy.smJ++;
                }
            }
            Iterator it2 = boy.smL.iterator();
            while (it2.hasNext()) {
                bon = (bon) it2.next();
                if (bon.rdS.equals(this.cXR)) {
                    Object obj = null;
                    Iterator it3 = this.npq.nuX.iterator();
                    while (it3.hasNext()) {
                        Object obj2;
                        if (((f) it3.next()).nvb == j) {
                            boy.smL.remove(bon);
                            boy.smJ--;
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                    if (obj != null) {
                        break;
                    }
                }
            }
            it = this.npq.nuT.iterator();
            while (it.hasNext()) {
                eVar = (e) it.next();
                if (eVar.nnO.rlK == j) {
                    bon = a(eVar.nnO);
                    if (!a(boy.smO, bon.jSA, bon.lOH)) {
                        boy.smO.add(bon);
                        boy.smM++;
                    }
                }
            }
        }
        return boy;
    }

    public static bon a(boi boi) {
        boh boh = boi.smo;
        boh boh2 = boi.smp;
        bon bon = new bon();
        bon.jSA = boh.jSA;
        bon.lOH = boh.lOH;
        bon.rTW = boh.sme;
        bon.rdq = boh.rdq;
        bon.hcE = boh.hcE;
        bon.rdS = boh.seC;
        bon.smh = boh.smh;
        bon.smk = boh.smk;
        bon.smm = boh.smm;
        bon.smB = boh2.seC;
        bon.smj = boh2.smj;
        bon.smg = boh2.smg;
        return bon;
    }

    public final boolean a(String str, boi boi) {
        return a(str, boi, "");
    }

    public final synchronized boolean a(String str, boi boi, String str2) {
        boolean z = true;
        synchronized (this) {
            e eVar = new e();
            eVar.nuY = str;
            eVar.nnO = boi;
            eVar.nuZ = (int) bi.VE();
            eVar.nva = str2;
            switch (boi.smo.hcE) {
                case 1:
                    this.npq.nuS.add(eVar);
                    if (eV(boi.rlK)) {
                        z = false;
                        break;
                    }
                    break;
                case 2:
                    this.npq.nuT.add(eVar);
                    break;
                case 3:
                    this.npq.nuU.add(eVar);
                    break;
                case 5:
                    this.npq.nuV.add(eVar);
                    break;
                case 7:
                    this.npq.nuS.add(eVar);
                    if (eV(boi.rlK)) {
                        z = false;
                        break;
                    }
                    break;
                case 8:
                    this.npq.nuT.add(eVar);
                    break;
            }
            if (!bxQ()) {
                x.e("MicroMsg.SnsAsyncQueueMgr", "error listToFile");
            }
        }
        return z;
    }

    public final void d(long j, int i, String str) {
        aj.byG();
        e(j, i, str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void e(long r2, int r4, java.lang.String r5) {
        /*
        r1 = this;
        monitor-enter(r1);
        switch(r4) {
            case 1: goto L_0x0009;
            case 2: goto L_0x0014;
            case 3: goto L_0x002c;
            case 4: goto L_0x0004;
            case 5: goto L_0x0034;
            case 6: goto L_0x0004;
            case 7: goto L_0x001c;
            case 8: goto L_0x0024;
            default: goto L_0x0004;
        };
    L_0x0004:
        r1.bxQ();	 Catch:{ all -> 0x0011 }
        monitor-exit(r1);
        return;
    L_0x0009:
        r0 = r1.npq;	 Catch:{ all -> 0x0011 }
        r0 = r0.nuS;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x0011:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x0014:
        r0 = r1.npq;	 Catch:{ all -> 0x0011 }
        r0 = r0.nuT;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x001c:
        r0 = r1.npq;	 Catch:{ all -> 0x0011 }
        r0 = r0.nuS;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x0024:
        r0 = r1.npq;	 Catch:{ all -> 0x0011 }
        r0 = r0.nuT;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x002c:
        r0 = r1.npq;	 Catch:{ all -> 0x0011 }
        r0 = r0.nuU;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x0034:
        r0 = r1.npq;	 Catch:{ all -> 0x0011 }
        r0 = r0.nuV;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.ad.e(long, int, java.lang.String):void");
    }

    private static void a(long j, LinkedList<e> linkedList, String str) {
        a(j, linkedList, str, false);
    }

    private static boolean a(long j, LinkedList<e> linkedList, String str, boolean z) {
        Object obj;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            obj = (e) it.next();
            if (obj.nnO.rlK == j && (z || obj.nuY.equals(str))) {
                break;
            }
        }
        obj = null;
        if (obj == null) {
            return false;
        }
        linkedList.remove(obj);
        return true;
    }

    public final synchronized boolean eU(long j) {
        boolean z = true;
        synchronized (this) {
            f fVar = new f();
            fVar.nvb = j;
            fVar.nuZ = (int) bi.VE();
            this.npq.nuX.add(fVar);
            bxQ();
            if (a(j, this.npq.nuS, "", true)) {
                z = false;
            }
        }
        return z;
    }

    final synchronized boolean eV(long j) {
        boolean z;
        Object obj;
        Iterator it = this.npq.nuX.iterator();
        while (it.hasNext()) {
            obj = (f) it.next();
            if (obj.nvb == j) {
                break;
            }
        }
        obj = null;
        if (obj != null) {
            this.npq.nuX.remove(obj);
            z = true;
        } else {
            z = false;
        }
        bxQ();
        return z;
    }

    private synchronized boolean bxQ() {
        boolean z = false;
        synchronized (this) {
            try {
                byte[] toByteArray = this.npq.toByteArray();
                if (FileOp.b(this.path, toByteArray, toByteArray.length) == 0) {
                    z = true;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", e, "listToFile failed: " + this.path, new Object[0]);
                FileOp.deleteFile(this.path);
            }
        }
        return z;
    }

    private synchronized boolean bxR() {
        boolean z;
        byte[] e = FileOp.e(this.path, 0, -1);
        if (e == null) {
            z = false;
        } else {
            try {
                this.npq = (d) new d().aG(e);
                z = true;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", e2, "", new Object[0]);
                FileOp.deleteFile(this.path);
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean wq(int i) {
        return this.npr.contains(Integer.valueOf(i));
    }

    public final synchronized boolean wr(int i) {
        boolean z;
        if (this.npr.contains(Integer.valueOf(i))) {
            z = false;
        } else {
            this.npr.add(Integer.valueOf(i));
            z = true;
        }
        return z;
    }

    public final synchronized boolean ws(int i) {
        this.npr.remove(Integer.valueOf(i));
        return true;
    }

    public final synchronized boolean isDownloading(String str) {
        return this.nps.containsKey(str);
    }

    public final synchronized boolean Mh(String str) {
        boolean z = false;
        synchronized (this) {
            if (!this.nps.containsKey(str)) {
                this.nps.put(str, Integer.valueOf(0));
                z = true;
            }
        }
        return z;
    }

    public final synchronized boolean Mi(String str) {
        this.nps.remove(str);
        return true;
    }

    public final synchronized int bxS() {
        return this.nps.size();
    }

    public final synchronized boolean wt(int i) {
        boolean z;
        if (this.npt.contains(Integer.valueOf(i))) {
            z = false;
        } else {
            this.npt.add(Integer.valueOf(i));
            z = true;
        }
        return z;
    }

    public final synchronized boolean wu(int i) {
        this.npt.remove(Integer.valueOf(i));
        this.npu.remove(Integer.valueOf(i));
        return true;
    }

    public final synchronized boolean du(int i, int i2) {
        this.npu.put(Integer.valueOf(i), Integer.valueOf(i2));
        return true;
    }

    public final synchronized boolean wv(int i) {
        this.npu.remove(Integer.valueOf(i));
        return true;
    }

    public final synchronized int ww(int i) {
        int intValue;
        if (this.npu.containsKey(Integer.valueOf(i))) {
            intValue = ((Integer) this.npu.get(Integer.valueOf(i))).intValue();
        } else {
            intValue = -1;
        }
        return intValue;
    }
}

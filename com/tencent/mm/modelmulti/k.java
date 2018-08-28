package com.tencent.mm.modelmulti;

import android.os.PowerManager;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.a.ql;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.s$a;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class k extends l implements com.tencent.mm.network.k {
    private static boolean dZK = false;
    private static int dZN = 0;
    protected static int selector = 7;
    public String TAG;
    private String Yy;
    private al dHa;
    private int dYV;
    private a dYW;
    private long dYY;
    private boolean dYZ;
    public q dZJ;
    private boolean dZL;
    private al dZM;
    private int dZO;
    private boolean dZP;
    private String dZQ;
    public b dZR;
    private long dZS;
    private boolean dZm;
    private e diJ;
    private int errCode;
    private int errType;

    public k(int i) {
        this.TAG = "MicroMsg.NetSceneSync";
        this.errType = 0;
        this.errCode = 0;
        this.Yy = "";
        this.dZJ = null;
        this.dZL = false;
        this.dYV = 0;
        this.dHa = null;
        this.dZM = null;
        this.dYY = -1;
        this.dYZ = false;
        this.dZP = false;
        this.dZm = false;
        this.dZQ = "";
        this.dZR = null;
        this.dZS = 0;
        this.TAG += "[" + hashCode() + "]";
        x.i(this.TAG, "dkpush NetSceneSync scene:%d stack:%s", new Object[]{Integer.valueOf(i), bi.cjd()});
        this.dZQ = aj.cin();
        this.dYW = new a();
        if (this.dZJ == null) {
            this.dZJ = new q();
        }
        this.dZJ.eaS = i;
        g.Ek();
        if (g.Ei() != null && g.Eg().Dx()) {
            g.Ek();
            if (!(g.Ei().DT() == null || com.tencent.mm.kernel.a.Dr())) {
                g.Ek();
                long a = bi.a((Long) g.Ei().DT().get(8196, null), 0);
                if (a != 0) {
                    g.Ek();
                    g.Ei().DT().set(8196, Long.valueOf(0));
                    int i2 = (int) (a | ((long) selector));
                    selector = i2;
                    selector = i2 & 95;
                }
            }
        }
        if (i == 1) {
            dZK = true;
        }
        if (i == 1010) {
            selector |= 16;
            dZK = true;
            this.dZO = 7;
        } else if (i == 1011) {
            selector |= 64;
            dZK = true;
            this.dZO = 7;
        } else if (i == 3) {
            selector |= 262144;
            dZK = true;
            this.dZO = 3;
            x.i(this.TAG, "summerbadcr NetSceneSync aiScene[%d], selector[%d], syncScene[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(selector), Integer.valueOf(this.dZO)});
        } else {
            this.dZO = i;
        }
        if (dZN == 0) {
            PH();
        }
    }

    public k(b bVar, int i, long j) {
        this(8);
        this.dZQ = aj.cin();
        x.i(this.TAG, "dkpush NOTIFYDATA resp size:%d pushSyncFlag:%d  recvTime:%d", new Object[]{Long.valueOf(bVar.bufferSize), Integer.valueOf(i), Long.valueOf(j)});
        this.dYV = i;
        this.dYY = j;
        this.dHa = new al(g.Em().lnJ.getLooper(), new 1(this, bVar), false);
        if (dZN == 0) {
            PH();
        }
    }

    protected final boolean a(l lVar) {
        boolean z = true;
        if (!(lVar instanceof k)) {
            return false;
        }
        k kVar = (k) lVar;
        if (kVar.dZL || !dZK) {
            return false;
        }
        x.e(this.TAG, "old not busy and notified, maybe cancel old scene, last dispatch=%d", new Object[]{Long.valueOf(kVar.dIY)});
        if (bi.bI(kVar.dIY) <= 360000) {
            z = false;
        }
        if (z) {
            x.i(this.TAG, "summerworker NetSceneSync timeout");
            Runnable findTaskByRunTime = g.Em().cil().findTaskByRunTime(0);
            if (findTaskByRunTime != null) {
                x.e(this.TAG, "summerworker worker is just blocked by task: " + ag.dump(findTaskByRunTime, false));
                return false;
            }
        }
        return z;
    }

    public final boolean KX() {
        return true;
    }

    protected final int Cc() {
        return 100;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    public final boolean KY() {
        int i = 1;
        boolean KY = super.KY();
        if (KY) {
            f.mDy.a(99, 228, 1, false);
            f fVar = f.mDy;
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(0);
            objArr[5] = Integer.valueOf(0);
            objArr[6] = Integer.valueOf(0);
            if (!com.tencent.mm.sdk.a.b.foreground) {
                i = 2;
            }
            objArr[7] = Integer.valueOf(i);
            objArr[8] = "9999";
            fVar.h(12063, objArr);
        }
        return KY;
    }

    public final int getType() {
        return 138;
    }

    protected final void cancel() {
        super.cancel();
        f.mDy.a(99, 229, 1, false);
        this.dZm = true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (l.PJ()) {
            dZN = 0;
            x.e(this.TAG, "dkinit never do sync before init done");
            return -1;
        }
        this.diJ = eVar2;
        if (this.dZJ == null) {
            this.dZJ = new q();
        }
        this.dZJ.eaR = com.tencent.mm.sdk.a.b.foreground;
        if (this.dZM != null) {
            x.i(this.TAG, "pushSyncRespHandler not null");
            c(eVar);
            this.dZM.J(0, 0);
            return 0;
        } else if (dZN > 0) {
            x.w(this.TAG, "other sync is dealing with resp data :%d", new Object[]{Integer.valueOf(dZN)});
            return -1;
        } else if (this.dHa != null) {
            x.i(this.TAG, "pusher not null");
            c(eVar);
            this.dHa.J(0, 0);
            return 0;
        } else {
            a aVar = new a();
            awd awd = ((s$a) aVar.KV()).qWW;
            if (this.dZO == 3) {
                awd.rZw = 1;
            } else {
                awd.rZw = 0;
            }
            this.dZO = this.dZP ? 6 : this.dZO;
            awd.rnx = selector;
            g.Ek();
            awd.rny = ab.O(bi.WP(bi.oV((String) g.Ei().DT().get(8195, new byte[0]))));
            awd.otY = this.dZO;
            awd.rZv = new pn();
            awd.reT = d.DEVICE_TYPE;
            x.i(this.TAG, "doScene Selector:%d Scene:%d key[%s]", new Object[]{Integer.valueOf(awd.rnx), Integer.valueOf(awd.otY), z.bp(r0)});
            dZK = false;
            return a(eVar, aVar, this);
        }
    }

    private boolean PH() {
        PInt pInt = new PInt();
        g.Ek();
        g.Eg();
        byte[] a = com.tencent.mm.booter.f.a(pInt, com.tencent.mm.kernel.a.Df());
        String str = this.TAG;
        String str2 = "dealWithRespData index:%d, hashcode:%d, buf.len:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(pInt.value);
        objArr[1] = Integer.valueOf(hashCode());
        objArr[2] = Integer.valueOf(a != null ? a.length : 0);
        x.i(str, str2, objArr);
        dZN = pInt.value;
        if (pInt.value == 0 || bi.bC(a)) {
            dZN = 0;
            return false;
        }
        b bVar = new b();
        try {
            bVar.G(a);
            this.dZM = new al(g.Em().lnJ.getLooper(), new 2(this, new a(bVar)), false);
            return true;
        } catch (Exception e) {
            f.mDy.a(99, 226, 1, false);
            x.e(this.TAG, "dealWithRespData SyncResp fromProtoBuf failed");
            int i = dZN;
            g.Ek();
            g.Eg();
            com.tencent.mm.booter.f.aO(i, com.tencent.mm.kernel.a.Df());
            dZN = 0;
            return false;
        } catch (Error e2) {
            long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
            long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
            x.i(this.TAG, "dealWithRespData memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", new Object[]{Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory)});
            Assert.assertTrue("dealWithRespData error", false);
            return false;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        String str2;
        if (qVar == null || qVar.getType() != 138) {
            int i4;
            String str3 = this.TAG;
            str2 = "onGYNetEnd error type:%d";
            Object[] objArr = new Object[1];
            if (qVar == null) {
                i4 = -2;
            } else {
                i4 = qVar.getType();
            }
            objArr[0] = Integer.valueOf(i4);
            x.e(str3, str2, objArr);
            return;
        }
        boolean z;
        b bVar = (b) qVar.Id();
        str2 = this.TAG;
        String str4 = "onGYNetEnd:[%d,%d,%s] time:%d  isnotifydata:%b count:%d pusher:%s pushSyncRespHandler:%s ";
        Object[] objArr2 = new Object[8];
        objArr2[0] = Integer.valueOf(i2);
        objArr2[1] = Integer.valueOf(i3);
        objArr2[2] = str;
        objArr2[3] = Long.valueOf(this.dYW.Ad());
        objArr2[4] = Boolean.valueOf(this.dYZ);
        objArr2[5] = Integer.valueOf(bVar.qWX.rnB == null ? -1 : bVar.qWX.rnB.hbF);
        objArr2[6] = this.dHa;
        objArr2[7] = this.dZM;
        x.i(str2, str4, objArr2);
        Object obj = (bVar.qWX.rnB == null ? -1 : bVar.qWX.rnB.hbF) > 0 ? 1 : null;
        if (!PI()) {
            f.mDy.a(99, obj != null ? 221 : 218, 1, false);
        } else if (com.tencent.mm.sdk.a.b.foreground) {
            f.mDy.a(99, obj != null ? 219 : 216, 1, false);
        } else {
            f.mDy.a(99, obj != null ? 220 : 217, 1, false);
        }
        this.dHa = null;
        this.dZL = true;
        if (i2 == 4 && i3 == -2006) {
            z = true;
            i2 = 0;
            i3 = 0;
            f.mDy.a(99, 227, 1, false);
        } else {
            z = false;
        }
        if (i2 == 0 && i3 == 0) {
            f.mDy.a(99, 233, 1, false);
            byte[] a = ab.a(((s$a) qVar.KV()).qWW.rny);
            byte[] a2 = ab.a(bVar.qWX.rny);
            x.i(this.TAG, "onGYNetEnd replace key:%b req :%s", new Object[]{Boolean.valueOf(z), z.bp(a)});
            x.i(this.TAG, "onGYNetEnd replace key:%b resp:%s", new Object[]{Boolean.valueOf(z), z.bp(a2)});
            if (!z) {
                if (bi.bC(a)) {
                    g.Ek();
                    a = bi.WP(bi.oV((String) g.Ei().DT().get(8195, new byte[0])));
                    x.d(this.TAG, "dkpush userinfo key : %d[%s]", new Object[]{Integer.valueOf(a.length), bi.bB(a)});
                }
                a = z.g(a, a2);
                if (a == null || a.length <= 0) {
                    x.w(this.TAG, "merge key failed, use server side instead");
                    a = a2;
                }
                bVar.qWX.rny = ab.O(a);
            }
            g.Ek();
            g.Eg().aW(bVar.qWX.hcd, bVar.qWX.rZx);
            g.Ek();
            g.Eg();
            com.tencent.mm.kernel.a.gH(bVar.qWX.hcd);
            Assert.assertTrue(this.dZR == null);
            this.dZR = bVar;
            this.dZS = bi.VF();
            new al(g.Em().lnJ.getLooper(), new 3(this), true).J(50, 50);
            return;
        }
        if (this.dZR != null) {
            x.i(this.TAG, "oreh sync mIRH.processingResp is not null, and simulate not continue");
            this.errType = i2;
            this.errCode = i3;
            this.Yy = str;
            ((b) qVar.Id()).qWX.rlm = 0;
        } else {
            this.diJ.a(i2, i3, str, this);
        }
        f.mDy.a(99, 232, 1, false);
    }

    protected final void a(b bVar) {
        g.Ek();
        g.Ei().DT().set(8195, bi.bE(ab.a(bVar.qWX.rny)));
        ad.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", bi.bE(ab.a(bVar.qWX.rny))).commit();
        g.Ek();
        g.Ei().DT().set(8196, Long.valueOf((long) bVar.qWX.rlm));
        boolean z = ((bVar.qWX.rlm & selector) == 0 || super.KY()) ? false : true;
        x.i(this.TAG, "canContinue cont:%b ContinueFlag:%d selector:%d securityLimitCountReach:%b", new Object[]{Boolean.valueOf(z), Integer.valueOf(bVar.qWX.rlm), Integer.valueOf(selector), Boolean.valueOf(super.KY())});
        if (!(z || (bVar.qWX.rlm & 256) == 0)) {
            com.tencent.mm.sdk.b.a.sFg.m(new ql());
        }
        if (!(z || (bVar.qWX.rlm & 2097152) == 0)) {
            com.tencent.mm.sdk.b.a.sFg.m(new li());
        }
        f.mDy.a(99, z ? 234 : 235, 1, false);
        x.i(this.TAG, "onRespHandled continueFlag:%d isNotifyData:%b conCont:%b notifyPending:%b pushSyncFlag:%d isContinueScene:%b respHandler:%s ", new Object[]{Integer.valueOf(bVar.qWX.rlm), Boolean.valueOf(this.dYZ), Boolean.valueOf(z), Boolean.valueOf(dZK), Integer.valueOf(this.dYV), Boolean.valueOf(this.dZP), this.dZM});
        int i;
        if (!this.dYZ && z) {
            this.dZP = true;
            a(this.dIX, this.diJ);
        } else if (dZK) {
            x.i(this.TAG, "dkpush new notify pending, sync now");
            if (dZN != 0) {
                i = dZN;
                g.Ek();
                g.Eg();
                com.tencent.mm.booter.f.aO(i, com.tencent.mm.kernel.a.Df());
            }
            dZN = 0;
            this.dZM = null;
            dZK = false;
            this.dZP = true;
            a(this.dIX, this.diJ);
        } else if (this.dZM != null) {
            i = dZN;
            g.Ek();
            g.Eg();
            com.tencent.mm.booter.f.aO(i, com.tencent.mm.kernel.a.Df());
            this.dZM = null;
            PH();
            a(this.dIX, this.diJ);
        } else {
            if ((this.dYV & 1) > 0) {
                g.Ek();
                g.DF().a(new g(this.dYY, bi.WP(bi.oV((String) g.Ei().DT().get(8195, null)))), 0);
            }
            x.d(this.TAG, "sync or init end: reset selector : now = " + selector + " default = 7");
            selector = 7;
            this.diJ.a(this.errType, this.errCode, this.Yy, this);
        }
    }

    private boolean PI() {
        try {
            return ((Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) ad.getContext().getSystemService("power"), new Object[0])).booleanValue();
        } catch (Throwable e) {
            x.e(this.TAG, "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[]{Boolean.valueOf(true), bi.i(e)});
            return true;
        }
    }
}

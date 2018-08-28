package com.tencent.mm.modelmulti;

import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.a.ql;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class p {
    private static Boolean eas = null;
    private WakerLock cWW = null;
    public Queue<c> eat = new LinkedList();
    public Queue<c> eau = new LinkedList();
    private HashMap<c, Long> eav = new HashMap();
    public c eaw = null;
    private long eax = 0;

    interface b {
        boolean ie(int i);
    }

    private static boolean FJ() {
        if (a.Dr() || !g.Eg().Dx()) {
            return false;
        }
        if (eas != null) {
            return eas.booleanValue();
        }
        eas = Boolean.valueOf(true);
        return true;
    }

    private static void assertTrue(String str, boolean z) {
        if (!z) {
            x.e("MicroMsg.SyncService", "ASSERT now msg:%s", new Object[]{str});
            Assert.assertTrue(str, z);
        }
    }

    public final int a(long j, int i, String str) {
        int i2 = 0;
        x.i("MicroMsg.SyncService", "dealWithSelectoru checkUse:%s selector:%d aiScene:%d xml:%s [%s] ", new Object[]{Boolean.valueOf(FJ()), Long.valueOf(j), Integer.valueOf(i), str, bi.cjd()});
        if ((256 & j) != 0) {
            com.tencent.mm.sdk.b.a.sFg.m(new ql());
        }
        if ((2097152 & j) != 0) {
            com.tencent.mm.sdk.b.a.sFg.m(new li());
        }
        long j2 = ((-257 & j) & -2097153) & 95;
        if (j2 != 0 && g.Eg().Dx()) {
            g.Ek();
            if (g.Ei().DT() != null) {
                g.Ek();
                g.Ei().DT().set(8196, Long.valueOf(j2));
                if (r1) {
                    i2 = e(i, 7, false);
                } else {
                    k kVar = new k(i);
                    x.i("MicroMsg.SyncService", "dealWithSelector syncHash: %d", new Object[]{Integer.valueOf(kVar.hashCode())});
                    g.Ek();
                    if (g.Eh().dpP.a(kVar, 0)) {
                        i2 = r1;
                    } else {
                        x.w("MicroMsg.SyncService", "dealWithSelector doScene failed, hash: %d, zero hash will be return.", new Object[]{Integer.valueOf(r1)});
                    }
                }
            }
        }
        if (!bi.oW(str)) {
            ah ahVar = new ah();
            ahVar.bHy.type = 3;
            ahVar.bHy.bHA = str;
            com.tencent.mm.sdk.b.a.sFg.m(ahVar);
        }
        return i2;
    }

    public final void a(com.tencent.mm.protocal.s.b bVar, int i, long j) {
        x.i("MicroMsg.SyncService", "triggerNotifyDataSync checkUse:%s resp:%s syncflag:%s recvtime:%s [%s]", new Object[]{Boolean.valueOf(FJ()), bVar, Integer.valueOf(i), Long.valueOf(j), bi.cjd()});
        if (FJ()) {
            a(new f(this, bVar, i, j));
            return;
        }
        g.Ek();
        g.Eh().dpP.a(new k(bVar, i, j), 0);
    }

    public final int id(int i) {
        x.i("MicroMsg.SyncService", "triggerSync checkUse:%s scene:%s [%s]", new Object[]{Boolean.valueOf(FJ()), Integer.valueOf(i), bi.cjd()});
        if (FJ()) {
            return e(i, 7, false);
        }
        k kVar = new k(i);
        g.Ek();
        g.Eh().dpP.a(kVar, 0);
        return kVar.hashCode();
    }

    private int e(int i, int i2, boolean z) {
        c eVar = new e(this, i, i2, z);
        a(eVar);
        return eVar.hashCode();
    }

    private synchronized void mo(String str) {
        boolean z = true;
        synchronized (this) {
            x.i("MicroMsg.SyncService", "wakelock tag:%s syncWakerLock:%s [%s]", new Object[]{str, this.cWW, bi.cjd()});
            if (this.cWW == null) {
                this.cWW = new WakerLock(ad.getContext(), "MicroMsg.SyncService", new 1(this));
            }
            String str2 = "lock";
            if (this.cWW.isLocking()) {
                z = false;
            }
            assertTrue(str2, z);
            if (!com.tencent.mm.sdk.a.b.foreground) {
                this.cWW.lock(30000, str);
            }
        }
    }

    private synchronized void PP() {
        if (this.cWW == null || !this.cWW.isLocking()) {
            String str;
            String str2 = "MicroMsg.SyncService";
            String str3 = "wakeUnlock syncWakerLock locking?:%s foreground:%s";
            Object[] objArr = new Object[2];
            if (this.cWW == null) {
                str = "null";
            } else {
                str = Boolean.valueOf(this.cWW.isLocking());
            }
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground);
            x.w(str2, str3, objArr);
        } else {
            this.cWW.unLock();
        }
    }

    private void a(final c cVar) {
        if (l.PJ()) {
            x.e("MicroMsg.SyncService", "tryStart dkinit never do sync before init done :%s ", new Object[]{cVar});
            return;
        }
        g.Em().H(new Runnable() {
            public final void run() {
                if (cVar != null) {
                    if (cVar instanceof f) {
                        p.this.eau.add(cVar);
                    } else {
                        p.this.eat.add(cVar);
                    }
                }
                g.Em().H(new 3(p.this, null));
            }
        });
    }

    private static boolean PI() {
        try {
            return ((Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) ad.getContext().getSystemService("power"), new Object[0])).booleanValue();
        } catch (Throwable e) {
            f.mDy.a(99, 45, 1, false);
            x.e("MicroMsg.SyncService", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[]{Boolean.valueOf(true), bi.i(e)});
            return true;
        }
    }
}

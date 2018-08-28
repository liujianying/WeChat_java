package com.tencent.mm.plugin.j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.bm;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.j.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.HashSet;

public final class b implements c, com.tencent.mm.kernel.b.c {
    private static HashMap<Integer, d> hsC;
    private static b hsF;
    private a dYI = new 10(this);
    private com.tencent.mm.plugin.j.b.b hsD;
    private u.a hsE;
    private ah hsG;
    private com.tencent.mm.plugin.j.c.c hsH = null;
    public HashSet<Long> hsI = new HashSet();
    public boolean hsJ = false;
    private boolean hsK = false;
    public com.tencent.mm.plugin.j.c.c hsL = null;
    com.tencent.mm.plugin.j.c.b hsM = null;
    private HashMap<Integer, com.tencent.mm.plugin.j.a.a> hsN = new HashMap();
    private com.tencent.mm.plugin.j.c.c.a hsO = new 6(this);
    private com.tencent.mm.plugin.j.c.c.a hsP = new 9(this);
    private com.tencent.mm.sdk.b.c<cd> hsQ = new 11(this);
    private boolean hsR = false;
    private boolean hsS = true;
    private BroadcastReceiver hsT;
    private Runnable hsU;
    private boolean hsV = false;
    private com.tencent.mm.sdk.b.c<bm> hsW = new 3(this);

    static /* synthetic */ boolean e(b bVar) {
        return (bVar.hsK || !bVar.hsR || bVar.hsS) ? false : true;
    }

    static {
        HashMap hashMap = new HashMap();
        hsC = hashMap;
        hashMap.put(Integer.valueOf("WXFILEINDEX_TABLE".hashCode()), new 1());
    }

    public static synchronized b avr() {
        b bVar;
        synchronized (b.class) {
            if (hsF == null) {
                hsF = new b();
            }
            bVar = hsF;
        }
        return bVar;
    }

    public final com.tencent.mm.plugin.j.b.b avs() {
        if (this.hsD == null) {
            this.hsD = new com.tencent.mm.plugin.j.b.b(this.hsE);
        }
        return this.hsD;
    }

    /* renamed from: j */
    public final void a(Runnable runnable) {
        if (this.hsG != null) {
            this.hsG.H(runnable);
            return;
        }
        x.w("MicroMsg.CalcWxService", "%s post runnable but thread is null ", new Object[]{avy()});
    }

    public final void dN(boolean z) {
        boolean z2 = false;
        String str = "MicroMsg.CalcWxService";
        String str2 = "%s manual scan now manualScanTask[%b] uiClick[%b]";
        Object[] objArr = new Object[3];
        objArr[0] = avy();
        if (this.hsL != null) {
            z2 = true;
        }
        objArr[1] = Boolean.valueOf(z2);
        objArr[2] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        a(new 4(this, z));
    }

    private void atI() {
        a(new 8(this));
    }

    public final void onAccountInitialized(e.c cVar) {
        x.i("MicroMsg.CalcWxService", "%s CalcWxService Initialized", new Object[]{avy()});
        if (this.hsG == null) {
            x.i("MicroMsg.CalcWxService", "%s init calc wx thread", new Object[]{avy()});
            this.hsG = new ah("calc-wx");
        }
        this.hsE = u.a(hashCode(), g.Ei().cachePath + "WxFileIndex.db", hsC, true);
        this.hsN.put(Integer.valueOf(43), new com.tencent.mm.plugin.j.a.e());
        this.hsN.put(Integer.valueOf(62), new com.tencent.mm.plugin.j.a.e());
        this.hsN.put(Integer.valueOf(44), new com.tencent.mm.plugin.j.a.e());
        this.hsN.put(Integer.valueOf(34), new f());
        this.hsN.put(Integer.valueOf(3), new com.tencent.mm.plugin.j.a.d());
        this.hsN.put(Integer.valueOf(49), new com.tencent.mm.plugin.j.a.c());
        this.hsN.put(Integer.valueOf(268435505), new com.tencent.mm.plugin.j.a.b());
        avt();
        ((i) g.l(i.class)).bcY().a(this.dYI, null);
        com.tencent.mm.sdk.b.a.sFg.a(this.hsQ);
        Context context = ad.getContext();
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            boolean z = intExtra == 2 || intExtra == 5;
            this.hsR = z;
        } else {
            this.hsR = false;
        }
        this.hsS = ((PowerManager) context.getSystemService("power")).isScreenOn();
        this.hsT = new 2(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.registerReceiver(this.hsT, intentFilter);
        com.tencent.mm.sdk.b.a.sFg.a(this.hsW);
        if (this.hsV) {
            com.tencent.mm.sdk.b.a.sFg.m(new bm());
        }
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.CalcWxService", "CalcWxService Release");
        this.hsI.clear();
        this.hsJ = false;
        if (this.hsE != null) {
            this.hsE.iQ(hashCode());
            this.hsE = null;
        }
        ((i) g.l(i.class)).bcY().a(this.dYI);
        com.tencent.mm.sdk.b.a.sFg.c(this.hsQ);
        this.hsN.clear();
        if (this.hsT != null) {
            ad.getContext().unregisterReceiver(this.hsT);
            this.hsT = null;
        }
        if (this.hsU != null) {
            au.Em();
            ah.M(this.hsU);
            this.hsU = null;
        }
        atI();
        if (this.hsG != null) {
            x.i("MicroMsg.CalcWxService", "%s quit calc wx thread", new Object[]{avy()});
            this.hsG.lnJ.quit();
        }
        this.hsG = null;
        com.tencent.mm.sdk.b.a.sFg.c(this.hsW);
    }

    public static long avt() {
        long longValue = ((Long) g.Ei().DT().get(aa.a.sYj, Long.valueOf(-1))).longValue();
        if (longValue > -1) {
            return longValue;
        }
        longValue = ((i) g.l(i.class)).bcY().He("message");
        g.Ei().DT().a(aa.a.sYj, Long.valueOf(longValue));
        return longValue;
    }

    public final boolean avu() {
        boolean z = avw() >= avt();
        x.i("MicroMsg.CalcWxService", "%d scan finish [%d %d %b]", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(avt()), Long.valueOf(avw()), Boolean.valueOf(z)});
        if (z && ((Long) g.Ei().DT().get(aa.a.sYm, Long.valueOf(0))).longValue() <= 0) {
            g.Ei().DT().a(aa.a.sYm, Long.valueOf(bi.VE()));
        }
        return z;
    }

    public final void avv() {
        this.hsJ = false;
        this.hsI.clear();
        x.d("MicroMsg.CalcWxService", "%d unlock msg change [%s]", new Object[]{Integer.valueOf(hashCode()), bi.cjd()});
    }

    public final void K(bd bdVar) {
        if (bdVar != null) {
            try {
                com.tencent.mm.plugin.j.a.a aVar = (com.tencent.mm.plugin.j.a.a) this.hsN.get(Integer.valueOf(bdVar.getType()));
                if (aVar != null) {
                    aVar.L(bdVar);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CalcWxService", e, "", new Object[0]);
                h.mEJ.a(664, 5, 1, false);
            }
        }
    }

    public static void p(int i, long j) {
        int i2;
        int i3 = 30;
        if (j <= 1000) {
            i2 = i + 5;
        } else {
            i2 = i - 5;
        }
        if (i2 <= 30) {
            i3 = i2;
        }
        if (i3 < 5) {
            i3 = 5;
        }
        g.Ei().DT().a(aa.a.sYh, Integer.valueOf(i3));
        h.mEJ.a(664, (long) ((Integer) h.a(i3, new int[]{5, 10, 20, 25, 30}, 10, 15)).intValue(), 1, false);
    }

    public final void cc(long j) {
        x.d("MicroMsg.CalcWxService", "%d update scan msgid[%d]", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(j)});
        g.Ei().DT().a(aa.a.sYi, Long.valueOf(j));
    }

    public static long avw() {
        return ((Long) g.Ei().DT().get(aa.a.sYi, Long.valueOf(0))).longValue();
    }

    public static int avx() {
        return ((Integer) g.Ei().DT().get(aa.a.sYh, Integer.valueOf(5))).intValue();
    }

    public final String avy() {
        return hashCode();
    }
}

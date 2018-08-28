package com.tencent.mm.plugin.ext;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.g.a.et;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.i;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.x;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;

public class b implements ar {
    private static HashMap<Integer, d> cVM;
    private static boolean iJn = false;
    private final long iIX = 1600;
    private x iIY;
    private bk iIZ;
    private bv iJa;
    private a iJb;
    private b iJc;
    private HashMap<String, Integer> iJd = new HashMap();
    private a iJe = new 5(this);
    i.a iJf = new 6(this);
    private ag iJg = new 7(this, Looper.getMainLooper());
    private LinkedList<String> iJh = new LinkedList();
    private final long iJi = 60;
    private ag iJj = new 8(this, Looper.getMainLooper());
    private j.a iJk = new 9(this);
    private boolean iJl = true;
    private boolean iJm = false;
    com.tencent.mm.sdk.e.m.b iwy = new 10(this);

    static {
        int zj = m.zj();
        try {
            if (!Build.CPU_ABI.contains("armeabi")) {
                com.tencent.mm.sdk.platformtools.x.e("hakon SilkCodec", "x86 machines not supported.");
            } else if ((zj & 1024) != 0) {
                k.b("wechatvoicesilk_v7a", b.class.getClassLoader());
            } else if ((zj & 512) != 0) {
                k.b("wechatvoicesilk", b.class.getClassLoader());
            } else {
                com.tencent.mm.sdk.platformtools.x.e("hakon SilkCodec", "load library failed! silk don't support armv5!!!!");
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("hakon SilkCodec", "load library failed!");
        }
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("OPENMSGLISTENER_TABLE".hashCode()), new 1());
        cVM.put(Integer.valueOf("USEROPENIDINAPP_TABLE".hashCode()), new 3());
    }

    public static b aIJ() {
        au.HN();
        b bVar = (b) bs.iK("plugin.ext");
        if (bVar != null) {
            return bVar;
        }
        bVar = new b();
        au.HN().a("plugin.ext", bVar);
        return bVar;
    }

    public static x aIK() {
        g.Eg().Ds();
        if (aIJ().iIY == null) {
            b aIJ = aIJ();
            au.HU();
            aIJ.iIY = new x(c.FO());
        }
        return aIJ().iIY;
    }

    public static bk aIL() {
        g.Eg().Ds();
        if (aIJ().iIZ == null) {
            b aIJ = aIJ();
            au.HU();
            aIJ.iIZ = new bk(c.FO());
        }
        return aIJ().iIZ;
    }

    public static bv aIM() {
        g.Eg().Ds();
        if (aIJ().iJa == null) {
            b aIJ = aIJ();
            au.HU();
            aIJ.iJa = new bv(c.FO());
        }
        return aIJ().iJa;
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void bo(boolean z) {
        aIN();
    }

    private static void aIN() {
        File file = new File(g.Ei().dqp);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(g.Ei().dqp + "image/ext/pcm");
        if (!file.exists()) {
            file.mkdirs();
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SubCoreExt", "summerpcm accPath[%s] [%s]", new Object[]{g.Ei().dqp, bi.cjd()});
    }

    public final void bn(boolean z) {
        et etVar = new et();
        etVar.bMw.op = 1;
        if (!com.tencent.mm.sdk.b.a.sFg.m(etVar)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountPostReset");
        }
        i.cbs().cbt();
        au.HU();
        c.FT().a(this.iJe, null);
        if (this.iJb == null) {
            this.iJb = new a();
        }
        com.tencent.mm.sdk.b.a.sFg.b(this.iJb);
        if (this.iJc == null) {
            this.iJc = new b();
        }
        com.tencent.mm.sdk.b.a.sFg.b(this.iJc);
        com.tencent.mm.pluginsdk.model.app.i bmf = ao.bmf();
        if (bmf != null) {
            bmf.c(this.iJk);
        }
        SharedPreferences chZ = ad.chZ();
        this.iJm = chZ.getBoolean("hasTryToInitVoiceControlData", false);
        iJn = chZ.getBoolean("hasCallVoiceControlApi", false);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SubCoreExt", "onAccountPostReset,hasTryToInit:%s,hasCallApi:%s", new Object[]{Boolean.valueOf(this.iJm), Boolean.valueOf(iJn)});
        au.HU();
        c.FR().a(this.iwy);
        eC(true);
        com.tencent.mm.plugin.ext.c.c.aJe();
        aIN();
    }

    public final void onAccountRelease() {
        if (this.iJb != null) {
            com.tencent.mm.sdk.b.a.sFg.c(this.iJb);
        }
        if (this.iJc != null) {
            com.tencent.mm.sdk.b.a.sFg.c(this.iJc);
        }
        com.tencent.mm.pluginsdk.model.app.i bmf = ao.bmf();
        if (bmf != null) {
            bmf.d(this.iJk);
        }
        au.HU();
        c.FT().a(this.iJe);
        et etVar = new et();
        etVar.bMw.op = 2;
        if (!com.tencent.mm.sdk.b.a.sFg.m(etVar)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountRelease");
        }
        i cbs = i.cbs();
        if (au.HX()) {
            i.qyP = false;
            ao.bmi().b(14, cbs);
        }
        au.HU();
        c.FR().b(this.iwy);
        com.tencent.mm.plugin.ext.c.c.aJf();
    }

    public static String aIO() {
        return g.Ei().dqp + "image/ext/pcm";
    }

    public static void aIP() {
        String str = (String) aIK().get(aa.a.sUa, null);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SubCoreExt", "sendSportBroadcast pkgNames = " + str);
        if (str != null) {
            for (String str2 : str.split(";")) {
                Intent intent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_SET_SPORT_STEP");
                intent.setPackage(str2);
                com.tencent.mm.compatible.a.a.a(12, new 4(intent));
                intent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "SPORT_MESSAGE");
                ad.getContext().sendBroadcast(intent);
            }
        }
    }

    public final void gi(int i) {
    }

    public static ab da(long j) {
        if (!au.HX() || j <= 0) {
            return null;
        }
        au.HU();
        return c.FR().gl(j);
    }

    public static void db(long j) {
        if (j > 0) {
            try {
                au.HU();
                if (c.FT().dZ(j)) {
                    au.HU();
                    f FT = c.FT();
                    au.HU();
                    FT.U(c.FT().dW(j));
                    return;
                }
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SubCoreExt", "msgId is out of range, " + j);
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SubCoreExt", e.getMessage());
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.SubCoreExt", e, "", new Object[0]);
            }
        }
    }

    public final void aIQ() {
        this.iJg.removeMessages(0);
        this.iJg.sendEmptyMessageDelayed(0, 1600);
    }

    private void eC(boolean z) {
        if (!this.iJl) {
            return;
        }
        if (z && this.iJm) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SubCoreExt", "fromStartApp and already try to init");
        } else if (z || iJn) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SubCoreExt", "initLocalVoiceControl,fromStartApp:%s,hasTryToInit:%s,hasCallApi:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.iJm), Boolean.valueOf(iJn)});
            this.iJl = false;
            au.Em().h(new 2(this), 10000);
        }
    }
}

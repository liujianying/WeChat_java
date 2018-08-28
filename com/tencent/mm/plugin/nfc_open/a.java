package com.tencent.mm.plugin.nfc_open;

import android.content.ComponentName;
import android.nfc.NfcAdapter;
import android.os.Process;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.nfc_open.a.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class a implements ar {
    private com.tencent.mm.plugin.nfc_open.b.a lFs;

    private static a bjt() {
        au.HN();
        a aVar = (a) bs.iK("plugin.nfc_open");
        if (aVar != null) {
            return aVar;
        }
        x.w("MicroMsg.SubCoreCpuCard", "[NFC]not found in MMCore, new one");
        aVar = new a();
        au.HN().a("plugin.nfc_open", aVar);
        return aVar;
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
    }

    public final void bn(boolean z) {
        boolean z2;
        int i = 1800;
        x.i("MicroMsg.SubCoreCpuCard", "alvinluo process: %s", new Object[]{bi.an(ad.getContext(), Process.myPid())});
        g.Eg().Ds();
        if (bjt().lFs == null) {
            bjt().lFs = new com.tencent.mm.plugin.nfc_open.b.a();
        }
        com.tencent.mm.plugin.nfc_open.b.a aVar = bjt().lFs;
        if (NfcAdapter.getDefaultAdapter(ad.getContext()) == null) {
            x.i("MicroMsg.CpuCardConfigManager", "Nfc not support no need update");
        } else if (aVar.lFu != null) {
            int i2 = aVar.lFu.ruM;
            if (i2 >= 1800) {
                if (i2 > 604800) {
                    i = 604800;
                } else {
                    i = i2;
                }
            }
            x.i("MicroMsg.CpuCardConfigManager", "now=" + bi.VE() + ", lastUpdateTime=" + aVar.lFu.lastUpdateTime + ", updateFreq=" + i + ", configUpdateFreq=" + aVar.lFu.ruM);
            if (bi.VE() - aVar.lFu.lastUpdateTime > ((long) i)) {
                z2 = true;
                if (z2) {
                    x.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
                    au.DF().a(1561, aVar);
                    au.DF().a(new b(aVar.lFu.version), 0);
                }
                au.HU();
                i = ((Integer) c.DT().get(com.tencent.mm.storage.aa.a.sQG, Integer.valueOf(0))).intValue();
                if (i == 0) {
                    au.HU();
                    if (((Integer) c.DT().get(com.tencent.mm.storage.aa.a.sQH, Integer.valueOf(0))).intValue() == 1) {
                        gT(true);
                    } else {
                        gT(false);
                    }
                } else if (i == 1) {
                    gT(true);
                } else {
                    gT(false);
                }
                x.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
                e.post(new 1(this), getClass().getName());
            }
        }
        z2 = false;
        if (z2) {
            x.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
            au.DF().a(1561, aVar);
            au.DF().a(new b(aVar.lFu.version), 0);
        }
        au.HU();
        i = ((Integer) c.DT().get(com.tencent.mm.storage.aa.a.sQG, Integer.valueOf(0))).intValue();
        if (i == 0) {
            au.HU();
            if (((Integer) c.DT().get(com.tencent.mm.storage.aa.a.sQH, Integer.valueOf(0))).intValue() == 1) {
                gT(true);
            } else {
                gT(false);
            }
        } else if (i == 1) {
            gT(true);
        } else {
            gT(false);
        }
        x.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
        e.post(new 1(this), getClass().getName());
    }

    private static void gT(boolean z) {
        if (z) {
            ad.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ad.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
        } else {
            ad.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ad.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
        }
    }

    public final void onAccountRelease() {
    }
}

package com.tencent.mm.plugin.walletlock.gesture.a;

import android.util.Base64;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.ayy;
import com.tencent.mm.protocal.c.ayz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;

public final class d {
    private static long pGz = -1;

    public static g bRG() {
        x DT = g.Ei().DT();
        if (DT == null) {
            return new g();
        }
        Object obj = DT.get(339969, null);
        if (obj == null) {
            return new g();
        }
        return new g().aZ(e.PI((String) obj));
    }

    public static void H(long j, long j2) {
        x DT = g.Ei().DT();
        if (DT != null) {
            g gVar = new g();
            gVar.pGZ = j;
            gVar.pHa = j2;
            DT.set(339969, e.aY(gVar.toByteArray()));
            DT.lm(true);
        }
    }

    public static void bRH() {
        x DT = g.Ei().DT();
        if (DT != null) {
            DT.set(339969, null);
            DT.lm(true);
        }
    }

    public static long bRw() {
        return pGz;
    }

    public static void fy(long j) {
        pGz = j;
    }

    public static void bRv() {
        pGz = -1;
    }

    public static g bRI() {
        x DT = g.Ei().DT();
        if (DT == null) {
            return new g();
        }
        Object obj = DT.get(339971, null);
        if (obj == null) {
            return new g();
        }
        return new g().aZ(e.PI((String) obj));
    }

    public static void I(long j, long j2) {
        x DT = g.Ei().DT();
        if (DT != null) {
            g gVar = new g();
            gVar.pGZ = j;
            gVar.pHa = j2;
            DT.set(339971, e.aY(gVar.toByteArray()));
            DT.lm(true);
        }
    }

    public static void bRJ() {
        x DT = g.Ei().DT();
        if (DT != null) {
            DT.set(339971, null);
            DT.lm(true);
        }
    }

    public static ayy bRK() {
        x DT = g.Ei().DT();
        if (DT == null) {
            return null;
        }
        String str = (String) DT.get(339989, null);
        if (bi.oW(str)) {
            return null;
        }
        try {
            return (ayy) new ayy().aG(Base64.decode(str, 2));
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            return null;
        } catch (Throwable e2) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e2, "", new Object[0]);
            return null;
        }
    }

    public static void a(ayy ayy) {
        x DT = g.Ei().DT();
        if (DT != null) {
            try {
                DT.set(339989, Base64.encodeToString(ayy.toByteArray(), 2));
                DT.lm(true);
                com.tencent.mm.sdk.platformtools.x.v("MicroMsg.GestureGuardInfoManager", "alvinluo savePatternBuffer isUserSetGesturePwd: %b", new Object[]{Boolean.valueOf(e.bRE())});
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            }
        }
    }

    public static ayz bRL() {
        x DT = g.Ei().DT();
        if (DT == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.GestureGuardInfoManager", "alvinluo configstg is null");
            return null;
        }
        String str = (String) DT.get(339990, null);
        if (bi.oW(str)) {
            return null;
        }
        try {
            return (ayz) new ayz().aG(Base64.decode(str, 2));
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            return null;
        } catch (Throwable e2) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e2, "", new Object[0]);
            return null;
        }
    }

    public static void a(ayz ayz) {
        if (ayz != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GestureGuardInfoManager", "alvinluo saveSyncedPatternInfo version: %d, status: %d", new Object[]{Integer.valueOf(ayz.sbK), Integer.valueOf(ayz.sbM)});
        }
        x DT = g.Ei().DT();
        if (DT != null) {
            try {
                DT.set(339990, Base64.encodeToString(ayz.toByteArray(), 2));
                DT.lm(true);
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            }
        }
    }

    public static int bRM() {
        x DT = g.Ei().DT();
        if (DT == null) {
            return -1;
        }
        Object obj = DT.get(339972, null);
        if (obj == null) {
            return -1;
        }
        return ((Integer) obj).intValue();
    }

    public static void zy(int i) {
        x DT = g.Ei().DT();
        if (DT != null) {
            DT.set(339972, Integer.valueOf(i));
            DT.lm(true);
        }
    }

    public static void bRN() {
        x DT = g.Ei().DT();
        if (DT != null) {
            DT.set(339972, null);
            DT.lm(true);
        }
    }
}

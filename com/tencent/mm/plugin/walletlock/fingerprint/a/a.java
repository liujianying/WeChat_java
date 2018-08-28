package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    private static long pGz = -1;

    private static JSONArray PF(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONArray(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FingerprintInfoStorage", e, "", new Object[0]);
            return null;
        }
    }

    private static HashSet<String> y(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            HashSet<String> hashSet = new HashSet();
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(jSONArray.getJSONObject(i).getString("fid"));
            }
            return hashSet;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FingerprintInfoStorage", e, "", new Object[0]);
            return null;
        }
    }

    private static String bRr() {
        return (String) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sYB, null);
    }

    public static boolean PG(String str) {
        x.i("MicroMsg.FingerprintInfoStorage", "alvinluo add fid to local: %s", new Object[]{str});
        try {
            JSONArray PF = PF(bRr());
            HashSet y = y(PF);
            if (PF == null) {
                x.w("MicroMsg.FingerprintInfoStorage", "alvinluo list is null");
                PF = new JSONArray();
            }
            if (y == null) {
                x.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet is null");
                y = new HashSet();
            }
            x.i("MicroMsg.FingerprintInfoStorage", "alvinluo fidList: %s before add fid", new Object[]{PF.toString()});
            if (!y.contains(str)) {
                x.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet contains fid %s: %b", new Object[]{str, Boolean.valueOf(false)});
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fid", str);
                PF.put(jSONObject);
                x.i("MicroMsg.FingerprintInfoStorage", "alvinluo list: %s", new Object[]{PF.toString()});
                g.Ei().DT().a(com.tencent.mm.storage.aa.a.sYB, PF.toString());
                g.Ei().DT().lm(true);
                return true;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FingerprintInfoStorage", e, "", new Object[0]);
        }
        return false;
    }

    public static boolean PH(String str) {
        x.i("MicroMsg.FingerprintInfoStorage", "alvinluo fid: %s, fidInfoList: %s", new Object[]{str, bRr()});
        HashSet y = y(PF(r2));
        if (y == null || !y.contains(str)) {
            return false;
        }
        return true;
    }

    public static void bRs() {
        x.i("MicroMsg.FingerprintInfoStorage", "alvinluo clear local fids, stack: %s", new Object[]{bi.cjd()});
        g.Ei().DT().a(com.tencent.mm.storage.aa.a.sYB, null);
        g.Ei().DT().lm(true);
    }

    public static boolean bRt() {
        return ((Boolean) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sYA, Boolean.valueOf(false))).booleanValue();
    }

    public static void jG(boolean z) {
        x.i("MicroMsg.FingerprintInfoStorage", "alvinluo set fingerprint lock status isOpened: %b", new Object[]{Boolean.valueOf(z)});
        g.Ei().DT().a(com.tencent.mm.storage.aa.a.sYA, Boolean.valueOf(z));
        g.Ei().DT().lm(true);
    }

    public static boolean bRu() {
        com.tencent.mm.plugin.walletlock.gesture.a.g gVar;
        com.tencent.mm.storage.x DT = g.Ei().DT();
        if (DT == null) {
            gVar = new com.tencent.mm.plugin.walletlock.gesture.a.g();
        } else {
            String str = (String) DT.get(com.tencent.mm.storage.aa.a.sYE, null);
            gVar = str == null ? new com.tencent.mm.plugin.walletlock.gesture.a.g() : new com.tencent.mm.plugin.walletlock.gesture.a.g().aZ(e.PI(str));
        }
        if (gVar.pGZ == -1) {
            return false;
        }
        e.a(gVar);
        if (gVar.pHa / 1000 < 30) {
            H(gVar.pGZ, gVar.pHa);
            return true;
        }
        DT = g.Ei().DT();
        if (DT != null) {
            DT.a(com.tencent.mm.storage.aa.a.sYE, null);
            DT.lm(true);
        }
        return false;
    }

    public static void H(long j, long j2) {
        com.tencent.mm.storage.x DT = g.Ei().DT();
        if (DT != null) {
            com.tencent.mm.plugin.walletlock.gesture.a.g gVar = new com.tencent.mm.plugin.walletlock.gesture.a.g();
            gVar.pGZ = j;
            gVar.pHa = j2;
            DT.a(com.tencent.mm.storage.aa.a.sYE, e.aY(gVar.toByteArray()));
            DT.lm(true);
        }
    }

    public static void bRv() {
        pGz = -1;
    }

    public static long bRw() {
        return pGz;
    }

    public static void fy(long j) {
        pGz = j;
    }
}

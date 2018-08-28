package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.g;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.protocal.c.dh;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONObject;

public final class q extends j {
    private static volatile q frF;

    public static q aei() {
        if (frF == null) {
            synchronized (q.class) {
                if (frF == null) {
                    frF = new q();
                }
            }
        }
        return frF;
    }

    public static void release() {
        synchronized (q.class) {
            frF = null;
        }
    }

    private q() {
    }

    public final void b(String str, int i, Object obj) {
        super.b(str, i, obj);
        ((g) e.x(g.class)).b(str, i, obj);
    }

    public final void c(a aVar) {
        super.a(aVar, c.Em().lnJ.getLooper());
    }

    public static boolean h(String str, int i, boolean z) {
        boolean z2 = false;
        p aba = e.aba();
        if (bi.oW(str)) {
            return false;
        }
        WxaAttributes e = aba.e(str, new String[]{"appOpt"});
        if (e == null) {
            return false;
        }
        int i2 = e.field_appOpt;
        i2 = !z ? i2 & (i ^ -1) : i2 | i;
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("appOpt", Integer.valueOf(i2));
        if (aba.dCZ.update("WxaAttributesTable", contentValues, String.format("%s=?", new Object[]{"username"}), new String[]{str}) > 0) {
            z2 = true;
        }
        if (z2) {
            kz kzVar = new kz();
            kzVar.bVk.bGy = str;
            kzVar.bVk.bVl = i2;
            com.tencent.mm.sdk.b.a.sFg.m(kzVar);
        }
        return z2;
    }

    public static t rT(String str) {
        if (bi.oW(str) || !com.tencent.mm.kernel.g.Eg().Dx()) {
            return null;
        }
        WxaAttributes e = e.aba().e(str, new String[]{"appId", "nickname", "signature", "brandIconURL", "dynamicInfo", "versionInfo", "appInfo", "registerSource", "bindWxaInfo"});
        if (e == null) {
            return null;
        }
        t tVar = new t();
        tVar.username = str;
        tVar.appId = e.field_appId;
        tVar.nickname = e.field_nickname;
        tVar.signature = e.field_signature;
        tVar.fsq = e.field_brandIconURL;
        tVar.fsc = e.aek().fsc;
        tVar.fsi = e.ael() == null ? -1 : e.ael().fsi;
        tVar.frQ = e.aem();
        tVar.bGM = e.aej().dCn;
        try {
            tVar.dLS = bi.oW(e.field_registerSource) ? "" : new JSONObject(e.field_registerSource).optString("RegisterBody", "");
        } catch (Exception e2) {
        }
        return tVar;
    }

    public static k a(String str, String str2, int i, long j) {
        int i2;
        WxaAttributes e = e.aba().e(str2, new String[]{"appId", "nickname", "brandIconURL", "appInfo"});
        String valueOf = String.valueOf(str);
        String str3 = e == null ? "" : e.field_appId;
        String str4 = e == null ? "" : e.field_nickname;
        String str5 = e == null ? "" : e.field_brandIconURL;
        if (e == null) {
            i2 = 0;
        } else {
            i2 = e.aej().dCn;
        }
        return new k(valueOf, str2, str3, str4, str5, i2, i, e.aba().rS(str2), e.abh().aq(str2, i), j);
    }

    public static AppBrandSysConfig rU(String str) {
        boolean z = false;
        WxaAttributes f = e.aba().f(str, new String[0]);
        if (f == null) {
            return null;
        }
        AppBrandSysConfig appBrandSysConfig;
        if (f != null) {
            appBrandSysConfig = new AppBrandSysConfig();
            appBrandSysConfig.bGy = f.field_username;
            appBrandSysConfig.bKC = f.field_nickname;
            appBrandSysConfig.fqJ = f.field_brandIconURL;
            appBrandSysConfig.appId = f.field_appId;
            appBrandSysConfig.fqK = f.aej().dzQ;
            appBrandSysConfig.fqR = f.aek().fsb.fqR;
            appBrandSysConfig.fqS = f.aek().fsb.fqS;
            appBrandSysConfig.fqV = f.aek().fsb.fqV;
            appBrandSysConfig.fqW = f.aek().fsb.fqW;
            appBrandSysConfig.fqX = f.aek().fsb.fqX;
            appBrandSysConfig.fqY = f.aek().fsb.fqY;
            appBrandSysConfig.fqU = f.aek().fsb.fqU;
            appBrandSysConfig.fqT = f.aek().fsb.fqT;
            appBrandSysConfig.fqZ = (long) f.aek().fsb.fsf;
            appBrandSysConfig.fra = f.aek().fsb.fsg;
            appBrandSysConfig.frd = (ArrayList) com.tencent.mm.plugin.appbrand.q.e.d(new ArrayList(), f.aej().frU);
            appBrandSysConfig.fre = (ArrayList) com.tencent.mm.plugin.appbrand.q.e.d(new ArrayList(), f.aej().frV);
            appBrandSysConfig.frg = (ArrayList) com.tencent.mm.plugin.appbrand.q.e.d(new ArrayList(), f.aej().frX);
            appBrandSysConfig.frf = (ArrayList) com.tencent.mm.plugin.appbrand.q.e.d(new ArrayList(), f.aej().frW);
            appBrandSysConfig.fro = new dh();
            appBrandSysConfig.fro.rdx = f.aej().fmc;
            appBrandSysConfig.fro.rdE = f.aej().frS;
            appBrandSysConfig.frh = f.aek().fsb.frh;
            appBrandSysConfig.fri = f.aek().fsb.fri;
            appBrandSysConfig.frj = f.aek().fsb.frj;
            appBrandSysConfig.frk = f.aek().fsb.frk;
            appBrandSysConfig.frl = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getInt("ClientBenchmarkLevel", -1);
        } else {
            appBrandSysConfig = null;
        }
        if (appBrandSysConfig != null) {
            String str2 = appBrandSysConfig.appId;
            boolean parseBoolean = (bi.oW(str2) || e.abf() == null) ? false : Boolean.parseBoolean(e.abf().get(str2 + "_AppDebugEnabled", "false"));
            appBrandSysConfig.fqL = parseBoolean;
            com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100216");
            if (fJ.isValid() && "1".equals(fJ.ckq().get("isOpenJSCore"))) {
                z = true;
            }
            appBrandSysConfig.frb = z;
            appBrandSysConfig.fqM = "1".equals(e.abf().get(appBrandSysConfig.appId + "_PerformancePanelEnabled", "0"));
        }
        return appBrandSysConfig;
    }

    public static long rS(String str) {
        return e.aba().rS(str);
    }

    public static String[] rV(String str) {
        if (bi.oW(str) || e.aba().e(str, new String[]{"roundedSquareIconURL", "bigHeadURL"}) == null) {
            return null;
        }
        return new String[]{e.aba().e(str, new String[]{"roundedSquareIconURL", "bigHeadURL"}).field_roundedSquareIconURL, e.aba().e(str, new String[]{"roundedSquareIconURL", "bigHeadURL"}).field_bigHeadURL};
    }

    public static String rW(String str) {
        if (bi.oW(str)) {
            return null;
        }
        WxaAttributes e = e.aba().e(str, new String[]{"appId"});
        if (e != null) {
            return e.field_appId;
        }
        return null;
    }

    public static String rX(String str) {
        if (bi.oW(str)) {
            return null;
        }
        WxaAttributes f = e.aba().f(str, new String[]{"nickname"});
        if (f != null) {
            return f.field_nickname;
        }
        return null;
    }

    public static String rY(String str) {
        if (bi.oW(str)) {
            return null;
        }
        WxaAttributes f = e.aba().f(str, new String[]{"username"});
        if (f != null) {
            return f.field_username;
        }
        return null;
    }

    public static void rZ(String str) {
        if (!bi.oW(str)) {
            p aba = e.aba();
            if (!bi.oW(str)) {
                ContentValues contentValues = new ContentValues(2);
                contentValues.put("syncVersion", "");
                contentValues.put("syncTimeSecond", Long.valueOf(0));
                aba.dCZ.update("WxaAttributesTable", contentValues, String.format(Locale.US, "%s=?", new Object[]{"username"}), new String[]{str});
            }
        }
    }

    public static void sa(String str) {
        if (!bi.oW(str)) {
            WxaAttributes wxaAttributes = new WxaAttributes();
            wxaAttributes.field_username = str;
            e.aba().a(wxaAttributes, new String[]{"username"});
        }
    }
}

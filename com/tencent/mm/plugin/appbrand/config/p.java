package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.aa.j;
import com.tencent.mm.aa.q;
import com.tencent.mm.bk.b;
import com.tencent.mm.bt.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.protocal.c.cgy;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.ab;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public final class p extends i<WxaAttributes> {
    final h dCZ;

    public final /* synthetic */ boolean b(c cVar, boolean z, String[] strArr) {
        WxaAttributes wxaAttributes = (WxaAttributes) cVar;
        if (!bi.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("username")) {
                    strArr[i] = "usernameHash";
                    wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
                    break;
                }
            }
        }
        return super.b(wxaAttributes, z, strArr);
    }

    public p(h hVar) {
        super(hVar, WxaAttributes.fgt, "WxaAttributesTable", WxaAttributes.ciG);
        this.dCZ = hVar;
        if (aeh() && !g.Ei().DT().getBoolean(a.sTX, false)) {
            x.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "before fix");
            Cursor b = hVar.b("select appInfo from WxaAttributesTable", null, 2);
            if (b == null || b.isClosed()) {
                x.e("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "try fix but db not working");
                return;
            }
            if (b.moveToFirst()) {
                List<Pair> linkedList = new LinkedList();
                do {
                    String string = b.getString(0);
                    if (!bi.oW(string)) {
                        try {
                            JSONObject jSONObject = new JSONObject(string);
                            string = jSONObject.optString("Appid");
                            String optString = jSONObject.optString("RoundedSquareIconUrl");
                            if (!(bi.oW(string) || bi.oW(optString))) {
                                ContentValues contentValues = new ContentValues(1);
                                contentValues.put("roundedSquareIconURL", optString);
                                linkedList.add(Pair.create(string, contentValues));
                            }
                        } catch (Exception e) {
                        }
                    }
                } while (b.moveToNext());
                b.close();
                long dO = hVar.dO(Thread.currentThread().getId());
                for (Pair pair : linkedList) {
                    String[] strArr = new String[]{(String) pair.first};
                    hVar.update("WxaAttributesTable", (ContentValues) ((Pair) r3.next()).second, "appId=?", strArr);
                }
                hVar.gp(dO);
                x.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "fix done");
            } else {
                x.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "no contacts available");
            }
            if (!b.isClosed()) {
                b.close();
            }
            g.Ei().DT().a(a.sTX, Boolean.valueOf(true));
        }
    }

    public final boolean aeh() {
        return (this.dCZ == null || this.dCZ.cjr()) ? false : true;
    }

    public final WxaAttributes e(String str, String... strArr) {
        WxaAttributes wxaAttributes = null;
        if (!bi.oW(str) && str.endsWith("@app")) {
            Cursor a = this.dCZ.a("WxaAttributesTable", bi.G(strArr) ? null : strArr, String.format(Locale.US, "%s=?", new Object[]{"usernameHash"}), new String[]{String.valueOf(str.hashCode())}, null, null, null, 2);
            if (a != null) {
                if (a.moveToFirst()) {
                    wxaAttributes = new WxaAttributes();
                    wxaAttributes.d(a);
                    wxaAttributes.field_username = str;
                }
                a.close();
            }
        }
        return wxaAttributes;
    }

    public final WxaAttributes f(String str, String... strArr) {
        WxaAttributes wxaAttributes = null;
        if (!bi.oW(str)) {
            Cursor a = this.dCZ.a("WxaAttributesTable", bi.G(strArr) ? null : strArr, String.format(Locale.US, "%s=?", new Object[]{"appId"}), new String[]{str}, null, null, null, 2);
            if (a != null) {
                if (a.moveToFirst()) {
                    wxaAttributes = new WxaAttributes();
                    wxaAttributes.d(a);
                    wxaAttributes.field_appId = str;
                }
                a.close();
            }
        }
        return wxaAttributes;
    }

    final long rS(String str) {
        WxaAttributes e = e(str, "appInfo");
        if (e == null || e.aej() == null) {
            return 0;
        }
        return e.aej().fmc;
    }

    public final boolean a(String str, b bVar, List<cgy> list) {
        if (bi.cX(list)) {
            return false;
        }
        int i;
        WxaAttributes wxaAttributes = new WxaAttributes();
        wxaAttributes.field_username = str;
        if (a(wxaAttributes, "username")) {
            boolean i2 = false;
        } else {
            i2 = 1;
        }
        int i3 = 0;
        for (cgy cgy : list) {
            if (cgy != null) {
                i3 = a(wxaAttributes, cgy) | i3;
            }
        }
        if (i3 != 0) {
            if (i2 != 0) {
                b(wxaAttributes);
            } else {
                c(wxaAttributes, new String[]{"username"});
            }
            try {
                if (g.Eg().Dx()) {
                    int i4;
                    boolean i42;
                    com.tencent.mm.l.a abVar;
                    String str2 = wxaAttributes.field_username;
                    String str3 = wxaAttributes.field_nickname;
                    String str4 = wxaAttributes.field_bigHeadURL;
                    String str5 = wxaAttributes.field_smallHeadURL;
                    j kc = q.KH().kc(str2);
                    if (kc == null) {
                        kc = new j();
                        i42 = 1;
                    } else {
                        i42 = false;
                    }
                    if (!bi.oV(str5).equals(kc.Ky())) {
                        kc.dHQ = str5;
                        i42 = 1;
                    }
                    if (!bi.oV(str4).equals(kc.Kx())) {
                        kc.dHR = str4;
                        i42 = 1;
                    }
                    if (i42 != 0) {
                        kc.username = str2;
                        kc.by(true);
                        kc.bWA = 31;
                        q.KH().a(kc);
                    }
                    ab Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(str2);
                    if (Yg == null) {
                        abVar = new ab();
                    } else {
                        abVar = Yg;
                    }
                    if (((int) abVar.dhP) == 0) {
                        abVar.setUsername(str2);
                        i42 = 1;
                    } else {
                        i42 = false;
                    }
                    if (!str3.equals(abVar.field_nickname)) {
                        abVar.dx(str3);
                        abVar.dy(com.tencent.mm.platformtools.h.oJ(str3));
                        abVar.dz(com.tencent.mm.platformtools.h.oI(str3));
                        i42 = 1;
                    }
                    if (i42 != 0) {
                        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().R(abVar);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WxaAttrStorage", e, "flushContactInMainDB", new Object[0]);
            }
        }
        e.abi().a(wxaAttributes.field_appId, wxaAttributes.ael());
        wxaAttributes.field_syncTimeSecond = bi.VE();
        wxaAttributes.field_syncVersion = bi.bE(bVar == null ? new byte[0] : bVar.lR);
        c(wxaAttributes, new String[]{"username"});
        return i3;
    }

    private static boolean a(WxaAttributes wxaAttributes, cgy cgy) {
        if ("NickName".equals(cgy.riD) && !be(cgy.mEl, wxaAttributes.field_nickname)) {
            wxaAttributes.field_nickname = bi.oV(cgy.mEl);
            return true;
        } else if ("BrandIconURL".equals(cgy.riD) && !be(cgy.mEl, wxaAttributes.field_brandIconURL)) {
            wxaAttributes.field_brandIconURL = cgy.mEl;
            return true;
        } else if ("BigHeadImgUrl".equals(cgy.riD) && !be(cgy.mEl, wxaAttributes.field_bigHeadURL)) {
            wxaAttributes.field_bigHeadURL = cgy.mEl;
            return true;
        } else if ("SmallHeadImgUrl".equals(cgy.riD) && !be(cgy.mEl, wxaAttributes.field_smallHeadURL)) {
            wxaAttributes.field_smallHeadURL = cgy.mEl;
            return true;
        } else if (!"Signature".equals(cgy.riD) || be(cgy.mEl, wxaAttributes.field_signature)) {
            if ("WxAppOpt".equals(cgy.riD)) {
                int i = bi.getInt(cgy.mEl, 0);
                if (i != wxaAttributes.field_appOpt) {
                    wxaAttributes.field_appOpt = i;
                    return true;
                }
            }
            if ("RegisterSource".equals(cgy.riD) && !be(cgy.mEl, wxaAttributes.field_registerSource)) {
                wxaAttributes.field_registerSource = cgy.mEl;
                return true;
            } else if ("WxaAppInfo".equals(cgy.riD) && !be(cgy.mEl, wxaAttributes.field_appInfo)) {
                wxaAttributes.field_appInfo = cgy.mEl;
                try {
                    JSONObject jSONObject = new JSONObject(cgy.mEl);
                    wxaAttributes.field_appId = jSONObject.getString("Appid");
                    wxaAttributes.field_roundedSquareIconURL = jSONObject.getString("RoundedSquareIconUrl");
                    m.a(wxaAttributes.field_appId, n.i(jSONObject).rcX);
                    return true;
                } catch (Exception e) {
                    return true;
                }
            } else if ("WxaAppVersionInfo".equalsIgnoreCase(cgy.riD) && !be(cgy.mEl, wxaAttributes.field_versionInfo)) {
                wxaAttributes.field_versionInfo = cgy.mEl;
                return true;
            } else if ("BindWxaInfo".equals(cgy.riD) && !be(cgy.mEl, wxaAttributes.field_bindWxaInfo)) {
                wxaAttributes.field_bindWxaInfo = cgy.mEl;
                return true;
            } else if ("WxaAppDynamic".equals(cgy.riD) && !be(cgy.mEl, wxaAttributes.field_dynamicInfo)) {
                wxaAttributes.field_dynamicInfo = cgy.mEl;
                return true;
            } else if (!"MMBizMenu".equals(cgy.riD) || be(cgy.mEl, wxaAttributes.field_bizMenu)) {
                return false;
            } else {
                wxaAttributes.field_bizMenu = cgy.mEl;
                return true;
            }
        } else {
            wxaAttributes.field_signature = cgy.mEl;
            return true;
        }
    }

    private static boolean be(String str, String str2) {
        return bi.oV(str).equals(bi.oV(str2));
    }

    private boolean a(WxaAttributes wxaAttributes, String... strArr) {
        if (!bi.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("username")) {
                    strArr[i] = "usernameHash";
                    wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
                    break;
                }
            }
        }
        return super.b(wxaAttributes, strArr);
    }
}

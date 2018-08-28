package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.k.f;
import com.tencent.mm.plugin.appbrand.k.h;
import com.tencent.mm.plugin.appbrand.k.i;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e extends a {
    public static final int CTRL_INDEX = 272;
    public static final String NAME = "createUploadTask";

    static /* synthetic */ boolean b(l lVar, String str) {
        f uN = h.alw().uN(lVar.mAppId);
        if (uN == null || !uN.uG(str)) {
            return false;
        }
        x.i("MicroMsg.JsApiCreateUploadTask", "upload abort %s", new Object[]{str});
        return true;
    }

    protected final String ajr() {
        StringBuilder stringBuilder = new StringBuilder();
        h.alw();
        return stringBuilder.append(h.alq()).toString();
    }

    protected final String ajs() {
        return "uploadTaskId";
    }

    public final void a(l lVar, JSONObject jSONObject, String str) {
        x.d("MicroMsg.JsApiCreateUploadTask", "JsApiCreateUploadTask");
        String str2 = lVar.mAppId;
        String optString = jSONObject.optString("filePath");
        if (bi.oW(optString)) {
            a(lVar, str, "filePath is null");
            return;
        }
        x.i("MicroMsg.JsApiCreateUploadTask", "tempFilePath " + optString);
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str2, optString);
        if (itemByLocalId == null) {
            a(lVar, str, "fail:file doesn't exist");
            return;
        }
        String str3 = itemByLocalId.dDG;
        String str4 = itemByLocalId.mimeType;
        x.i("MicroMsg.JsApiCreateUploadTask", "filePath(%s)", new Object[]{str3});
        1 1 = new 1(this, lVar, str, str3);
        AppBrandSysConfig appBrandSysConfig = lVar.fdO.fcu;
        a aVar = lVar.fdO.fcv;
        Map a = i.a(jSONObject, appBrandSysConfig);
        String optString2 = jSONObject.optString("url");
        if (bi.oW(optString2)) {
            x.i("MicroMsg.JsApiCreateUploadTask", "url is null");
            a(lVar, str, "url is null or nil");
            return;
        }
        boolean z;
        boolean a2;
        int optInt;
        f fVar;
        if (i.c(lVar.fdO.fct)) {
            if (jSONObject.optBoolean("__skipDomainCheck__")) {
                z = true;
                a2 = i.a(appBrandSysConfig, z);
                if (a2 || i.b(appBrandSysConfig.frf, optString2)) {
                    String str5;
                    if (appBrandSysConfig.fqU <= 0) {
                        x.i("MicroMsg.JsApiCreateUploadTask", "concurrent <= 0 ");
                    }
                    optInt = jSONObject.optInt("timeout", 0);
                    if (optInt <= 0) {
                        optInt = i.a(appBrandSysConfig, aVar, 2);
                    }
                    if (optInt <= 0) {
                        optInt = 60000;
                    }
                    if (h.alw().uN(str2) != null) {
                        p d = d(lVar);
                        String str6 = null;
                        if (!(d == null || d.gns == null)) {
                            str6 = d.gns.getUserAgentString();
                        }
                        f fVar2 = new f(str2, str6, lVar.fdO.fcu);
                        h alw = h.alw();
                        if (!alw.fNX.containsKey(str2)) {
                            alw.fNX.put(str2, fVar2);
                        }
                        fVar = fVar2;
                    } else {
                        fVar = h.alw().uN(str2);
                    }
                    if (optString.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                        str5 = "wx-file." + itemByLocalId.fjS;
                    } else {
                        str5 = org.a.a.a.a.getName(optString);
                    }
                    if (fVar != null) {
                        x.i("MicroMsg.JsApiCreateUploadTask", "before do upload, checkDomains = %b, timeout %d", new Object[]{Boolean.valueOf(a2), Integer.valueOf(optInt)});
                        if (a2) {
                            fVar.a(optInt, str4, str3, jSONObject, a, appBrandSysConfig.frf, 1, str, NAME, str5);
                            return;
                        }
                        fVar.a(optInt, str4, str3, jSONObject, a, null, 1, str, NAME, str5);
                    }
                }
                x.i("MicroMsg.JsApiCreateUploadTask", "not in domain url %s", new Object[]{optString2});
                a(lVar, str, "url not in domain list");
                return;
            }
        }
        z = false;
        a2 = i.a(appBrandSysConfig, z);
        if (a2) {
        }
        if (appBrandSysConfig.fqU <= 0) {
            x.i("MicroMsg.JsApiCreateUploadTask", "concurrent <= 0 ");
        }
        optInt = jSONObject.optInt("timeout", 0);
        if (optInt <= 0) {
            optInt = i.a(appBrandSysConfig, aVar, 2);
        }
        if (optInt <= 0) {
            optInt = 60000;
        }
        if (h.alw().uN(str2) != null) {
            fVar = h.alw().uN(str2);
        } else {
            p d2 = d(lVar);
            String str62 = null;
            if (!(d2 == null || d2.gns == null)) {
                str62 = d2.gns.getUserAgentString();
            }
            f fVar22 = new f(str2, str62, lVar.fdO.fcu);
            h alw2 = h.alw();
            if (!alw2.fNX.containsKey(str2)) {
                alw2.fNX.put(str2, fVar22);
            }
            fVar = fVar22;
        }
        if (optString.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
            str5 = "wx-file." + itemByLocalId.fjS;
        } else {
            str5 = org.a.a.a.a.getName(optString);
        }
        if (fVar != null) {
            x.i("MicroMsg.JsApiCreateUploadTask", "before do upload, checkDomains = %b, timeout %d", new Object[]{Boolean.valueOf(a2), Integer.valueOf(optInt)});
            if (a2) {
                fVar.a(optInt, str4, str3, jSONObject, a, appBrandSysConfig.frf, 1, str, NAME, str5);
                return;
            }
            fVar.a(optInt, str4, str3, jSONObject, a, null, 1, str, NAME, str5);
        }
    }

    private static void a(l lVar, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("uploadTaskId", str);
        hashMap.put("state", "fail");
        hashMap.put("errMsg", str2);
        String jSONObject = new JSONObject(hashMap).toString();
        com.tencent.mm.plugin.appbrand.jsapi.h a = new a().a(lVar);
        a.mData = jSONObject;
        a.ahM();
    }
}

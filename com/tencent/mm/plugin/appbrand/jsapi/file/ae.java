package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.config.j;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class ae extends a {
    public static final int CTRL_INDEX = 51;
    public static final String NAME = "saveFile";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        f$a c = c(lVar, jSONObject);
        lVar.E(i, f(c.Yy, c.values));
    }

    static f$a c(l lVar, JSONObject jSONObject) {
        String str = lVar.mAppId;
        String optString = jSONObject.optString("tempFilePath");
        String optString2 = jSONObject.optString("filePath");
        if (bi.oW(optString)) {
            x.e("MicroMsg.JsApiSaveFile", "temp localId is null or nil");
            return new f$a("fail", new Object[0]);
        }
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str, optString);
        boolean z = itemByLocalId != null && e.cn(itemByLocalId.dDG);
        x.i("MicroMsg.JsApiSaveFile", "get temp obj = %s, fileExists = %b", new Object[]{itemByLocalId, Boolean.valueOf(z)});
        if (!z || bi.oW(itemByLocalId.dDG)) {
            return new f$a("fail tempFilePath file not exist", new Object[0]);
        }
        Map map;
        if (!bi.oW(optString2)) {
            str = a(lVar.fdO, itemByLocalId.dDG, optString2);
            map = null;
            if ("ok".equals(str)) {
                map = new HashMap();
                map.put("savedFilePath", optString2);
            }
            return new f$a(str, new Object[0]).z(map);
        } else if (itemByLocalId.fjT) {
            return new f$a("ok", new Object[0]);
        } else {
            x.i("MicroMsg.JsApiSaveFile", "before markPermanent, quota = %d, occupation = %d, fileLength = %d", new Object[]{Long.valueOf(j.rQ(str)), Long.valueOf(AppBrandLocalMediaObjectManager.getStoredFilesOccupation(str)), Long.valueOf(new File(itemByLocalId.dDG).length())});
            if (AppBrandLocalMediaObjectManager.getStoredFilesOccupation(str) + new File(itemByLocalId.dDG).length() > j.rQ(str)) {
                return new f$a(String.format(Locale.US, "fail:exceed quota %dM", new Object[]{Long.valueOf(r4 / 1048576)}), new Object[0]);
            }
            AppBrandLocalMediaObject markPermanent = AppBrandLocalMediaObjectManager.markPermanent(lVar.mAppId, itemByLocalId);
            optString2 = "MicroMsg.JsApiSaveFile";
            String str2 = "after markPermanent, (obj==null): %b, obj.localId: %s, obj.path: %s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(markPermanent == null);
            objArr[1] = markPermanent == null ? null : markPermanent.bNH;
            objArr[2] = markPermanent == null ? null : markPermanent.dDG;
            x.i(optString2, str2, objArr);
            if (markPermanent == null || bi.oW(markPermanent.bNH) || bi.oW(markPermanent.dDG)) {
                return new f$a("fail", new Object[0]);
            }
            map = new HashMap(1);
            map.put("savedFilePath", markPermanent.bNH);
            return new f$a("ok", new Object[0]).z(map);
        }
    }

    public static String a(g gVar, String str, String str2) {
        com.tencent.mm.plugin.appbrand.appstorage.j rf = gVar.fcw.rf(str2);
        if (rf == com.tencent.mm.plugin.appbrand.appstorage.j.fkO || rf == com.tencent.mm.plugin.appbrand.appstorage.j.fkQ) {
            try {
                rf = gVar.fcw.a(str2, new FileInputStream(str), false);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiSaveFile", e, "saveToNewFS", new Object[0]);
                return "fail read tempFilePath error";
            }
        }
        switch (1.fQo[rf.ordinal()]) {
            case 1:
                return String.format("fail permission denied, open \"%s\"", new Object[]{str2});
            case 2:
                return String.format("fail no such file or directory \"%s\"", new Object[]{str2});
            case 3:
                return String.format("fail illegal operation on a directory, open \"%s\"", new Object[]{str2});
            case 4:
                return "fail the maximum size of the file storage limit is exceeded";
            case 5:
                return "ok";
            default:
                return "fail " + rf.name();
        }
    }
}

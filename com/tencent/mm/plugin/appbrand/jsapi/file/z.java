package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

public final class z extends a {
    private static final int CTRL_INDEX = 117;
    private static final String NAME = "removeSavedFile";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String str = lVar.mAppId;
        String optString = jSONObject.optString("filePath", "");
        if (bi.oW(optString)) {
            str = "fail:invalid data";
        } else {
            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str, optString);
            if (itemByLocalId == null || bi.oW(itemByLocalId.dDG)) {
                str = "fail:file doesn't exist";
            } else {
                e.deleteFile(itemByLocalId.dDG);
                str = "ok";
            }
        }
        lVar.E(i, f(str, null));
    }
}

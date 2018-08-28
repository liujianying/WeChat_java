package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class p extends a {
    private static final int CTRL_INDEX = 116;
    private static final String NAME = "getSavedFileInfo";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String str = lVar.mAppId;
        String optString = jSONObject.optString("filePath", "");
        if (bi.oW(optString)) {
            lVar.E(i, f("fail:invalid data", null));
            return;
        }
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str, optString);
        if (itemByLocalId == null) {
            lVar.E(i, f("fail:file doesn't exist", null));
            return;
        }
        File file = new File(itemByLocalId.dDG);
        Map hashMap = new HashMap(3);
        hashMap.put("size", Long.valueOf(file.length()));
        hashMap.put("createTime", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(file.lastModified())));
        lVar.E(i, f("ok", hashMap));
    }
}

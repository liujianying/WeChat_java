package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public final class q extends a {
    private static final int CTRL_INDEX = 115;
    private static final String NAME = "getSavedFileList";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        List<AppBrandLocalMediaObject> listStoredFiles = AppBrandLocalMediaObjectManager.listStoredFiles(lVar.mAppId);
        JSONArray jSONArray = new JSONArray();
        if (!bi.cX(listStoredFiles)) {
            for (AppBrandLocalMediaObject appBrandLocalMediaObject : listStoredFiles) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("filePath", appBrandLocalMediaObject.bNH);
                    jSONObject2.put("size", appBrandLocalMediaObject.eyz);
                    jSONObject2.put("createTime", TimeUnit.MILLISECONDS.toSeconds(appBrandLocalMediaObject.fjU));
                    jSONArray.put(jSONObject2);
                } catch (Exception e) {
                }
            }
        }
        Map hashMap = new HashMap(1);
        hashMap.put("fileList", jSONArray);
        lVar.E(i, f("ok", hashMap));
    }
}

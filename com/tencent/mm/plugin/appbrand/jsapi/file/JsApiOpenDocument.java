package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class JsApiOpenDocument extends a {
    private static final int CTRL_INDEX = 99;
    private static final String NAME = "openDocument";
    private static long fQk = -1;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        super.a(lVar, jSONObject, i);
        long VF = bi.VF();
        if (VF - fQk < 1000) {
            lVar.E(i, f("fail:document viewer already starting", null));
            return;
        }
        fQk = VF;
        MMActivity c = c(lVar);
        if (c == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        String optString = jSONObject.optString("filePath");
        if (bi.oW(optString)) {
            lVar.E(i, f("fail:invalid data", null));
            return;
        }
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(lVar.mAppId, optString);
        if (itemByLocalId == null) {
            lVar.E(i, f("fail:file doesn't exist", null));
            return;
        }
        OpenRequest openRequest = new OpenRequest();
        openRequest.filePath = itemByLocalId.dDG;
        openRequest.fjS = s.Tu(itemByLocalId.mimeType);
        optString = jSONObject.optString("fileType");
        if (!bi.oW(optString)) {
            openRequest.fjS = optString;
        }
        com.tencent.mm.plugin.appbrand.ipc.a.b(c, openRequest, new 1(this, lVar, i));
    }
}

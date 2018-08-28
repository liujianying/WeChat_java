package com.tencent.mm.plugin.appbrand.g;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    private static boolean gdQ = false;

    public static b cD(Context context) {
        b jVar;
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        Object obj = (!sharedPreferences.getBoolean("switch_x5_jscore", true) || "1".equals(sharedPreferences.getString("tbs_webview_disable", "0")) || gdQ) ? 1 : null;
        if (obj != null) {
            jVar = new j(context);
        } else {
            i iVar = new i(context);
            if (iVar.gdR.isValid()) {
                jVar = iVar;
            } else {
                gdQ = true;
                iVar.destroy();
                jVar = new j(context);
            }
        }
        if (jVar instanceof j) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(434, 1, 1, false);
            x.i("MicroMsg.AppBrandJsRuntimeFactory", "Using WebView Based Javascript Engine");
        } else {
            com.tencent.mm.plugin.report.service.h.mEJ.a(434, !((i) jVar).gdR.isValid() ? 1 : 2, 1, false);
            x.i("MicroMsg.AppBrandJsRuntimeFactory", "Using v8 Javascript Engine, probably");
        }
        com.tencent.mm.plugin.report.service.h.mEJ.a(434, 0, 1, false);
        return jVar;
    }
}

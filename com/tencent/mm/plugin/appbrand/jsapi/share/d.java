package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.menu.k;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 240;
    public static final String NAME = "shareAppMessageDirectly";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiShareAppMessageDirectly", "invoke share app message directly.");
        if (jSONObject == null) {
            x.i("MicroMsg.JsApiShareAppMessageDirectly", "data is null");
            lVar.E(i, f("fail:data is null", null));
            return;
        }
        MMActivity c = c(lVar);
        if (c == null) {
            x.i("MicroMsg.JsApiShareAppMessageDirectly", "share app message fail, context is null");
            lVar.E(i, f("fail: page context is null", null));
            return;
        }
        p d = d(lVar);
        if (d == null) {
            x.i("MicroMsg.JsApiShareAppMessageDirectly", "share app message fail, pageView is null");
            lVar.E(i, f("fail:current page do not exist", null));
            return;
        }
        k lo = d.lo(com.tencent.mm.plugin.appbrand.menu.l.gjw);
        if (lo == null) {
            x.i("MicroMsg.JsApiShareAppMessageDirectly", "share app message fail, menuInfo is null.");
            lVar.E(i, f("fail:menu is null", null));
            return;
        }
        boolean optBoolean;
        AppBrandSysConfig appBrandSysConfig = lVar.fdO.fcu;
        boolean z = lo.fvX.getBoolean("enable_share_with_share_ticket", false);
        int i2 = z ? 3 : 2;
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("desc", "");
        String optString3 = jSONObject.optString("path");
        String optString4 = jSONObject.optString("imageUrl");
        String optString5 = jSONObject.optString("cacheKey");
        if (lVar.fdO.aaq()) {
            optBoolean = jSONObject.optBoolean("useDefaultSnapshot", false);
        } else {
            optBoolean = jSONObject.optBoolean("useDefaultSnapshot", true);
        }
        boolean ie = lo.fvX.ie("enable_share_dynamic");
        boolean ie2 = lo.fvX.ie("enable_share_with_updateable_msg");
        String string = lo.fvX.getString("enable_share_with_updateable_msg_template_id", "");
        String str = lVar.mAppId;
        String str2 = appBrandSysConfig.bGy;
        int i3 = appBrandSysConfig.frm.fih;
        int i4 = appBrandSysConfig.frm.fii;
        int i5 = 0;
        if (!bi.oW(str)) {
            g pY = com.tencent.mm.plugin.appbrand.a.pY(str);
            AppBrandInitConfig appBrandInitConfig = pY == null ? null : pY.fct;
            if (appBrandInitConfig != null) {
                i5 = appBrandInitConfig.bGM;
            } else {
                x.i("MicroMsg.JsApiShareAppMessageDirectly", "null = initConfig!");
            }
        }
        String qz = n.qz(lVar.mAppId);
        boolean tY = k.tY(optString4);
        String a = k.a(d, optString4, optBoolean);
        Serializable hashMap = new HashMap();
        hashMap.put("desc", optString2);
        hashMap.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(i2));
        hashMap.put("title", optString);
        hashMap.put("app_id", str);
        hashMap.put("pkg_type", Integer.valueOf(i3));
        hashMap.put("pkg_version", Integer.valueOf(i4));
        hashMap.put("img_url", optString4);
        hashMap.put("is_dynamic", Boolean.valueOf(ie));
        hashMap.put("cache_key", optString5);
        hashMap.put("path", optString3);
        if (!bi.oW(a)) {
            hashMap.put("delay_load_img_path", a);
        }
        x.i("MicroMsg.JsApiShareAppMessageDirectly", "msgParams:%s", new Object[]{hashMap});
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("mutil_select_is_ret", !z);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("scene_from", 3);
        intent.putExtra("appbrand_params", hashMap);
        intent.putExtra("Retr_Msg_Type", 2);
        com.tencent.mm.bg.d.a(c, ".ui.transmit.SelectConversationUI", intent, 1, new 1(this, lVar, i, str, str2, optString, optString2, qz, optString3, i2, tY, optString4, appBrandSysConfig, d, a, z, ie, ie2, string, optString5, i5, c));
    }
}

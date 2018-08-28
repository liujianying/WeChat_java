package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.u.b;
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

public final class c extends a {
    public static final int CTRL_INDEX = 73;
    public static final String NAME = "shareAppMessage";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.i("MicroMsg.JsApiShareAppMessage", "data is null");
            lVar.E(i, f("fail:data is null", null));
            return;
        }
        p d = d(lVar);
        if (d == null) {
            x.i("MicroMsg.JsApiShareAppMessage", "share app message fail, pageView is null");
            lVar.E(i, f("fail:current page do not exist", null));
            return;
        }
        k lo = d.lo(com.tencent.mm.plugin.appbrand.menu.l.gjw);
        if (lo == null) {
            x.i("MicroMsg.JsApiShareAppMessage", "share app message fail, menuInfo is null.");
            lVar.E(i, f("fail:menu is null", null));
            return;
        }
        b bVar = lo.fvX;
        if (bVar.ie("user_clicked_share_btn")) {
            x.i("MicroMsg.JsApiShareAppMessage", "invoke share app message");
            bVar.w("user_clicked_share_btn", false);
            MMActivity c = c(lVar);
            if (c == null) {
                x.i("MicroMsg.JsApiShareAppMessage", "share app message fail, context is null");
                lVar.E(i, f("fail: page context is null", null));
                return;
            }
            boolean optBoolean;
            AppBrandSysConfig appBrandSysConfig = lVar.fdO.fcu;
            boolean z = bVar.getBoolean("enable_share_with_share_ticket", false);
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
            boolean ie = bVar.ie("enable_share_dynamic");
            boolean ie2 = bVar.ie("enable_share_with_updateable_msg");
            String string = bVar.getString("enable_share_with_updateable_msg_template_id", "");
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
                    x.i("MicroMsg.JsApiShareAppMessage", "null = initConfig!");
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
            x.i("MicroMsg.JsApiShareAppMessage", "msgParams:%s", new Object[]{hashMap});
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("mutil_select_is_ret", !z);
            intent.putExtra("select_is_ret", true);
            intent.putExtra("scene_from", 3);
            intent.putExtra("appbrand_params", hashMap);
            intent.putExtra("Retr_Msg_Type", 2);
            d.a(c, ".ui.transmit.SelectConversationUI", intent, 1, new 1(this, lVar, i, str, optString3, z, str2, optString, optString2, qz, i2, optString4, appBrandSysConfig, string, d, tY, a, ie, ie2, optString5, i5, c));
            return;
        }
        x.i("MicroMsg.JsApiShareAppMessage", "share app message fail, not allow to share");
        lVar.E(i, f("fail:not allow to share", null));
    }
}

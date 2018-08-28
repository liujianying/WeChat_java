package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class au extends a {
    public static final int CTRL_INDEX = 192;
    public static final String NAME = "openSetting";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiOpenSetting", "jumpToSettingView!");
        AppBrandSysConfig appBrandSysConfig = lVar.fdO.fcu;
        if (appBrandSysConfig == null) {
            x.e("MicroMsg.JsApiOpenSetting", "config is null!");
            lVar.E(i, f("fail", null));
            return;
        }
        MMActivity c = e.c(lVar);
        if (c == null) {
            lVar.E(i, f("fail", null));
            x.e("MicroMsg.JsApiOpenSetting", "mmActivity is null, invoke fail!");
            return;
        }
        c.geJ = new 1(this, lVar, i);
        Intent putExtra = new Intent(lVar.getContext(), AppBrandAuthorizeUI.class).putExtra("key_username", appBrandSysConfig.bGy);
        putExtra.putExtra("key_app_authorize_jsapi", true);
        d.b(c, "appbrand", ".ui.AppBrandAuthorizeUI", putExtra, 1);
    }
}

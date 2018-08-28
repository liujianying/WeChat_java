package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class o extends a {
    public static final int CTRL_BYTE = 28;
    public static final String NAME = "getBrandWCPayRequest";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiGetBrandWCPayRequest", "invoke");
        GameWebViewUI pageActivity = dVar.getPageActivity();
        if (jSONObject == null) {
            x.i("MicroMsg.GameJsApiGetBrandWCPayRequest", "data is null");
            dVar.E(i, a.f("get_brand_wcpay_request:fail_invalid_data", null));
            return;
        }
        h.a(pageActivity, new g(jSONObject), hashCode() & 65535, new 1(this, dVar, i));
    }
}

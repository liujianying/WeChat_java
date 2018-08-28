package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class ar extends a {
    public static final int CTRL_BYTE = 218;
    public static final String NAME = "setBounceBackground";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiSetBounceBackground", "invoke");
        if (jSONObject == null || bi.oW(jSONObject.optString("backgroundColor"))) {
            dVar.E(i, a.f("setBounceBackground:fail_invalid_data", null));
            return;
        }
        dVar.setBounceBackground(jSONObject.optString("backgroundColor"));
        dVar.E(i, a.f("setBounceBackground:ok", null));
    }
}

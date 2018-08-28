package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.gamewebview.ui.d.25;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class k extends a {
    public static final int CTRL_BYTE = 189;
    public static final String NAME = "clearBounceBackground";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiClearBounceBackground", "invoke");
        if (dVar.jIZ != null) {
            dVar.mHandler.post(new 25(dVar));
        }
        dVar.E(i, a.f("clearBounceBackground:ok", null));
    }
}

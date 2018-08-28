package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class aw extends a {
    public static final int CTRL_BYTE = 270;
    public static final String NAME = "setScreenOrientation";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        int i2 = 0;
        x.i("MicroMsg.GameJsApiSetScreenOrientation", "invoke");
        if (jSONObject != null) {
            String optString = jSONObject.optString("orientation");
            if (!bi.oW(optString)) {
                if (!optString.equals("horizontal")) {
                    if (optString.equals("vertical")) {
                        i2 = 1;
                    } else if (optString.equals("sensor")) {
                        i2 = 4;
                    } else if (!optString.equals("horizontal_unforced")) {
                        i2 = optString.equals("vertical_unforced") ? 1 : -1;
                    }
                }
                dVar.getWebPage().setPageOrientation(i2);
                dVar.E(i, a.f("setScreenOrientation:ok", null));
                return;
            }
        }
        x.e("MicroMsg.GameJsApiSetScreenOrientation", "data is null");
        dVar.E(i, a.f("setScreenOrientation:fail_invalid_data", null));
    }
}

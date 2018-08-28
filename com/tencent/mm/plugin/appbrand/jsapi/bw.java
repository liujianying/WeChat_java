package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Vibrator;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class bw extends a {
    public static final int CTRL_INDEX = 231;
    public static final String NAME = "vibrateLong";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiVibrateLong", "JsApiVibrateLong!");
        Vibrator vibrator = (Vibrator) lVar.getContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(400);
        }
        lVar.E(i, f("ok", null));
    }
}

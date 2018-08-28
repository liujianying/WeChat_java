package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Vibrator;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class bx extends a {
    public static final int CTRL_INDEX = 230;
    public static final String NAME = "vibrateShort";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiVibrateShort", "JsApiVibrateShort services!");
        cy(lVar.getContext());
        lVar.E(i, f("ok", null));
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiVibrateShort", "JsApiVibrateShort!");
        cy(pVar.mContext);
        pVar.E(i, f("ok", null));
    }

    private static void cy(Context context) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(15);
        }
    }
}

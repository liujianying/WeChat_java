package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.graphics.Color;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

public final class au extends a {
    public static final int CTRL_BYTE = 182;
    public static final String NAME = "setNavigationBarColor";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        int i2;
        int i3 = 1;
        x.i("MicroMsg.GameJsApiSetNavigationBarColor", "invoke");
        int i4 = -1;
        try {
            i4 = Color.parseColor(jSONObject.optString("color")) | WebView.NIGHT_MODE_COLOR;
            i2 = jSONObject.optInt("actionCode") == i3 ? i3 : 0;
        } catch (Exception e) {
            x.e("MicroMsg.GameJsApiSetNavigationBarColor", e.getMessage());
            i2 = i3;
        }
        try {
            bi.getFloat(jSONObject.optString("alpha"), 1.0f);
        } catch (Exception e2) {
            x.e("MicroMsg.GameJsApiSetNavigationBarColor", e2.getMessage());
        }
        if (i2 != 0) {
            dVar.gnw = android.support.v4.content.a.g(dVar.jIJ, R.e.action_bar_color);
            dVar.gny = "";
            dVar.aSS();
        } else {
            dVar.setStatusBarColor(i4);
        }
        dVar.E(i, a.f("setNavigationBarColor:ok", null));
    }
}

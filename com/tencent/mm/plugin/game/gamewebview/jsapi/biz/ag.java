package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class ag extends a {
    public static final int CTRL_BYTE = 250;
    public static final int DO_IN_ENV = 2;
    public static final String NAME = "openWeApp";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiOpenWeApp", "invoke");
        JSONObject ti = d.ti(str);
        if (ti == null) {
            x.e("MicroMsg.GameJsApiOpenWeApp", "data is null");
            aVar.tp(a.f("openWeApp:fail_null_data", null));
            return;
        }
        qu quVar = new qu();
        quVar.cbq.context = context;
        quVar.cbq.userName = ti.optString("userName");
        quVar.cbq.appId = ti.optString("appId");
        quVar.cbq.cbs = ti.optString("relativeURL");
        quVar.cbq.cbu = ti.optInt("appVersion", 0);
        quVar.cbq.scene = ti.optInt("scene", 1018);
        quVar.cbq.bGG = ti.optString("sceneNote");
        if (bi.oW(quVar.cbq.bGG)) {
            quVar.cbq.bGG = p.encode(bi.oV(ti.optString("current_url")));
        }
        quVar.cbq.cbv = ti.optString("downloadURL");
        quVar.cbq.cbt = ti.optInt("openType", 0);
        quVar.cbq.cbw = ti.optString("checkSumMd5");
        quVar.cbq.cby = false;
        com.tencent.mm.sdk.b.a.sFg.m(quVar);
        if (quVar.cbr.cbD) {
            aVar.tp(a.f("openWeApp:ok", null));
        } else {
            aVar.tp(a.f("openWeApp:fail:" + bi.oV(quVar.cbr.cbE), null));
        }
    }
}

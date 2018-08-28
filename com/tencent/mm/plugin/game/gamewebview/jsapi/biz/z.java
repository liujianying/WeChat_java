package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class z extends a {
    public static final int CTRL_BYTE = 277;
    public static final int DO_IN_ENV = 2;
    public static final String NAME = "launchMiniProgram";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        int i = 1;
        x.i("MicroMsg.GameJsApiLaunchMiniProgram", "invoke");
        JSONObject ti = d.ti(str);
        if (ti == null) {
            x.e("MicroMsg.GameJsApiLaunchMiniProgram", "data is null");
            aVar.tp(a.f(a.f("launchMiniProgram:fail_null_data", null), null));
            return;
        }
        String optString = ti.optString("targetAppId");
        String optString2 = ti.optString("current_url");
        String optString3 = ti.optString("current_appid");
        if (bi.oW(optString3)) {
            optString3 = ti.optString("referrerAppId");
        }
        if (bi.oW(optString)) {
            aVar.tp(a.f("launchMiniProgram:fail_invalid_targetAppId", null));
        } else if (bi.oW(optString3)) {
            aVar.tp(a.f("launchMiniProgram:fail_invalid_referrerAppId", null));
        } else {
            String oV = bi.oV(ti.optString("envVersion"));
            int i2 = -1;
            switch (oV.hashCode()) {
                case 110628630:
                    if (oV.equals("trial")) {
                        i2 = 1;
                        break;
                    }
                    break;
                case 1559690845:
                    if (oV.equals("develop")) {
                        i2 = 0;
                        break;
                    }
                    break;
            }
            switch (i2) {
                case 0:
                    break;
                case 1:
                    i = 2;
                    break;
                default:
                    i = 0;
                    break;
            }
            ((com.tencent.mm.plugin.appbrand.n.d) g.l(com.tencent.mm.plugin.appbrand.n.d.class)).a(context, optString2, optString3, optString, i, ti.optString("path"));
            aVar.tp(a.f("launchMiniProgram:ok", null));
        }
    }
}

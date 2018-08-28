package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.webview.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class at extends a {
    public static final int CTRL_BYTE = 298;
    public static final int DO_IN_ENV = 1;
    public static final String NAME = "setGameData";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiSetGameData", "invoke");
        JSONObject ti = d.ti(str);
        if (ti == null) {
            x.e("MicroMsg.GameJsApiSetGameData", "data is null");
            aVar.tp(a.f("setGameData:fail_null_data", null));
            return;
        }
        String optString = ti.optString("current_appid");
        if (bi.oW(optString)) {
            x.i("MicroMsg.GameJsApiSetGameData", "appId is null");
            aVar.tp(a.f("setGameData:fail_appid_null", null));
            return;
        }
        String optString2 = ti.optString("key");
        String optString3 = ti.optString("value");
        String optString4 = ti.optString("weight", "1");
        String optString5 = ti.optString("expireTime");
        boolean optBoolean = ti.optBoolean("autoClean", true);
        if (bi.oW(optString2) || bi.oW(optString3)) {
            x.i("MicroMsg.GameJsApiSetGameData", "key or value is null");
            aVar.tp(a.f("setGameData:fail_null_key", null));
        } else if (b.bTB().a(optString, optString2, optString3, optString4, optString5, optBoolean)) {
            aVar.tp(a.f("setGameData:ok", null));
        } else {
            aVar.tp(a.f("setGameData:fail_exceed_size", null));
        }
    }
}

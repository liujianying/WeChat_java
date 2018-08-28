package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.webview.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l extends a {
    public static final int CTRL_BYTE = 300;
    public static final int DO_IN_ENV = 1;
    public static final String NAME = "clearGameData";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiSetGameData", "invoke");
        JSONObject ti = d.ti(str);
        if (ti == null) {
            x.e("MicroMsg.GameJsApiSetGameData", "data is null");
            aVar.tp(a.f("clearGameData:fail_null_data", null));
            return;
        }
        String optString = ti.optString("current_appid");
        if (bi.oW(optString)) {
            x.i("MicroMsg.GameJsApiSetGameData", "appId is null");
            aVar.tp(a.f("clearGameData:fail_appid_null", null));
            return;
        }
        JSONArray optJSONArray = ti.optJSONArray("keys");
        boolean optBoolean = ti.optBoolean("clearAllData", false);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            b.bTB().b(optString, optJSONArray);
            aVar.tp(a.f("clearGameData:ok", null));
        } else if (optBoolean) {
            b.bTB().Qc(optString);
            aVar.tp(a.f("clearGameData:ok", null));
        } else {
            x.i("MicroMsg.GameJsApiSetGameData", "keys is null");
            aVar.tp(a.f("clearGameData:fail", null));
        }
    }
}

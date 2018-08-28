package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.webview.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p extends a {
    public static final int CTRL_BYTE = 299;
    public static final int DO_IN_ENV = 1;
    public static final String NAME = "getGameData";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiSetGameData", "invoke");
        JSONObject ti = d.ti(str);
        if (ti == null) {
            x.e("MicroMsg.GameJsApiSetGameData", "data is null");
            aVar.tp(a.f("getGameData:fail_null_data", null));
            return;
        }
        String optString = ti.optString("current_appid");
        if (bi.oW(optString)) {
            x.i("MicroMsg.GameJsApiSetGameData", "appId is null");
            aVar.tp(a.f("getGameData:fail_appid_null", null));
            return;
        }
        String optString2 = ti.optString("key");
        if (bi.oW(optString2)) {
            x.i("MicroMsg.GameJsApiSetGameData", "key is null");
            aVar.tp(a.f("getGameData:fail_null_key", null));
            return;
        }
        com.tencent.mm.plugin.webview.b.a fk = b.bTB().fk(optString, optString2);
        if (bi.oW(fk.field_value)) {
            aVar.tp(a.f("getGameData:ok", null));
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put("value", fk.field_value);
        hashMap.put("weight", fk.field_weight);
        hashMap.put("expireTime", Long.valueOf(fk.field_expireTime - (System.currentTimeMillis() / 1000)));
        aVar.tp(f("getGameData:ok", hashMap));
    }
}

package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.net.Uri;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import org.json.JSONObject;

public final class aj extends a {
    public static final int CTRL_BYTE = -2;
    public static final String NAME = "preRequestData";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiPreRequestData", "invoke");
        if (Uri.parse(dVar.getCurrentURL()).getHost().equals("game.weixin.qq.com")) {
            String optString = jSONObject.optString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
            String optString2 = jSONObject.optString("method");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            x.i("MicroMsg.GameJsApiPreRequestData", "reqUrl = %s, method = %s", new Object[]{optString, optString2});
            if (bi.oW(optString) || bi.oW(optString2)) {
                x.i("MicroMsg.GameJsApiPreRequestData", "reqUrl or method is null");
                dVar.E(i, a.f("preRequestData:fail", null));
                return;
            }
            com.tencent.mm.plugin.game.gamewebview.c.a.c(optString, optString2, optJSONObject);
            dVar.E(i, a.f("preRequestData:ok", null));
            return;
        }
        x.i("MicroMsg.GameJsApiPreRequestData", "host is not game");
        dVar.E(i, a.f("preRequestData:fail", null));
    }
}

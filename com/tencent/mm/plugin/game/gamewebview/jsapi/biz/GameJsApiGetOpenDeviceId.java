package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class GameJsApiGetOpenDeviceId extends a {
    public static final int CTRL_BYTE = 227;
    public static final String NAME = "getOpenDeviceId";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiGetOpenDeviceId", "invoke");
        GetDeviceIdTask getDeviceIdTask = new GetDeviceIdTask();
        GameWebViewMainProcessService.b(getDeviceIdTask);
        String cacheAppId = dVar.getCacheAppId();
        if (bi.oW(getDeviceIdTask.byN) || bi.oW(getDeviceIdTask.jHa) || bi.oW(cacheAppId)) {
            dVar.E(i, a.f("getOpenDeviceId:fail", null));
            return;
        }
        String ce = ac.ce(ac.ce(cacheAppId + getDeviceIdTask.byN));
        String ce2 = ac.ce(ac.ce(cacheAppId + getDeviceIdTask.jHa));
        Map hashMap = new HashMap();
        hashMap.put("deviceid", ce);
        hashMap.put("newDeviceId", ce2);
        dVar.E(i, f("getOpenDeviceId:ok", hashMap));
    }
}

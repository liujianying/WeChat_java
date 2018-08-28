package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.game.wepkg.model.f.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.28;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class g$28$1 implements a {
    final /* synthetic */ 28 qjh;

    g$28$1(28 28) {
        this.qjh = 28;
    }

    public final void L(JSONObject jSONObject) {
        Map hashMap = new HashMap();
        hashMap.put("wepkg_info", jSONObject);
        this.qjh.qiK.a(this.qjh.qiH, "getLocalWePkgInfo:ok", hashMap);
    }
}

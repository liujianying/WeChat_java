package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.r.1;
import com.tencent.mm.plugin.game.wepkg.model.f.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class r$1$1 implements a {
    final /* synthetic */ 1 jGZ;

    r$1$1(1 1) {
        this.jGZ = 1;
    }

    public final void L(JSONObject jSONObject) {
        Map hashMap = new HashMap();
        hashMap.put("wepkg_info", jSONObject);
        this.jGZ.jGI.tp(r.f("getLocalWePkgInfo:ok", hashMap));
    }
}

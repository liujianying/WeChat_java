package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.protocal.c.aot;
import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_BYTE = 232;
    public static final String NAME = "authorize";

    public final void a(com.tencent.mm.plugin.game.gamewebview.ui.d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiAuthorize", "invoke");
        GameWebViewUI pageActivity = dVar.getPageActivity();
        JSONArray optJSONArray = jSONObject.optJSONArray("scope");
        if (optJSONArray == null) {
            x.e("MicroMsg.GameJsApiAuthorize", "scope is null!");
            dVar.E(i, a.f("authorize:fail", null));
            return;
        }
        String cacheAppId = dVar.getCacheAppId();
        if (bi.oW(cacheAppId)) {
            x.e("MicroMsg.GameJsApiAuthorize", "appId is null!");
            dVar.E(i, a.f("authorize:fail", null));
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            linkedList.add(optJSONArray.optString(i2));
        }
        b.a aVar = new b.a();
        aot aot = new aot();
        aVar.dIG = aot;
        aVar.dIH = new aou();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize";
        aVar.dIF = 1157;
        aVar.dII = 0;
        aVar.dIJ = 0;
        aot.jQb = cacheAppId;
        aot.rQZ = linkedList;
        aot.rRb = 0;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.KT(), new 1(this, new a.a(dVar, i), pageActivity, cacheAppId));
    }
}

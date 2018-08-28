package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.protocal.c.aox;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONObject;

public final class aa extends a {
    public static final int CTRL_BYTE = 231;
    public static final String NAME = "login";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiLogin", "invoke");
        GameWebViewUI pageActivity = dVar.getPageActivity();
        LinkedList linkedList = new LinkedList();
        String str = "";
        String str2 = "";
        String cacheAppId = dVar.getCacheAppId();
        if (bi.oW(cacheAppId)) {
            x.e("MicroMsg.GameJsApiLogin", "appId is null!");
            dVar.E(i, a.f("login:fail", null));
            return;
        }
        a.a aVar = new a.a(dVar, i);
        b.a aVar2 = new b.a();
        aox aox = new aox();
        aVar2.dIG = aox;
        aVar2.dIH = new aoy();
        aVar2.uri = "/cgi-bin/mmbiz-bin/js-login";
        aVar2.dIF = 1029;
        aVar2.dII = 0;
        aVar2.dIJ = 0;
        aox.jQb = cacheAppId;
        aox.rQZ = linkedList;
        aox.rRe = 0;
        aox.jPK = str2;
        aox.rRf = str;
        aox.rRb = 0;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar2.KT(), new 1(this, aVar, pageActivity, cacheAppId));
    }
}

package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.protocal.c.bxt;
import com.tencent.mm.protocal.c.bxu;
import org.json.JSONObject;

public final class bv extends a {
    public static final int CTRL_INDEX = 313;
    public static final String NAME = "verifyPlugin";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (jSONObject == null || jSONObject.opt("data") == null) {
            lVar.E(i, f("fail:data is null or nil", null));
            return;
        }
        String str = lVar.mAppId;
        bxt bxt = new bxt();
        a aVar = new a();
        aVar.dIG = bxt;
        aVar.dIH = new bxu();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/verifyplugin";
        aVar.dIF = 1714;
        aVar.dII = 0;
        aVar.dIJ = 0;
        bxt.bPS = str;
        bxt.stT = jSONObject.opt("data").toString();
        b.a(aVar.KT(), new 1(this, lVar, i));
    }
}

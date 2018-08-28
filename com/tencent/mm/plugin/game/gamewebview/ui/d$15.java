package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.b;
import com.tencent.xweb.c;
import java.util.Map;
import org.json.JSONObject;

class d$15 implements Runnable {
    final /* synthetic */ d jJO;
    final /* synthetic */ Map jJQ;
    final /* synthetic */ String jJR;

    d$15(d dVar, Map map, String str) {
        this.jJO = dVar;
        this.jJQ = map;
        this.jJR = str;
    }

    public final void run() {
        int i;
        if (!(this.jJQ == null || this.jJQ.size() == 0)) {
            d.I(this.jJO);
            c.ij(d.t(this.jJO));
            b cIi = b.cIi();
            for (String str : this.jJQ.keySet()) {
                cIi.setCookie(bi.Xl(this.jJR), str + "=" + ((String) this.jJQ.get(str)));
            }
            cIi.setCookie(bi.Xl(d.J(this.jJO)), "httponly");
            c.cIk();
            c.sync();
            x.i("MicroMsg.GameWebPageView", "cookies:%s", new Object[]{cIi.getCookie(bi.Xl(this.jJR))});
        }
        d dVar = this.jJO;
        String str2 = this.jJR;
        if (this.jJQ == null || this.jJQ.size() == 0) {
            i = 0;
        } else {
            i = 1;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fullurl", str2);
            jSONObject.put("set_cookie", i);
            dVar.cW("onGetA8KeyUrl", jSONObject.toString());
        } catch (Exception e) {
            x.e("MicroMsg.GameWebviewJsLoader", "onGetA8Key, e:" + e.getMessage());
        }
    }
}

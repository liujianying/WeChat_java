package com.tencent.mm.plugin.webview.fts.c;

import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class d implements a {
    public al gbr;
    public int gbs;
    private com.tencent.mm.plugin.webview.ui.tools.jsapi.d pNV;
    private b$b pQK;
    FtsWebVideoView pQU;

    public d(FtsWebVideoView ftsWebVideoView, b$b b_b, com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar) {
        this.pQU = ftsWebVideoView;
        this.pQK = b_b;
        this.pQK.a(this);
        this.pNV = dVar;
    }

    public final void clean() {
        x.i("MicroMsg.JsApiVideoCallback", "clean %s", new Object[]{toString()});
        akb();
    }

    public final void ao(JSONObject jSONObject) {
        this.pNV.a("onVideoPlayerCallback", null, jSONObject);
    }

    public final void bTU() {
        try {
            JSONObject aka = aka();
            aka.put("currentTime", this.pQU.getCurrPosSec());
            ao(a(6, aka));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
        }
    }

    public final JSONObject aka() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", this.pQU.getCookieData());
        return jSONObject;
    }

    public final void akb() {
        if (this.gbr != null) {
            this.gbr.SO();
        }
    }

    public final void agL() {
    }

    public final void agK() {
    }

    public final void onDestroy() {
        x.d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
        clean();
        this.pQU.setCallback(null);
    }

    public final void ajd() {
    }

    public final boolean agV() {
        return false;
    }

    public final void bIu() {
    }

    public final void bTS() {
    }

    public final JSONObject a(int i, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("playerId", this.pQU.getmVideoPlayerId());
        jSONObject2.put("event", i);
        if (jSONObject != null) {
            jSONObject2.put("detail", jSONObject);
        }
        return jSONObject2;
    }
}

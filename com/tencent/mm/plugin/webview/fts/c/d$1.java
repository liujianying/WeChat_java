package com.tencent.mm.plugin.webview.fts.c;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class d$1 implements a {
    final /* synthetic */ d pQV;

    public d$1(d dVar) {
        this.pQV = dVar;
    }

    public final boolean vD() {
        try {
            int currPosMs = this.pQV.pQU.getCurrPosMs();
            if (Math.abs(currPosMs - this.pQV.gbs) >= 250) {
                this.pQV.gbs = currPosMs;
                d dVar = this.pQV;
                d dVar2 = this.pQV;
                d dVar3 = this.pQV;
                JSONObject aka = dVar3.aka();
                aka.put("currentTime", dVar3.pQU.getCurrPosSec());
                dVar.ao(dVar2.a(4, aka));
            }
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiVideoCallback", "OnVideoTimeUpdate e=%s", e);
        }
        return true;
    }
}

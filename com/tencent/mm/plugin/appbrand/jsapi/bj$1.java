package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

class bj$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JSONObject fHi;
    final /* synthetic */ bj fHj;

    bj$1(bj bjVar, JSONObject jSONObject, l lVar, int i) {
        this.fHj = bjVar;
        this.fHi = jSONObject;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void run() {
        float f = 0.01f;
        this.fHj.fHh = (float) this.fHi.optDouble("value");
        if (Float.isNaN(this.fHj.fHh) || this.fHj.fHh < 0.0f || this.fHj.fHh > 1.0f) {
            this.fCl.E(this.doP, this.fHj.f("fail:value invalid", null));
            x.e("MicroMsg.JsApiSetScreenBrightness", "value invalid");
            return;
        }
        MMActivity c = bj.c(this.fCl);
        if (c == null) {
            this.fCl.E(this.doP, this.fHj.f("fail", null));
            x.e("MicroMsg.JsApiSetScreenBrightness", "context is null, invoke fail!");
            return;
        }
        LayoutParams attributes = c.getWindow().getAttributes();
        if (Float.isNaN(this.fHj.fHg)) {
            this.fHj.fHg = attributes.screenBrightness;
            e.a(this.fCl.mAppId, new 1(this, attributes, c));
        }
        if (this.fHj.fHh >= 0.01f) {
            f = this.fHj.fHh;
        }
        attributes.screenBrightness = f;
        c.getWindow().setAttributes(attributes);
        this.fCl.E(this.doP, this.fHj.f("ok", null));
    }
}

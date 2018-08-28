package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

class JsApiChooseVideo$3 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JSONObject fHi;
    final /* synthetic */ JsApiChooseVideo fUP;

    JsApiChooseVideo$3(JsApiChooseVideo jsApiChooseVideo, l lVar, JSONObject jSONObject, int i) {
        this.fUP = jsApiChooseVideo;
        this.fCl = lVar;
        this.fHi = jSONObject;
        this.doP = i;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 115) {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                this.fCl.E(this.doP, this.fUP.f("fail:system permission denied", null));
            } else {
                this.fUP.a(this.fCl, this.fHi, this.doP);
            }
        }
    }
}

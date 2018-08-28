package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class i$3 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JSONObject fHi;
    final /* synthetic */ i fIF;

    i$3(i iVar, l lVar, JSONObject jSONObject, int i) {
        this.fIF = iVar;
        this.fCl = lVar;
        this.fHi = jSONObject;
        this.doP = i;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 116) {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                x.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, SYS_PERM_DENIED");
                this.fCl.E(this.doP, this.fIF.f("fail:system permission denied", null));
                return;
            }
            x.i("MicroMsg.Record.JsApiOperateRecorder", "PERMISSION_GRANTED, do invoke again");
            this.fIF.a(this.fCl, this.fHi, this.doP);
        }
    }
}

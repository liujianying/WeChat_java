package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

class e$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JSONObject fHi;
    final /* synthetic */ e fPE;

    e$1(e eVar, l lVar, JSONObject jSONObject, int i) {
        this.fPE = eVar;
        this.fCl = lVar;
        this.fHi = jSONObject;
        this.doP = i;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 48) {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                this.fCl.E(this.doP, this.fPE.f("fail:system permission denied", null));
            } else {
                this.fPE.a(this.fCl, this.fHi, this.doP);
            }
        }
    }
}

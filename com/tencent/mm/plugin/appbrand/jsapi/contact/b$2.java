package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

class b$2 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JSONObject fHi;
    final /* synthetic */ b fPk;

    b$2(b bVar, l lVar, JSONObject jSONObject, int i) {
        this.fPk = bVar;
        this.fCl = lVar;
        this.fHi = jSONObject;
        this.doP = i;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 48) {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                this.fCl.E(this.doP, this.fPk.f("permission_denied", null));
            } else {
                this.fPk.a(this.fCl, this.fHi, this.doP);
            }
        }
    }
}

package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession.RefreshSessionTask;
import com.tencent.mm.protocal.c.apc;
import com.tencent.mm.sdk.platformtools.x;

class JsApiRefreshSession$RefreshSessionTask$1 implements a {
    final /* synthetic */ RefreshSessionTask fGK;

    JsApiRefreshSession$RefreshSessionTask$1(RefreshSessionTask refreshSessionTask) {
        this.fGK = refreshSessionTask;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        x.d("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            apc apc = (apc) bVar.dIE.dIL;
            if (apc == null) {
                RefreshSessionTask.b(this.fGK, 0);
                x.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest failed, response is null!");
                RefreshSessionTask.b(this.fGK);
            } else {
                RefreshSessionTask.c(this.fGK, apc.rRd.bMH);
                String str2 = apc.rRd.bMI;
                if (RefreshSessionTask.c(this.fGK) == 0) {
                    RefreshSessionTask.d(this.fGK, apc.rRl);
                    RefreshSessionTask.c(this.fGK, apc.rRd.bMH);
                    RefreshSessionTask.b(this.fGK, 1);
                    RefreshSessionTask.d(this.fGK);
                } else {
                    RefreshSessionTask.c(this.fGK, apc.rRd.bMH);
                    RefreshSessionTask.b(this.fGK, 2);
                    x.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest ERROR %s", new Object[]{str2});
                    RefreshSessionTask.e(this.fGK);
                }
            }
        } else {
            RefreshSessionTask.b(this.fGK, 0);
            RefreshSessionTask.a(this.fGK);
        }
        return 0;
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;

class a$5 implements a {
    final /* synthetic */ a fWK;
    final /* synthetic */ b$b fWL;

    a$5(a aVar, b$b b_b) {
        this.fWK = aVar;
        this.fWL = b_b;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.fWK.hashCode() & 65535)) {
            if (i2 == -1) {
                Object obj = "";
                if (intent != null) {
                    obj = bi.aG(intent.getStringExtra("token"), "");
                }
                if (TextUtils.isEmpty(obj)) {
                    x.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is empty, verifyWCPayPassword:fail");
                    if (this.fWL != null) {
                        this.fWL.f(false, null);
                        return;
                    }
                    return;
                }
                x.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is valid, verifyWCPayPassword:ok");
                if (this.fWL != null) {
                    this.fWL.f(true, obj);
                }
            } else if (this.fWL != null) {
                this.fWL.f(false, null);
            }
        }
    }
}

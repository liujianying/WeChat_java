package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;

class a$1 implements a {
    final /* synthetic */ b.a fWJ;
    final /* synthetic */ a fWK;

    a$1(a aVar, b.a aVar2) {
        this.fWK = aVar;
        this.fWJ = aVar2;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.fWK.hashCode() & 65535)) {
            if (i2 == -1) {
                if (this.fWJ != null) {
                    this.fWJ.a(1, null, null);
                }
            } else if (i2 == 5) {
                int intExtra = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                x.e("MicroMsg.AppBrandJsApiPayService", "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(intExtra), bi.oV(intent.getStringExtra("key_jsapi_pay_err_msg"))});
                if (this.fWJ != null) {
                    this.fWJ.a(2, r1, null);
                }
            } else if (this.fWJ != null) {
                this.fWJ.a(3, null, null);
            }
        }
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

class e$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ p fJO;
    final /* synthetic */ e fKv;

    e$1(e eVar, p pVar, int i) {
        this.fKv = eVar;
        this.fJO = pVar;
        this.doP = i;
    }

    public final void b(int i, int i2, Intent intent) {
        x.i("MicroMsg.JsApiOpenRealnameAuth", "mmOnActivityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1) {
            Map hashMap = new HashMap();
            if (i2 == -1) {
                x.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth ok");
                String stringExtra = intent.getStringExtra("intent_auth_token");
                if (bi.oW(stringExtra)) {
                    this.fJO.E(this.doP, this.fKv.f("fail", hashMap));
                    return;
                }
                hashMap.put("errCode", Integer.valueOf(0));
                hashMap.put("auth_token", stringExtra);
                this.fJO.E(this.doP, this.fKv.f("ok", hashMap));
                x.d("MicroMsg.JsApiOpenRealnameAuth", "authToken:%s", new Object[]{stringExtra});
            } else if (i2 == 0) {
                x.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth cancel");
                this.fJO.E(this.doP, this.fKv.f("cancel", null));
            } else if (i2 == 1) {
                x.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth fail");
                if (intent != null) {
                    int intExtra = intent.getIntExtra("intent_err_code", -1);
                    String stringExtra2 = intent.getStringExtra("intent_err_msg");
                    hashMap.put("errCode", Integer.valueOf(intExtra));
                    this.fJO.E(this.doP, this.fKv.f("fail:" + bi.oV(stringExtra2), hashMap));
                    x.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(intExtra), stringExtra2});
                    return;
                }
                this.fJO.E(this.doP, this.fKv.f("fail", hashMap));
            }
        }
    }
}

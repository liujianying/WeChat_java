package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

class o$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ d jGF;
    final /* synthetic */ o jGX;

    o$1(o oVar, d dVar, int i) {
        this.jGX = oVar;
        this.jGF = dVar;
        this.doP = i;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.jGX.hashCode() & 65535)) {
            if (i2 == -1) {
                this.jGF.E(this.doP, com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("ok", null));
            } else if (i2 == 5) {
                Map hashMap = new HashMap();
                int intExtra = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                String oV = bi.oV(intent.getStringExtra("key_jsapi_pay_err_msg"));
                hashMap.put("err_code", Integer.valueOf(intExtra));
                hashMap.put("err_desc", oV);
                x.e("MicroMsg.GameJsApiGetBrandWCPayRequest", "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(intExtra), oV});
                this.jGF.E(this.doP, o.f("get_brand_wcpay_request:fail", hashMap));
            } else {
                this.jGF.E(this.doP, com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("get_brand_wcpay_request:cancel", null));
            }
        }
    }
}

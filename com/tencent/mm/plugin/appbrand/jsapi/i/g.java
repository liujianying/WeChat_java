package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = 285;
    public static final String NAME = "requestVirtualPayment";
    boolean fWQ = false;

    public final void a(final l lVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        MMActivity c = c(lVar);
        if (c == null) {
            lVar.E(i, f("fail", null));
        } else if (this.fWQ) {
            Map hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(2));
            x.e("MicroMsg.JsApiRequestVirtualPayment", "errCode: %d, errMsg: an order is being paid", new Object[]{Integer.valueOf(2)});
            lVar.E(i, f("fail an order is being paid", hashMap));
        } else {
            this.fWQ = true;
            AnonymousClass1 anonymousClass1 = new MMActivity.a() {
                public final void b(int i, int i2, Intent intent) {
                    if (i == (g.this.hashCode() & 65535)) {
                        g.this.fWQ = false;
                        if (i2 == -1) {
                            int intExtra = intent.getIntExtra("key_err_code", 1);
                            if (intExtra == 0) {
                                x.e("MicroMsg.JsApiRequestVirtualPayment", "requestIAP ok");
                                lVar.E(i, g.this.f("ok", null));
                                return;
                            }
                            Map hashMap = new HashMap();
                            String oV = bi.oV(intent.getStringExtra("key_err_msg"));
                            hashMap.put("errCode", Integer.valueOf(intExtra));
                            x.e("MicroMsg.JsApiRequestVirtualPayment", "requestVirtualPayment errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(intExtra), oV});
                            lVar.E(i, g.this.f("fail " + oV, hashMap));
                            return;
                        }
                        lVar.E(i, g.this.f("cancel", null));
                    }
                }
            };
            Bundle bundle = new Bundle();
            bundle.putInt("scene", 0);
            p d = d(lVar);
            if (d != null) {
                d.a(2, bundle, new Object[0]);
            } else {
                x.e("MicroMsg.JsApiRequestVirtualPayment", "hy: associated page view is null!!");
            }
            Intent intent = new Intent();
            x.i("MicroMsg.JsApiRequestVirtualPayment", "iap payment start ... data : " + jSONObject);
            intent.putExtra("key_appid", lVar.mAppId);
            intent.putExtra("key_product_id", jSONObject.optString("priceLevel"));
            intent.putExtra("key_price", jSONObject.optString("priceLevel"));
            intent.putExtra("key_currency_type", jSONObject.optString("currencyType", "CNY"));
            intent.putExtra("key_desc", jSONObject.optString("desc"));
            intent.putExtra("key_count", jSONObject.optInt("count", 1));
            intent.putExtra("key_is_mini_program", true);
            intent.putExtra("key_busiid", jSONObject.optString("outTradeNo"));
            intent.putExtra("key_virtual_pay_sign", jSONObject.optString("virtualPaySign"));
            intent.putExtra("key_attach", jSONObject.optString("attach"));
            c.geJ = anonymousClass1;
            d.b(c, "wallet_index", ".ui.WalletIapUI", intent, hashCode() & 65535);
        }
    }
}

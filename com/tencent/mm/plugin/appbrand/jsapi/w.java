package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class w extends a {
    public static final int CTRL_INDEX = 286;
    public static final String NAME = "chooseInvoiceTitle";

    public final void a(final l lVar, JSONObject jSONObject, final int i) {
        Intent intent = new Intent();
        intent.putExtra("req_scene", 0);
        intent.putExtra("launch_from_appbrand", true);
        MMActivity c = c(lVar);
        if (c == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        c.geJ = new a() {
            public final void b(int i, int i2, Intent intent) {
                if (i == (w.this.hashCode() & 65535)) {
                    if (i2 == -1 && intent != null) {
                        Map hashMap = new HashMap();
                        String aG = bi.aG(intent.getStringExtra("choose_invoice_title_info"), "");
                        x.i("MicroMsg.JsApiChooseInvoiceTitle", "choose_invoice_title_info is : " + aG);
                        hashMap.put("invoiceTitleInfo", aG);
                        lVar.E(i, w.this.f("ok", hashMap));
                    } else if (i2 == 0) {
                        lVar.E(i, w.this.f("cancel", null));
                    } else {
                        lVar.E(i, w.this.f("fail", null));
                    }
                }
            }
        };
        d.a(c, "address", ".ui.InvoiceListUI", intent, hashCode() & 65535, false);
    }
}

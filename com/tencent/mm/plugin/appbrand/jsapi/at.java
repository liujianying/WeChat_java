package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONArray;
import org.json.JSONObject;

public final class at extends a {
    public static final int CTRL_INDEX = 434;
    public static final String NAME = "openQRCode";
    private static volatile boolean fGq = false;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (fGq) {
            lVar.E(i, f("cancel", null));
            return;
        }
        fGq = true;
        x.i("MicroMsg.JsApiOpenQRCode", "openQRCode data::%s", new Object[]{jSONObject});
        MMActivity c = c(lVar);
        if (c == null) {
            fGq = false;
            x.e("MicroMsg.JsApiOpenQRCode", "pageContext is null, err");
            lVar.E(i, f("fail:context is err", null));
            return;
        }
        boolean z;
        boolean z2;
        int i2;
        jSONObject.optString("desc");
        int i3 = bi.getInt(jSONObject.optString("needResult"), 1);
        String optString = jSONObject.optString("scanType");
        if (bi.oW(optString)) {
            z = true;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        if (optString != null) {
            try {
                JSONArray jSONArray = new JSONArray(optString);
                int i4 = 0;
                while (i4 < jSONArray.length()) {
                    boolean z3;
                    optString = (String) jSONArray.get(i4);
                    if (optString.equalsIgnoreCase("qrCode")) {
                        z3 = z;
                        z2 = true;
                    } else if (optString.equalsIgnoreCase("barCode")) {
                        z3 = true;
                    } else {
                        z3 = z;
                    }
                    i4++;
                    z = z3;
                }
            } catch (Exception e) {
                x.e("MicroMsg.JsApiOpenQRCode", "doScanQRCode, ex in scanType");
            }
        }
        if (z2 && !r2) {
            i2 = 8;
        } else if (z2 || !r2) {
            i2 = 1;
        } else {
            i2 = 4;
        }
        c.geJ = new 1(this, lVar, i);
        if (i3 == 0) {
            x.i("MicroMsg.JsApiOpenQRCode", "doScanQRCode, startActivity");
            Intent intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", i2);
            d.c(c, "scanner", ".ui.SingleTopScanUI", intent);
            fGq = false;
            lVar.E(i, f("ok", null));
        } else if (i3 == 1) {
            x.d("MicroMsg.JsApiOpenQRCode", "doScanQRCode, startActivityForResult requestCode:%d", new Object[]{Integer.valueOf(hashCode())});
            Intent intent2 = new Intent();
            intent2.putExtra("BaseScanUI_select_scan_mode", i2);
            intent2.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            intent2.putExtra("key_is_finish_on_scanned", true);
            intent2.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 3);
            d.a(c, "scanner", ".ui.SingleTopScanUI", intent2, hashCode() & 65535, false);
        } else {
            x.e("MicroMsg.JsApiOpenQRCode", "needResult is err");
            lVar.E(i, f("fail:invalid data", null));
        }
    }
}

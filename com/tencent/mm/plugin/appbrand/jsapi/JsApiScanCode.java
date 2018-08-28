package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiScanCode extends a {
    public static final int CTRL_INDEX = 148;
    public static final String NAME = "scanCode";
    private static volatile boolean fGq = false;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (fGq) {
            lVar.E(i, f("cancel", null));
            return;
        }
        fGq = true;
        MMActivity c = e.c(lVar);
        if (c == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        c.geJ = new 1(this, lVar, i);
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 1);
        intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
        intent.putExtra("key_is_finish_on_scanned", true);
        intent.putExtra("key_is_hide_right_btn", jSONObject.optBoolean("onlyFromCamera", false));
        JSONArray optJSONArray = jSONObject.optJSONArray("scanType");
        Set<Integer> hashSet = new HashSet();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            hashSet.add(Integer.valueOf(2));
            hashSet.add(Integer.valueOf(3));
            hashSet.add(Integer.valueOf(4));
            hashSet.add(Integer.valueOf(5));
            hashSet.add(Integer.valueOf(0));
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                if ("zzm".equalsIgnoreCase(optJSONArray.optString(i2, "")) && lVar.fdO.fcu.frk) {
                    hashSet.add(Integer.valueOf(6));
                }
            }
            int[] iArr = new int[hashSet.size()];
            int i3 = 0;
            for (Integer intValue : hashSet) {
                int i4 = i3 + 1;
                iArr[i3] = intValue.intValue();
                i3 = i4;
            }
            intent.putExtra("key_support_scan_code_type", iArr);
        }
        d.a(c, "scanner", ".ui.SingleTopScanUI", intent, hashCode() & 65535, false);
    }
}

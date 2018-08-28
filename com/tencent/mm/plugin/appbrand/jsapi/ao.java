package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class ao extends a {
    public static final int CTRL_INDEX = 62;
    public static final String NAME = "openAddress";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        Intent intent = new Intent();
        intent.putExtra("req_app_id", lVar.mAppId);
        intent.putExtra("launch_from_appbrand", true);
        MMActivity c = c(lVar);
        if (c == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        c.geJ = new 1(this, lVar, i);
        d.a(c, "address", ".ui.WalletSelectAddrUI", intent, hashCode() & 65535, false);
    }
}

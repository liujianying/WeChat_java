package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.e;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.plugin.appbrand.widget.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.Closeable;
import java.io.InputStream;
import org.json.JSONObject;

public final class bl extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "setTabBarItem";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        try {
            int i2 = jSONObject.getInt("index");
            String optString = jSONObject.optString("text", "");
            String optString2 = jSONObject.optString("iconPath", "");
            String optString3 = jSONObject.optString("selectedIconPath", "");
            com.tencent.mm.plugin.appbrand.page.l currentPage = lVar.fdO.fcz.getCurrentPage();
            if (currentPage instanceof e) {
                Closeable d = ao.d(lVar.fdO, optString2);
                Bitmap decodeStream = BitmapFactory.decodeStream(d);
                if (d != null) {
                    bi.d(d);
                }
                InputStream d2 = ao.d(lVar.fdO, optString3);
                Bitmap decodeStream2 = BitmapFactory.decodeStream(d2);
                if (d2 != null) {
                    bi.d(d);
                }
                c tabBar = ((e) currentPage).getTabBar();
                if (i2 < tabBar.gEl.size()) {
                    a aVar = (a) tabBar.gEl.get(i2);
                    aVar.gEw = optString;
                    if (decodeStream == null) {
                        decodeStream = aVar.sq;
                    }
                    aVar.sq = decodeStream;
                    if (decodeStream2 == null) {
                        decodeStream = aVar.gEv;
                    } else {
                        decodeStream = decodeStream2;
                    }
                    aVar.gEv = decodeStream;
                    tabBar.aoV();
                }
                lVar.E(i, f("ok", null));
                return;
            }
            lVar.E(i, f("fail:not TabBar page", null));
        } catch (Exception e) {
            lVar.E(i, f("fail", null));
        }
    }
}

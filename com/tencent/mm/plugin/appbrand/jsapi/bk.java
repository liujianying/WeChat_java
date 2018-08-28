package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.e;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONObject;

public final class bk extends a {
    public static final int CTRL_INDEX = 389;
    public static final String NAME = "setTabBarBadge";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        try {
            int i2 = jSONObject.getInt("index");
            String optString = jSONObject.optString(DownloadSettingTable$Columns.TYPE, "none");
            String optString2 = jSONObject.optString("badgeValue", "");
            String optString3 = jSONObject.optString("badgeColor", "");
            String optString4 = jSONObject.optString("badgeTextColor", "");
            com.tencent.mm.plugin.appbrand.page.l currentPage = lVar.fdO.fcz.getCurrentPage();
            if (currentPage instanceof e) {
                c tabBar = ((e) currentPage).getTabBar();
                optString2 = optString2.substring(0, optString2.length() < 4 ? optString2.length() : 4);
                int aO = j.aO(optString3, 0);
                int aO2 = j.aO(optString4, -1);
                for (int i3 = 0; i3 < tabBar.gEl.size(); i3++) {
                    if (i3 == i2) {
                        ((c$a) tabBar.gEl.get(i3)).aoW();
                        if ("redDot".equals(optString)) {
                            ((c$a) tabBar.gEl.get(i3)).gEy = true;
                        } else if ("text".equals(optString)) {
                            ((c$a) tabBar.gEl.get(i3)).gEz = optString2;
                            ((c$a) tabBar.gEl.get(i3)).gEA = aO;
                            ((c$a) tabBar.gEl.get(i3)).gEB = aO2;
                        }
                    }
                }
                tabBar.aoV();
                lVar.E(i, f("ok", null));
                return;
            }
            lVar.E(i, f("fail:not TabBar page", null));
        } catch (Exception e) {
            lVar.E(i, f("fail", null));
        }
    }
}

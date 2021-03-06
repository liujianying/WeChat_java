package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.gamewebview.ui.e;
import com.tencent.mm.plugin.game.gamewebview.ui.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class u extends a {
    public static final int CTRL_BYTE = 85;
    public static final String NAME = "hideMenuItems";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiHideMenuItems", "invoke");
        GameWebViewUI pageActivity = dVar.getPageActivity();
        if (pageActivity == null || pageActivity.isFinishing()) {
            x.e("MicroMsg.GameJsApiHideMenuItems", "activity is finish");
            return;
        }
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("menuList");
            if (optJSONArray != null) {
                e actionBar = dVar.getActionBar();
                if (actionBar != null && actionBar.jKe != null) {
                    i iVar = actionBar.jKe;
                    if (optJSONArray != null) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= optJSONArray.length()) {
                                break;
                            }
                            i2 = bi.f((Integer) iVar.jKs.get(optJSONArray.optString(i3)));
                            if (i2 > 0 && !iVar.jKt.contains(Integer.valueOf(i2))) {
                                iVar.jKr.add(Integer.valueOf(i2));
                            }
                            i2 = i3 + 1;
                        }
                    }
                }
                dVar.E(i, a.f("hideMenuItems:ok", null));
                return;
            }
        }
        x.i("MicroMsg.GameJsApiHideMenuItems", "data is null");
        dVar.E(i, a.f("hideMenuItems:fail_invalid_data", null));
    }
}

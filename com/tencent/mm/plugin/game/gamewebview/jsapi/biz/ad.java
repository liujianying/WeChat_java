package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ad extends a {
    public static final int CTRL_BYTE = 242;
    public static final String NAME = "openGameRegion";

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        x.i("MicroMsg.GameJsApiOpenGameRegion", "invoke");
        GameWebViewUI pageActivity = dVar.getPageActivity();
        pageActivity.geJ = new MMActivity.a() {
            public final void b(int i, int i2, Intent intent) {
                if (i != (ad.this.hashCode() & 65535)) {
                    return;
                }
                if (i2 == -1) {
                    if (intent != null) {
                        String aG = bi.aG(intent.getStringExtra("gameRegionName"), "");
                        Map hashMap = new HashMap();
                        hashMap.put("gameRegionName", aG);
                        dVar.E(i, a.f("get game region:ok", hashMap));
                        return;
                    }
                    dVar.E(i, a.f("get game region:fail", null));
                } else if (i2 == 1) {
                    dVar.E(i, a.f("get game region:fail", null));
                } else {
                    dVar.E(i, a.f("get game region:cancel", null));
                }
            }
        };
        com.tencent.mm.bg.d.a(pageActivity, "game", ".ui.GameRegionSelectUI", null, hashCode() & 65535, false);
    }
}

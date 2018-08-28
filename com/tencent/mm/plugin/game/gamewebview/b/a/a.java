package com.tencent.mm.plugin.game.gamewebview.b.a;

import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.game.gamewebview.b.a {
    public static final int CTRL_BYTE = 0;
    public static final String NAME = "onCustomGameMenuClicked";

    public final void m(int i, Bundle bundle) {
        x.i("MicroMsg.GameJsEventCustomGameMenuClicked", "invoke");
        if (bundle != null) {
            int i2 = bundle.getInt("itemId");
            d qL = com.tencent.mm.plugin.game.gamewebview.model.a.qL(i);
            if (qL != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("itemId", i2);
                    qL.cW(getName(), jSONObject.toString());
                } catch (Exception e) {
                    x.e("MicroMsg.GameJsEventCustomGameMenuClicked", "ex : " + e.getMessage());
                }
            }
        }
    }
}

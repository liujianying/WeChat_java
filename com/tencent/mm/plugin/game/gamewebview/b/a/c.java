package com.tencent.mm.plugin.game.gamewebview.b.a;

import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.b.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_BYTE = 0;
    public static final String NAME = "wxdownload:state_change";

    public final void m(int i, Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("appid");
            long j = bundle.getLong("download_id");
            String string2 = bundle.getString("state");
            d qL = com.tencent.mm.plugin.game.gamewebview.model.a.qL(i);
            if (qL != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appid", string);
                    jSONObject.put("download_id", j);
                    jSONObject.put("state", string2);
                    qL.cW(getName(), jSONObject.toString());
                } catch (Exception e) {
                    x.e("MicroMsg.GameJsEventDownloadInfo", "ex : " + e.getMessage());
                }
            }
        }
    }
}

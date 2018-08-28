package com.tencent.mm.plugin.game.gamewebview.b.a;

import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.b.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_BYTE = 0;
    public static final String NAME = "wxdownload:progress_change";

    public final void m(int i, Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("appid");
            long j = bundle.getLong("download_id");
            long j2 = (long) bundle.getInt("progress");
            d qL = com.tencent.mm.plugin.game.gamewebview.model.a.qL(i);
            if (qL != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appid", string);
                    jSONObject.put("download_id", j);
                    jSONObject.put("progress", j2);
                    qL.cW(getName(), jSONObject.toString());
                } catch (Exception e) {
                    x.e("MicroMsg.GameJsEventDownloadProgressChange", "ex : " + e.getMessage());
                }
            }
        }
    }
}

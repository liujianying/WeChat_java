package com.tencent.mm.plugin.game.gamewebview.b.a;

import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.b.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_BYTE = 0;
    public static final String NAME = "onMediaFileUploadProgress";

    public final void m(int i, Bundle bundle) {
        x.i("MicroMsg.GameJsEventUploadMediaFileProgess", "invoke");
        if (bundle != null) {
            String string = bundle.getString("webview_jssdk_file_item_local_id");
            int i2 = bundle.getInt("webview_jssdk_file_item_progreess");
            d qL = com.tencent.mm.plugin.game.gamewebview.model.a.qL(i);
            if (qL != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("localId", string);
                    jSONObject.put("percent", i2);
                    qL.cW(getName(), jSONObject.toString());
                } catch (Exception e) {
                    x.e("MicroMsg.GameJsEventUploadMediaFileProgess", "ex : " + e.getMessage());
                }
            }
        }
    }
}

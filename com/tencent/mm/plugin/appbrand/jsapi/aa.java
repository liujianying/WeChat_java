package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aa extends a {
    public static final int CTRL_INDEX = 169;
    public static final String NAME = "getClipboardData";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        ClipboardManager clipboardManager = (ClipboardManager) lVar.getContext().getSystemService("clipboard");
        if (clipboardManager == null) {
            x.i("MicroMsg.JsApiGetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
            lVar.E(i, f("fail", null));
            return;
        }
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        Object obj = "";
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            Item itemAt = primaryClip.getItemAt(0);
            if (itemAt.getText() != null) {
                obj = itemAt.getText().toString();
            }
        }
        x.d("MicroMsg.JsApiGetClipboardData", "stevyang retData %s", new Object[]{obj});
        Map hashMap = new HashMap();
        hashMap.put("data", obj);
        lVar.E(i, f("ok", hashMap));
    }
}

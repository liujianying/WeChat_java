package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

final class n$a extends JSONObject {
    public n$a(Object obj) {
        if (obj instanceof String) {
            put("type", 1);
            put("val", obj);
        } else if (obj instanceof Integer) {
            put("type", 2);
            put("val", obj);
        } else if (obj instanceof Long) {
            put("type", 3);
            put("val", obj);
        } else if (obj instanceof Boolean) {
            put("type", 4);
            put("val", obj);
        } else {
            x.w("MicroMsg.WebViewBagIntentLogic", "put not support type;class:%s", new Object[]{obj.getClass()});
            put("type", 0);
            put("val", obj);
        }
    }

    static void a(Bundle bundle, String str, JSONObject jSONObject) {
        try {
            x.i("MicroMsg.WebViewBagIntentLogic", "restoreToBundle key:%s type：%d", new Object[]{str, Integer.valueOf(jSONObject.getInt("type"))});
            switch (jSONObject.getInt("type")) {
                case 1:
                    bundle.putString(str, jSONObject.getString("val"));
                    return;
                case 2:
                    bundle.putInt(str, jSONObject.getInt("val"));
                    return;
                case 3:
                    bundle.putLong(str, jSONObject.getLong("val"));
                    return;
                case 4:
                    bundle.putBoolean(str, jSONObject.getBoolean("val"));
                    return;
                default:
                    x.w("MicroMsg.WebViewBagIntentLogic", "not support type");
                    return;
            }
        } catch (JSONException e) {
            x.e("MicroMsg.WebViewBagIntentLogic", "restoreToBundle e:%s", new Object[]{e});
        }
        x.e("MicroMsg.WebViewBagIntentLogic", "restoreToBundle e:%s", new Object[]{e});
    }
}

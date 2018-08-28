package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class n {
    private static final HashSet<String> tnr;

    public static JSONObject an(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null) {
            return jSONObject;
        }
        try {
            for (String str : bundle.keySet()) {
                jSONObject.put(str, new a(bundle.get(str)));
            }
        } catch (JSONException e) {
            x.e("MicroMsg.WebViewBagIntentLogic", "save exp:%s", new Object[]{e});
        }
        return jSONObject;
    }

    public static void a(Intent intent, JSONObject jSONObject) {
        if (jSONObject != null) {
            Iterator keys = jSONObject.keys();
            if (keys != null) {
                Bundle bundle = new Bundle();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    try {
                        a.a(bundle, str, jSONObject.getJSONObject(str));
                    } catch (JSONException e) {
                    }
                }
                intent.putExtras(bundle);
            }
        }
    }

    public static Bundle aL(Intent intent) {
        Bundle extras = intent.getExtras();
        Bundle bundle = new Bundle();
        if (extras == null) {
            return bundle;
        }
        for (String str : extras.keySet()) {
            if (tnr.contains(str)) {
                Object obj = extras.get(str);
                if (obj instanceof String) {
                    bundle.putString(str, (String) obj);
                } else if (obj instanceof Integer) {
                    bundle.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    bundle.putLong(str, ((Long) obj).longValue());
                } else if (obj instanceof Boolean) {
                    bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                } else {
                    x.w("MicroMsg.WebViewBagIntentLogic", "put not support type; key:%s", new Object[]{str});
                }
            }
        }
        return bundle;
    }

    static {
        HashSet hashSet = new HashSet();
        tnr = hashSet;
        hashSet.add("webpageTitle");
        tnr.add("srcUsername");
        tnr.add("srcDisplayname");
        tnr.add("mode");
        tnr.add("KTemplateId");
    }
}

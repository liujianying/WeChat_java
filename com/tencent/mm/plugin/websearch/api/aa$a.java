package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONObject;

public class aa$a {
    static String e(String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("__msg_type", str);
            if (str.equals("event")) {
                jSONObject.put("__event_id", str2);
            }
            jSONObject.put("__params", V(map));
            return jSONObject.toString();
        } catch (Exception e) {
            x.e("MicroMsg.WebViewPreLoadMgr.Builder", "build fail, exception = " + e.getMessage());
            return null;
        }
    }

    private static JSONObject V(Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return new JSONObject();
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                if (str != null) {
                    jSONObject.put(str, map.get(str));
                }
            }
            return jSONObject;
        } catch (Exception e) {
            x.e("MicroMsg.WebViewPreLoadMgr.Builder", "convertMapToJSON fail, exception = " + e.getMessage());
            return null;
        }
    }
}

package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONObject;

public final class bk {
    public static bk dDa = new bk();
    private SharedPreferences dDb = ad.getContext().getSharedPreferences(ad.chY() + "_register_history", 0);

    private bk() {
    }

    public final void d(String str, Map<String, String> map) {
        try {
            if (map.isEmpty()) {
                x.i("MicroMsg.RegisterAccountInfo", "kv map is null or empty!");
                return;
            }
            JSONObject jSONObject;
            if (this.dDb.contains(str)) {
                String string = this.dDb.getString(str, "");
                if (bi.oW(string)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(new String(Base64.decode(string, 0)));
                }
            } else {
                jSONObject = new JSONObject();
            }
            for (String str2 : map.keySet()) {
                jSONObject.put(str2, map.get(str2));
            }
            x.i("MicroMsg.RegisterAccountInfo", "put json str %s", new Object[]{jSONObject.toString()});
            this.dDb.edit().putString(str, Base64.encodeToString(jSONObject.toString().getBytes(), 0)).commit();
        } catch (Exception e) {
            x.e("MicroMsg.RegisterAccountInfo", "save account info about %s failed, error: %s", new Object[]{str, e.getMessage()});
        }
    }

    public final String getString(String str, String str2) {
        try {
            x.i("MicroMsg.RegisterAccountInfo", "get %s, %s", new Object[]{str, str2});
            if (this.dDb.contains(str)) {
                String str3 = new String(Base64.decode(this.dDb.getString(str, ""), 0));
                if (!bi.oW(str3)) {
                    x.i("MicroMsg.RegisterAccountInfo", "get json str %s", new Object[]{str3});
                    JSONObject jSONObject = new JSONObject(str3);
                    if (jSONObject.has(str2)) {
                        return jSONObject.getString(str2);
                    }
                }
            }
            x.w("MicroMsg.RegisterAccountInfo", "register info about %s is not found!", new Object[]{str});
        } catch (Exception e) {
            x.e("MicroMsg.RegisterAccountInfo", "get register info %s about %s failed, error: %s", new Object[]{str2, str, e.getMessage()});
        }
        return "";
    }
}

package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class bt {
    public static bt dDs = new bt();
    private SharedPreferences dDb = ad.getContext().getSharedPreferences(ad.chY() + "_account_history", 0);
    private SharedPreferences dDt = ad.getContext().getSharedPreferences(ad.chY() + "_account_switch", 0);

    private bt() {
    }

    public final void l(String str, String str2, String str3) {
        try {
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
            if (!bi.G(str2, str3)) {
                jSONObject.put(str2, str3);
                x.i("MicroMsg.SwitchAccountInfo", "put key %s, jsonStr %s", str2, jSONObject.toString());
                this.dDb.edit().putString(str, Base64.encodeToString(jSONObject.toString().getBytes(), 0)).commit();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SwitchAccountInfo", "save account info %s about %s failed, error: %s", str2, str, e.getMessage());
        }
    }

    public final void d(String str, Map<String, String> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
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
                    x.i("MicroMsg.SwitchAccountInfo", "put json str %s", jSONObject.toString());
                    this.dDb.edit().putString(str, Base64.encodeToString(jSONObject.toString().getBytes(), 0)).commit();
                    return;
                }
            } catch (Exception e) {
                x.e("MicroMsg.SwitchAccountInfo", "save account info about %s failed, error: %s", str, e.getMessage());
                return;
            }
        }
        x.i("MicroMsg.SwitchAccountInfo", "kv map is null or empty!");
    }

    public final String getString(String str, String str2) {
        try {
            x.i("MicroMsg.SwitchAccountInfo", "get %s, %s", str, str2);
            if (this.dDb.contains(str)) {
                String str3 = new String(Base64.decode(this.dDb.getString(str, ""), 0));
                if (!bi.oW(str3)) {
                    x.i("MicroMsg.SwitchAccountInfo", "get json str %s", str3);
                    JSONObject jSONObject = new JSONObject(str3);
                    if (jSONObject.has(str2)) {
                        return jSONObject.getString(str2);
                    }
                }
            }
            x.w("MicroMsg.SwitchAccountInfo", "account info about %s is not found!", str);
        } catch (Exception e) {
            x.e("MicroMsg.SwitchAccountInfo", "get account info %s about %s failed, error: %s", str2, str, e.getMessage());
        }
        return "";
    }

    public final void iL(String str) {
        if (iM(str)) {
            Set stringSet = this.dDt.getStringSet("first_switch_group", null);
            if (stringSet != null) {
                stringSet.remove(str);
                Editor edit = this.dDt.edit();
                edit.remove("first_switch_group").apply();
                edit.putStringSet("first_switch_group", stringSet).commit();
            }
        }
        if (iN(str) && this.dDb.contains(str)) {
            this.dDb.edit().remove(str).commit();
        }
    }

    public final void W(String str, String str2) {
        if (!bi.G(str, str2) && !str.equals(str2)) {
            Set stringSet = this.dDt.getStringSet("first_switch_group", null);
            if (stringSet == null) {
                stringSet = new HashSet();
            }
            if (!stringSet.contains(str) || stringSet.size() >= 2) {
                stringSet.clear();
                stringSet.add(str);
                stringSet.add(str2);
            } else {
                stringSet.add(str2);
            }
            Editor edit = this.dDt.edit();
            edit.remove("first_switch_group").apply();
            edit.putStringSet("first_switch_group", stringSet).commit();
        }
    }

    public final boolean iM(String str) {
        Set stringSet = this.dDt.getStringSet("first_switch_group", null);
        if (stringSet == null) {
            return false;
        }
        return stringSet.contains(str);
    }

    public final boolean iN(String str) {
        return this.dDb.contains(str);
    }

    public final Set<String> IH() {
        Set<String> hashSet = new HashSet();
        Collection stringSet = this.dDt.getStringSet("first_switch_group", null);
        if (!(stringSet == null || stringSet.isEmpty())) {
            hashSet.addAll(stringSet);
        }
        return hashSet;
    }

    public final String II() {
        Set<String> IH = IH();
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : IH) {
            stringBuilder.append(append);
            stringBuilder.append(';');
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        x.i("MicroMsg.SwitchAccountInfo", "switch users %s", stringBuilder.toString());
        return stringBuilder.toString();
    }
}

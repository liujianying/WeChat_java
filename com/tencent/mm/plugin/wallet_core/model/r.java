package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.g.c.ej;
import com.tencent.mm.plugin.wallet_core.d.d;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r extends ej {
    public static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bulletin_scene";
        aVar.sKA.put("bulletin_scene", "TEXT PRIMARY KEY ");
        stringBuilder.append(" bulletin_scene TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "bulletin_scene";
        aVar.columns[1] = "bulletin_content";
        aVar.sKA.put("bulletin_content", "TEXT");
        stringBuilder.append(" bulletin_content TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "bulletin_url";
        aVar.sKA.put("bulletin_url", "TEXT");
        stringBuilder.append(" bulletin_url TEXT");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public static void aj(JSONObject jSONObject) {
        boolean z = true;
        int i = 0;
        d bPa = o.bPa();
        StringBuilder append;
        if (jSONObject == null || bPa == null) {
            String str = "MicroMsg.WalletBulletin";
            append = new StringBuilder("json==null?").append(jSONObject == null).append("  stg==null?");
            if (bPa != null) {
                z = false;
            }
            x.e(str, append.append(z).toString());
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("banner_map");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("banner_content_array");
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        if (optJSONArray == null || optJSONArray2 == null) {
            String str2 = "MicroMsg.WalletBulletin";
            append = new StringBuilder("scenes==null?").append(optJSONArray == null).append("  contents==null?");
            if (optJSONArray2 != null) {
                z = false;
            }
            x.e(str2, append.append(z).toString());
            return;
        }
        int i2;
        JSONObject optJSONObject;
        int length = optJSONArray.length();
        for (i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
            if (optJSONObject2 != null) {
                String optString = optJSONObject2.optString("banner_type");
                String optString2 = optJSONObject2.optString("banner_template_id");
                x.i("MicroMsg.WalletBulletin", "sceneid=" + optString + "; contentid=" + optString2);
                if (!(bi.oW(optString) || bi.oW(optString2))) {
                    hashMap.put(optString, optString2);
                    x.i("MicroMsg.WalletBulletin", "sceneid:" + optString + " map contentid:" + optString2);
                }
            }
        }
        i2 = optJSONArray2.length();
        while (i < i2) {
            optJSONObject = optJSONArray2.optJSONObject(i);
            if (optJSONObject != null) {
                hashMap2.put(optJSONObject.optString("banner_template_id"), Integer.valueOf(i));
            }
            i++;
        }
        if (hashMap.size() > 0) {
            for (String str3 : hashMap.keySet()) {
                String str4 = (String) hashMap.get(str3);
                if (hashMap2.containsKey(str4)) {
                    x.i("MicroMsg.WalletBulletin", "find contentid:" + str4 + "in contentMap");
                    optJSONObject = optJSONArray2.optJSONObject(((Integer) hashMap2.get(str4)).intValue());
                    r rVar = new r();
                    rVar.field_bulletin_scene = str3;
                    rVar.field_bulletin_content = optJSONObject.optString("content");
                    rVar.field_bulletin_url = optJSONObject.optString("url");
                    bPa.b(rVar);
                } else {
                    x.e("MicroMsg.WalletBulletin", "can not find contentid:" + str4 + "in contentMap");
                }
            }
        }
    }
}

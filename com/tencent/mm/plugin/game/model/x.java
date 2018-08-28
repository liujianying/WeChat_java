package com.tencent.mm.plugin.game.model;

import com.tencent.mm.g.a.go;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class x {
    public static void a(go goVar) {
        String str = goVar.bPJ.bPE;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.GameJsapiProcessor", "writeMsg param=%s", new Object[]{str});
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.isNull("type") || bi.getInt(jSONObject.optString("type"), 0) == 0) {
                    JSONArray jSONArray = new JSONArray();
                    JSONArray jSONArray2 = jSONObject.getJSONArray("localIdList");
                    int length = jSONArray2.length();
                    long[] jArr = new long[length];
                    for (int i = 0; i < length; i++) {
                        jArr[i] = jSONArray2.getLong(i);
                    }
                    ((c) g.l(c.class)).aSj().f(jArr);
                } else if (bi.getInt(jSONObject.optString("type"), 0) == 65536) {
                    ((c) g.l(c.class)).aSj().fV("GameRawMessage", "update GameRawMessage set isRead=1 where 1=1");
                }
            } catch (JSONException e) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[]{e.getMessage()});
            }
        }
    }
}
